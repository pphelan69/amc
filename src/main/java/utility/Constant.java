package utility;

/**
 * Created by pphelan on 9/30/2015.
 */
public class Constant {

    public static final String  Browser="FireFox"; // also can be select as FireFox,IE,Chrome
    public static final String  http_protocol = "https";
    // QA server IP
    //public static final String  hostNameOrIP = "146.20.50.31";   // "10.4.24.42";  146.20.50.31
    // Build system IP
    public static final String  hostNameOrIP = "10.4.24.244";


    public static final String hostPort = "8443";
    public static final String amc1 = "/amc";

    public static final String Username="sysadmin";
    public static final String Password="password";
    public static final String CloudServiceProviderAWS="Amazon Web Services";
    public static final String CloudServiceProviderRackSpace="Rackspace";

    // AWS Cloud Definition constants.
    public static final String CloudNameAWS = "AWS Cloud";
    public static final String CloudNameAWS2 = "AWS";
    public static final String CloudNameAWS3 = "AWS_Subnet";
    public static final String CloudDescriptionAWS = "AWS Cloud";
    public static final String CloudGroupNameAWS = "QA_Group";
    public static final String CloudProviderAWS = "aws-ec2";
    public static final String CloudAccessKeyAWS = "AKIAJ74DRTT7DMBJCBTA";
    public static final String CloudSecretAccessKeyAWS = "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";
    public static final String CloudRegionAWS = "US West (Oregon) Zone C";
    public static final String SubnetIdAWS = "subnet-0894767e";
    public static final String SecurityGroupIdAWS = "sg-c82c41af";
    public static final String SubnetIdZoneAWS = "Locate by Subnet ID";
    public static final String AvailableZoneAWS = "Locate by Availability Zone";

    // AWS Cloud Definition constants.
    public static final String TestCloudName = "Cloud Test";
    public static final String TestCloudDescription = "Cloud Test Description";

    // AWS Cloud Definition constants.
    public static final String EditCloudName = "Edit CloudTest";
    public static final String EditCloudDescription = "Edit Cloud Test Description";

    // RackSpace Cloud Definition constants.
    public static final String CloudNameRS = "RSCloud";
    public static final String CloudNameRS2 = "RS";
    public static final String CloudDescriptionRS = "RSCloud";
    public static final String CloudGroupNameRS = "QA_Group";
    public static final String CloudProviderRS = "rackspace-cloudservers-us";
    public static final String CloudUserNameRS = "peter.phelan";
    public static final String CloudAPIKeyRS = "ed4f0734d6fa40d8b9bd08563a5747ed";
    public static final String CloudRegionRS = "IAD";

    // *****************************************************************************************************************
    public static final String esdusername = "manjunatha.n";
    public static final String esdpassword = "123@123.Com";

    // *****************************************************************************************************************
    // **************************  Products  ***************************************************************************
    // *****************************************************************************************************************

    public static final String AMC_Product      = "AMC";
    public static final String Matrix_Product   = "Matrix";
    public static final String VectorH_Product  = "Vector in Hadoop 4";//"Vector in Hadoop Enterprise";
    public static final String VectorH_Exp_Product   = "Vector in Hadoop 5";//"Vector in Hadoop Express";
    public static final String Hortonworks_Product   = "Hortonworks";

    // *****************************************************************************************************************
    // **************************   AMC constants **********************************************************************
    // *****************************************************************************************************************

    // AMC Instance names for AWS
    public static final String InstanceNameAMC_AWS1 = "AMC_AWS_2CPU4GB";
    public static final String InstanceNameAMC_AWS2 = "AMC_AWS_2CPU8GB";
    public static final String InstanceNameAMC_AWS3 = "AMC_AWS_4CPU16GB";

    // AMC Instance names for AWS-Subnet
    public static final String InstanceNameAMC_AWSsub1 = "AMC_AWSsub_2CPU4GB";
    public static final String InstanceNameAMC_AWSsub2 = "AMC_AWSsub_2CPU8GB";
    public static final String InstanceNameAMC_AWSsub3 = "AMC_AWSsub_4CPU16GB";


