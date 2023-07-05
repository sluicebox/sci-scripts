;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use smell)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm213 0
	sentry1Talker 11
	sentry2Talker 12
)

(instance rm213 of ADRoom
	(properties
		picture 210
	)

	(method (init)
		(if (== gAct 0)
			(= gAct 1)
			(proc875_0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 178 118 168 111 168 66 206 66 206 99 203 120 183 120
					yourself:
				)
		)
		(super init: &rest)
		(door setCel: 3 init: addToPic:)
		((ScriptID 895 0) normalize: setScale: 0 x: 192 y: 123 init:) ; pepper
		(poorRichard
			view: 841
			setLoop: 0
			x: 155
			y: 125
			setScale: 0
			setCycle: Fwd
			illegalBits: 0
			ignoreActors: 1
			setPri: 12
			init:
		)
		(gLongSong number: 249 setLoop: -1 play:)
		(sentry1 init: stopUpd:)
		(sentry2 init: stopUpd:)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: MoveTo 260 106 self) ; pepper
				(poorRichard setMotion: PolyPath 230 106 self)
			)
			(1
				((ScriptID 895 0) setHeading: 270) ; pepper
			)
			(2
				(poorRichard setCycle: 0 stopUpd:)
				((ScriptID 2000 3) ; PepperTalker
					forceWidth: 1
					talkWidth: 180
					offX: -33
					offY: 3
				)
				(gMessager say: 1 0 1 1 13 self) ; "What a disgrace! That man deserves to hang! (Hee hee!)"
			)
			(3
				(sentry1 view: 216 setLoop: 2 setCel: 0 setCycle: End self)
				(sentry2 view: 216 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4)
			(5
				(gMessager say: 1 0 1 14 16 self) ; "Good! Now maybe I won't report your bad vision and total confusion to the General!"
			)
			(6
				(sentry1 setLoop: 5 setCel: 0 setCycle: End self)
				(sentry2 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(7)
			(8
				(sentry1 setCycle: Beg)
				(sentry2 setCycle: Beg)
				(gEgo setMotion: MoveTo 319 106 self)
				(poorRichard setCycle: Walk setMotion: MoveTo 319 106 self)
			)
			(9
				(gEgo hide:)
			)
			(10
				((ScriptID 2000 3) forceWidth: 0) ; PepperTalker
				(gCurRoom drawPic: 99 9)
				(= cycles 2)
			)
			(11
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 140
		y 51
		view 210
		loop 1
	)
)

(instance sentry1 of Actor
	(properties
		x 129
		y 135
		view 215
		loop 4
	)
)

(instance sentry2 of Actor
	(properties
		x 184
		y 114
		view 215
		loop 1
	)
)

(instance poorRichard of Actor
	(properties
		view 206
		loop 2
		priority 6
		signal 18448
		detailLevel 3
	)
)

(instance sentry2Talker of BalloonTalker
	(properties
		x 140
		y 90
		talkWidth 160
	)
)

(instance sentry1Talker of BalloonTalker
	(properties
		x 10
		y 80
		talkWidth 160
		tailPosn 1
	)
)

