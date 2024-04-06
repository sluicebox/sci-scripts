;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use GloryRm)
(use DButton)
(use Str)
(use Print)
(use LoadMany)
(use File)
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
	[local5 48]
	local53 = 25
	local54 = 190
	local55
	local56
	local57 = 55
	local58 = 109
	local59 = 196
	local60 = 242
	local61 = 208
	local62
	local63
	local64
	local65
	local66
	local67
	local68
)

(instance CharSave of GloryRm
	(properties)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(LoadMany 0 64993 64944)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		(= local64 (Str new:))
		(= local65 (Str new:))
		(= local66 (Str new:))
		((ScriptID 15) doit:) ; charSheet
		(gKeyDownHandler add: self)
		(User canControl: 0 canInput: 0)
		(self setScript: saveHero)
	)
)

(instance glory4_sav of File
	(properties
		name {glory4.sav}
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
				(Message msgGET 52 2 0 10 1 (local64 data:)) ; "a:shadows.sav"
				(if (>= gScore gPossibleScore)
					(gMessager say: 2 0 8 1 self) ; "CONGRATULATIONS!! You have successfully completed "Quest for Glory: Shadows of Darkness" with the maximum possible score! We welcome you to the ranks of the few, the proud, the True Heroes!"
				else
					(Message msgGET 52 2 0 4 1 (local66 data:)) ; "Congratulations! You have successfully completed "Quest for Glory: Shadows of Darkness.""
					(local65 format: (local66 data:) gScore gPossibleScore)
					(Print addText: local65 init: self)
				)
				(= register 1)
			)
			(1
				(gMessager say: 2 0 5 0 self) ; "If you have not already done so, we encourage you to play "Shadows of Darkness" again with the other character types. Many of the puzzles are different or have alternate solutions."
				(= register 1)
			)
			(2
				(if
					(Print
						addText: 2 0 11 1 0 0 52 ; "Disk file in which to save your Hero:"
						font: 999
						addEdit: local64 30 0 30 local64
						init:
					)
					(glory4_sav name: (local64 data:))
					(= cycles 2)
				else
					(self changeState: 8)
				)
			)
			(3
				(if (!= (glory4_sav open: 1) 0)
					(Message msgGET 52 2 0 13 1 (local66 data:)) ; "You already have a file with that name. Do you wish to overwrite it?"
					(local65 format: (local66 data:) (glory4_sav name:))
					(gGlory setCursor: gNormalCursor)
					(switch
						(= local68
							(Print
								addText: local65
								classButton: MyButton
								font: 999
								addButton: 1 2 0 14 1 25 45 ; "NO"
								addButton: 2 2 0 15 1 105 45 ; "YES"
								init:
							)
						)
						(1
							(self changeState: 2)
						)
						(2
							(glory4_sav close:)
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (glory4_sav open: 2)
					(glory4_sav close:)
					(= seconds 2)
				else
					(Message msgGET 52 2 0 2 1 (local66 data:)) ; "Could not create that file."
					(local65 format: (local66 data:) (glory4_sav name:))
					(Print addText: local65 init:)
					(self changeState: 8)
				)
			)
			(5
				(if (not (glory4_sav open: 0))
					(self changeState: 8)
					(return)
				)
				(for ((= temp0 0)) (< temp0 42) ((++ temp0))
					(= [local5 temp0] [gEgoStats temp0])
				)
				(= temp1 (+ ((gInventory at: 0) amount:) (/ global154 100))) ; thePurse
				(= local1 gHeroType)
				(= local2 (/ temp1 100))
				(= local3 (mod temp1 100))
				(= local4 0)
				(if (IsFlag 387)
					(|= local4 $0010)
				)
				(if (gEgo has: 34) ; theBlackbird
					(|= local4 $0020)
				)
				(= local62 local61)
				(for ((= temp0 0)) (< temp0 52) ((+= temp0 2))
					(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
					(+= local62 [local0 (+ temp0 1)])
				)
				(= local63 0)
				(for ((= temp0 1)) (< temp0 52) ((+= temp0 2))
					(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
					(+= local63 [local0 (+ temp0 1)])
				)
				(= local55 local62)
				(= local56 local63)
				(for ((= temp0 0)) (< temp0 60) ((++ temp0))
					(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
					(^= [local0 (+ temp0 1)] [local0 temp0])
				)
				(= temp2 (Str newWith: 1 {*}))
				(temp2 at: 0 10)
				(glory4_sav writeString: { glory4.sav })
				(glory4_sav writeString: temp2)
				(glory4_sav writeString: gHeroName)
				(glory4_sav writeString: temp2)
				(for ((= temp0 1)) (< temp0 61) ((++ temp0))
					(local65 format: {%2x} (/ [local0 temp0] 100))
					(glory4_sav writeString: local65)
					(local65 format: {%2x} (mod [local0 temp0] 100))
					(glory4_sav writeString: local65)
				)
				(glory4_sav writeString: temp2)
				(glory4_sav close:)
				(= seconds 2)
			)
			(6
				(= register 1)
				(gMessager say: 2 0 1 0 self) ; "The save character file has been created. Save this disk for use with later Quest for Glory games from Sierra On-Line."
			)
			(7
				(= local67 1)
				(self changeState: 9)
			)
			(8
				(User canInput: 1)
				(if
					(= temp4
						(Print
							addText: 2 0 16 1 ; "Would you like to try saving your character again?"
							font: 999
							addButton: 1 2 0 14 1 55 30 ; "NO"
							addButton: 2 2 0 15 1 95 30 ; "YES"
							init:
						)
					)
					(switch temp4
						(1
							(User canInput: 0)
							(= temp4 9)
						)
						(2
							(User canInput: 0)
							(= temp4 2)
							(= local53 25)
							(= local54 190)
							(= local57 55)
							(= local58 109)
							(= local59 196)
							(= local60 242)
						)
					)
				)
				(self changeState: temp4)
			)
			(9
				(gMessager say: 2 0 7 0 self) ; "Thank you for playing "Quest for Glory: Shadows of Darkness," and congratulations again on winning. We hope to see you again in a future Quest for Glory."
			)
			(10
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(class MyButton of DButton
	(properties
		view 64990
		fore 0
		font 999
	)
)

