;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use Print)
(use File)
(use Game)
(use User)
(use Actor)
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
	local5
	[local6 25]
	local31
	local32
	local33
	local34
	local35
	local36 = 121
	local37 = 134
	local38
	local39
	local40 = 67
	local41 = 136
	local42 = 173
	local43 = 240
	local44 = 206
	[local45 7]
	[local52 16]
	[local68 400]
	local468
	[local469 40]
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(= [gEgoStats temp0] 0)
	)
	(gEgo use: 2) ; sword
	(gEgo use: 3) ; chainMail
	(gEgo use: 7) ; lockPick
	(gEgo use: 8) ; thiefKit
	(gEgo use: 20) ; magicMirror
	(ClearFlag 325)
	((gInventory at: 38) amount: 0) ; gold
	((gInventory at: 0) amount: 0) ; silver
	((gInventory at: 6) amount: 0) ; dagger
	((gInventory at: 12) amount: 0) ; healingPotion
	((gInventory at: 13) amount: 0) ; manaPotion
	((gInventory at: 14) amount: 0) ; staminaPotion
	((gInventory at: 19) amount: 0) ; ghostOil
	(= gScore 0)
	(= gHeroType 0) ; Fighter
	(StrCpy @global428 {xxxxxxxxxxy})
	(for ((= temp0 0)) (< temp0 43) ((++ temp0))
		(= [local0 (+ temp0 1)] 0)
	)
)

(instance CharSave of Rm
	(properties
		noun 1
		picture 750
		style 7
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(SL enable:)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(self setScript: saveHero)
	)
)

(instance glory1_sav of File
	(properties
		name {glory1.sav}
	)
)

