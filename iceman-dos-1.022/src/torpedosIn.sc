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
	[local10 16]
	local26
	local27
	local28
	local29
	local30 = 1700
	local31
	local32
	local33
	local34
	local35 = 900
	local36
	local37
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if (< 2 local29)
		(return 0)
	)
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if
			(and
				[local10 temp0]
				(or
					(not (-- [local10 temp0]))
					(not (-- [local10 temp0]))
					(not (-- [local10 temp0]))
				)
			)
			([local10 (+ temp0 8)] dispose:)
			(= [local10 (+ temp0 8)] 0)
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
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if
			(and
				[local10 (+ temp0 8)]
				(!=
					([local10 (+ temp0 8)] cel:)
					(= temp1 (localproc_2 [local10 temp0] 100))
				)
			)
			([local10 (+ temp0 8)] setCel: temp1)
		)
	)
	(if
		(and
			local26
			(!= (local26 cel:) (= temp1 (localproc_2 (Abs local30) 80)))
		)
		(local26 setCel: temp1)
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
						(++ local33)
					)
					(JOY_UPRIGHT
						(if (< (Class_399_0 at: 29) 3)
							(if (event modifiers:)
								(proc396_0 5 399 2) ; "STINGER LAUNCHED, SIR."
								(proc322_0 local30)
								(DisposeScript 322)
								(= local36 120)
							else
								(proc396_0 5 399 3) ; "SIR, MISSLE NOT LOCKED ON TARGET AND IT'S COMING AT US!"
								(proc321_0 100 100 local30)
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
			(if
				(and
					[local0 temp0]
					(or
						(not (-- [local0 temp0]))
						(not (-- [local0 temp0]))
						(not (-- [local0 temp0]))
					)
				)
				(cond
					((< 5 (Submarine hSpeed:))
						(= local37 1)
					)
					((& (Submarine flags:) $0080)
						(= local37 2)
					)
					((not (& (Submarine flags:) $0040))
						(= local37 3)
					)
					((<= (Submarine depth:) 1100)
						(= local37 4)
					)
					(local36
						(= local37 5)
					)
					((and (< local35 0) (<= (Submarine depth:) 2282))
						(= local37 6)
					)
					(else
						([local0 (+ temp0 5)] dispose:)
						(= [local0 (+ temp0 5)] 0)
						(++ local32)
						(self changeState: 6)
					)
				)
				(if local37
					(self setScript: (ScriptID 320 0) 0 local37) ; deadByTorpedo
				)
			)
		)
		(if (and (localproc_0) (< (Abs local30) 1200) (< (Random 0 100) 20))
			(++ local29)
			(target setCycle: ForwardCounter 4)
			(self changeState: 3)
		)
		(-- local35)
		(if
			(and
				(< local29 3)
				(< (-- local30) 0)
				(or
					(< 5 (Submarine hSpeed:))
					(& (Submarine flags:) $0080)
					(not (& (Submarine flags:) $0040))
					(< (Submarine depth:) 2282)
					local36
				)
			)
			(= local30 (Abs local30))
			(= local34 2)
		)
		(if local36
			(-- local36)
		)
		(localproc_1)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(if (not local37)
			(switch (= state newState)
				(0
					(proc387_0)
					(DisposeScript 387)
					(= cycles 2)
				)
				(1
					(= start state)
					(proc321_0 local30 75 local30)
					(DisposeScript 321)
					(= seconds 4)
				)
				(2
					(if (proc343_0 local34 local35 local30)
						(++ local34)
						(= seconds 5)
					else
						(= cycles 5)
					)
					(DisposeScript 343)
				)
				(3
					(switch local29
						(0
							(= cycles 2)
						)
						(1
							(proc396_0 5 399 5) ; "THE ALPHA HAS BEEN HIT AND DAMMAGED, SIR."
							(gGame changeScore: 1)
							(++ local29)
							(= seconds 6)
						)
						(3
							(= start 4)
							(proc396_0 5 399 6) ; "WE HIT HER AGAIN, SHE'S BREAKING UP, SIR."
							(gGame changeScore: 4)
							(++ local29)
							(proc325_0)
							(DisposeScript 325)
							(local26 dispose: delete:)
							(= local26 0)
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
					(if local32
						(-- local32)
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
					(if local33
						(-- local33)
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
					(if (and (or (< 2 local29) (< local30 -800)) (not local27))
						(proc396_0 5 399 10) ; "SIR, ENEMY SUB NOT REGISTERING ON SONAR."
						(if local26
							(local26 dispose: delete:)
							(= local26 0)
						)
						(blackHawk setPri: 0 forceUpd: dispose: delete:)
						(target hide: forceUpd: dispose: delete:)
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

