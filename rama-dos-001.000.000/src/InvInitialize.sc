;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use thighComputer)
(use VidmailChoices)
(use InvInset)
(use SaveManager)
(use RamaInterface)
(use n1111)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	InvInitialize 0
	proc70_1 1
	proc70_2 2
	proc70_3 3
	proc70_4 4
	proc70_5 5
	proc70_6 6
	proc70_7 7
	proc70_8 8
	proc70_9 9
	proc70_10 10
	proc70_11 11
	playersInventory 12
	falstaffInventory 13
	proc70_14 14
	InvDispose 15
)

(procedure (proc70_1 param1 param2 param3 &tmp temp0 temp1 temp2)
	(if (and argc (> param1 -1))
		(if (== param1 124)
			(= temp1 (invMannaMelon new:))
			(++ global231)
		else
			(= temp1 (proc70_6 param1))
		)
	else
		(= temp1 (gTheCursor invItem:))
	)
	(if temp1
		(switch (= temp2 (temp1 owner:))
			(-3
				(cond
					((and (not global125) (IsFlag 14))
						(InvInset dispose:)
						(gTheCursor setNormalCursor:)
					)
					((not global125)
						(gTheCursor setNormalCursor:)
					)
					((!= (global125 myInvObj:) temp1)
						(gTheCursor setInvCursor: (global125 myInvObj:))
					)
					(else
						(global125 myInvObj: 0)
						(InvInset dispose:)
						(gTheCursor setNormalCursor:)
					)
				)
				(cond
					((> argc 2)
						(= temp0 param3)
					)
					((not (= temp0 (InventoryWindow whichHas: temp1)))
						(= temp0 (InventoryWindow at: 0))
					)
				)
				(gInventory addInvItem: temp1 temp0)
			)
			(else
				(cond
					((or (< 0 argc 2) (not param2))
						(gTheCursor setInvCursor: temp1)
					)
					((and (> argc 2) param3)
						(gInventory addInvItem: temp1 param3)
					)
					(else
						(gInventory addInvItem: temp1 (InventoryWindow at: 0))
					)
				)
			)
		)
	)
	(return temp1)
)

