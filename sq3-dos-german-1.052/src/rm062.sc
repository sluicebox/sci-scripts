;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Menu)
(use System)

(public
	rm062 0
)

(instance rm062 of Rm
	(properties
		picture 62
		south 67
		west 61
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 63)
		(super init:)
		(TheMenuBar draw:)
		(SL enable:)
		(switch gPrevRoomNum
			(61
				(gEgo setStep: 4 3 view: 63 posn: 2 (gEgo y:) init:)
			)
			(67
				(gEgo setStep: 4 3 view: 63 posn: (gEgo x:) 187 init:)
			)
			(else
				(Load rsSOUND 71)
				(self setScript: landScript)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== script 0)
			(gEgo setStep: 3 2)
			(if global256
				(++ global593)
			)
			(if (> global593 15)
				(self setScript: CrackUp)
			else
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (> global593 15)
			(self setScript: CrackUp)
		)
		(if (== (gCurRoom script:) 0)
			(if (== (= temp0 (gEgo onControl:)) 16385)
				(gCurRoom newRoom: 14)
			)
			(cond
				((== temp0 3)
					(gEgo setPri: 7 posn: (+ (gEgo x:) 6) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 5) (== temp0 7) (== temp0 13))
					(gEgo
						setPri: 5
						posn:
							(if (< (gEgo x:) 100)
								(- (gEgo x:) 6)
							else
								(+ (gEgo x:) 6)
							)
							(gEgo y:)
					)
					(= global180 1)
				)
				((== temp0 9)
					(gEgo setPri: 3 posn: (gEgo x:) (- (gEgo y:) 6))
					(= global180 1)
				)
				((or (== temp0 17) (== temp0 19))
					(gEgo setPri: 9 posn: (+ (gEgo x:) 12) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 33) (== temp0 37))
					(gEgo
						setPri: 5
						posn:
							(if (< (gEgo x:) 100)
								(- (gEgo x:) 6)
							else
								(+ (gEgo x:) 18)
							)
							(gEgo y:)
					)
					(= global180 1)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evSAID
				(if
					(or
						(Said 'enter,go,get,get[<in]/craft,ramp,door')
						(Said 'climb/ramp')
					)
					(Print 62 0) ; "Just walk right in!"
				)
			)
		)
	)
)

(instance landScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setStep: 4 3
					view: 63
					setLoop: 2
					posn: 164 142
					setPri: -1
					illegalBits: 0
					edgeHit: EDGE_NONE
					init:
				)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: MoveTo 151 162 self)
			)
			(2
				(gEgo setLoop: -1 setPri: -1 illegalBits: -32768)
				(HandsOn)
				(if global182
					(Print 62 1) ; "My, my, this is one hot planet! But you don't care, you're beating the heat with ThermoWeave underwear."
					(= global171 0)
				else
					(Print 62 2) ; "My, my, this is one hot planet! Hopefully you'll last more than a few minutes."
					(= global171 10)
				)
				(gLongSong number: 71 loop: -1 priority: 0 play:)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance CrackUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global593 0)
				(HandsOff)
				(ShakeScreen 30 ssFULL_SHAKE)
				(gEgo dispose:)
				(RedrawCast)
				(Print 62 3) ; "The quakes started by the detonator have broken open a huge crack in the planet surface, which you and everything else in the vicinity have fallen into. The super-heated magma does a quick work of boiling you alive."
				(EgoDead 0 0 1 2)
			)
		)
	)
)

