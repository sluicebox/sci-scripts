;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 159)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	pushChair 0
	pushCan 1
	brigandsEast 2
)

(instance pushChair of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 159)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if ((ScriptID 95 0) notify: 6) ; rm95
					(gEgo setMotion: MoveTo 276 106 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 303 106 self)
			)
			(2
				(gEgo loop: 3)
				(= cycles 1)
			)
			(3
				(HighPrint 159 0) ; "You move the chair in front of the door."
				(gEgo setPri: 7 setMotion: MoveTo 300 102 self)
				((ScriptID 95 7) setCel: 0 posn: 297 100) ; chair
			)
			(4
				(gEgo setMotion: MoveTo 297 98 self)
				((ScriptID 95 7) posn: 288 96) ; chair
			)
			(5
				(gEgo setMotion: MoveTo 300 110 self)
			)
			(6
				(NormalEgo)
				(if ((ScriptID 95 0) notify: 3) ; rm95
					(gEgo illegalBits: $9000)
				)
				((ScriptID 95 0) notify: 5) ; rm95
				((ScriptID 95 0) notify: 7) ; rm95
				((ScriptID 95 12) dispose:) ; brig4
				((ScriptID 95 13) dispose:) ; brig5
				((ScriptID 95 14) dispose:) ; brig6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pushCan of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 159)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if ((ScriptID 95 0) notify: 6) ; rm95
					(gEgo illegalBits: 0 setMotion: MoveTo 270 100 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setPri: 6 setMotion: MoveTo 274 92 self)
			)
			(2
				(gEgo illegalBits: 0 loop: 1)
				(= cycles 1)
			)
			(3
				(gEgo view: 510 setLoop: 1 setCel: 0 setPri: 6 posn: 272 91)
				(= cycles 1)
			)
			(4
				(gEgo setCel: 1 posn: 271 91)
				(= cycles 1)
			)
			(5
				(gEgo setCel: 2 posn: 267 91)
				(= cycles 1)
			)
			(6
				(gEgo setCel: 1 posn: 261 91)
				((ScriptID 95 5) setCel: 1) ; candelabra
				(= cycles 1)
			)
			(7
				(gEgo setCel: 0 posn: 256 91)
				((ScriptID 95 5) setCel: 2) ; candelabra
				(= cycles 1)
			)
			(8
				(gEgo view: 4 setLoop: 1 setCel: 0)
				((ScriptID 95 5) setCel: 3) ; candelabra
				(= cycles 1)
			)
			(9
				((ScriptID 95 5) setCel: 4) ; candelabra
				(NormalEgo)
				(if ((ScriptID 95 0) notify: 3) ; rm95
					(gEgo illegalBits: $9000)
				)
				(= cycles 1)
			)
			(10
				((ScriptID 95 0) notify: 2) ; rm95
				((ScriptID 95 0) notify: 7) ; rm95
				(if ((ScriptID 95 0) notify: 4) ; rm95
					(HandsOn)
					(self dispose:)
				else
					((ScriptID 95 12) setScript: (ScriptID 159 2)) ; brig4, brigandsEast
				)
			)
		)
	)
)

(instance brigandsEast of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 159)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 95 0) notify: 11) ; rm95
				((ScriptID 95 3) setPri: 4 setCel: 1) ; rDoor
				((ScriptID 95 12) ; brig4
					show:
					setPri: 5
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					posn: 300 90
					setMotion: MoveTo 295 90 self
				)
			)
			(1
				((ScriptID 95 12) setMotion: MoveTo 282 100) ; brig4
				((ScriptID 95 13) ; brig5
					init:
					setPri: 5
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					posn: 310 90
					setMotion: MoveTo 294 90 self
				)
			)
			(2
				(if (gEgo inRect: 50 108 230 124)
					(HandsOff)
					(gEgo loop: 0)
					((ScriptID 95 12) setPri: -1 setMotion: MoveTo 224 113) ; brig4
					((ScriptID 95 13) setMotion: MoveTo 277 114 self) ; brig5
					((ScriptID 95 14) ; brig6
						init:
						setPri: 5
						illegalBits: 0
						ignoreActors: 1
						setCycle: Walk
						posn: 310 90
						setMotion: MoveTo 294 90
					)
				else
					(self changeState: 5)
				)
			)
			(3
				(gEgo
					view: 525
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 50 110
				)
				((ScriptID 95 12) ignoreActors: 0 setMotion: MoveTo 204 113) ; brig4
				((ScriptID 95 13) ; brig5
					setPri: -1
					ignoreActors: 0
					setMotion: MoveTo 268 111
				)
				((ScriptID 95 14) ; brig6
					ignoreActors: 0
					setMotion: MoveTo 287 102 self
				)
			)
			(4
				((ScriptID 95 14) setPri: -1 setMotion: MoveTo 253 104 self) ; brig6
			)
			(5
				(EgoDead ; "There are still too many brigands for you to fight in here. You need to find some way to block one of the doors."
					159
					1
					82
					516
					0
					9
					80
					{You're half right but completely dead.}
				)
			)
		)
	)
)

