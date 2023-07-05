;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use rm800)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	guardsScript 0
)

(local
	local0
	local1
)

(instance guardsScript of Script
	(properties)

	(method (dispose)
		(gGame handsOn:)
		(super dispose:)
		(DisposeScript 802)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager
					say: 6 1 (+ 24 ((ScriptID 80 0) tstFlag: #rFlag1 32)) 1 self ; rgCastle
				)
			)
			(1
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(gEgo
					normal: 0
					view: 802
					loop: 0
					cel: 0
					posn: 297 173
					setScale: 0
					scaleX: 128
					scaleY: 128
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gCast eachElementDo: #startUpd)
				(= cycles 4)
			)
			(3
				(gTheIconBar disable:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 802 10)
				(background addToPic:)
				(guard1 init: stopUpd:)
				(guard2 init: stopUpd:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 32)) ; rgCastle
					(gGame givePoints: 2)
					(saladin init: stopUpd:)
				)
				(= cycles 4)
			)
			(4
				(gTheIconBar enable:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 32)) ; rgCastle
					(self setScript: overHearGuards self)
				else
					(self setScript: guardsNotHere self)
				)
			)
			(5
				(background dispose:)
				(guard1 dispose: delete:)
				(guard2 dispose: delete:)
				(saladin dispose: delete:)
				(proc800_1)
				(gEgo setCycle: Beg self)
			)
			(6
				(gTheIconBar enable:)
				(gEgo posn: local0 local1 reset: 0)
				(= cycles 2)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance overHearGuards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 0) setFlag: #rFlag1 32) ; rgCastle
				(= cycles 3)
			)
			(1
				(gMessager say: 6 1 24 2 self oneOnly: 0) ; "Cap'n, I've been hearin' rumors from the guards who've been watchin' the princess. They say lately she's been poundin' on her door and beggin' to be let out."
			)
			(2
				(Print
					font: gUserFont
					width: 250
					posn: 20 139
					addText:
						{He was speakin' to that door--black magic, is what I say! I heard him say 'Ali', but then Bay came up and started yappin at me.}
					modeless: 1
					init:
				)
				(= seconds 10)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 10)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance guardsNotHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gMessager say: 6 1 25 2 self oneOnly: 0) ; "Captain Saladin has left, and the other two guard dogs are talking too quietly for Alexander to hear them."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance background of View
	(properties
		x 77
		y 54
		view 803
		signal 16400
	)
)

(instance guard1 of View
	(properties
		x 144
		y 125
		view 724
		loop 4
		cel 3
		scaleSignal 1
		scaleX 147
		scaleY 147
	)
)

(instance guard2 of View
	(properties
		x 127
		y 110
		view 726
		loop 4
		scaleSignal 1
		scaleX 121
		scaleY 121
	)
)

(instance saladin of View
	(properties
		x 167
		y 110
		view 736
		loop 4
		cel 2
		scaleSignal 1
		scaleX 112
		scaleY 112
	)
)

