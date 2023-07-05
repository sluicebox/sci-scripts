;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use eRS)
(use Timer)
(use System)

(public
	actBreak 0
)

(instance actBreak of FPRoom
	(properties
		style 10
	)

	(method (init)
		(gGame handsOff:)
		(gTheIconBar disable: 7)
		(switch gAct
			(1
				(proc0_9 230)
				(gGameMusic1 number: global135 loop: -1 play:)
				(= gCurPuzzle 1)
				(SetFlag 18)
				(self picture: 143)
				(SetFlag 52)
			)
			(2
				(proc0_9 250)
				(gGameMusic2 number: 600 loop: -1 play:)
				(= gCurPuzzle 8)
				(= global139 0)
				(= global138 0)
				(gEgo x: 260 y: 106 setHeading: 180 put: 50 stopUpd:) ; Shot_Glass
				(= global123 1)
				(SetFlag 34)
				(ClearFlag 87)
				(ClearFlag 84)
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 5) ; deathTimer, deathTimer
				(self picture: 144)
				(ClearFlag 52)
			)
			(3
				(proc0_9 630)
				(gGameMusic1 number: 630 loop: -1 play:)
				(= global138 0)
				(= gCurPuzzle 16)
				(ClearFlag 87)
				(SetFlag 105)
				(gEgo x: 148 y: 118 setHeading: 90 stopUpd:)
				(ClearFlag 87)
				(PalVary pvUNINIT)
				(self picture: 145)
			)
			(4
				(if (!= gPrevRoomNum 630)
					(gGameMusic1 number: 638 loop: -1 play:)
				)
				(proc0_9 240)
				(= global138 0)
				(= gCurPuzzle 20)
				(gEgo put: 2 put: 6 put: 10 put: 38 put: 51 put: 52 put: 11) ; Boots, Church_Key, Clothes, Neckerchief, Shovel, Silver_Ear, Coffee
				(gTheIconBar enable:)
				(ClearFlag 87)
				(self picture: 146)
			)
			(5
				(ClearFlag 1)
				(gGameMusic1 number: 654 loop: -1 play:)
				(self picture: 147)
			)
		)
		(super init:)
		((Timer new:) setReal: self 5)
	)

	(method (cue)
		(switch gAct
			(1
				(gGameMusic1 fade: 63 5 1 0)
				(gCurRoom newRoom: 230)
			)
			(2
				(gGameMusic2 fade: 80 5 1 0)
				(gCurRoom newRoom: 250)
			)
			(3
				(gGameMusic2 fade: 80 5 1 0)
				(gCurRoom newRoom: 630)
			)
			(4
				(gCurRoom newRoom: 240)
			)
			(5
				(gCurRoom setScript: sEpilogue)
			)
		)
	)
)

(instance sEpilogue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 780)
				(= cycles 10)
			)
			(1
				(gMessager say: 1 0 0 0 self) ; "Yes, sir! By gum, by cracky!"
			)
			(2
				(gGameMusic1 fade: 0 6 2 1)
				(gCurRoom newRoom: 170)
				(self dispose:)
			)
		)
	)
)

