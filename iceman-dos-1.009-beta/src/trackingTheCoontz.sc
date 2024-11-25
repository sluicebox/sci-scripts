;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n396)
(use Submarine_806)
(use n821)
(use Motion)
(use Actor)
(use System)

(public
	trackingTheCoontz 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp5 (Abs (- (coontz x:) (ourSub x:))))
	(= temp6 (Abs (- (coontz y:) (ourSub y:))))
	(= local1 (Max local1 temp5 temp6))
	(if (and (< temp5 12) (< temp6 12))
		(= temp0 (/ (+ (Submarine hSpeed:) 19) 20))
		(if (< (Submarine hSpeed:) 0)
			(= temp0 -1)
		)
		(cond
			((< (= temp3 (Submarine absHeading:)) 30)
				(= temp1 0)
				(= temp2 (- temp0))
			)
			((<= 30 temp3 60)
				(= temp1 temp0)
				(= temp2 (- temp0))
			)
			((<= 60 temp3 120)
				(= temp1 temp0)
				(= temp2 0)
			)
			((<= 120 temp3 150)
				(= temp1 temp0)
				(= temp2 temp0)
			)
			((<= 150 temp3 210)
				(= temp1 0)
				(= temp2 temp0)
			)
			((<= 210 temp3 240)
				(= temp1 (- temp0))
				(= temp2 temp0)
			)
			((<= 240 temp3 300)
				(= temp1 (- temp0))
				(= temp2 0)
			)
			((<= 300 temp3 330)
				(= temp1 (- temp0))
				(= temp2 (- temp0))
			)
			(else
				(= temp1 0)
				(= temp2 (- temp0))
			)
		)
		(+= temp1 (ourSub x:))
		(+= temp2 (ourSub y:))
		(if (and (<= 112 temp1 202) (<= 35 temp2 99))
			(ourSub show: x: temp1 y: temp2)
		else
			(ourSub hide: x: temp1 y: temp2)
		)
		(return 0)
	else
		(return 1)
	)
)

(instance trackingTheCoontz of Script
	(properties)

	(method (dispose)
		(if (< state 9)
			(self setScript: tooSoon)
		)
		(super dispose:)
		(proc0_3)
		(DisposeScript 340)
		(DisposeScript 396)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400)
				(switch (event message:)
					(JOY_NULL
						(proc396_0 5 340 0) ; "HARPOON MISSLE LAUNCHED, SIR."
						(self setScript: firedOnCoontz)
					)
					(JOY_UP
						(proc396_0 5 340 1) ; "DECOY LAUNCHED, SIR."
					)
					(JOY_UPRIGHT
						(proc396_0 5 340 2) ; "STINGER LAUNCHED, SIR."
						(self setScript: firedOnCoontz)
					)
				)
			)
		)
	)

	(method (doit)
		(if
			(and
				(< state 6)
				(not (umod (++ local0) 20))
				(localproc_0)
				(not script)
			)
			(self setScript: strayedAway)
		)
		(if (< (Submarine depth:) 150)
			(self setScript: hitCoontz)
		)
		(if (not script)
			(super doit:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(coontz init: setLoop: 2 moveSpeed: 20 setCycle: Fwd)
				(ourSub init: setLoop: 3 setCycle: Fwd)
				(proc396_0 5 340 3) ; "SIR, WE ARE DIRECTLY UNDER THE COONTZ."
				(= seconds 6)
			)
			(1
				(proc396_0 5 340 4) ; "THE COONTZ IS MOVING, SIR."
				(coontz setMotion: MoveTo 128 70 self)
			)
			(2
				(coontz setMotion: MoveTo 150 48 self)
			)
			(3
				(coontz setMotion: MoveTo 188 48 self)
			)
			(4
				(Submarine longitude: -4 latitude: 38)
				(coontz setMotion: MoveTo 196 40 self)
			)
			(5
				(coontz setMotion: MoveTo 202 40 self)
			)
			(6
				(Submarine longitude: -13 latitude: 33)
				(proc396_0 5 340 5) ; "THE COONTZ HAS JUST PINGED A SINGLE PING, SIR."
				(= cycles 2)
			)
			(7
				(proc396_0 5 340 6) ; "THE COONTZ IS MOVING OFF AT HIGH SPEED, SIR."
				(coontz hide: forceUpd: dispose: delete:)
				(ourSub hide: forceUpd: dispose: delete:)
				(= cycles 2)
			)
			(8
				(= temp0
					(*
						2
						(cond
							((< local1 3) 5)
							((< local1 5) 4)
							((< local1 7) 3)
							((< local1 9) 2)
							(else 1)
						)
					)
				)
				(Printf 340 7 temp0) ; "Your navigation skills rate a %d out of a possible 10"
				(gGame changeScore: temp0)
				(Print 340 8) ; "The ping from the coontz signals your arrival off the coast of Tunisia."
				(Print 340 9) ; "You feel a tap on the shoulder as a familiar but weak voice says to you..."
				(Print 340 10) ; "Well John boy" the Captain says, "Looks like you've been putting on one heck of a one man show!"
				(Print 340 11) ; ""Come up to periscope depth then we'll have a look around." The captain directs you."
				(= start 9)
				(= register 0)
				(subMarine cue:)
				(= cycles 2)
			)
			(9
				(++ register)
				(if (< 30 register)
					(self setScript: tooLong)
				else
					(= seconds 2)
				)
			)
			(10
				(self init:)
			)
		)
	)
)

(instance strayedAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(proc396_0 4 340 12) ; "SIR, WE LOST CONTACT WITH THE COONTZ."
				(= seconds 5)
			)
			(1
				(EgoDead 7 0 0 340 13) ; "Due to your poor handling of the sub, the passive sonar can't locate the Coontz. Mission aborted."
			)
		)
	)
)

(instance hitCoontz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(proc396_0 4 340 14) ; "SIR, WE'RE TO CLOSE TO THE SURFACE."
				(= seconds 5)
			)
			(1
				(EgoDead 7 0 0 340 15) ; "Due to your poor handling of the sub, the Coontz has a very large dent in it's hull and the Blackhawk has been converted into a bathtub. Rub a dub dub Johnny's no longer in a sub."
			)
		)
	)
)

(instance tooLong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(EgoDead 7 0 0 340 16) ; "Due to your poor handling of the sub, and your recalcitrant attitude. Mission aborted."
			)
		)
	)
)

(instance tooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(EgoDead 7 0 0 340 17) ; "Desertion of your post prior to completing the job at hand. Mission aborted."
			)
		)
	)
)

(instance coontz of Act
	(properties
		y 88
		x 128
		yStep 1
		view 40
		loop 2
		priority 14
		signal 16400
		illegalBits 0
		xStep 1
	)
)

(instance ourSub of Prop
	(properties
		y 88
		x 128
		view 40
		loop 3
		priority 14
		signal 16400
	)
)

(instance firedOnCoontz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(EgoDead 926 1 0 340 18) ; "The United States rules of engagement prohibit our use of weapons unless fired upon. You're a shame to the service, Johnny."
			)
		)
	)
)