    // AMC AWS Configurations:
    public static final String AMC_AWS_Config1 = "$: 2 CPU, 4GB, 1 x 8GB + 1 x 25GB";
    public static final String AMC_AWS_Config2 = "$$: 2 CPU, 8GB, 1 x 8GB + 1 x 25GB";
    public static final String AMC_AWS_Config3 = "$$$$: 4 CPU, 16GB, 1 x 8GB + 1 x 25GB, High Performance Network";

    // AMC Instance names foe RackSpace
    public static final String InstanceNameAMC_RS1 = "AMC_RS";

    // AMC Instance custom node config value
    public static final String custom_Value = "7";

    // *****************************************************************************************************************
    // **************************   VectorH constants **********************************************************************
    // *****************************************************************************************************************

    // VectorH Instance names for AWS- Regression Test
    public static final String InstanceNameVectorH_AWS1 = "VecH_AWS_Sm_dev";
    public static final String InstanceNameVectorH_AWS2 = "VecH_AWS_Sm_bal";
    public static final String InstanceNameVectorH_AWS3 = "VecH_AWS_Sm_prd";

    public static final String InstanceNameVectorH_AWS4 = "VecH_AWS_Med_dev";
    public static final String InstanceNameVectorH_AWS5 = "VecH_AWS_Med_bal";
    public static final String InstanceNameVectorH_AWS6 = "VecH_AWS_Med_prd";

    public static final String InstanceNameVectorH_AWS7 = "VecH_AWS_Lar_dev";
    public static final String InstanceNameVectorH_AWS8 = "VecH_AWS_Lar_bal";
    public static final String InstanceNameVectorH_AWS9 = "VecH_AWS_Lar_prd";

    public static final String InstanceNameVectorH_AWS10 = "VecH_AWS_Cus_dev";
    public static final String InstanceNameVectorH_AWS11 = "VecH_AWS_Cus_bal";
    public static final String InstanceNameVectorH_AWS12 = "VecH_AWS_Cus_prd";

    // VectorH Instance names for AWS_subnet- Regression Test
    public static final String InstanceNameVectorH_AWS_Sub1 = "VecHAWSsub_Sm_dev";
    public static final String InstanceNameVectorH_AWS_Sub2 = "VecHAWSsub_Sm_bal";
    public static final String InstanceNameVectorH_AWS_Sub3 = "VecHAWSsub_Smprd";

    public static final String InstanceNameVectorH_AWS_Sub4 = "VecHAWSsub_Med_dev";
    public static final String InstanceNameVectorH_AWS_Sub5 = "VecHAWSsub_Med_bal";
    public static final String InstanceNameVectorH_AWS_Sub6 = "VecHAWSsub_Medprd";

    public static final String InstanceNameVectorH_AWS_Sub7 = "VecHAWSsub_Lar_dev";
    public static final String InstanceNameVectorH_AWS_Sub8 = "VecHAWSsub_Lar_bal";
    public static final String InstanceNameVectorH_AWS_Sub9 = "VecHAWSsub_Larprd";

    public static final String InstanceNameVectorH_AWS_Sub10 = "VecHAWSsub_Cus_dev";
    public static final String InstanceNameVectorH_AWS_Sub11 = "VecHAWSsub_Cus_bal";
    public static final String InstanceNameVectorH_AWS_Sub12 = "VecHAWSsub_Cusprd";

    // VectorH Instance names for RackSpace- Regression Test
    public static final String InstanceNameVectorH_RS1 = "VecH_RS_Sm_Vir";
    public static final String InstanceNameVectorH_RS2 = "VecH_RS_Sm_Mix";
    public static final String InstanceNameVectorH_RS3 = "VecH_RS_Sm_OnMet";

    public static final String InstanceNameVectorH_RS4 = "VecH_RS_Med_Vir";
    public static final String InstanceNameVectorH_RS5 = "VecH_RS_Med_Mix";
    public static final String InstanceNameVectorH_RS6 = "VecH_RS_Med_OnMet";

