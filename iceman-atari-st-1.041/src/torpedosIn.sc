;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 399)
(include sci.sh)
(use Main)
(use n321)
(use n322)
(use n323)
(use n324)
(use n325)
(use n343)
(use n387)
(use n396)
(use Submarine_806)
(use ForwardCounter)
(use Actor)
(use System)

(public
	torpedosIn 0
	blackHawk 1
	target 2
)

(local
	[local0 10]
	[local10 10]
	local20
	local21
	local22
	local23
	local24 = 2040
	local25
	local26
	local27
	local28
	local29 = 900
	local30
	local31
	local32 = 3
	local33 = 1
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if (< 2 local23)
		(return 0)
	)
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if (and [local10 temp0] (<= (-= [local10 temp0] local32) 0))
			(= [local10 temp0] 0)
			([local10 (+ temp0 5)] dispose:)
			(= [local10 (+ temp0 5)] 0)
			(= temp1 1)
		)
	)
	(return temp1)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if
			(and
				[local0 (+ temp0 5)]
				(!=
					([local0 (+ temp0 5)] cel:)
					(= temp1 (localproc_2 [local0 temp0] 100))
				)
			)
			([local0 (+ temp0 5)] setCel: temp1)
		)
	)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if
			(and
				[local10 (+ temp0 5)]
				(!=
					([local10 (+ temp0 5)] cel:)
					(= temp1 (localproc_2 [local10 temp0] 100))
				)
			)
			([local10 (+ temp0 5)] setCel: temp1)
		)
	)
	(if
		(and
			local20
			(!= (local20 cel:) (= temp1 (localproc_2 (Abs local24) 80)))
		)
		(local20 setCel: temp1)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(= temp0 (/ param1 param2))
	(if (or (== param1 0) (< 9 temp0))
		(return 10)
	else
		(return temp0)
	)
)

