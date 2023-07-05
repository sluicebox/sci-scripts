;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm044 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm044 of PQRoom
	(properties
		picture 44
	)

	(method (init)
		(LoadMany rsVIEW 5 25 476 478)
		(gEgo view: 5 posn: 67 135 setStep: 3 2 init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 119 112 157 102 197 133 154 139 119 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 170 88 110 94 115 99 106 104 82 107 72 100 0 116 0 0 319 0 319 189 121 189 230 145 230 130 170 87
					yourself:
				)
		)
		(judge init:)
		(bookcase init:)
		(desk init:)
		(table init:)
		(tableLamp init:)
		(windows init:)
		(paneling init:)
		(floor init:)
		(if (== ((gInventory at: 6) state:) 1) ; photo
			(++ local1)
		)
		(if (== ((gInventory at: 35) state:) 1) ; article
			(++ local1)
		)
		(super init:)
		(HandsOff)
		(if (and (gEgo has: 8) (IsFlag 188)) ; warrant
			(proc0_17 20)
			(gCurRoom setScript: egoAfterWarrant)
		else
			(proc0_17 20)
			(gCurRoom setScript: egoEnterRoom)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $4000)
				(if
					(or
						(== ((gInventory at: 8) owner:) 44) ; warrant
						(== ((gInventory at: 9) owner:) 44) ; judicialOrder
					)
					(HandsOff)
					(self setScript: forgotNote)
				else
					(gCurRoom newRoom: 42)
				)
			)
		)
		(super doit:)
	)
)

(instance forgotNote of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo judge self)
			)
			(1
				(= save1 1)
				(ijudge init:)
				(Say ijudge 44 0) ; "Officer Bonds! Have you forgotten something?"
				(= seconds 6)
			)
			(2
				(ijudge dispose:)
				(= cycles 1)
			)
			(3
				(Printf ; "Sheepishly you go back and pick up the %s."
					44
					1
					(if (gEgo has: 8) {judicial order} else {search warrant}) ; warrant
					(if (gEgo has: 8) ; warrant
						{orden judicial}
					else
						{orden de registro}
					)
				)
				(gEgo setMotion: PolyPath 124 120 self)
			)
			(4
				(if (gEgo has: 8) ; warrant
					(gEgo put: 8 0) ; warrant
					(gEgo get: 9) ; judicialOrder
				else
					(gEgo get: 8) ; warrant
				)
				(warrant dispose:)
				(gEgo setMotion: PolyPath 66 133 self)
			)
			(5
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance judgeSigning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drawerSound init: play:)
				(judge view: 478 loop: 0 x: 171 y: 106 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(signingSound init: play:)
				(judge
					view: 478
					loop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 8 1 self
				)
			)
			(3
				(if (gEgo has: 8) ; warrant
					((gInventory at: 9) moveTo: 44) ; judicialOrder
					(= local3 1)
				else
					((gInventory at: 8) moveTo: 44) ; warrant
					(= local2 1)
				)
				(warrant init:)
				(judge setCycle: End self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEnterRoom of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 114 128 self)
			)
			(1
				(NormalEgo 5 0)
				(ijudge init:)
				(= cycles 1)
			)
			(2
				(= save1 1)
				(Say ijudge 44 2) ; "Well, Officer! What's on your mind."
				(= seconds 6)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoAfterWarrant of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 114 128 self)
			)
			(1
				(NormalEgo 5 0)
				(Print 44 3) ; "Judge Simpson looks up as you come into her chambers."
				(= cycles 1)
			)
			(2
				(ijudge init:)
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say ijudge 44 4) ; "I see you're back. Did you have a problem with the warrant?"
				(= seconds 7)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(= cycles 1)
			)
			(5
				(iEgo init:)
				(= cycles 1)
			)
			(6
				(= save1 1)
				(Say iEgo 44 5) ; "No, not the warrant - just gaining entry. The place is fortified."
				(= seconds 5)
			)
			(7
				(= save1 1)
				(Say iEgo 44 6) ; "There's only one way to get into that house. I'm requesting a special order to use the department's ram unit."
				(= seconds 5)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= cycles 1)
			)
			(9
				(Print 44 7) ; "The judge studies you closely, then says..."
				(ijudge init:)
				(= cycles 1)
			)
			(10
				(= save1 1)
				(Say ijudge 44 8) ; "I see. Alright, Officer. I trust your judgement."
				(= seconds 5)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(= cycles 1)
			)
			(12
				(client setScript: judgeSigning self)
			)
			(13
				(ijudge init:)
				(= cycles 1)
			)
			(14
				(= save1 1)
				(Say ijudge 44 9) ; "Just make sure you have plenty of back up."
				(= seconds 5)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveLocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 230)
				(Print 44 10 #at 40 115) ; "You explain to the judge about recovering Marie's locket. You tell her you believe the cult is responsible for Marie's attempted murder."
				(= cycles 1)
			)
			(1
				(switch local1
					(1
						(client setScript: givenOne)
					)
					(2
						(client setScript: givenTwo)
					)
					(3
						(client setScript: givenThree)
					)
					(else
						(Print 44 11) ; "OOPS THINGS GIVEN DOESN'T WORK"
					)
				)
			)
		)
	)
)

