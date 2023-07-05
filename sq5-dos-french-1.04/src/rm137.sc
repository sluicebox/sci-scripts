;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 137)
(include sci.sh)
(use Main)
(use Feature)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	rm137 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 10] = [84 76 84 84 92 90 97 74 76 86]
	[local15 10] = [1 2 3 3 2 1 1 1 3 2]
	[local25 10] = [1 2 1 1 3 2 2 3 2 1]
	[local35 10] = [2 2 1 2 2 2 1 1 2 2]
	[local45 10] = [1 1 2 1 2 3 1 2 5 1]
	[local55 20] = [3 4 4 2 4 2 4 3 0 0 2 3 0 4 1 4 1 1 2 4]
	[local75 200]
)

(class AnswerBox of View
	(properties
		view 128
		loop 1
		cel 1
		priority 15
		boxnum 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(DrawCel 128 1 0 x y)
				(if (== [local55 global114] boxnum)
					(++ global115)
				)
				(gSq5Music2 number: 124 setLoop: 1 play:)
				(sTest setScript: sNextQuest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm137 of Rm
	(properties
		picture 24
		style -32758
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 128)
		(gEgo view: 1)
		(exitTest init:)
		(super init:)
		(gGame handsOn:)
		(gCurRoom setScript: sTest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(and
					(InRect 20 0 300 200 gMouseX gMouseY)
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982)
			)
			(
				(and
					(not (InRect 20 0 300 200 gMouseX gMouseY))
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 1))
				)
				(gTheIconBar select: (gTheIconBar at: 1))
				(gGame setCursor: 981)
			)
		)
	)
)

(instance sTest of Script
	(properties)

	(method (doit)
		(if (GameIsRestarting)
			(self changeState: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4
					(+
						(= local3
							(+
								(= local2
									(+
										(= local1
											(+
												(= local0
													(- [local5 global114] 12)
												)
												(* [local15 global114] 10)
											)
										)
										(* [local25 global114] 10)
									)
								)
								(* [local35 global114] 10)
							)
						)
						(* [local45 global114] 10)
					)
				)
				(box1 init:)
				(= state global114)
				(= cycles 1)
			)
			(1
				(Message msgGET 137 2 0 0 1 @local75) ; "1) Gronko is commanding a Nova Class scoutship when he finds himself face to face with three Horak battle cruisers. He should:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 2 0 0 2 @local75) ; "A) Surrender in the face of impossible odds."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 2 0 0 3 @local75) ; "B) Pretend they aren't there."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 2 0 0 4 @local75) ; "C) Activate his ship's self-destruct mechanism."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 2 0 0 5 @local75) ; "D) Beam over a 'Pick-U-Up' bouquet."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 2 0 0 6 @local75) ; "E) Reboot."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(2
				(Message msgGET 137 3 0 0 1 @local75) ; "2) When encountering an alien ship for the first time you should immediately:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 3 0 0 2 @local75) ; "A) Open fire with every weapon at your disposal."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 3 0 0 3 @local75) ; "B) Broadcast Wagner's ''Ride of the Valkyres'' over the com-link."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 3 0 0 4 @local75) ; "C) Beam your entire crew over to their ship as a gesture of goodwill."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 3 0 0 5 @local75) ; "D) B then A."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 3 0 0 6 @local75) ; "E) None of the above."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(3
				(Message msgGET 137 4 0 0 1 @local75) ; "3) Before beaming down to an unexplored planet for the first time you should be sure to check:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 4 0 0 2 @local75) ; "A) To see that your seat belt is fastened and tray tables are locked securely in the upright position."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 4 0 0 3 @local75) ; "B) Your fly."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 4 0 0 4 @local75) ; "C) Your life insurance coverage."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 4 0 0 5 @local75) ; "D) The Pfetzer valve in your oxygen mask."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 4 0 0 6 @local75) ; "E) The planet's atmospheric readings."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(4
				(Message msgGET 137 5 0 0 1 @local75) ; "4) You're marooned on an alien planet with no weapons and a killer android out for your blood. You should:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 5 0 0 2 @local75) ; "A) Gather basic ingredients to make gun powder and fashion a cannon from vines and sticks."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 5 0 0 3 @local75) ; "B) Stuff a banana in its exhaust pipe."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 5 0 0 4 @local75) ; "C) Drop a big rock on the robot and shout ''Hasta la vista, Baby!''"
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 5 0 0 5 @local75) ; "D) Roll in the mud to camouflage yourself."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 5 0 0 6 @local75) ; "E) Climb a tree, flap your arms wildly, and scream ''tweet-tweet'' at the top of your lungs in order to mimic the mating behavior of the Ruby-throated Arcturan Swinefalcon as a diversionary tactic."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(5
				(Message msgGET 137 6 0 0 1 @local75) ; "5) You're on an EVA with a partner and you notice his face is turning blue and he is clutching wildly at his throat. This is a sign that:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 6 0 0 2 @local75) ; "A) You will soon need a new partner."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 6 0 0 3 @local75) ; "B) In a burst of creative insight, he has created a new dance called the ''moonwalk.''"
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 6 0 0 4 @local75) ; "C) He is suffering from a vitamin deficiency and needs to eat more leafy green vegetables."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 6 0 0 5 @local75) ; "D) He fell for the old ''golf ball in the airhose'' trick."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 6 0 0 6 @local75) ; "E) A and D."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(6
				(Message msgGET 137 7 0 0 1 @local75) ; "6) To ensure that your crew's microwave meals are heated adequately and evenly on board your ship you should:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 7 0 0 2 @local75) ; "A) Wrap everything in aluminum foil."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 7 0 0 3 @local75) ; "B) Cook each meal at the maximum power setting for 45 minutes."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 7 0 0 4 @local75) ; "C) Put a live space varmint in with each meal so you can more easily determine when it is done."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 7 0 0 5 @local75) ; "D) Huck the thing and settle for roasting wieners on the maneuvering jets."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 7 0 0 6 @local75) ; "E) Inject a radioactive plutonium isotope into each piece of food: When it glows, it's ready."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(7
				(Message msgGET 137 8 0 0 1 @local75) ; "7) If Greeb leaves the Crab Nebula at 32:00 GST (Galactic Standard Time) and travels at 9.75 Million ZPM, how long will it take him to reach Planet Davicon 5 if he has the solar wind at his back?"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 8 0 0 2 @local75) ; "A) 49.3 Hours."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 8 0 0 3 @local75) ; "B) He will never reach Davicon 5: the solar wind is highly unstable and will blow him off course."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 8 0 0 4 @local75) ; "C) 3.75 Standard days."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 8 0 0 5 @local75) ; "D) 49:30 GST."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 8 0 0 6 @local75) ; "E) Never: The neutron star at the center of the Crab nebula is so massive that Greeb's ship can never reach escape velocity."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(8
				(Message msgGET 137 9 0 0 1 @local75) ; "8) How fast does light travel through a vacuum?"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 9 0 0 2 @local75) ; "A) 186,000 MPS."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 9 0 0 3 @local75) ; "B) Very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very fast."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 9 0 0 4 @local75) ; "C) 669,600,000 MPH."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 9 0 0 5 @local75) ; "D) Depends whether it's an upright or canister vacuum."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(9
				(Message msgGET 137 10 0 0 1 @local75) ; "9) Which is an example of a ''fuzzy boundary?''"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 10 0 0 2 @local75) ; "A) The area in space between two planetary bodies where a smaller third object is not clearly under the gravitational influence of either."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 10 0 0 3 @local75) ; "B) The event horizon of a super-massive black hole."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 10 0 0 4 @local75) ; "C) The place where a receding hairline gives way to bare scalp."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 10 0 0 5 @local75) ; "D) The point at which the marginal utility of trying to squeeze the last bit of toothpaste from the tube is offset by the opportunity cost of going to the store for a new one."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(10
				(Message msgGET 137 1 0 0 1 @local75) ; "10) To successfully accomplish a manual molecular reintegration bypass on a standard transporter unit you should:"
				(Display @local75 dsCOORD 38 42 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 240)
				(Message msgGET 137 1 0 0 2 @local75) ; "A) Reverse the phase polarity of the interface grid."
				(Display @local75 dsCOORD 55 local0 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 1 0 0 3 @local75) ; "B) Jiggle the handle."
				(Display @local75 dsCOORD 55 local1 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 1 0 0 4 @local75) ; "C) Pray fervently to whatever deity you happen to believe in."
				(Display @local75 dsCOORD 55 local2 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 1 0 0 5 @local75) ; "D) C then B."
				(Display @local75 dsCOORD 55 local3 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
				(Message msgGET 137 1 0 0 6 @local75) ; "E) Switch to US Sprint."
				(Display @local75 dsCOORD 55 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH 235)
			)
			(11
				(gSq5Music2 number: 125 setLoop: 1 play: self)
			)
			(12
				(gCurRoom newRoom: 135)
				(self dispose:)
			)
		)
	)
)