(instance torpedosIn of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(proc0_3)
		(DisposeScript 956)
		(DisposeScript 396)
		(DisposeScript 399)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400) ; evNULL | $0400
				(switch (event message:)
					(JOY_NULL
						(proc396_0 5 399 0) ; "YOUR HARPOON MISSLE IS USELESS AGAINEST SUBS."
					)
					(JOY_UP
						(proc396_0 5 399 1) ; "DECOY LAUNCHED, SIR."
						(++ local27)
					)
					(JOY_UPRIGHT
						(if (< local23 3)
							(if (event modifiers:)
								(proc396_0 5 399 2) ; "STINGER LAUNCHED, SIR."
								(proc322_0 local24)
								(DisposeScript 322)
								(= local30 120)
							else
								(proc396_0 5 399 3) ; "SIR, MISSLE NOT LOCKED ON TARGET AND IT'S COMING AT US!"
								(proc321_0 100 100 local24)
								(DisposeScript 321)
							)
						else
							(proc396_0 5 399 4) ; "SIR, ENEMY SUB NOT SHOWING ON SONAR."
						)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (and [local0 temp0] (<= (-= [local0 temp0] local32) 0))
				(= [local0 temp0] 0)
				(cond
					((< 5 (Submarine hSpeed:))
						(= local31 1)
					)
					((& (Submarine flags:) $0080)
						(= local31 2)
					)
					((not (& (Submarine flags:) $0040))
						(= local31 3)
					)
					((<= (Submarine depth:) 1100)
						(= local31 4)
					)
					(local30
						(= local31 5)
					)
					((and (< local29 0) (<= (Submarine depth:) 2282))
						(= local31 6)
					)
					(else
						([local0 (+ temp0 5)] dispose:)
						(= [local0 (+ temp0 5)] 0)
						(++ local26)
						(self changeState: 6)
					)
				)
				(if local31
					(self setScript: (ScriptID 320 0) 0 local31) ; deadByTorpedo
				)
			)
		)
		(if (and (localproc_0) (< (Abs local24) 1200) (< (Random 0 100) 20))
			(++ local23)
			(target setCycle: ForwardCounter 4)
			(self changeState: 3)
		)
		(-- local29)
		(if
			(and
				(< local23 3)
				(< (-= local24 local33) 0)
				(or
					(< 5 (Submarine hSpeed:))
					(& (Submarine flags:) $0080)
					(not (& (Submarine flags:) $0040))
					(< (Submarine depth:) 2282)
					local30
				)
			)
			(= local24 (Abs local24))
			(= local28 2)
		)
		(if local30
			(-- local30)
		)
		(localproc_1)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(if (not local31)
			(switch (= state newState)
				(0
					(switch global132
						(0
							(= local32 6)
							(= local33 3)
						)
						(1
							(= local32 4)
							(= local33 2)
						)
					)
					(proc387_0)
					(DisposeScript 387)
					(= cycles 2)
				)
				(1
					(= start state)
					(proc321_0 local24 75 local24)
					(DisposeScript 321)
					(= seconds 4)
				)
				(2
					(if (proc343_0 local28 local29 local24)
						(++ local28)
						(= seconds 5)
					else
						(= cycles 5)
					)
					(DisposeScript 343)
				)
				(3
					(switch local23
						(0
							(= cycles 2)
						)
						(1
							(proc396_0 5 399 5) ; "THE ALPHA HAS BEEN HIT AND DAMMAGED, SIR."
							(gGame changeScore: 1)
							(++ local23)
							(= seconds 6)
						)
						(3
							(= start 4)
							(proc396_0 5 399 6) ; "WE HIT HER AGAIN, SHE'S BREAKING UP, SIR."
							(gGame changeScore: 4)
							(++ local23)
							(proc325_0)
							(DisposeScript 325)
							(local20 dispose: delete:)
							(= local20 0)
							(target hide: forceUpd: dispose: delete:)
							(= seconds 6)
						)
						(else
							(= cycles 2)
						)
					)
				)
				(4
					(= seconds (proc324_0))
					(DisposeScript 324)
				)
				(5
					(= seconds (proc324_1))
					(DisposeScript 324)
				)
				(6
					(if local26
						(-- local26)
						(switch (Random 0 2)
							(0
								(proc396_0 5 399 7) ; "TORPEDO PASSING BY, SIR."
							)
							(1
								(proc396_0 5 399 8) ; "A TORPEDO SONAR FADING, SIR."
							)
							(2
								(ShakeScreen 30)
								(proc396_0 5 399 9) ; "THAT WAS CLOSE."
							)
						)
						(= seconds 6)
					else
						(= cycles 2)
					)
				)
				(7
					(if local27
						(-- local27)
						(= seconds (proc323_0))
						(DisposeScript 323)
					else
						(= cycles 2)
					)
				)
				(8
					(= seconds (Random 1 3))
				)
				(9
					(if (and (or (< 2 local23) (< local24 -800)) (not local21))
						(= local23 4)
						(proc396_0 5 399 10) ; "SIR, ENEMY SUB NOT REGISTERING ON SONAR."
						(if local20
							(local20 dispose: delete:)
							(= local20 0)
							(target hide: forceUpd: dispose: delete:)
						)
						(blackHawk setPri: 0 forceUpd: dispose: delete:)
						(gGame changeScore: 5)
						(= seconds 4)
					else
						(self init:)
					)
				)
				(10
					(self dispose:)
				)
			)
		)
	)
)

(instance blackHawk of View
	(properties
		y 65
		x 125
		view 527
		loop 9
		priority 14
		signal 273
	)
)

(instance target of Prop
	(properties
		y 39
		x 190
		view 527
		loop 8
		priority 14
		signal 17
	)
)

(class Class_399_0
	(properties)

	(method (at param1 param2)
		(if (< 1 argc)
			(= [local0 param1] param2)
		else
			(return [local0 param1])
		)
	)
)

