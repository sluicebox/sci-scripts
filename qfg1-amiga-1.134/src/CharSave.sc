;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use Interface)
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
	[local45 2]
	[local47 5]
	[local52 16]
	[local68 400]
	local468
	[local469 40]
)

(instance CharSave of Rm
	(properties
		picture 750
		style 7
	)

	(method (dispose)
		(SL code: gStatusCode)
		(super dispose:)
	)

	(method (init)
		(SL code: endStatus enable:)
		(super init: &rest)
		(gContMusic stop:)
		(User canControl: 0 canInput: 0)
		(self setScript: saveHero)
	)
)

(instance hq1_hero_sav of gamefile_sh
	(properties
		name {hq1 hero.sav}
	)
)

(instance saveHero of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Format @local52 601 0) ; "df0:hq1_hero.sav"
				(if (>= gScore 500)
					(HighPrint 601 1) ; "CONGRATULATIONS!! You have successfully completed "Hero's Quest I: So You Want To Be A Hero" with the maximum possible score, 500 of 500!! We welcome you to the ranks of the few, the proud, the True Heroes!"
				else
					(HighPrint (Format @local68 601 2 gScore)) ; "Congratulations! You have successfully completed "Hero's Quest I: So You Want To Be A Hero." Your final score was %d of 500 possible Puzzle Points."
				)
				(HighPrint 601 3) ; "If you have not already done so, we encourage you to play "Hero's Quest I" again with the other two character types; many of the puzzles are different, or have alternate solutions."
				(HighPrint 601 4) ; "In the meantime, you are already a winner! Please insert a writeable disk in your floppy drive to save your winning Hero for use in "Hero's Quest II: Trial By Fire.""
				(self cue:)
			)
			(1
				(= cycles 2)
			)
			(2
				(if
					(GetInput
						@local52
						30
						{Disk file in which to save your Hero.}
					)
					(hq1_hero_sav name: @local52)
					(= cycles 2)
				else
					(self changeState: 6)
				)
			)
			(3
				(if (hq1_hero_sav open: 2)
					(hq1_hero_sav close:)
					(= seconds 2)
				else
					(HighPrint (Format @local68 601 5 (hq1_hero_sav name:))) ; "Could not create file -- %s."
					(self changeState: 6)
				)
			)
			(4
				(if (not (hq1_hero_sav open: 0))
					(self changeState: 6)
					(return)
				)
				(for ((= temp0 0)) (< temp0 25) ((++ temp0))
					(= [local6 temp0] [gEgoStats temp0])
				)
				(= temp1 (+ [gInvNum 2] (/ [gInvNum 1] 10))) ; gold, silver
				(= local1 gHeroType)
				(= local2 (/ temp1 100))
				(= local3 (mod temp1 100))
				(= local4 gScore)
				(= local5 0)
				(if (gEgo has: 6) ; blade
					(|= local5 $0001)
				)
				(if (gEgo has: 33) ; chainmail
					(|= local5 $0002)
				)
				(if (gEgo has: 23) ; lockpick
					(|= local5 $0004)
				)
				(if (gEgo has: 24) ; thief kit
					(|= local5 $0008)
				)
				(if (gEgo has: 40) ; mirror
					(|= local5 $0010)
				)
				(if (IsFlag 325)
					(|= local5 $0020)
				)
				(if (< 255 gScore)
					(|= local5 $0040)
				)
				(= local31 [gInvNum 7]) ; dagger
				(= local32 [gInvNum 34]) ; healing
				(= local33 [gInvNum 35]) ; mana potion
				(= local34 [gInvNum 36]) ; vigor potion
				(= local35 [gInvNum 39]) ; grease
				(= local38 local44)
				(for ((= temp0 0)) (< temp0 35) ((+= temp0 2))
					(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $007f))
					(+= local38 [local0 (+ temp0 1)])
				)
				(= local39 0)
				(for ((= temp0 1)) (< temp0 35) ((+= temp0 2))
					(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $007f))
					(+= local39 [local0 (+ temp0 1)])
				)
				(&= local38 $007f)
				(&= local39 $007f)
				(for ((= temp0 0)) (< temp0 43) ((++ temp0))
					(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $007f))
					(= [local0 (+ temp0 1)]
						(^ [local0 (+ temp0 1)] [local0 temp0])
					)
				)
				(hq1_hero_sav write: @global401)
				(hq1_hero_sav write: {\n})
				(for ((= temp0 1)) (< temp0 44) ((++ temp0))
					(Format @local68 601 6 [local0 temp0]) ; "%2x"
					(hq1_hero_sav write: @local68)
				)
				(hq1_hero_sav write: {\n})
				(hq1_hero_sav close:)
				(= seconds 2)
			)
			(5
				(HighPrint 601 7) ; "The save character file has been created. Save this disk for use with "Hero's Quest II: Trial By Fire" from Sierra On-Line."
				(= local468 1)
				(= cycles 2)
			)
			(6
				(Format @local47 601 8) ; "n"
				(if
					(GetInput
						@local47
						2
						{If you wish to try saving your character again, type "y", then ENTER.  Otherwise type "n", then ENTER.}
					)
					(if (StrCmp @local47 {y})
						(self changeState: 8)
					else
						(= local36 121)
						(= local37 134)
						(= local40 67)
						(= local41 136)
						(= local42 173)
						(= local43 240)
						(self changeState: 1)
					)
				else
					(= cycles 2)
				)
			)
			(7
				(HighPrint 601 9) ; "Please answer "y" or "n"."
				(self changeState: 6)
			)
			(8
				(HighPrint 601 10) ; "Thank you for playing "Hero's Quest I: So You Want To Be A Hero," and congratulations again on winning. We'll see you again soon in "Hero's Quest II: Trial By Fire.""
				(= gQuit 1)
			)
		)
	)
)

(instance endStatus of Code
	(properties)

	(method (doit param1)
		(Format param1 601 11 gScore) ; "Wow! You're Really A Hero! [score %d of 500]"
	)
)