(procedure (proc70_8 param1 &tmp temp0)
	(if (not (= temp0 (InventoryWindow firstTrue: #containsInv param1)))
		(= temp0 (InventoryWindow at: 0))
	)
	(gInventory addInvItem: param1 temp0)
)

(procedure (proc70_2 &tmp temp0 temp1) ; UNUSED
	(for ((= temp0 0)) (< temp0 123) ((++ temp0))
		(= temp1 (proc70_6 temp0))
		(if (== (temp1 owner:) gEgo)
			(proc70_1 temp0 1)
		)
	)
)

(procedure (proc70_3 param1 param2 &tmp temp0 temp1 temp2)
	(switch argc
		(0
			(= temp1 (gTheCursor invItem:))
		)
		(1
			(= temp1 (proc70_6 param1))
		)
		(2
			(= temp1 param2)
			(-- global231)
		)
	)
	(= temp2 (temp1 owner:))
	(gInventory deleteInvItem: temp1)
	(if (== temp2 -3)
		(gTheCursor setNormalCursor:)
	)
	(temp1 dispose:)
)

(procedure (proc70_4 param1 param2 &tmp temp0) ; UNUSED
	(if (and (= temp0 (proc70_6 param1)) (== (temp0 owner:) (gInventory owner:)))
		(temp0 setHotspot: param2)
	)
)

(procedure (proc70_5 param1 &tmp temp0) ; UNUSED
	(if (and (= temp0 (proc70_6 param1)) (== (temp0 owner:) (gInventory owner:)))
		(temp0 deleteHotspot:)
	)
)

(procedure (proc70_6 param1)
	(return
		(switch param1
			(0 invAvianCup)
			(1 invAvianRing)
			(2 invAvianRope)
			(3 invAvianSqawkBox)
			(4 invAvianToken)
			(5 invBlue_Filter)
			(6 invCatechismCard)
			(7 invChartOf41)
			(8 invCigaretteCase)
			(9 invCigaretteLighter)
			(10 invCPMapPiece_1)
			(11 invCPMapPiece_2)
			(12 invCPMapPiece_3)
			(13 invCPMapPiece_4)
			(14 invCPMapPiece_5)
			(15 invCPMapPiece_6)
			(16 invCraneBiotLaser)
			(17 invCrowBar)
			(18 invDataCube_4)
			(19 invDataCube_5)
			(20 invDataCube_6)
			(21 invDataCube_7)
			(22 invDataCube_8)
			(23 invDataCube_9)
			(24 invDataCube_10)
			(25 invDataCube_11)
			(26 invDataCube_12)
			(27 invDataCube_13)
			(28 invDataCube_15)
			(29 invDataCube_16)
			(30 invDataCube_17)
			(31 invDecryptionCard_1)
			(32 invDecryptionCard_2)
			(33 invFalstaff)
			(34 invFermentationAgent)
			(35 invGourdOfOil)
			(36 invHumanKey)
			(37 invHumanTalisman)
			(38 invHydraulicJack)
			(40 invInventoryMedallion)
			(39 invISAComputer)
			(41 invJewel_1)
			(42 invJewel_2)
			(43 invJewel_3)
			(44 invKeyRing)
			(45 invKnife)
			(46 invLadder)
			(48 invMP_Piece_Box)
			(47 invMaze_Controller_Card)
			(64 invMP_Piece_L11x)
			(65 invMP_Piece_L11y)
			(66 invMP_Piece_L11z)
			(67 invMP_Piece_L21x)
			(68 invMP_Piece_L21y)
			(69 invMP_Piece_L21z)
			(70 invMP_Piece_L22x)
			(71 invMP_Piece_L22y)
			(72 invMP_Piece_L22z)
			(73 invMP_Piece_L31x)
			(74 invMP_Piece_L31y)
			(75 invMP_Piece_L31z)
			(76 invMP_Piece_L32x)
			(77 invMP_Piece_L32y)
			(78 invMP_Piece_L32z)
			(49 invMP_Piece_B11x)
			(50 invMP_Piece_B11y)
			(51 invMP_Piece_B11z)
			(52 invMP_Piece_B21x)
			(53 invMP_Piece_B21y)
			(54 invMP_Piece_B21z)
			(55 invMP_Piece_B22x)
			(56 invMP_Piece_B22y)
			(57 invMP_Piece_B22z)
			(58 invMP_Piece_B31x)
			(59 invMP_Piece_B31y)
			(60 invMP_Piece_B31z)
			(61 invMP_Piece_B32x)
			(62 invMP_Piece_B32y)
			(63 invMP_Piece_B32z)
			(79 invMetallicCorn)
			(80 invMirmicatCuttingTool)
			(81 invMirmicatID)
			(82 invNoteFromNicole)
			(83 invNYMapPiece_1)
			(84 invNYMapPiece_2)
			(85 invNYMapPiece_3)
			(86 invNYMapPiece_4)
			(87 invNYMapPiece_5)
			(88 invNYMapPiece_6)
			(89 invOctoFood)
			(90 invOctoFood2)
			(91 invOctoKey)
			(92 invOctoKey_BO)
			(93 invOctoKey_BY)
			(94 invOctoKey_BY_2)
			(95 invOctoKey_GG)
			(96 invOctoKey_GG_2)
			(97 invOctoKey_GR)
			(98 invOctoKey_GR_2)
			(99 invOctoKey_IG)
			(100 invOctoKey_IY)
			(101 invOctoKey_OR)
			(102 invOctoKey_VB)
			(103 invOctoKey_YR)
			(104 invOctoTalisman)
			(105 invOpticalLense_1)
			(106 invOpticalLense_2)
			(107 invOpticalLense_3)
			(108 invOToolSnapShot)
			(109 invOToolUniversalID)
			(110 invOttosKey)
			(111 invPerchStool)
			(112 invPlayersLockerKey)
			(113 invPrism)
			(114 invPuck)
			(115 invRedFilter)
			(116 invRosettaStone)
			(117 invTuningFork_TA)
			(118 invTuningFork_TB)
			(119 invTuningFork_TC)
			(120 invTuningFork_TD)
			(121 invTuningFork_TE)
			(122 invVideoCamera)
			(123 invYellowFilter)
			(else 0)
		)
	)
)

(procedure (proc70_7 param1)
	(if (== (param1 noun:) 8)
		(return 124)
	)
	(return
		(switch param1
			(invAvianCup 0)
			(invAvianRing 1)
			(invAvianRope 2)
			(invAvianSqawkBox 3)
			(invAvianToken 4)
			(invBlue_Filter 5)
			(invCatechismCard 6)
			(invChartOf41 7)
			(invCigaretteCase 8)
			(invCigaretteLighter 9)
			(invCPMapPiece_1 10)
			(invCPMapPiece_2 11)
			(invCPMapPiece_3 12)
			(invCPMapPiece_4 13)
			(invCPMapPiece_5 14)
			(invCPMapPiece_6 15)
			(invCraneBiotLaser 16)
			(invCrowBar 17)
			(invDataCube_4 18)
			(invDataCube_5 19)
			(invDataCube_6 20)
			(invDataCube_7 21)
			(invDataCube_8 22)
			(invDataCube_9 23)
			(invDataCube_10 24)
			(invDataCube_11 25)
			(invDataCube_12 26)
			(invDataCube_13 27)
			(invDataCube_15 28)
			(invDataCube_16 29)
			(invDataCube_17 30)
			(invDecryptionCard_1 31)
			(invDecryptionCard_2 32)
			(invFalstaff 33)
			(invFermentationAgent 34)
			(invGourdOfOil 35)
			(invHumanKey 36)
			(invHumanTalisman 37)
			(invHydraulicJack 38)
			(invInventoryMedallion 40)
			(invISAComputer 39)
			(invJewel_1 41)
			(invJewel_2 42)
			(invJewel_3 43)
			(invKeyRing 44)
			(invKnife 45)
			(invLadder 46)
			(invMaze_Controller_Card 47)
			(invMP_Piece_Box 48)
			(invMP_Piece_L11x 64)
			(invMP_Piece_L11y 65)
			(invMP_Piece_L11z 66)
			(invMP_Piece_L21x 67)
			(invMP_Piece_L21y 68)
			(invMP_Piece_L21z 69)
			(invMP_Piece_L22x 70)
			(invMP_Piece_L22y 71)
			(invMP_Piece_L22z 72)
			(invMP_Piece_L31x 73)
			(invMP_Piece_L31y 74)
			(invMP_Piece_L31z 75)
			(invMP_Piece_L32x 76)
			(invMP_Piece_L32y 77)
			(invMP_Piece_L32z 78)
			(invMP_Piece_B11x 49)
			(invMP_Piece_B11y 50)
			(invMP_Piece_B11z 51)
			(invMP_Piece_B21x 52)
			(invMP_Piece_B21y 53)
			(invMP_Piece_B21z 54)
			(invMP_Piece_B22x 55)
			(invMP_Piece_B22y 56)
			(invMP_Piece_B22z 57)
			(invMP_Piece_B31x 58)
			(invMP_Piece_B31y 59)
			(invMP_Piece_B31z 60)
			(invMP_Piece_B32x 61)
			(invMP_Piece_B32y 62)
			(invMP_Piece_B32z 63)
			(invMetallicCorn 79)
			(invMirmicatCuttingTool 80)
			(invMirmicatID 81)
			(invNoteFromNicole 82)
			(invNYMapPiece_1 83)
			(invNYMapPiece_2 84)
			(invNYMapPiece_3 85)
			(invNYMapPiece_4 86)
			(invNYMapPiece_5 87)
			(invNYMapPiece_6 88)
			(invOctoFood 89)
			(invOctoFood2 90)
			(invOctoKey 91)
			(invOctoKey_BO 92)
			(invOctoKey_BY 93)
			(invOctoKey_BY_2 94)
			(invOctoKey_GG 95)
			(invOctoKey_GG_2 96)
			(invOctoKey_GR 97)
			(invOctoKey_GR_2 98)
			(invOctoKey_IG 99)
			(invOctoKey_IY 100)
			(invOctoKey_OR 101)
			(invOctoKey_VB 102)
			(invOctoKey_YR 103)
			(invOctoTalisman 104)
			(invOpticalLense_1 105)
			(invOpticalLense_2 106)
			(invOpticalLense_3 107)
			(invOToolSnapShot 108)
			(invOToolUniversalID 109)
			(invOttosKey 110)
			(invPerchStool 111)
			(invPlayersLockerKey 112)
			(invPrism 113)
			(invPuck 114)
			(invRedFilter 115)
			(invRosettaStone 116)
			(invTuningFork_TA 117)
			(invTuningFork_TB 118)
			(invTuningFork_TC 119)
			(invTuningFork_TD 120)
			(invTuningFork_TE 121)
			(invVideoCamera 122)
			(invYellowFilter 123)
			(else -1)
		)
	)
)

(procedure (proc70_9 param1 &tmp temp0)
	(= temp0 (proc70_6 param1))
	(temp0 owner:)
)

(procedure (proc70_10 param1 param2 &tmp temp0)
	(= temp0 (proc70_6 param1))
	(temp0 owner: param2)
)

(procedure (proc70_11)
	(falstaffInventory init:)
)

(procedure (proc70_14)
	(falstaffInventory dispose:)
)

(instance InvInitialize of Code
	(properties)

	(method (doit)
		(InventoryWindow init:)
		(playersInventory init:)
	)
)

(instance InvDispose of Code
	(properties)

	(method (doit)
		(playersInventory dispose:)
		(InventoryWindow dispose:)
	)
)

(class InventoryItem of View
	(properties
		modNum 90
		noun 15
		priority 250
		verb 2
		owner -1
		case 4
		closeView -1
		hiliteState 0
	)

	(method (init)
		(Lock rsVIEW view 1)
		(&= signal $efff)
		(super init: &rest)
		(self setHotspot: 2 32 11)
	)

	(method (dispose)
		(Lock rsVIEW view 0)
		(global123 delete: self)
		(self deleteHotspot:)
		(self owner: -1)
		(super dispose:)
	)

	(method (setHotspot)
		(super setHotspot: &rest 2 32 11)
	)

	(method (isMyVerb param1)
		(return (== verb param1))
	)

	(method (giveTo param1)
		(= owner param1)
		(return self)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)

	(method (isPreRendered)
		(return (!= closeView -1))
	)

	(method (show)
		(if
			(and
				(!= owner -3)
				(or (not global125) (!= (global125 myInvObj:) self))
			)
			(super show: &rest)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(switch theVerb
			(1
				(super doVerb: theVerb)
				(global123 displayOptionsText: modNum noun 0 case 1)
				(cond
					(
						(and
							(gTheCursor isTempCursor:)
							(gTheCursor invItem:)
							(scratch respondsTo: ((gTheCursor invItem:) verb:))
						)
						(gTheCursor setInvCursor: (gTheCursor invItem:))
					)
					(
						(or
							(and
								(gTheCursor isInvCursor:)
								(not
									(scratch
										respondsTo: ((gTheCursor invItem:) verb:)
									)
								)
							)
							(not (gTheCursor hilited:))
						)
						(gTheCursor setTempCursor:)
						(gTheCursor hilite: 1)
					)
				)
			)
			(32
				(if (IsFlag 14)
					(= temp1 (gTheCursor invItem:))
					(self hide:)
					(= temp0 (proc70_7 temp1))
					(if (and global125 (!= temp1 (global125 myInvObj:)))
						(proc70_1 (proc70_7 temp1))
					)
					((ScriptID 75 0) resetInvObj: self) ; InvInset
					(gTheCursor setInvCursor: self)
				else
					(if (= temp1 (gTheCursor invItem:))
						(proc70_1 (proc70_7 temp1))
					)
					(if (IsFlag 1)
						(proc90_2)
						(proc70_1 39)
					)
					(self hide:)
					(gTheCursor setInvCursor: self)
					((ScriptID 75 0) init: 0 gCurRoom 0 0 self) ; InvInset
				)
			)
			(2
				(if (gTheCursor invItem:)
					(= temp1 (gTheCursor invItem:))
					(= temp0 (proc70_7 temp1))
					(cond
						((and global125 (== (global125 myInvObj:) temp1)) 0)
						((and (not global125) (IsFlag 14)) 0)
						((and (== temp1 invISAComputer) (IsFlag 1)) 0)
						((== temp0 124)
							(proc70_8 temp1)
						)
						(else
							(proc70_1 temp0)
						)
					)
				else
					(super doVerb: theVerb)
				)
				(self hide:)
				(gTheCursor setInvCursor: self)
			)
			(41
				(if (== (gTheCursor invItem:) self)
					(gTheCursor setInvCursor: self)
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)

	(method (serialize param1)
		(if (and argc param1)
			(self view: (SaveManager readWord:))
			(self loop: (SaveManager readWord:))
			(self cel: (SaveManager readWord:))
			(self verb: (SaveManager readWord:))
			(self owner: (SaveManager readWord:))
			(self hiliteState: (SaveManager readWord:))
			(self noun: (SaveManager readWord:))
			(self case: (SaveManager readWord:))
			(self closeView: (SaveManager readWord:))
			(self state: (SaveManager readWord:))
			(if (== owner -3)
				(gTheCursor setInvCursor: self)
			)
		else
			(SaveManager writeWord: (self view:))
			(SaveManager writeWord: (self loop:))
			(SaveManager writeWord: (self cel:))
			(SaveManager writeWord: (self verb:))
			(SaveManager writeWord: (self owner:))
			(SaveManager writeWord: (self hiliteState:))
			(SaveManager writeWord: (self noun:))
			(SaveManager writeWord: (self case:))
			(SaveManager writeWord: (self closeView:))
			(SaveManager writeWord: (self state:))
		)
	)
)

(instance invAvianCup of InventoryItem
	(properties
		noun 16
		verb 22
		owner 6500
		loop 5
		view 601
		closeView 20002
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22
				(= verb 21)
				(gTheCursor verb: 21)
				(self cel: 2 closeView: 20003)
			)
			(21
				(= verb 22)
				(gTheCursor verb: 22)
				(self cel: 0 closeView: 20002)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invAvianRing of InventoryItem
	(properties
		noun 19
		verb 48
		loop 9
		view 601
		closeView 20016
	)
)

(instance invAvianRope of InventoryItem
	(properties
		noun 13
		verb 24
		owner 6814
		loop 8
		view 601
		closeView 20023
	)
)

(instance invAvianSqawkBox of InventoryItem
	(properties
		noun 20
		verb 20
		loop 13
		view 601
		closeView 20030
	)
)

(instance invAvianToken of InventoryItem
	(properties
		noun 21
		verb 49
		owner 5005
		loop 53
		view 601
		closeView 20035
	)
)

(instance invBlue_Filter of InventoryItem
	(properties
		noun 103
		verb 131
		owner 5301
		loop 38
		view 601
		closeView 20006
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(invKnife cel: 12)
				(invKnife verb: 139)
				(invKnife setHotspot:)
				(if (and global125 (== (global125 myInvObj:) invKnife))
					(global125 setHotspot: 2 11)
					(global125 view: 20940)
				)
				(proc70_3 5)
				(gTheCursor lolite:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invCatechismCard of InventoryItem
	(properties
		noun 23
		verb 147
		owner 7800
		loop 59
		view 601
		closeView 20042
	)
)

(instance invChartOf41 of InventoryItem
	(properties
		noun 24
		verb 147
		owner 7800
		loop 56
		view 601
		closeView 20049
	)
)

(instance invCigaretteCase of InventoryItem
	(properties
		noun 26
		verb 51
		loop 35
		view 601
		closeView 20056
	)
)

(instance invCigaretteLighter of InventoryItem
	(properties
		noun 25
		verb 52
		owner 1011
		loop 37
		view 601
		closeView 20063
	)
)

(instance invCPMapPiece_1 of InventoryItem
	(properties
		noun 27
		verb 53
		owner 1011
		loop 41
		view 601
		closeView 20071
	)
)

(instance invCPMapPiece_2 of InventoryItem
	(properties
		noun 27
		state 1
		verb 53
		owner 2043
		loop 41
		cel 2
		view 601
		closeView 20072
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2043 2042)
						(2042
							(= verb 40)
							(= loop 51)
							(= closeView 20077)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 41)
				(= cel 0)
				(= verb 53)
				(= closeView 20072)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invCPMapPiece_3 of InventoryItem
	(properties
		noun 27
		state 1
		verb 53
		owner 2062
		loop 41
		cel 4
		view 601
		closeView 20073
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2062 2007)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invCPMapPiece_4 of InventoryItem
	(properties
		noun 27
		verb 53
		owner 3003
		loop 41
		cel 6
		view 601
		closeView 20074
	)
)

(instance invCPMapPiece_5 of InventoryItem
	(properties
		noun 27
		verb 53
		owner 3003
		loop 41
		cel 8
		view 601
		closeView 20075
	)
)

(instance invCPMapPiece_6 of InventoryItem
	(properties
		noun 27
		verb 53
		owner 3007
		loop 41
		cel 10
		view 601
		closeView 20076
	)
)

(instance invCraneBiotLaser of InventoryItem
	(properties
		noun 28
		verb 54
		owner 7921
		loop 61
		view 601
		closeView 20112
	)
)

(instance invCrowBar of InventoryItem
	(properties
		noun 106
		verb 45
		loop 23
		view 601
		closeView 20308
	)
)

(instance invDataCube_4 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 1011
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_5 of InventoryItem
	(properties
		noun 30
		verb 56
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_6 of InventoryItem
	(properties
		noun 30
		verb 56
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_7 of InventoryItem
	(properties
		noun 30
		verb 56
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_8 of InventoryItem
	(properties
		noun 30
		verb 56
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_9 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 7509
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_10 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 7509
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_11 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 7509
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_12 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 1016
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_13 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 5307
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_15 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 2009
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_16 of InventoryItem
	(properties
		noun 30
		verb 56
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDataCube_17 of InventoryItem
	(properties
		noun 30
		verb 56
		owner 5500
		loop 36
		view 601
		closeView 20126
	)
)

(instance invDecryptionCard_1 of InventoryItem
	(properties
		noun 22
		verb 50
		loop 47
		view 601
		closeView 20196
	)
)

(instance invDecryptionCard_2 of InventoryItem
	(properties
		noun 22
		verb 50
		owner 7509
		loop 47
		view 601
		closeView 20196
	)
)

(instance invFalstaff of InventoryItem
	(properties
		noun 104
		verb 43
		loop 16
		view 601
	)
)

(instance invFermentationAgent of InventoryItem
	(properties
		noun 31
		verb 57
		loop 10
		view 601
		closeView 20212
	)
)

(instance invGourdOfOil of InventoryItem
	(properties
		noun 10
		verb 15
		owner 6403
		loop 2
		view 601
		closeView 20224
	)
)

(instance invHumanKey of InventoryItem
	(properties
		noun 12
		verb 19
		owner 6911
		loop 3
		view 601
		closeView 20231
	)
)

(instance invHumanTalisman of InventoryItem
	(properties
		noun 33
		verb 59
		owner 4007
		loop 6
		view 601
		closeView 20240
	)
)

(instance invHydraulicJack of InventoryItem
	(properties
		noun 34
		verb 60
		loop 45
		view 601
		closeView 20246
	)
)

(instance invInventoryMedallion of InventoryItem
	(properties
		noun 35
		verb 61
		owner 3063
		loop 29
		view 601
		closeView 20254
	)
)

(instance invISAComputer of InventoryItem
	(properties
		noun 3
		verb 148
		loop 50
		cel 2
		view 601
	)

	(method (init)
		(super init: &rest)
		(SetFlag 84)
		(self setHotspot: 2 32 11 56 50)
	)

	(method (doVerb theVerb &tmp [temp0 2] temp2 temp3)
		(switch theVerb
			(56
				(self hide:)
				(= temp2 (gTheCursor invItem:))
				(proc70_3 (proc70_7 temp2))
				(insertCardSnd play:)
				(proc70_10 (proc70_7 temp2) 55)
				(proc55_3 (proc55_2 temp2))
				(proc70_1 39 1)
			)
			(50
				(self hide:)
				(= temp3 (gTheCursor invItem:))
				(proc70_3 (proc70_7 temp3))
				(insertCardSnd play:)
				(gTheCursor setInvCursor: self)
				(proc70_10 (proc70_7 temp3) 55)
				(cond
					((IsFlag 12)
						(proc44_8)
						(proc55_3 -1)
					)
					((IsFlag 1)
						(proc44_8)
					)
					(else
						(proc90_1)
					)
				)
				(proc70_1 39 1)
			)
			(32
				(if (IsFlag 1)
					(proc90_2)
				else
					(proc90_1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invJewel_1 of InventoryItem
	(properties
		noun 36
		verb 142
		owner 4008
		loop 25
		view 601
		closeView 20261
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(invKnife cel: 10)
				(invKnife verb: 140)
				(if (and global125 (== (global125 myInvObj:) invKnife))
					(global125 setHotspot: 2 11)
					(global125 view: 20938)
				)
				(proc70_3 41)
				(self owner: 45)
				(gTheCursor lolite:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invJewel_2 of InventoryItem
	(properties
		noun 36
		verb 142
		owner 4008
		loop 25
		view 601
		closeView 20261
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(invKnife cel: 10)
				(invKnife verb: 140)
				(if (and global125 (== (global125 myInvObj:) invKnife))
					(global125 setHotspot: 2 11)
					(global125 view: 20938)
				)
				(proc70_3 42)
				(self owner: 45)
				(gTheCursor lolite:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invJewel_3 of InventoryItem
	(properties
		noun 36
		verb 142
		owner 4008
		loop 25
		view 601
		closeView 20261
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(invKnife cel: 10)
				(invKnife verb: 140)
				(if (and global125 (== (global125 myInvObj:) invKnife))
					(global125 setHotspot: 2 11)
					(global125 view: 20938)
				)
				(proc70_3 43)
				(self owner: 45)
				(gTheCursor lolite:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invKeyRing of InventoryItem
	(properties
		noun 37
		verb 65
		owner 1008
		loop 27
		view 601
		closeView 20281
	)
)

(instance invKnife of InventoryItem
	(properties
		noun 1
		verb 34
		owner 1010
		case 1
		view 601
		closeView 20289
	)

	(method (init)
		(super init: &rest)
		(switch cel
			(4
				(self setHotspot: 131 129 119 142)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(131
				(self setHotspot:)
				(self cel: 12)
				(self verb: 139)
				(if (and global125 (== invBlue_Filter (global125 myInvObj:)))
					(InvInset resetInvObj: self)
				)
				(proc70_3 5)
			)
			(119
				(self setHotspot:)
				(self cel: 14)
				(self verb: 140)
				(if (and global125 (== invRedFilter (global125 myInvObj:)))
					(InvInset resetInvObj: self)
				)
				(proc70_3 115)
			)
			(129
				(self setHotspot:)
				(self cel: 16)
				(self verb: 141)
				(if (and global125 (== invYellowFilter (global125 myInvObj:)))
					(InvInset resetInvObj: self)
				)
				(proc70_3 123)
			)
			(142
				(self setHotspot:)
				(self cel: 10)
				(self verb: 140)
				(= temp0 (gTheCursor invItem:))
				(if (and global125 (== temp0 (global125 myInvObj:)))
					(InvInset resetInvObj: self)
				)
				(proc70_3 (proc70_7 temp0))
				(temp0 owner: 45)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invLadder of InventoryItem
	(properties
		noun 38
		verb 67
		owner 2054
		loop 57
		view 601
		closeView 20294
	)
)

(instance invMannaMelon of InventoryItem
	(properties
		noun 8
		verb 17
		loop 1
		view 601
		closeView 20947
	)

	(method (init)
		(super init: &rest)
		(switch cel
			(0
				(self setHotspot: 16)
			)
			(2
				(self setHotspot: 66)
			)
			(4
				(self setHotspot: 66)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(self cel: 2 deleteHotspot: setHotspot: 66)
			)
			(66
				(switch cel
					(2
						(self cel: 4)
						(if (IsFlag 14)
							((ScriptID 75 0) dispose:) ; InvInset
						)
						(FrameOut)
						(gGame setScript: (ScriptID 100 0)) ; eatMelonScr
					)
					(else
						(proc70_3 124 self)
						(if (IsFlag 14)
							((ScriptID 75 0) dispose:) ; InvInset
						)
						(FrameOut)
						(gGame setScript: (ScriptID 100 0)) ; eatMelonScr
					)
				)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance invMaze_Controller_Card of InventoryItem
	(properties
		noun 90
		verb 46
		owner 2039
		loop 21
		cel 60
		view 601
		closeView 20375
	)
)

(instance invMP_Piece_Box of InventoryItem
	(properties
		noun 108
		verb 132
		owner 3004
		loop 55
		view 601
		closeView 20961
	)
)

(instance invMP_Piece_L11x of InventoryItem
	(properties
		noun 41
		verb 70
		owner 1011
		loop 21
		cel 30
		view 601
		closeView 20345
	)
)

(instance invMP_Piece_L11y of InventoryItem
	(properties
		noun 41
		verb 47
		owner 2007
		loop 21
		cel 32
		view 601
		closeView 20347
	)
)

(instance invMP_Piece_L11z of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		owner 2049
		loop 21
		cel 34
		view 601
		closeView 20349
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2049 2042)
						(2042
							(= verb 38)
							(= loop 22)
							(= closeView 20350)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 21)
				(= cel 34)
				(= verb 47)
				(= closeView 20349)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_L21x of InventoryItem
	(properties
		noun 41
		state 1
		verb 71
		owner 2000
		loop 21
		cel 36
		view 601
		closeView 20351
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(-1 1)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_L21y of InventoryItem
	(properties
		noun 41
		verb 47
		owner 1011
		loop 21
		cel 38
		view 601
		closeView 20353
	)
)

(instance invMP_Piece_L21z of InventoryItem
	(properties
		noun 41
		verb 47
		owner 2007
		loop 21
		cel 40
		view 601
		closeView 20355
	)
)

(instance invMP_Piece_L22x of InventoryItem
	(properties
		noun 41
		verb 130
		owner 3004
		loop 21
		cel 42
		view 601
		closeView 20357
	)
)

(instance invMP_Piece_L22y of InventoryItem
	(properties
		noun 41
		verb 47
		owner 2000
		loop 21
		cel 44
		view 601
		closeView 20359
	)
)

(instance invMP_Piece_L22z of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		owner 2042
		loop 21
		cel 46
		view 601
		closeView 20361
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2042
							(= verb 38)
							(= loop 22)
							(= closeView 20362)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 21)
				(= cel 46)
				(= verb 47)
				(= closeView 20361)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_L31x of InventoryItem
	(properties
		noun 41
		state 1
		verb 72
		owner 2043
		loop 21
		cel 48
		view 601
		closeView 20363
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2043 2042)
						(2042
							(= verb 38)
							(= loop 22)
							(= closeView 20364)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 21)
				(= cel 48)
				(= verb 72)
				(= closeView 20363)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_L31y of InventoryItem
	(properties
		noun 41
		verb 72
		owner 3021
		loop 21
		cel 50
		view 601
		closeView 20365
	)
)

(instance invMP_Piece_L31z of InventoryItem
	(properties
		noun 41
		verb 47
		owner 3003
		loop 21
		cel 52
		view 601
		closeView 20367
	)
)

(instance invMP_Piece_L32x of InventoryItem
	(properties
		noun 41
		verb 73
		owner 3040
		loop 21
		cel 54
		view 601
		closeView 20369
	)
)

(instance invMP_Piece_L32y of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		loop 21
		cel 56
		view 601
		closeView 20371
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(-1 2042)
						(2042
							(= verb 38)
							(= loop 22)
							(= closeView 20372)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 21)
				(= cel 56)
				(= verb 47)
				(= closeView 20371)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_L32z of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		owner 2062
		loop 21
		cel 58
		view 601
		closeView 20373
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2062 2007)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B11x of InventoryItem
	(properties
		noun 41
		state 1
		verb 74
		owner 2011
		loop 21
		view 601
		closeView 20315
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2011 2007)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B11y of InventoryItem
	(properties
		noun 41
		verb 38
		owner 3040
		loop 22
		cel 2
		view 601
	)

	(method (init)
		(super init: &rest)
		(if (== verb 38)
			(= closeView 20318)
		else
			(= closeView 20317)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41
				(= view 601)
				(= loop 21)
				(= cel 2)
				(= verb 47)
				(= closeView 20317)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B11z of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		owner 2015
		loop 21
		cel 4
		view 601
		closeView 20319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2015 2013)
						(2013
							(= verb 38)
							(= loop 22)
							(= closeView 20320)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 21)
				(= cel 4)
				(= verb 47)
				(= closeView 20319)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invMP_Piece_B21x of InventoryItem
	(properties
		noun 41
		verb 38
		owner 3040
		loop 22
		cel 6
		view 601
		closeView 20322
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41
				(= view 601)
				(= loop 21)
				(= cel 6)
				(= verb 75)
				(= closeView 20321)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B21y of InventoryItem
	(properties
		noun 41
		verb 38
		owner 3040
		loop 22
		cel 8
		view 601
		closeView 20324
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41
				(= view 601)
				(= loop 21)
				(= cel 8)
				(= verb 47)
				(= closeView 20323)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B21z of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		owner 2016
		loop 21
		cel 10
		view 601
		closeView 20325
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2016 2007)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B22x of InventoryItem
	(properties
		noun 41
		verb 76
		owner 2043
		loop 21
		cel 12
		view 601
		closeView 20327
	)
)

(instance invMP_Piece_B22y of InventoryItem
	(properties
		noun 41
		verb 47
		owner 3004
		loop 21
		cel 14
		view 601
		closeView 20329
	)
)

(instance invMP_Piece_B22z of InventoryItem
	(properties
		noun 41
		verb 47
		owner 4022
		loop 21
		cel 16
		view 601
		closeView 20331
	)
)

(instance invMP_Piece_B31x of InventoryItem
	(properties
		noun 41
		verb 38
		owner 3040
		loop 22
		cel 18
		view 601
		closeView 20334
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41
				(= view 601)
				(= loop 21)
				(= cel 18)
				(= verb 77)
				(= closeView 20333)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B31y of InventoryItem
	(properties
		noun 41
		verb 47
		owner 2000
		loop 21
		cel 20
		view 601
		closeView 20335
	)
)

(instance invMP_Piece_B31z of InventoryItem
	(properties
		noun 41
		state 1
		verb 47
		owner 2013
		loop 21
		cel 22
		view 601
		closeView 20337
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2013
							(= verb 38)
							(= loop 22)
							(= closeView 20338)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 21)
				(= cel 22)
				(= verb 47)
				(= closeView 20337)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMP_Piece_B32x of InventoryItem
	(properties
		noun 41
		verb 78
		loop 21
		cel 24
		view 601
		closeView 20339
	)
)

(instance invMP_Piece_B32y of InventoryItem
	(properties
		noun 41
		verb 47
		owner 2027
		loop 21
		cel 26
		view 601
		closeView 20341
	)
)

(instance invMP_Piece_B32z of InventoryItem
	(properties
		noun 41
		verb 47
		owner 1011
		loop 21
		cel 28
		view 601
		closeView 20343
	)
)

(instance invMetallicCorn of InventoryItem
	(properties
		noun 42
		verb 79
		loop 11
		view 601
		closeView 20527
	)
)

(instance invMirmicatCuttingTool of InventoryItem
	(properties
		noun 43
		verb 80
		owner 4130
		loop 54
		view 601
		closeView 20539
	)
)

(instance invMirmicatID of InventoryItem
	(properties
		noun 44
		verb 23
		owner 6820
		loop 14
		view 601
		closeView 20541
	)
)

(instance invNoteFromNicole of InventoryItem
	(properties
		noun 112
		verb 147
		owner 2009
		loop 48
		view 601
		closeView 20959
	)
)

(instance invNYMapPiece_1 of InventoryItem
	(properties
		noun 45
		verb 81
		owner 1011
		loop 49
		view 601
		closeView 20546
	)
)

(instance invNYMapPiece_2 of InventoryItem
	(properties
		noun 45
		verb 81
		owner 2007
		loop 49
		cel 2
		view 601
		closeView 20547
	)
)

(instance invNYMapPiece_3 of InventoryItem
	(properties
		noun 45
		state 1
		verb 81
		owner 2041
		loop 49
		cel 4
		view 601
		closeView 20548
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2041 2042)
						(2042
							(= verb 39)
							(= loop 52)
							(= closeView 20552)
							3040
						)
						(else owner)
					)
				)
			)
			(41
				(= view 601)
				(= loop 49)
				(= cel 4)
				(= verb 81)
				(= closeView 20548)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invNYMapPiece_4 of InventoryItem
	(properties
		noun 45
		verb 81
		owner 3004
		loop 49
		cel 6
		view 601
		closeView 20549
	)
)

(instance invNYMapPiece_5 of InventoryItem
	(properties
		noun 45
		verb 81
		owner 3007
		loop 49
		cel 8
		view 601
		closeView 20550
	)
)

(instance invNYMapPiece_6 of InventoryItem
	(properties
		noun 45
		state 1
		verb 81
		owner 2062
		loop 49
		cel 10
		view 601
		closeView 20551
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2062 2007)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invOctoFood of InventoryItem
	(properties
		noun 91
		verb 82
		owner 7800
		loop 24
		view 601
		closeView 20588
	)
)

(instance invOctoFood2 of InventoryItem
	(properties
		noun 91
		verb 82
		owner 4007
		loop 24
		view 601
		closeView 20588
	)
)

(instance invOctoKey of InventoryItem
	(properties
		noun 11
		verb 18
		owner 6405
		loop 4
		view 601
		closeView 20595
	)
)

(instance invOctoKey_BO of InventoryItem
	(properties
		noun 49
		verb 84
		owner 7508
		loop 44
		cel 6
		view 601
		closeView 20609
	)
)

(instance invOctoKey_BY of InventoryItem
	(properties
		noun 51
		verb 86
		owner 5202
		loop 44
		cel 6
		view 601
		closeView 20623
	)
)

(instance invOctoKey_BY_2 of InventoryItem
	(properties
		noun 51
		verb 86
		owner 7506
		loop 44
		cel 6
		view 601
		closeView 20623
	)
)

(instance invOctoKey_GG of InventoryItem
	(properties
		noun 110
		verb 134
		owner 5302
		loop 44
		cel 4
		view 601
		closeView 20630
	)
)

(instance invOctoKey_GG_2 of InventoryItem
	(properties
		noun 110
		verb 134
		owner 7506
		loop 44
		cel 4
		view 601
		closeView 20630
	)
)

(instance invOctoKey_GR of InventoryItem
	(properties
		noun 53
		verb 88
		owner 5212
		loop 44
		cel 2
		view 601
		closeView 20637
	)
)

(instance invOctoKey_GR_2 of InventoryItem
	(properties
		noun 53
		verb 88
		owner 7506
		loop 44
		cel 2
		view 601
		closeView 20637
	)
)

(instance invOctoKey_IG of InventoryItem
	(properties
		noun 56
		verb 91
		owner 4212
		loop 44
		cel 6
		view 601
		closeView 20658
	)
)

(instance invOctoKey_IY of InventoryItem
	(properties
		noun 59
		verb 94
		owner 5310
		loop 44
		cel 6
		view 601
		closeView 20679
	)
)

(instance invOctoKey_OR of InventoryItem
	(properties
		noun 61
		verb 96
		owner 7506
		loop 44
		cel 2
		view 601
		closeView 20693
	)
)

(instance invOctoKey_VB of InventoryItem
	(properties
		noun 63
		verb 98
		owner 7506
		loop 44
		view 601
		closeView 20707
	)
)

(instance invOctoKey_YR of InventoryItem
	(properties
		noun 69
		verb 104
		owner 5321
		loop 44
		cel 2
		view 601
		closeView 20749
	)
)

(instance invOctoTalisman of InventoryItem
	(properties
		noun 71
		verb 106
		owner 4007
		loop 7
		view 601
		closeView 20765
	)
)

(instance invOpticalLense_1 of InventoryItem
	(properties
		noun 72
		verb 107
		owner 1016
		loop 30
		view 601
		closeView 20779
	)
)

(instance invOpticalLense_2 of InventoryItem
	(properties
		noun 73
		verb 108
		owner 2000
		loop 32
		view 601
		closeView 20786
	)
)

(instance invOpticalLense_3 of InventoryItem
	(properties
		noun 74
		state 1
		verb 109
		owner 2047
		loop 33
		view 601
		closeView 20772
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36
				(if (not (& state $0001))
					(return)
				)
				(= owner
					(switch owner
						(2047 2006)
						(else owner)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invOToolSnapShot of InventoryItem
	(properties
		noun 76
		verb 111
		owner 5319
		loop 63
		view 601
		closeView 20798
	)
)

(instance invOToolUniversalID of InventoryItem
	(properties
		noun 77
		verb 112
		owner 7922
		loop 58
		view 601
		closeView 20805
	)
)

(instance invOttosKey of InventoryItem
	(properties
		noun 102
		verb 37
		owner 1011
		loop 28
		view 601
		closeView 20282
	)
)

(instance invPerchStool of InventoryItem
	(properties
		noun 79
		verb 114
		owner 5022
		loop 46
		view 601
		closeView 20819
	)
)

(instance invPlayersLockerKey of InventoryItem
	(properties
		noun 80
		verb 115
		loop 26
		view 601
		closeView 20280
	)
)

(instance invPrism of InventoryItem
	(properties
		noun 82
		verb 117
		owner 5320
		loop 39
		view 601
		closeView 20840
	)
)

(instance invPuck of InventoryItem
	(properties
		noun 118
		verb 144
		owner 1012
		loop 18
		view 601
	)
)

(instance invRedFilter of InventoryItem
	(properties
		noun 84
		verb 119
		owner 2046
		loop 31
		view 601
		closeView 20854
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(invKnife cel: 14)
				(invKnife verb: 140)
				(invKnife setHotspot:)
				(if (and global125 (== (global125 myInvObj:) invKnife))
					(global125 setHotspot: 2 11)
					(global125 view: 20939)
				)
				(proc70_3 115)
				(gTheCursor lolite:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invRosettaStone of InventoryItem
	(properties
		noun 85
		verb 120
		owner 4132
		loop 42
		view 601
		closeView 20861
	)
)

(instance invTuningFork_TA of InventoryItem
	(properties
		noun 88
		verb 123
		owner 5518
		loop 12
		view 601
		closeView 20882
	)
)

(instance invTuningFork_TB of InventoryItem
	(properties
		noun 88
		verb 124
		owner 5505
		loop 12
		view 601
		closeView 20884
	)
)

(instance invTuningFork_TC of InventoryItem
	(properties
		noun 88
		verb 125
		owner 5515
		loop 12
		view 601
		closeView 20886
	)
)

(instance invTuningFork_TD of InventoryItem
	(properties
		noun 88
		verb 126
		owner 5509
		loop 12
		view 601
		closeView 20888
	)
)

(instance invTuningFork_TE of InventoryItem
	(properties
		noun 88
		verb 127
		owner 5512
		loop 12
		view 601
		closeView 20890
	)
)

(instance invVideoCamera of InventoryItem
	(properties
		noun 89
		verb 128
		owner 5307
		loop 34
		view 601
		closeView 20917
	)
)

(instance invYellowFilter of InventoryItem
	(properties
		noun 107
		verb 129
		owner 5003
		loop 40
		view 601
		closeView 20217
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(invKnife cel: 16)
				(invKnife verb: 141)
				(invKnife setHotspot:)
				(if (and global125 (== (global125 myInvObj:) invKnife))
					(global125 setHotspot: 2 11)
					(global125 view: 20941)
				)
				(proc70_3 123)
				(gTheCursor lolite:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class InventoryHole of Feature
	(properties
		modNum 90
		noun 7
		case 4
		sightAngle 360
		inventoryItem 0
	)

	(method (init)
		(= plane global124)
		(super init: &rest)
		(self setHotspot: 11)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if (gTheCursor isInvCursor:)
					(global123 displayOptionsText: modNum noun 0 case 1)
				else
					(global123 displayOptionsText:)
				)
				(super doVerb: theVerb)
			)
			(else
				(proc70_1 -1 1 self)
			)
		)
	)

	(method (isNotOccupied)
		(return (== inventoryItem 0))
	)

	(method (containsInv param1)
		(return (== inventoryItem param1))
	)

	(method (placeItem param1)
		(self removeItem:)
		(if (and argc param1)
			(= inventoryItem param1)
			(param1 x: (+ nsLeft 26) y: (+ nsTop 22))
			(if (not (global112 contains: param1))
				(param1 init: global112)
			)
			(if (param1 show:)
				(UpdateScreenItem param1)
			else
				(param1 hide:)
			)
		)
	)

	(method (removeItem)
		(if
			(and
				inventoryItem
				(== (inventoryItem x:) (+ nsLeft 26))
				(== (inventoryItem y:) (+ nsTop 22))
			)
			(inventoryItem hide: x: 0 y: 0)
		)
		(self inventoryItem: 0)
	)

	(method (serialize param1 &tmp temp0)
		(cond
			((and argc param1)
				(if (!= (= temp0 (SaveManager readWord:)) -1)
					(self placeItem: (gInventory at: temp0))
				)
			)
			(inventoryItem
				(SaveManager writeWord: (gInventory indexOf: inventoryItem))
			)
			(else
				(SaveManager writeWord: -1)
			)
		)
	)
)

(class InventoryWindow of List
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(= temp0 353)
		(= temp1 352)
		(for ((= temp2 0)) (< temp2 2) ((++ temp2))
			(for ((= temp3 0)) (< temp3 4) ((++ temp3))
				(InventoryWindow
					add:
						((InventoryHole new:)
							nsLeft: temp0
							nsTop: temp1
							nsRight: (+ temp0 53)
							nsBottom: (+ temp1 44)
							plane: global124
							init:
							yourself:
						)
				)
				(+= temp0 53)
			)
			(= temp0 353)
			(+= temp1 44)
		)
	)

	(method (clear)
		(if size
			(self eachElementDo: #removeItem)
		)
	)

	(method (whichHas param1 &tmp temp0)
		(= temp0 0)
		(if (and argc param1)
			(= temp0 (self firstTrue: #containsInv param1))
		)
		(return temp0)
	)

	(method (iWhichHas param1 &tmp temp0 temp1)
		(= temp0 -1)
		(if (and argc param1 (= temp1 (self whichHas: param1)))
			(= temp0 (self indexOf: temp1))
		)
		(return temp0)
	)

	(method (serialize param1)
		(if (and argc param1)
			(self clear:)
			(self eachElementDo: #serialize param1)
		else
			(self eachElementDo: #serialize param1)
		)
	)
)

(class InventoryList of List
	(properties
		owner -2
		startOfDisplay 0
	)

	(method (init)
		(super init:)
		(= gInventory self)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (contains)
		(if (self size:)
			(return (super contains: &rest))
		else
			(return 0)
		)
	)

	(method (addAt param1 param2)
		(switch param2
			(0
				(self addToFront: param1)
			)
			(else
				(self addAfter: (self at: (- param2 1)) param1)
			)
		)
	)

	(method (adjustGrid &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= temp1 (InventoryWindow at: temp0))
			(if (< (+ temp0 startOfDisplay) (self size:))
				(= temp2 (self at: (+ startOfDisplay temp0)))
				(temp1 placeItem: temp2)
			else
				(temp1 inventoryItem: 0)
			)
		)
	)

	(method (addInvItem param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (InventoryWindow firstTrue: #containsInv param1))
		(= temp4 (param1 owner:))
		(param1 owner: (gInventory owner:) state: (& (param1 state:) $fffe))
		(if param2
			(if (= temp0 (param2 inventoryItem:))
				(= temp2 (self indexOf: temp0))
			)
		else
			(= temp0 0)
		)
		(if (and (self contains: param1) (!= param2 temp1))
			(self delete: param1)
		)
		(cond
			((== temp1 param2)
				(param2 placeItem: param1)
			)
			(temp0
				(= temp3 (self indexOf: param1))
				(self addAt: param1 temp2)
				(= startOfDisplay (Min startOfDisplay temp2))
				(self adjustGrid:)
				(FrameOut)
			)
			(else
				(= temp1 (InventoryWindow firstTrue: #isNotOccupied))
				(temp1 placeItem: param1)
				(self add: param1)
				(self adjustGrid:)
			)
		)
	)

	(method (deleteInvItem param1 &tmp temp0 temp1)
		(if
			(and
				(self contains: param1)
				(>= (= temp0 (self indexOf: param1)) 0)
			)
			(= temp1 (InventoryWindow firstTrue: #containsInv param1))
			(self delete: param1)
			(if (and startOfDisplay (>= startOfDisplay temp0))
				(-- startOfDisplay)
			)
			(if temp1
				(temp1 inventoryItem: 0)
				(self adjustGrid:)
			)
		)
	)

	(method (scrollUp)
		(if (> startOfDisplay 0)
			(= startOfDisplay (Max (- startOfDisplay 4) 0))
			(self adjustGrid:)
		)
	)

	(method (scrollDown)
		(if (<= (+ startOfDisplay 8) (- size 1))
			(+= startOfDisplay 4)
			(self adjustGrid:)
		)
	)

	(method (serialize param1 &tmp temp0 temp1 temp2 temp3)
		(if (and argc param1)
			(if size
				(self eachElementDo: #dispose release:)
			)
			(self owner: (SaveManager readWord:))
			(self startOfDisplay: (SaveManager readWord:))
			(= temp3 (SaveManager readWord:))
			(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
				(if (== (= temp2 (SaveManager readWord:)) 124)
					(= temp1 (invMannaMelon new:))
					(temp1 serialize: param1)
				else
					(= temp1 (proc70_6 temp2))
				)
				(if size
					(self addToEnd: temp1)
				else
					(self add: temp1)
				)
			)
		else
			(SaveManager writeWord: (self owner:))
			(SaveManager writeWord: (self startOfDisplay:))
			(SaveManager writeWord: (self size:))
			(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
				(= temp1 (self at: temp0))
				(= temp2 (proc70_7 temp1))
				(SaveManager writeWord: temp2)
				(if (== temp2 124)
					(temp1 serialize: param1)
				)
			)
		)
	)
)

(instance playersInventory of InventoryList
	(properties)

	(method (init)
		(if (not (self size:))
			(super init:)
		else
			(self adjustGrid:)
		)
		(= gInventory self)
	)

	(method (dispose)
		(InventoryWindow clear:)
		(super dispose: &rest)
	)
)

(instance falstaffInventory of InventoryList
	(properties
		owner -4
	)

	(method (init)
		(InventoryWindow clear:)
		(super init:)
	)

	(method (dispose &tmp temp0 temp1)
		(InventoryWindow clear:)
		(playersInventory init:)
		(for ((= temp1 0)) (< temp1 (self size:)) ((++ temp1))
			(= temp0 (self at: temp1))
			(proc70_1 (proc70_7 temp0) 1)
		)
		(if (self size:)
			(self release:)
		)
		(FrameOut)
		(super dispose:)
	)
)

(instance insertCardSnd of Sound
	(properties
		number 6102
		flags 5
	)
)