    public static final String InstanceNameVectorH_RS7 = "VecH_RS_Lar_Vir";
    public static final String InstanceNameVectorH_RS8 = "VecH_RS_Lar_Mix";
    public static final String InstanceNameVectorH_RS9 = "VecH_RS_Lar_OnMet";

    // *****************************************************************************************************************
    // Hortonworks Instance names for RackSpace- Regression Test
    public static final String InstanceNameHortonworks_RS1 = "Horton_RS_Sm_Vir";
    public static final String InstanceNameHortonworks_RS2 = "Horton_RS_Sm_Mix";
    public static final String InstanceNameHortonworks_RS3 = "Horton_RS_Sm_OnMet";

    public static final String InstanceNameHortonworks_RS4 = "Horton_RS_Med_Vir";
    public static final String InstanceNameHortonworks_RS5 = "Horton_RS_Med_Mix";
    public static final String InstanceNameHortonworks_RS6 = "Horton_RS_Med_OnMet";

    public static final String InstanceNameHortonworks_RS7 = "Horton_RS_Lar_Vir";
    public static final String InstanceNameHortonworks_RS8 = "Horton_RS_Lar_Mix";
    public static final String InstanceNameHortonworks_RS9 = "Horton_RS_Lar_OnMet";

    // Hortonworks Instance names for AWS- Regression Test
    public static final String InstanceNameHortonworks_AWS1 = "HrtonAWS_Sm_dev";
    public static final String InstanceNameHortonworks_AWS2 = "HrtonAWS_Sm_bal";
    public static final String InstanceNameHortonworks_AWS3 = "HrtonAWS_Sm_prd";

    public static final String InstanceNameHortonworks_AWS4 = "HrtonAWS_Med_dev";
    public static final String InstanceNameHortonworks_AWS5 = "HrtonAWS_Med_bal";
    public static final String InstanceNameHortonworks_AWS6 = "HrtonAWS_Med_prd";

    public static final String InstanceNameHortonworks_AWS7 = "HrtonAWS_Lar_dev";
    public static final String InstanceNameHortonworks_AWS8 = "HrtonAWS_Lar_bal";
    public static final String InstanceNameHortonworks_AWS9 = "HrtonAWS_Lar_prd";

    public static final String InstanceNameHortonworks_AWS10 = "HrtonAWS_Cus_dev";
    public static final String InstanceNameHortonworks_AWS11 = "HrtonAWS_Cus_bal";
    public static final String InstanceNameHortonworks_AWS12 = "HrtonAWS_Cus_prd";

    public static final String InstanceNameHortonworks_AWS13 = "HrtonAWS_Sm_dev1";
    public static final String InstanceNameHortonworks_AWS14 = "HrtonAWS_Sm_bal2";
    public static final String InstanceNameHortonworks_AWS15 = "HrtonAWS_Sm_prd3";

    public static final String InstanceNameHortonworks_AWS16 = "HrtonAWS_Med_dev4";
    public static final String InstanceNameHortonworks_AWS17 = "HrtonAWS_Med_bal5";
    public static final String InstanceNameHortonworks_AWS18 = "HrtonAWS_Med_prd6";

    public static final String InstanceNameHortonworks_AWS19 = "HrtonAWS_Lar_dev7";
    public static final String InstanceNameHortonworks_AWS20 = "HrtonAWS_Lar_bal8";
    public static final String InstanceNameHortonworks_AWS21 = "HrtonAWS_Lar_prd9";

    public static final String InstanceNameHortonworks_AWS22 = "HrtonAWS_Cus_dev10";
    public static final String InstanceNameHortonworks_AWS23 = "HrtonAWS_Cus_bal11";
    public static final String InstanceNameHortonworks_AWS24 = "HrtonAWS_Cus_prd12";

    public static final String InstanceNameHortonworks_AWS25 = "HrtonAWS_Sm_dev13";
    public static final String InstanceNameHortonworks_AWS26 = "HrtonAWS_Sm_bal14";
    public static final String InstanceNameHortonworks_AWS27 = "HrtonAWS_Sm_prd15";

