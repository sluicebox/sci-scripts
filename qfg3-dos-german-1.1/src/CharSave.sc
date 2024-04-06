;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Print)
(use LoadMany)
(use File)
(use Game)
(use User)
(use System)

(public
	CharSave 0
)

(local
	local0 = 83
	local1
	local2
	local3
	local4
	[local5 34]
	local39
	local40
	local41
	local42
	local43
	local44
	local45 = 25
	local46 = 190
	local47
	local48
	local49 = 55
	local50 = 109
	local51 = 196
	local52 = 242
	local53 = 208
	local54
	local55
	[local56 5]
	[local61 44]
	[local105 300]
	[local405 300]
	local705
	[local706 40]
	local746
)

(instance CharSave of Rm
	(properties
		style 7
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(LoadMany 0 993 944)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		((ScriptID 15) doit:) ; charSheet
		(gKeyDownHandler add: self)
		(User canControl: 0 canInput: 0)
		(self setScript: saveHero)
	)
)

(instance glory3_sav of File
	(properties
		name {glory3.sav}
	)
)

(instance saveHero of Script
	(properties)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN) register)
			(= register 0)
			(= cycles 1)
			(event claimed: 1)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(Animate)
				(Message msgGET 52 2 0 10 1 @local61) ; "a:glory3.sav"
				(if (>= gScore gPossibleScore)
					(gMessager say: 2 0 8 1 self) ; "CONGRATULATIONS!! You have successfully completed "Quest for Glory III: Wages of War" with the maximum possible score! We welcome you to the ranks of the few, the proud, the True Heroes!"
				else
					(Message msgGET 52 2 0 4 1 @local405) ; "Congratulations! You have successfully completed "Quest for Glory III: Wages of War" with a final score of %d out of a possible %d points."
					(Format @local105 @local405 gScore gPossibleScore)
					(Print mode: 1 width: 220 addText: @local105 init: self)
				)
				(= register 1)
			)
			(1
				(gMessager say: 2 0 5 0 self) ; "If you have not already done so, we encourage you to play "Quest for Glory III" again with the other character types. Many of the puzzles are different or have alternate solutions."
				(= register 1)
			)
			(2
				(if
					(Print
						addText: 2 0 11 1 ; "Disk file in which to save your Hero:"
						addEdit: @local61 30 0 30 @local61
						init:
					)
					(glory3_sav name: @local61)
					(= cycles 2)
				else
					(self changeState: 8)
				)
			)
			(3
				(if (!= (glory3_sav open: 1) 0)
					(Message msgGET 52 2 0 13 1 @local405) ; "You already have a file called "%s". Do you wish to overwrite it?"
					(Format @local105 @local405 (glory3_sav name:))
					(switch
						(= local746
							(Print
								mode: 1
								addText: @local105
								addButton: 1 2 0 14 1 10 45 ; "NO"
								addButton: 2 2 0 15 1 100 45 ; "YES"
								init:
							)
						)
						(1
							(self changeState: 2)
						)
						(2
							(glory3_sav close:)
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (glory3_sav open: 2)
					(glory3_sav close:)
					(= seconds 2)
				else
					(Message msgGET 52 2 0 2 1 @local405) ; "Could not create file "%s"."
					(Format @local105 @local405 (glory3_sav name:))
					(Print mode: 1 width: 220 addText: @local105 init:)
					(self changeState: 8)
				)
			)
			(5
				(if (not (glory3_sav open: 0))
					(self changeState: 8)
					(return)
				)
				(for ((= temp0 0)) (< temp0 34) ((++ temp0))
					(= [local5 temp0] [gEgoStats temp0])
				)
				(= temp1 (+ ((gInventory at: 0) amount:) (/ global410 100))) ; theRoyals
				(= local1 gHeroType)
				(= local2 (/ temp1 100))
				(= local3 (mod temp1 100))
				(= local4 0)
				(if (gEgo has: 16) ; theDispell
					(|= local4 $0001)
				)
				(if (gEgo has: 9) ; theTinderbox
					(|= local4 $0002)
				)
				(if (gEgo has: 28) ; thePin
					(|= local4 $0004)
				)
				(if (gEgo has: 2) ; theFineDagger
					(|= local4 $0008)
				)
				(if (gEgo has: 15) ; theWaterskin
					(|= local4 $0010)
				)
				(if (gEgo has: 33) ; theBird
					(|= local4 $0020)
				)
				(if (IsFlag 158)
					(|= local4 $0040)
				)
				(if (gEgo has: 26) ; theRope
					(|= local4 $0080)
				)
				(if (gEgo has: 7) ; theToolkit
					(|= local4 $0100)
				)
				(if (gEgo has: 1) ; theSword
					(|= local4 $0200)
				)
				(if (and (gEgo has: 5) (== gHeroType 0)) ; theShield, Fighter
					(|= local4 $0400)
				)
				(= local39 ((gInventory at: 14) amount:)) ; theRations
				(= local40 ((gInventory at: 10) amount:)) ; theDaggers
				(= local41 ((gInventory at: 25) amount:)) ; theOil
				(= local42 ((gInventory at: 12) amount:)) ; theHealPills
				(= local43 ((gInventory at: 13) amount:)) ; theManaPills
				(= local44 ((gInventory at: 11) amount:)) ; theCurePills
				(= local54 local53)
				(for ((= temp0 0)) (< temp0 44) ((+= temp0 2))
					(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
					(+= local54 [local0 (+ temp0 1)])
				)
				(= local55 0)
				(for ((= temp0 1)) (< temp0 44) ((+= temp0 2))
					(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
					(+= local55 [local0 (+ temp0 1)])
				)
				(= local47 local54)
				(= local48 local55)
				(for ((= temp0 0)) (< temp0 52) ((++ temp0))
					(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
					(^= [local0 (+ temp0 1)] [local0 temp0])
				)
				(= temp2 {*})
				(StrAt temp2 0 10)
				(glory3_sav writeString: { glory3.sav } temp2)
				(glory3_sav writeString: @global157 temp2)
				(for ((= temp0 1)) (< temp0 53) ((++ temp0))
					(Format @local105 {%2x} (/ [local0 temp0] 100))
					(glory3_sav writeString: @local105)
					(Format @local105 {%2x} (mod [local0 temp0] 100))
					(glory3_sav writeString: @local105)
				)
				(glory3_sav writeString: temp2)
				(glory3_sav close:)
				(= seconds 2)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= register 1)
				(gMessager say: 2 0 1 0 self) ; "The save character file has been created. Save this disk for use with "Quest for Glory IV: Shadows of Darkness" from Sierra On-Line."
			)
			(7
				(= local705 1)
				(self changeState: 9)
			)
			(8
				(if
					(= temp4
						(Print
							mode: 1
							addText: 2 0 16 1 ; "Would you like to try saving your character again?"
							addButton: 1 2 0 14 1 55 30 ; "NO"
							addButton: 2 2 0 15 1 95 30 ; "YES"
							init:
						)
					)
					(switch temp4
						(1
							(= temp4 9)
						)
						(2
							(= temp4 2)
							(= local45 25)
							(= local46 190)
							(= local49 55)
							(= local50 109)
							(= local51 196)
							(= local52 242)
						)
					)
				)
				(self changeState: temp4)
			)
			(9
				(gMessager say: 2 0 7 0 self) ; "Thank you for playing "Quest for Glory III: Wages of War", and congratulations again on winning. We'll see you again soon in "Quest for Glory IV: Shadows of Darkness.""
			)
			(10
				(gCurRoom newRoom: 890)
			)
		)
	)
)