(instance saveHero of Script
	(properties)

	(method (handleEvent event)
		(if
			(and
				(>= state 9)
				(or
					(== (event type:) evKEYBOARD)
					(== (event type:) evMOUSEBUTTON)
					(== (event message:) KEY_RETURN)
				)
			)
			(event claimed: 1)
			(gGameControls window: (ScriptID 0 10) show:) ; gcWin
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				0
				(Format @local52 601 0) ; "a:glory1.sav"
				(if (>= gScore 500)
					(gMessager say: 1 0 8 1 self) ; "CONGRATULATIONS!! You have successfully completed "Quest for Glory I: So You Want To Be A Hero" with the maximum possible score, 500 of 500!! We welcome you to the ranks of the few, the proud, the True Heroes!"
				else
					(gMessager say: 1 0 4 1 self) ; "Congratulations! You have successfully completed "Quest for Glory I: So You Want To Be A Hero.""
				)
			)
			(1
				1
				(gMessager say: 1 0 5 0 self) ; "If you have not already done so, we encourage you to play "Quest for Glory I" again with the other two character types; many of the puzzles are different, or have alternate solutions."
			)
			(2
				2
				(if
					(Print
						mode: 1
						addText: {Disk file in which to save your Hero.}
						addEdit: @local52 30 0 30 @local52
						init:
					)
					(glory1_sav name: @local52)
					(= cycles 2)
				else
					(self changeState: 6)
				)
			)
			(3
				3
				(if (glory1_sav open: 2)
					(glory1_sav close:)
					(= seconds 2)
				else
					(self changeState: 6)
				)
			)
			(4
				4
				(if (not (glory1_sav open: 0))
					(self changeState: 6)
					(return)
				)
				(for ((= temp0 0)) (< temp0 25) ((++ temp0))
					(= [local6 temp0] [gEgoStats temp0])
				)
				(= temp1 (/ ((gInventory at: 0) amount:) 10)) ; silver
				(= local1 gHeroType)
				(= local2 (/ temp1 100))
				(= local3 (mod temp1 100))
				(= local4 gScore)
				(= local5 0)
				(if (gEgo has: 2) ; sword
					(|= local5 $0001)
				)
				(if (gEgo has: 3) ; chainMail
					(|= local5 $0002)
				)
				(if (gEgo has: 7) ; lockPick
					(|= local5 $0004)
				)
				(if (gEgo has: 8) ; thiefKit
					(|= local5 $0008)
				)
				(if (gEgo has: 20) ; magicMirror
					(|= local5 $0010)
				)
				(if (IsFlag 325)
					(|= local5 $0020)
				)
				(if (< 255 gScore)
					(|= local5 $0040)
				)
				(= local31 ((gInventory at: 6) amount:)) ; dagger
				(= local32 ((gInventory at: 12) amount:)) ; healingPotion
				(= local33 ((gInventory at: 13) amount:)) ; manaPotion
				(= local34 ((gInventory at: 14) amount:)) ; staminaPotion
				(= local35 ((gInventory at: 19) amount:)) ; ghostOil
				(= local38 local44)
				(for ((= temp0 0)) (< temp0 35) ((+= temp0 2))
					(&= [local0 (+ temp0 1)] $007f)
					(+= local38 [local0 (+ temp0 1)])
				)
				(= local39 0)
				(for ((= temp0 1)) (< temp0 35) ((+= temp0 2))
					(&= [local0 (+ temp0 1)] $007f)
					(+= local39 [local0 (+ temp0 1)])
				)
				(&= local38 $007f)
				(&= local39 $007f)
				(for ((= temp0 0)) (< temp0 43) ((++ temp0))
					(&= [local0 (+ temp0 1)] $007f)
					(^= [local0 (+ temp0 1)] [local0 temp0])
				)
				(glory1_sav writeString: @global428)
				(glory1_sav writeString: {\n})
				(for ((= temp0 1)) (< temp0 44) ((++ temp0))
					(Format @local68 601 1 [local0 temp0]) ; "%2x"
					(glory1_sav writeString: @local68)
				)
				(glory1_sav writeString: {\n})
				(glory1_sav close:)
				(= seconds 2)
			)
			(5
				5
				(gMessager say: 1 0 1) ; "The save character file has been created. Save this disk for use with "Quest for Glory II: Trial By Fire" from Sierra On-Line."
				(= local468 1)
				(= cycles 2)
			)
			(6
				6
				(switch
					(= temp3
						(Print
							mode: 1
							addText:
								{Do you wish to try saving your character again?}
							addButton: 0 { No } 55 30
							addButton: 1 { Yes } 95 30
							init:
						)
					)
					(0
						(= state 7)
						(gMessager say: 1 0 7 1 self) ; "Thank you for playing "Quest for Glory I: So You Want To Be A Hero," and congratulations again on winning. We'll see you again soon in "Quest for Glory II: Trial By Fire.""
					)
					(1
						(= temp3 2)
						(= local36 121)
						(= local37 134)
						(= local40 67)
						(= local41 136)
						(= local42 173)
						(= local43 240)
						(self changeState: temp3)
					)
				)
			)
			(7
				7
				(gMessager say: 1 0 7 1 self) ; "Thank you for playing "Quest for Glory I: So You Want To Be A Hero," and congratulations again on winning. We'll see you again soon in "Quest for Glory II: Trial By Fire.""
			)
			(8
				(gCurRoom drawPic: 903 10)
				(= seconds 3)
			)
			(9
				(User canControl: 1 canInput: 1)
				(gCurRoom drawPic: 903 9)
				(animators init:)
				(= seconds 8)
			)
			(10
				(gCurRoom drawPic: 903 9)
				(animators dispose:)
				(artists init:)
				(= seconds 8)
			)
			(11
				(gCurRoom drawPic: 903 9)
				(artists dispose:)
				(programmers init:)
				(= seconds 8)
			)
			(12
				(gCurRoom drawPic: 903 9)
				(programmers dispose:)
				(musicDirector init:)
				(= seconds 8)
			)
			(13
				(gCurRoom drawPic: 903 9)
				(musicDirector dispose:)
				(developmentSys init:)
				(= seconds 8)
			)
			(14
				(gCurRoom drawPic: 903 9)
				(developmentSys dispose:)
				(soundEffects init:)
				(= seconds 8)
			)
			(15
				(gCurRoom drawPic: 903 9)
				(soundEffects dispose:)
				(qualityDudes init:)
				(= seconds 8)
			)
			(16
				(gGameControls window: (ScriptID 0 10) show:) ; gcWin
				(= ticks 10)
			)
			(17
				(= gQuit 1)
			)
		)
	)
)

(instance endStatus of Code ; UNUSED
	(properties)

	(method (doit param1)
		(Format param1 601 2 gScore) ; "Wow! You're Really A Hero! [score %d of 500]"
	)
)

(instance animators of View
	(properties
		x 170
		y 167
		view 902
		loop 1
	)
)

(instance artists of View
	(properties
		x 161
		y 135
		view 902
		loop 2
	)
)

(instance programmers of View
	(properties
		x 158
		y 110
		view 902
		loop 3
	)
)

(instance musicDirector of View
	(properties
		x 105
		y 65
		view 902
		loop 4
	)
)

(instance developmentSys of View
	(properties
		x 85
		y 165
		view 902
		loop 5
	)
)

(instance soundEffects of View
	(properties
		x 95
		y 65
		view 902
		loop 6
	)
)

(instance qualityDudes of View
	(properties
		x 94
		y 65
		view 902
		loop 7
	)
)