    public static final String InstanceNameHortonworks_AWS28 = "HrtonAWS_Med_dev16";
    public static final String InstanceNameHortonworks_AWS29 = "HrtonAWS_Med_bal17";
    public static final String InstanceNameHortonworks_AWS30 = "HrtonAWS_Med_prd18";

    public static final String InstanceNameHortonworks_AWS31 = "HrtonAWS_Lar_dev19";
    public static final String InstanceNameHortonworks_AWS32 = "HrtonAWS_Lar_bal20";
    public static final String InstanceNameHortonworks_AWS33 = "HrtonAWS_Lar_prd21";

    public static final String InstanceNameHortonworks_AWS34 = "HrtonAWS_Cus_dev22";
    public static final String InstanceNameHortonworks_AWS35 = "HrtonAWS_Cus_bal23";
    public static final String InstanceNameHortonworks_AWS36 = "HrtonAWS_Cus_prd24";

    // Hortonworks Instance names for AWS_subnet- Regression Test
    public static final String InstanceNameHortonworks_AWS_Sub1 = "Hort_AWSsub_Sm_dev";
    public static final String InstanceNameHortonworks_AWS_Sub2 = "Hort_AWSsub_Sm_bal";
    public static final String InstanceNameHortonworks_AWS_Sub3 = "Hort_AWSsub_Sm_prd";

    public static final String InstanceNameHortonworks_AWS_Sub4 = "Hort_AWSsub_Med_dev";
    public static final String InstanceNameHortonworks_AWS_Sub5 = "Hort_AWSsub_Med_bal";
    public static final String InstanceNameHortonworks_AWS_Sub6 = "Hort_AWSsub_Med_prd";

    public static final String InstanceNameHortonworks_AWS_Sub7 = "Hort_AWSsub_Lar_dev";
    public static final String InstanceNameHortonworks_AWS_Sub8 = "Hort_AWSsub_Lar_bal";
    public static final String InstanceNameHortonworks_AWS_Sub9 = "Hort_AWSsub_Lar_prd";

    public static final String InstanceNameHortonworks_AWS_Sub10 = "Hort_AWSsub_Cus_dev";
    public static final String InstanceNameHortonworks_AWS_Sub11 = "Hort_AWSsub_Cus_bal";
    public static final String InstanceNameHortonworks_AWS_Sub12 = "Hort_AWSsub_Cus_prd";

    public static final String InstanceNameHortonworks_AWS_Sub13 = "Hort_AWSsub_Sm_dev1";
    public static final String InstanceNameHortonworks_AWS_Sub14 = "Hort_AWSsub_Sm_bal2";
    public static final String InstanceNameHortonworks_AWS_Sub15 = "Hort_AWSsub_Sm_prd3";

    public static final String InstanceNameHortonworks_AWS_Sub16 = "Hort_AWSsub_Med_dev4";
    public static final String InstanceNameHortonworks_AWS_Sub17 = "Hort_AWSsub_Med_bal5";
    public static final String InstanceNameHortonworks_AWS_Sub18 = "Hort_AWSsub_Med_prd6";

    public static final String InstanceNameHortonworks_AWS_Sub19 = "Hort_AWSsub_Lar_dev7";
    public static final String InstanceNameHortonworks_AWS_Sub20 = "Hort_AWSsub_Lar_bal8";
    public static final String InstanceNameHortonworks_AWS_Sub21 = "Hort_AWSsub_Lar_prd9";

    public static final String InstanceNameHortonworks_AWS_Sub22 = "Hort_AWSsub_Cus_dev10";
    public static final String InstanceNameHortonworks_AWS_Sub23 = "Hort_AWSsub_Cus_bal11";
    public static final String InstanceNameHortonworks_AWS_Sub24 = "Hort_AWSsub_Cus_prd12";

