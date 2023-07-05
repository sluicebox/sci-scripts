;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 342)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use PChase)
(use Polygon)
(use Motion)
(use System)

(public
	rm342 0
)

(instance rm342 of EcoRoom
	(properties
		picture 340
		style -32759
		horizon 20
		north 343
		picAngle 89
		vanishingY 0
		walkOffTop 1
	)

	(method (init)
		(self setRegions: 51) ; bubblesRegion
		(NormalEgo)
		(gEgo ignoreHorizon: 1 init:)
		(NormalDelph)
		(gDelph z: 0 ignoreHorizon: 1 init:)
		(gCurRoom
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 0 188 0 1 3 1 3 187 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 318 187 318 2 319 0 319 185
					yourself:
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(343
				(self setScript: fromNet)
			)
			(480
				(self setScript: fromReef)
			)
			(500
				(self setScript: fromReef)
			)
			(else
				(gEgo x: 230 y: 100)
				(gDelph x: 120 y: 100)
			)
		)
	)
)

(instance fromReef of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gPrevRoomNum 480)
					(gEgo x: 70)
				else
					(gEgo x: 300)
				)
				(gEgo y: 230 setMotion: MoveTo 140 60 self)
				(gDelph
					posn: (gEgo x:) (+ (gEgo y:) 60)
					setMotion: PFollow gEgo 90
				)
			)
			(1
				(gEgo setMotion: MoveTo 140 -40 self)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 343)
				(self dispose:)
			)
		)
	)
)

(instance fromNet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) 180)
					(rm342 south: 480)
					(gEgo x: 90 setMotion: MoveTo 60 240 self)
				else
					(rm342 south: 500)
					(gEgo x: 210 setMotion: MoveTo 290 240 self)
				)
				(gDelph
					posn: (gEgo x:) (- (gEgo y:) 80)
					setMotion: PFollow gEgo 50
				)
			)
			(1
				(HandsOn)
				(if (< (gEgo x:) 180)
					(gCurRoom newRoom: 480)
				else
					(gCurRoom newRoom: 500)
				)
				(self dispose:)
			)
		)
	)
)

