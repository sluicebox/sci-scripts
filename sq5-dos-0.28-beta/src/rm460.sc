;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm460 0
)

(local
	local0
	[local1 10]
	local11
	[local12 500]
	local512
	local513 = 3
	local514
	local515
)

(procedure (localproc_0 &tmp temp0 temp1 [temp2 6])
	(= temp1 1)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if (!= (StrAt @local1 temp0) (StrAt {80869} temp0))
			(= temp1 0)
			(break)
		)
	)
	(return temp1)
)

(instance theMusic4 of Sound
	(properties)
)

(instance rm460 of Rm
	(properties
		picture 119
	)

	(method (init)
		(switch gPrevRoomNum
			(420
				(gTheIconBar disable: 0 3 4 6)
				(gCurRoom setScript: sComputer)
			)
			(else
				(gTheIconBar disable: 0 3 4 6 1)
				(gCurRoom setScript: sComputer)
			)
		)
		(super init:)
		(gGame handsOn:)
	)

	(method (notify param1 param2 param3 param4 param5 param6)
		(Format ; "%c%c%c%c%c"
			@local1
			460
			0
			(+ param2 48)
			(+ param3 48)
			(+ param4 48)
			(+ param5 48)
			(+ param6 48)
		)
		(if (== param1 -1)
			(= local11 -1)
		else
			(= local11 (localproc_0))
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(previousIcon init:)
				(nextIcon init:)
				(exitIcon init:)
				(self setScript: (ScriptID 203 0) self 0) ; keyStuff
			)
			(1
				(switch local11
					(1
						(theMusic4 number: 124 loop: 1 play:)
						(= local514 1)
						(= local11 0)
						(SetScore 221 20)
						(compHeading init:)
						(Message msgGET 460 2 0 0 1 @local12) ; "Personal log, Clorox II Colony Administrator Harry Kerry, Stardate 3012.68. Something very strange has been going on here in the colony since the Goliath's last visit. A small survey team is a week overdue and there have been reports of strange creatures roaming the badlands. No doubt it's just a bit of ''cabin fever'' by the more imaginative types, but I am worried by the disappearance of the survey team."
						(Display
							@local12
							dsCOORD
							50
							50
							dsCOLOR
							39
							dsBACKGROUND
							0
							dsFONT
							1605
							dsWIDTH
							240
						)
					)
					(0
						(= state -1)
						(= cycles 1)
					)
					(-1
						(gTheIconBar enable: 0 3 5 4 6)
						(gCurRoom newRoom: 420)
					)
					(else
						(= cycles 1)
					)
				)
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sComputerLog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local512
					(0
						(Message msgGET 460 2 0 0 1 @local12) ; "Personal log, Clorox II Colony Administrator Harry Kerry, Stardate 3012.68. Something very strange has been going on here in the colony since the Goliath's last visit. A small survey team is a week overdue and there have been reports of strange creatures roaming the badlands. No doubt it's just a bit of ''cabin fever'' by the more imaginative types, but I am worried by the disappearance of the survey team."
						(Display
							@local12
							dsCOORD
							50
							50
							dsCOLOR
							39
							dsBACKGROUND
							0
							dsFONT
							1605
							dsWIDTH
							240
						)
					)
					(1
						(Message msgGET 460 2 0 0 2 @local12) ; "Personal Log: Stardate 3015.68. I am becoming more and more alarmed. The search party dispatched to learn the fate of the survey team hasn't reported back for more than 50 hours. Fear spurred on by more wild rumors about the creatures has the colony on the verge of panic."
						(Display
							@local12
							dsCOORD
							50
							50
							dsCOLOR
							39
							dsBACKGROUND
							0
							dsFONT
							1605
							dsWIDTH
							240
						)
					)
					(2
						(Message msgGET 460 2 0 0 3 @local12) ; "Personal Log: Stardate 3016.68. God help us! A band of the hideous mutant creatures attacked the colony last night. Very few of us escaped the massacre, and I have been wounded slightly. There is no doubt that these creatures are intelligent and even appear to have a rudimentary understanding of technology. They have captured the shuttle pad, cutting off our only means of escape. Using my personal passcodes, I have sealed the colony so that the creatures will no longer be able to get into any of the undamaged structures."
						(Display
							@local12
							dsCOORD
							50
							50
							dsCOLOR
							39
							dsBACKGROUND
							0
							dsFONT
							1605
							dsWIDTH
							240
						)
					)
					(3
						(Message msgGET 460 2 0 0 4 @local12) ; "Personal Log: Stardate 3017.68. I am in agony. The wound I received burns like fire. An hour ago, the mutant creatures blasted off in the colony shuttle. As they climbed the boarding ramp, I got my first good look at a creature in daylight, it was hideous. The tattered rags he wore were the remnants of a survey team survival suit. I have a terrible suspicion about the fate of the colonists. I am now utterly alone on this planet, dying--I hope.  <END>"
						(Display
							@local12
							dsCOORD
							50
							50
							dsCOLOR
							39
							dsBACKGROUND
							0
							dsFONT
							1605
							dsWIDTH
							240
						)
					)
				)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitIcon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(exitIcon setCycle: Beg self)
			)
			(1
				(gTheIconBar enable: 0 3 5 4 6)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance compHeading of Prop
	(properties
		x 119
		y 26
		view 627
		loop 13
		cel 1
		signal 16384
	)
)

(instance nextIcon of Prop
	(properties
		y 87
		view 627
		loop 8
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local514
					(if (< local512 local513)
						(++ local512)
					)
					(self setCycle: Beg)
					(gCurRoom setScript: sComputerLog)
				)
			)
		)
	)
)

(instance previousIcon of Prop
	(properties
		y 72
		view 627
		loop 6
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local514
					(if (> local512 0)
						(-- local512)
					)
					(self setCycle: Beg)
					(gCurRoom setScript: sComputerLog)
				)
			)
		)
	)
)

(instance exitIcon of Prop
	(properties
		y 102
		view 627
		loop 9
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sExitIcon)
			)
		)
	)
)