    public static final String InstanceNameHortonworks_AWS_Sub25 = "Hort_AWSsub_Sm_dev13";
    public static final String InstanceNameHortonworks_AWS_Sub26 = "Hort_AWSsub_Sm_bal14";
    public static final String InstanceNameHortonworks_AWS_Sub27 = "Hort_AWSsub_Sm_prd15";

    public static final String InstanceNameHortonworks_AWS_Sub28 = "Hort_AWSsub_Med_dev16";
    public static final String InstanceNameHortonworks_AWS_Sub29 = "Hort_AWSsub_Med_bal17";
    public static final String InstanceNameHortonworks_AWS_Sub30 = "Hort_AWSsub_Med_prd18";

    public static final String InstanceNameHortonworks_AWS_Sub31 = "Hort_AWSsub_Lar_dev19";
    public static final String InstanceNameHortonworks_AWS_Sub32 = "Hort_AWSsub_Lar_bal20";
    public static final String InstanceNameHortonworks_AWS_Sub33 = "Hort_AWSsub_Lar_prd21";

    public static final String InstanceNameHortonworks_AWS_Sub34 = "Hort_AWSsub_Cus_dev22";
    public static final String InstanceNameHortonworks_AWS_Sub35 = "Hort_AWSsub_Cus_bal23";
    public static final String InstanceNameHortonworks_AWS_Sub36 = "Hort_AWSsub_Cus_prd24";

    // *****************************************************************************************************************
    // **************************   VectorhEXPS constants *******************************************************************

    // VectorhEXPS Instance names for AWS- Regression Test
    public static final String InstanceNameVectorhEXP_AWS1 = "VecEXPSAWS_Smdev";
    public static final String InstanceNameVectorhEXP_AWS2 = "VecEXPSAWS_Smbal";
    public static final String InstanceNameVectorhEXP_AWS3 = "VecEXPSAWS_Smprd";

    public static final String InstanceNameVectorhEXP_AWS4 = "VecEXPSAWS_Meddev";
    public static final String InstanceNameVectorhEXP_AWS5 = "VecEXPSAWS_Medbal";
    public static final String InstanceNameVectorhEXP_AWS6 = "VecEXPSAWS_Medprd";

    public static final String InstanceNameVectorhEXP_AWS7 = "VecEXPSAWS_Lardev";
    public static final String InstanceNameVectorhEXP_AWS8 = "VecEXPSAWS_Larbal";
    public static final String InstanceNameVectorhEXP_AWS9 = "VecEXPSAWS_Larprd";

    public static final String InstanceNameVectorhEXP_AWS10 = "VecEXPSAWS_Cusdev";
    public static final String InstanceNameVectorhEXP_AWS11 = "VecEXPSAWS_Cusbal";
    public static final String InstanceNameVectorhEXP_AWS12 = "VecEXPSAWS_Cusprd";

    // VectorhEXPS Instance names for AWS_subnet- Regression Test
    public static final String InstanceNameVectorhEXPS_AWSsub1 = "Exp_AWSsubSmdev";
    public static final String InstanceNameVectorhEXPS_AWSsub2 = "Exp_AWSsubSmbal";
    public static final String InstanceNameVectorhEXPS_AWSsub3 = "Exp_AWSsubSmprd";

    public static final String InstanceNameVectorhEXPS_AWSsub4 = "Exp_AWSsubMeddev";
    public static final String InstanceNameVectorhEXPS_AWSsub5 = "Exp_AWSsubMedbal";
    public static final String InstanceNameVectorhEXPS_AWSsub6 = "Exp_AWSsubMedprd";

    public static final String InstanceNameVectorhEXPS_AWSsub7 = "Exp_AWSsubLardev";
    public static final String InstanceNameVectorhEXPS_AWSsub8 = "Exp_AWSsubLarbal";
    public static final String InstanceNameVectorhEXPS_AWSsub9 = "Exp_AWSsubLarprd";

