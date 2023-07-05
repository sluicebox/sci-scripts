;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 157)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	brigandsSouth 0
)

(instance brigandsSouth of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 157)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 95 9) ; brig1
					show:
					posn: 122 222
					setPri: 15
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 195 194 self
				)
			)
			(1
				((ScriptID 95 9) setMotion: MoveTo 295 194 self) ; brig1
				((ScriptID 95 11) ; brig3
					init:
					posn: 286 224
					setPri: 15
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 286 190
				)
			)
			(2
				(if (gEgo inRect: 220 150 320 200)
					(self changeState: 9)
				else
					((ScriptID 95 9) loop: 3) ; brig1
					((ScriptID 95 10) ; brig2
						init:
						posn: 340 194
						setPri: 15
						illegalBits: 0
						ignoreActors: 1
						setCycle: Walk
						setMotion: MoveTo 304 194 self
					)
				)
			)
			(3
				((ScriptID 95 10) loop: 3) ; brig2
				(= cycles 4)
			)
			(4
				(if ((ScriptID 95 0) notify: 3) ; rm95
					((ScriptID 95 11) loop: 0) ; brig3
					((ScriptID 95 10) loop: 1) ; brig2
					(= cycles 18)
				else
					((ScriptID 95 0) notify: 5) ; rm95
					((ScriptID 95 0) notify: 10) ; rm95
					((ScriptID 95 9) setPri: 14 setMotion: MoveTo 304 165) ; brig1
					((ScriptID 95 10) setPri: 14 setMotion: MoveTo 310 163) ; brig2
					((ScriptID 95 11) setPri: 14 setMotion: MoveTo 307 161) ; brig3
					(if (gEgo inRect: 50 108 230 124)
						(HandsOff)
						(gEgo loop: 0)
						(self changeState: 7)
					else
						(self changeState: 9)
					)
				)
			)
			(5
				((ScriptID 95 9) setMotion: MoveTo 340 194) ; brig1
				((ScriptID 95 10) setMotion: MoveTo 340 194) ; brig2
				((ScriptID 95 11) setMotion: MoveTo 307 250 self) ; brig3
			)
			(6
				((ScriptID 95 0) notify: 10) ; rm95
				((ScriptID 95 10) dispose:) ; brig2
				((ScriptID 95 11) dispose:) ; brig3
				(self dispose:)
			)
			(7
				(gEgo
					view: 525
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 50 110
				)
				(= cycles 2)
			)
			(8
				((ScriptID 95 9) ; brig1
					setPri: 13
					ignoreActors: 0
					setMotion: MoveTo 280 165
				)
				((ScriptID 95 10) ignoreActors: 0 setMotion: MoveTo 310 150) ; brig2
				(= cycles 20)
			)
			(9
				(EgoDead 157 0 82 516 0 9 80 {Don't you feel a draft?}) ; "You'd better find a way to prevent the brigands from getting at you from all sides if you want to survive this."
			)
		)
	)
)