(instance givePhoto of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gInventory at: 6) state: 1) ; photo
				(Print 44 12 #at 40 115) ; "You tell the judge how the photograph of Michael and Jessie Bains helped you locate the suspected crack house."
				(= cycles 1)
			)
			(1
				(switch local1
					(1
						(client setScript: givenOne)
					)
					(2
						(client setScript: givenTwo)
					)
					(3
						(client setScript: givenThree)
					)
					(else
						(Print 44 11) ; "OOPS THINGS GIVEN DOESN'T WORK"
					)
				)
			)
		)
	)
)

(instance giveArticle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gInventory at: 35) state: 1) ; article
				(gEgo put: 35 0) ; article
				(Print 44 13 #at 40 115) ; "You hand the news clipping to the judge."
				(SetScore 186 3)
				(= cycles 1)
			)
			(1
				(switch local1
					(1
						(client setScript: givenOne)
					)
					(2
						(client setScript: givenTwo)
					)
					(3
						(client setScript: givenThree)
					)
					(else
						(Print 44 11) ; "OOPS THINGS GIVEN DOESN'T WORK"
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance givenOne of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 44 14 #at 40 115) ; "You try to convince the judge, but she insists on more evidence."
				(= cycles 1)
			)
			(1
				(ijudge init:)
				(= cycles 1)
			)
			(2
				(= save1 1)
				(Say ijudge 44 15) ; "I can see you've done some good detective work, Officer Bonds, but I need more evidence to justify a search warrant."
				(= seconds 12)
			)
			(3
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance givenTwo of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iEgo init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say iEgo 44 16) ; "Your Honor, I'm convinced that some sort of cult operating a crack house at this location."
				(= seconds 9)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= cycles 1)
			)
			(3
				(if (not (gEgo has: 37)) ; locket
					(client setScript: givenThree)
				else
					(= cycles 1)
				)
			)
			(4
				(ijudge init:)
				(= cycles 1)
			)
			(5
				(= save1 1)
				(Say ijudge 44 17) ; "I wish I were as convinced, Officer Bonds. Is there anything else?"
				(= seconds 10)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance givenThree of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 177)
					(ijudge init:)
					(= cycles 1)
				else
					(client setScript: wheresTheHouse)
				)
			)
			(1
				(= save1 1)
				(Say ijudge 44 18) ; "Well! This looks like a very nasty business indeed! You've sold me. I'll sign the warrant."
				(= seconds 10)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(= cycles 1)
			)
			(3
				(client setScript: judgeSigning self)
			)
			(4
				(Print 44 19 #at 40 115) ; "Judge Simpson lays the warrant on the desk and says..."
				(= cycles 1)
			)
			(5
				(ijudge init:)
				(= cycles 1)
			)
			(6
				(= save1 1)
				(Say ijudge 44 20) ; "Good luck, Officer. Contact me if you need any further assistance."
				(= seconds 10)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wheresTheHouse of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ijudge init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say ijudge 44 21) ; "Sounds like you have a good case Bonds. But I need a location and at least an attempt to gain normal entry."
				(= seconds 9)
			)
			(2
				(= local0 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance judgeTalkToldNo of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ijudge init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say ijudge 44 22) ; "I wish I could help, but you must go to the location and see if anyone is home first."
				(= seconds 7)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance judgeTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iEgo init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say iEgo 44 23) ; "Your Honor,... I need to obtain a search warrant."
				(= seconds 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= cycles 1)
			)
			(3
				(if (>= local1 2)
					(client setScript: givenThree)
				else
					(= cycles 1)
				)
			)
			(4
				(ijudge init:)
				(= cycles 1)
			)
			(5
				(= save1 1)
				(cond
					((not (IsFlag 177))
						(Say ijudge 44 24) ; "Well then... How about an address...?"
						(= seconds 6)
					)
					((<= local1 1)
						(Say ijudge 44 25) ; "Well then... How about some evidence...?"
						(= seconds 6)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ijudge dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dontForgetSomething of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ijudge init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say ijudge 44 26) ; "Are you forgetting something?"
				(= seconds 4)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(ijudge dispose:)
				(self dispose:)
			)
		)
	)
)