    public static final String InstanceNameVectorhEXPS_AWSsub10 = "Exp_AWSsubCusdev";
    public static final String InstanceNameVectorhEXPS_AWSsub11 = "Exp_AWSsubCusbal";
    public static final String InstanceNameVectorhEXPS_AWSsub12 = "Exp_AWSsubCusprd";

    // VectorhEXPS Instance names for RackSpace- Regression Test
    public static final String InstanceNameVectorhEXPS_RS1 = "VecEXP_RS_SmVir";
    public static final String InstanceNameVectorhEXPS_RS2 = "VecEXP_RS_SmMix";
    public static final String InstanceNameVectorhEXPS_RS3 = "VechEXP_RS_SmOnMet";

    public static final String InstanceNameVectorhEXPS_RS4 = "VecEXP_RS_MedVir";
    public static final String InstanceNameVectorhEXPS_RS5 = "VecEXP_RS_MedMix";
    public static final String InstanceNameVectorhEXPS_RS6 = "VecEXP_RS_MedOnMet";

    public static final String InstanceNameVectorhEXPS_RS7 = "VecEXP_RS_LarVir";
    public static final String InstanceNameVectorhEXPS_RS8 = "VecEXP_RS_LarMix";
    public static final String InstanceNameVectorhEXPS_RS9 = "VecEXP_RS_LarOnMet";

    // *****************************************************************************************************************
    // **************************   Matrix constants *******************************************************************
    // *****************************************************************************************************************

    // Matrix Instance names for RackSpace - Regression Test
    public static final String InstanceNameMatrix_RS1 = "Matrix_RS_XS_Vir";
    public static final String InstanceNameMatrix_RS2 = "Matrix_RS_XS_OnMe";

    public static final String InstanceNameMatrix_RS3 = "Matrix_RS_Sm_Vir";
    public static final String InstanceNameMatrix_RS4 = "Matrix_RS_Sm_OnMet";

    public static final String InstanceNameMatrix_RS5 = "Matrix_RS_Med_Vir";
    public static final String InstanceNameMatrix_RS6 = "Matrix_RS_Med_OnMet";

    public static final String InstanceNameMatrix_RS7 = "Matrix_RS_Lar_Vir";
    public static final String InstanceNameMatrix_RS8 = "Matrix_RS_Lar_OnMet";

    // Matrix Instance names for AWS - Regression Test
    public static final String InstanceNameMatrix_AWS1 = "Matrix_AWS_XS_dev";
    public static final String InstanceNameMatrix_AWS2 = "Matrix_AWS_XS_bal";
    public static final String InstanceNameMatrix_AWS3 = "Matrix_AWS_XS_prd";

    public static final String InstanceNameMatrix_AWS4 = "Matrix_AWS_Sm_dev";
    public static final String InstanceNameMatrix_AWS5 = "Matrix_AWS_Sm_bal";
    public static final String InstanceNameMatrix_AWS6 = "Matrix_AWS_Sm_prd";

    public static final String InstanceNameMatrix_AWS7 = "Matrix_AWS_Meddev";
    public static final String InstanceNameMatrix_AWS8 = "Matrix_AWS_Medbal";
    public static final String InstanceNameMatrix_AWS9 = "Matrix_AWS_Medprd";

    public static final String InstanceNameMatrix_AWS10 = "Matrix_AWS_Lardev";
    public static final String InstanceNameMatrix_AWS11 = "Matrix_AWS_Larbal";
    public static final String InstanceNameMatrix_AWS12 = "Matrix_AWS_Larprd";

    public static final String InstanceNameMatrix_AWS13 = "Matrix_AWS_Cusdev";
    public static final String InstanceNameMatrix_AWS14 = "Matrix_AWS_Cusbal";
    public static final String InstanceNameMatrix_AWS15 = "Matrix_AWS_Cusprd";

    public static final String InstanceNameMatrix_AWS16 = "Mat_AWS_XS_devgrp";
    public static final String InstanceNameMatrix_AWS17 = "Mat_AWS_XS_balgrp";
    public static final String InstanceNameMatrix_AWS18 = "Mat_AWS_XS_prdgrp";

