;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use Print)
(use Dialog)
(use Talker)
(use Game)
(use Actor)
(use System)

(public
	deathRm 0
)

(local
	local0
)

(instance deathRm of Room
	(properties
		picture 770
		style 14
		exitStyle 13
	)

	(method (init)
		(if (IsHiRes)
			(= picture 99)
			(hiResSkull init:)
		)
		(super init: &rest)
		(gGame handsOn:)
		(if (gGame keepBar:)
			(gTheIconBar erase:)
		)
		(gTheIconBar disable:)
		(= local0 gNarrator)
		(= gNarrator deathSpeaks)
		(gGkMusic1
			number: 325
			loop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 5 10 0
		)
		(gGame setCursor: ((ScriptID 0 1) view: 996)) ; globeCursor
		(self setScript: deathScript)
	)
)

(instance deathScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame setCursor: ((ScriptID 0 1) view: 999)) ; globeCursor
			)
			(1
				(gGame handsOn:)
				(gMessager say: 30 0 12 1 self 0) ; "(RRCC. FOR DEATH SCREEN. TO PLAYER--SARCASTIC)I really don't want to be dead.  Can we try that again?"
			)
			(2
				(= gNarrator local0)
				(gGame setCursor: ((ScriptID 0 1) view: 999)) ; globeCursor
				(repeat
					(SetCursor 36 140 280 175)
					(switch
						(myP
							dialog: myD
							addButtonBM: 770 0 0 87 {} 2 18
							addButtonBM: 770 1 0 110 {} 84 18
							addButtonBM: 770 2 0 111 {} 166 18
							y: 130
							init:
						)
						(87
							(gGame restore:)
						)
						(110
							(= gQuit 1)
							(break)
						)
						(111
							(gCurRoom newRoom: 93) ; restartGame
							(break)
						)
					)
				)
			)
		)
	)
)

(instance myP of Print
	(properties)

	(method (init &tmp temp0)
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(dialog mouseHiliting: 1)
		(plane picture: -2)
		(super init: &rest)
	)
)

(instance myD of Dialog
	(properties)

	(method (handleEvent event)
		(if (== (event message:) KEY_ESCAPE)
			(return 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance deathSpeaks of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self back: global214 font: gUserFont talkWidth: 290 x: 18 y: 157)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0)
		(= fore 54)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)
)

(instance hiResSkull of View
	(properties
		x 159
		y 70
		view 10771
	)
)

