;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use Interface)
(use n396)
(use Submarine_806)
(use n821)
(use Motion)
(use Actor)
(use System)

(public
	gettingUnderCoontz 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(if
		(and
			(< (Abs (- (coontz x:) (ourSub x:))) 3)
			(< (Abs (- (coontz y:) (ourSub y:))) 3)
		)
		(return 1)
	else
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
	)
)

(procedure (localproc_1)
	(if local2
		(return (not (InRect 117 35 198 97 ourSub)))
	else
		(return 0)
	)
)

(instance gettingUnderCoontz of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400) ; evNULL | $0400
				(switch (event message:)
					(JOY_NULL
						(proc396_0 5 341 0) ; "HARPOON MISSLE LAUNCHED, SIR."
						(self setScript: firedOnCoontz)
					)
					(JOY_UP
						(proc396_0 5 341 1) ; "DECOY LAUNCHED, SIR."
					)
					(JOY_UPRIGHT
						(proc396_0 5 341 2) ; "STINGER LAUNCHED, SIR."
						(self setScript: firedOnCoontz)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (and (not (umod (++ local1) 20)) (localproc_0))
			(if (and (<= (Submarine depth:) 150) (not script))
				(self setScript: diedUnderCoontz)
			else
				(= temp0
					(cond
						((< 2400 local0) 5)
						((< 1800 local0) 4)
						((< 1200 local0) 3)
						((< 600 local0) 2)
						(else 1)
					)
				)
				(Printf 341 3 temp0) ; "Your navigation skills rate a %d out of a possible 5."
				(gGame changeScore: temp0)
				(= local2 0)
				(ourSub setPri: 0 dispose:)
				(coontz setPri: 0 dispose:)
				(Animate (gCast elements:) 0)
				(self dispose:)
			)
		)
		(if (and (<= (Submarine depth:) 70) (not script))
			(self setScript: showedSelf)
		)
		(if (and (not (-- local0)) (not script))
			(self setScript: didntGetUnderCoontz_a)
		)
		(if (and (not script) (localproc_1))
			(self setScript: didntGetUnderCoontz_a)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(proc0_3)
		(DisposeScript 396)
		(DisposeScript 341)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 3000)
				(coontz init: setLoop: 2 moveSpeed: 20 setCycle: Fwd)
				(ourSub init: setLoop: 3 setCycle: Fwd)
				(= local2 1)
				(= cycles 2)
			)
			(1
				(= start state)
				(coontz setMotion: MoveTo 160 40 self)
			)
			(2
				(coontz setMotion: MoveTo 140 60 self)
			)
			(3
				(coontz setMotion: MoveTo 165 70 self)
			)
			(4
				(coontz setMotion: MoveTo 180 58 self)
			)
			(5
				(coontz setMotion: MoveTo 180 50 self)
			)
			(6
				(self init:)
			)
		)
	)
)

(instance didntGetUnderCoontz_a of Script
	(properties
		name {didntGetUnderCoontz}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(proc396_0 4 341 4) ; "SIR, WE LOST CONTACT WITH THE COONTZ."
				(= seconds 5)
			)
			(1
				(EgoDead 7 0 0 341 5) ; "By not getting the Blackhawk under the USS Coontz in time, you lost your cover. Mission aborted."
			)
		)
	)
)

(instance didntGetUnderCoontz_b of Script ; UNUSED
	(properties
		name {didntGetUnderCoontz}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(proc396_0 4 341 4) ; "SIR, WE LOST CONTACT WITH THE COONTZ."
				(= seconds 5)
			)
			(1
				(EgoDead 7 0 0 341 6) ; "By not getting the Blackhawk under the USS Coontz, you lost your cover. Mission aborted."
			)
		)
	)
)

(instance showedSelf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coontz hide: forceUpd: dispose: delete:)
				(proc396_0 4 341 4) ; "SIR, WE LOST CONTACT WITH THE COONTZ."
				(= seconds 5)
			)
			(1
				(EgoDead 7 0 0 341 7) ; "The Coontz, having seen your sub surface, has assumed the mission is aborted."
			)
		)
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
				(EgoDead 926 1 0 341 8) ; "The United States rules of engagement prohibit our use of weapons unless fired upon. You're a shame to the service, Johnny."
			)
		)
	)
)

(instance diedUnderCoontz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc396_0 4 341 9) ; "SIR, WE HAVE HIT THE COONTZ."
				(= seconds 5)
			)
			(1
				(EgoDead 7 0 0 341 10) ; "Hitting the Coontz has ripped off your conning tower, down, down you go."
			)
		)
	)
)

(instance coontz of Act
	(properties
		y 50
		x 180
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
		y 65
		x 135
		view 40
		loop 3
		priority 14
		signal 16400
	)
)