    public static final String InstanceNameMatrix_AWS19 = "Mat_AWS_Sm_de_grp";
    public static final String InstanceNameMatrix_AWS20 = "Mat_AWS_Sm_balgrp";
    public static final String InstanceNameMatrix_AWS21 = "Mat_AWS_Sm_prdgrp";

    public static final String InstanceNameMatrix_AWS22 = "Mat_AWS_Med_devgrp";
    public static final String InstanceNameMatrix_AWS23 = "Mat_AWS_Med_balgrp";
    public static final String InstanceNameMatrix_AWS24 = "Mat_AWS_Med_prdgrp";

    public static final String InstanceNameMatrix_AWS25 = "Mat_AWS_Lar_devgrp";
    public static final String InstanceNameMatrix_AWS26 = "Mat_AWS_Lar_balgrp";
    public static final String InstanceNameMatrix_AWS27 = "Mat_AWS_Lar_prdgrp";

    public static final String InstanceNameMatrix_AWS28 = "Mat_AWS_Cus_devgrp";
    public static final String InstanceNameMatrix_AWS29 = "Mat_AWS_Cus_balgrp";
    public static final String InstanceNameMatrix_AWS30 = "Mat_AWS_Cus_prdgrp";

    // Matrix Instance names for AWS_Subnet - Regression Test
    public static final String InstanceNameMatrix_AWS_Sub1 = "Mat_AWSsub_XSdev";
    public static final String InstanceNameMatrix_AWS_Sub2 = "Mat_AWSsub_XSbal";
    public static final String InstanceNameMatrix_AWS_Sub3 = "Mat_AWSsub_XSprd";

    public static final String InstanceNameMatrix_AWS_Sub4 = "Mat_AWSsub_Smdev";
    public static final String InstanceNameMatrix_AWS_Sub5 = "Mat_AWSsub_Smbal";
    public static final String InstanceNameMatrix_AWS_Sub6 = "Mat_AWSsub_Smprd";

    public static final String InstanceNameMatrix_AWS_Sub7 = "Mat_AWSsub_Meddev";
    public static final String InstanceNameMatrix_AWS_Sub8 = "Mat_AWSsub_Medbal";
    public static final String InstanceNameMatrix_AWS_Sub9 = "Mat_AWSsub_Medprd";

    public static final String InstanceNameMatrix_AWS_Sub10 = "Mat_AWSsub_Lardev";
    public static final String InstanceNameMatrix_AWS_Sub11 = "Mat_AWSsub_Larbal";
    public static final String InstanceNameMatrix_AWS_Sub12 = "Mat_AWSsub_Larprd";

    public static final String InstanceNameMatrix_AWS_Sub13 = "Mat_AWSsub_Cusdev";
    public static final String InstanceNameMatrix_AWS_Sub14 = "Mat_AWSsub_Cusbal";
    public static final String InstanceNameMatrix_AWS_Sub15 = "Mat_AWSsub_Cusprd";

    public static final String InstanceNameMatrix_AWS_Sub16 = "MatAWSsb_XSdevgrp";
    public static final String InstanceNameMatrix_AWS_Sub17 = "MatAWSsb_XSbalgrp";
    public static final String InstanceNameMatrix_AWS_Sub18 = "MatAWSsb_XSprdgrp";

    public static final String InstanceNameMatrix_AWS_Sub19 = "MatAWSsb_Smdevgrp";
    public static final String InstanceNameMatrix_AWS_Sub20 = "MatAWSsb_Smbalgrp";
    public static final String InstanceNameMatrix_AWS_Sub21 = "MatAWSsb_Smprdgrp";

    public static final String InstanceNameMatrix_AWS_Sub22 = "MatAWSsb_Meddevgrp";
    public static final String InstanceNameMatrix_AWS_Sub23 = "MatAWSsb_Medbalgrp";
    public static final String InstanceNameMatrix_AWS_Sub24 = "MatAWSsb_Medprdgrp";