(instance judge of Prop
	(properties
		x 171
		y 106
		lookStr {Judge Simpson looks like a woman who likes to get right down to business.}
		view 478
		priority 9
		signal 16
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 44 27) ; "The judge is not the kind of person you want to mess with."
			)
			(5 ; Talk
				(HandsOff)
				(cond
					(local0
						(gCurRoom setScript: judgeTalkToldNo)
					)
					(local2
						(gCurRoom setScript: dontForgetSomething)
					)
					(local3
						(gCurRoom setScript: dontForgetSomething)
					)
					(
						(and
							(IsFlag 177)
							(not (gEgo has: 8)) ; warrant
							(not (gEgo has: 9)) ; judicialOrder
						)
						(gCurRoom setScript: judgeTalk)
					)
					((gEgo has: 8) ; warrant
						(HandsOn)
						(Print 44 28) ; "The judge doesn't want to talk now."
					)
					((gEgo has: 9) ; judicialOrder
						(HandsOn)
						(Print 44 29) ; "You got what you wanted. What are you waiting for?"
					)
					(else
						(HandsOn)
						(Print 44 30) ; "The judge just wants to see some evidence."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(37 ; locket
						(cond
							((IsFlag 230)
								(Print 44 31 #at 40 115) ; "You've already shown Marie's locket to Judge Simpson."
							)
							((not (gEgo has: 8)) ; warrant
								(HandsOff)
								(++ local1)
								(gCurRoom setScript: giveLocket)
							)
							(else
								(Print 44 32) ; "The judge doesn't care about Marie's locket now."
							)
						)
					)
					(6 ; photo
						(if (== ((gInventory at: 6) state:) 1) ; photo
							(Print 44 33 #at 40 115) ; "You've already shown the photograph to Judge Simpson."
						else
							(HandsOff)
							(++ local1)
							(gCurRoom setScript: givePhoto)
						)
					)
					(35 ; article
						(if (== ((gInventory at: 35) state:) 1) ; article
							(Print 44 34 #at 40 115) ; "You've already shown the news clipping to Judge Simpson."
						else
							(HandsOff)
							(++ local1)
							(gCurRoom setScript: giveArticle)
						)
					)
					(1 ; gun
						(Print 44 35) ; "She'd rip you apart, Bonds."
					)
					(2 ; handcuff
						(Print 44 35) ; "She'd rip you apart, Bonds."
					)
					(17 ; knife
						(Print 44 35) ; "She'd rip you apart, Bonds."
					)
					(16 ; nightStick
						(Print 44 35) ; "She'd rip you apart, Bonds."
					)
					(19 ; wallet
						(Print 44 36) ; "I remember you perfectly well, Officer Bonds!"
					)
					(else
						(Print 44 37) ; "The judge isn't interested in that."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance warrant of View
	(properties
		x 140
		y 113
		z 10
		approachX 124
		approachY 120
		_approachVerbs 12
		view 478
		loop 2
		cel 1
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gEgo has: 8) ; warrant
					(Print 44 38) ; "The judicial order lies on the desk."
				else
					(Print 44 39) ; "The search warrant lies on the desk."
				)
			)
			(3 ; Do
				(if (gEgo has: 8) ; warrant
					(SetScore 189 5)
					(Print 44 40) ; "You pick up the judicial order."
					(gEgo put: 8 0) ; warrant
					(gEgo get: 9) ; judicialOrder
					(= local3 0)
				else
					(SetScore 187 5)
					(gEgo get: 8) ; warrant
					(= local2 0)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookcase of Feature
	(properties
		x 204
		y 72
		description {the bookcase}
		onMeCheck 2
		lookStr {The bookcase is filled with legal tomes.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 44 41) ; "The judge would not appreciate you handling her things."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 152
		y 107
		description {the desk}
		onMeCheck 16
		lookStr {The judge's desk is neat and orderly.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 44 41) ; "The judge would not appreciate you handling her things."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 92
		y 93
		description {the table}
		onMeCheck 4
		lookStr {The small table holds a lamp and nothing else of interest.}
	)
)

(instance tableLamp of Feature
	(properties
		x 92
		y 93
		description {the lamp}
		onMeCheck 64
		lookStr {A lamp is of no interest.}
	)
)

(instance windows of Feature
	(properties
		x 123
		y 51
		description {the window}
		onMeCheck 8
		lookStr {The window looks over the park next door.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 44 42) ; "If the judge wants her windows open, she'll open them herself."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance paneling of Feature
	(properties
		x 125
		y 78
		description {the paneling}
		onMeCheck 32
		lookStr {The judge's chambers has nice oak paneling.}
	)
)

(instance floor of Feature
	(properties
		x 170
		y 87
		description {the floor}
		onMeCheck 128
		lookStr {The judge's chambers has nice, thick, blue carpeting.}
	)
)

(instance classicalSound of Sound ; UNUSED
	(properties
		number 440
		priority 13
		loop -1
	)
)

(instance signingSound of Sound
	(properties
		number 441
		priority 14
	)
)

(instance drawerSound of Sound
	(properties
		number 914
		priority 14
	)
)

(instance ijudge of View
	(properties
		x 215
		y 130
		view 476
		cel 2
		priority 14
		signal 16
	)

	(method (init)
		(jmouth
			x: (ijudge x:)
			y: (ijudge y:)
			setPri: 15
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(jmouth dispose:)
		(super dispose:)
	)
)

(instance jmouth of Prop
	(properties
		view 476
		loop 1
		cycleSpeed 8
	)
)

(instance iEgo of View
	(properties
		x 207
		y 126
		view 25
		priority 14
		signal 16
	)

	(method (init)
		(iEgoMouth x: (iEgo x:) y: (iEgo y:) setCycle: RandCycle init:)
		(iEgoClothes x: (+ (iEgo x:) 3) y: (+ (iEgo y:) 61) init:)
		(iEgoEyes x: (iEgo x:) y: (iEgo y:) init: setScript: egoEyesBlink)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoClothes dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
	)
)

(instance iEgoClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 16
	)
)

(instance iEgoEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