(instance sNextQuest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ global114)
				(= ticks 45)
			)
			(1
				(box1 dispose:)
				(DrawPic 24 9)
				(= cycles 1)
			)
			(2
				(if (< global114 10)
					(= local4
						(+
							(= local3
								(+
									(= local2
										(+
											(= local1
												(+
													(= local0
														(-
															[local5 global114]
															12
														)
													)
													(* [local15 global114] 10)
												)
											)
											(* [local25 global114] 10)
										)
									)
									(* [local35 global114] 10)
								)
							)
							(* [local45 global114] 10)
						)
					)
					(box1 init:)
					(= cycles 15)
				else
					(= cycles 1)
				)
			)
			(3
				(sTest cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance box1 of AnswerBox
	(properties)

	(method (init)
		(self cel: 1 posn: 37 (- local0 1))
		(super init:)
		(self stopUpd:)
		(self ignoreActors: 1)
		(box2 cel: 1 posn: 37 (- local1 1) init: ignoreActors: 1 stopUpd:)
		(box3 cel: 1 posn: 37 (- local2 1) init: ignoreActors: 1 stopUpd:)
		(box4 cel: 1 posn: 37 (- local3 1) init: ignoreActors: 1 stopUpd:)
		(if (not (< 6 global114 9))
			(box5 cel: 1 posn: 37 (- local4 1) init: ignoreActors: 1 stopUpd:)
		)
	)

	(method (dispose)
		(super dispose:)
		(box2 dispose:)
		(box3 dispose:)
		(box4 dispose:)
		(box5 dispose:)
	)
)

(instance box2 of AnswerBox
	(properties
		boxnum 1
	)
)

(instance box3 of AnswerBox
	(properties
		boxnum 2
	)
)

(instance box4 of AnswerBox
	(properties
		boxnum 3
	)
)

(instance box5 of AnswerBox
	(properties
		boxnum 4
	)
)

(instance exitTest of Feature
	(properties
		x 4
		y 20
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom newRoom: 135)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