    public static final String InstanceNameMatrix_AWS_Sub25 = "MatAWSsb_Lardevgrp";
    public static final String InstanceNameMatrix_AWS_Sub26 = "MatAWSsb_Larbalgrp";
    public static final String InstanceNameMatrix_AWS_Sub27 = "MatAWSsb_Larprdgrp";

    public static final String InstanceNameMatrix_AWS_Sub28 = "MatAWSsb_Cusdevgrp";
    public static final String InstanceNameMatrix_AWS_Sub29 = "MatAWSsb_Cusbalgrp";
    public static final String InstanceNameMatrix_AWS_Sub30 = "MatAWSsb_Cusprdgrp";


    // Ambari versions
    public static final String Ambariversion1 = "Ambari 2.2.2.0";
    public static final String Ambariversion2 = "Ambari 2.1.2";
    public static final String hdpversion1 = "2.4";
    public static final String hdpversion2 = "2.2";

    public static final String localStoragecheckbox = "Use instance store for data";
    public static final String placementgrpcheckbox = "Use placement group";

    // *****************************************************************************************************************

    //Input data alert messages
    public static final String AlertMsgCloudServiceRackSpace     = "Choose a cloud service which will be used to host your product instances. You may need to establish an account with the chosen service.";
    public static final String AlertMsgCloudProviderAPIRackSapce = "Enter the Rackspace Cloud provider or API used to connect to your Rackspace account. This is almost always: rackspace-cloudservers-us.";
    public static final String AlertMsgRegionNameRackSapce       = "Enter the Region Name to use with the Rackspace account. For example: IAD.";
    public static final String AlertMsgAPIKeyRackSapce           = "Enter the API Key for the Rackspace account.";
    public static final String AlertMsgUsernameRackSapce         = "Enter the Username for the Rackspace account.";

    public static final String AlertMsgCloudServiceAWS           = "Choose a cloud service which will be used to host your product instances. You may need to establish an account with the chosen service.";
    public static final String AlertMsgCloudProviderAPIAWS       = "Enter the AWS Cloud Provider or API used to connect to your AWS account. This is almost always: aws-ec2.";
    public static final String AlertMsgAccessAWS                 = "Enter the Access Key for the AWS account.";
    public static final String AlertMsgSecretAccesskeyAWS        = "Enter the Secret Access Key for the AWS account.";
    public static final String AlertMsgRegionNameAWS             = "Select an availability zone supported by your AWS account. The availability zone will determine the region used to provision clusters.";
    public static final String AlertMsgSubnetIdAWS               = "Enter the ID of the AWS Subnet where clusters will be deployed";
    public static final String AlertMsgAwsLicenseAgreement        ="If you have already accepted on this account, you don't need to click. If you do not accept the license, provisions will fail";

    // Required input data for Edit cloud Definition tests
    public static final String WarningMsgReqField                = "This field is required";
    public static final String WarningMsgCloudField              = "The minimum length for this field is 1";
    public static final String WarningMsgEmailField              = "Invalid email address";

    // input fields to create New User
    public static final String NewUser_Firstname ="Test";
    public static final String NewUser_Lastname ="user";
    public static final String NewUser_Emailid ="Testuser@localhost.com";
    public static final String NewUser_Username ="testuser";
    public static final String NewUser_Password ="password";
    public static final String NewUser_confirmpassword ="password";

    public static final String NewUser_privilege_amc ="Access to AMC";
    public static final String NewUser_privilege_admin ="Admin Access";
    public static final String NewUser_privilege_no ="No Access";

    public static final String EditUser_Firstname ="Test1";
    public static final String EditUser_Lastname ="user1";
    public static final String EditUser_Emailid ="Testuser1@localhost.com";
    public static final String EditUser_Username ="edit_testuser";
    public static final String EditUser_Password ="password";
    public static final String EditUser_confirmpassword ="password";

    public static final String NewUser_Username1 ="testadmin";
    public static final String NewUser_Username2 ="testmaster";
    public static final String NewUser_Username3 ="testnoaccess";
    public static final String NewUser_Username4 ="testuser1";
}
