;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
(include sci.sh)
(use Main)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use System)

(public
	weekend 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0) ; UNUSED
	(Format @global100 232 0) ; "Filler"
	(Format @global100 232 1) ; "You spent the whole weekend watching some of the food in your refrigerator grow mold and spores. It sure was fun."
	(Format @global100 232 2) ; "You spent the whole weekend watching the water in your refrigerator freeze."
	(Format @global100 232 3) ; "You spent the whole weekend baking oatmeal cookies."
	(Format @global100 232 4) ; "You spent the entire weekend watching Star Trek reruns."
	(Format @global100 232 5) ; "You rented some movies and ate artificially flavored buttered popcorn."
	(Format @global100 232 6) ; "You spent the weekend playing your stereo and patching the plaster your speakers cracked."
	(Format @global100 232 7) ; "You spent the weekend cleaning your microwave after you tried to dry your pet rat in it. You also need a new pet rat."
	(Format @global100 232 8) ; "You and some friends had a hot tub party this weekend."
	(Format @global100 232 9) ; "You played games on your computer all weekend."
	(Format @global100 232 10) ; "You watched CELEBRITY INCOME TAX EVASION on TV this weekend."
	(Format @global100 232 11) ; "You read all about the mating habits of the North American computer programmer in your encyclopedia."
	(Format @global100 232 12) ; "You read your dictionary all weekend. Boy, was that fun."
	(Format @global100 232 13) ; "You read your atlas and committed the population of 43 countries to memory. OH WOW!!!"
	(Format @global100 232 14) ; "You went to the baseball game this weekend and ate hotdogs till you puked."
	(Format @global100 232 15) ; "You went to the theatre this weekend and saw the one MAN version of Cats."
	(Format @global100 232 16) ; "You had front row seats at a rock concert. The doctor said that the hearing loss shouldn't be permanent."
	(Format @global100 232 17) ; "You watched them change the mannequins at QT Clothing this weekend."
	(Format @global100 232 18) ; "You washed and waxed your marble this weekend right before it rained."
	(Format @global100 232 19) ; "You stayed home and did absolutely nothing this weekend."
	(Format @global100 232 20) ; "You spent the weekend hiking around Yosemite."
	(Format @global100 232 21) ; "You listened to the Talking Bear 256 times this weekend."
	(Format @global100 232 22) ; "You read the 'Wall Street Journal' this weekend."
	(Format @global100 232 23) ; "You thought about what you would do on your next turn."
	(Format @global100 232 24) ; "You spent the weekend in a hotel because they had to fumigate your apartment."
	(Format @global100 232 25) ; "You played in a ping pong tournament this weekend."
	(Format @global100 232 26) ; "You pitched horseshoes in your apartment all weekend. The people downstairs love you."
	(Format @global100 232 27) ; "You sat around and played solitaire all weekend."
	(Format @global100 232 28) ; "You went panning for gold this weekend, but all you got was wet."
	(Format @global100 232 29) ; "You spent the weekend in the laundromat washing your clothes. Now that was exciting."
	(Format @global100 232 30) ; "You took a friend out to a cheap restaurant this weekend."
	(Format @global100 232 31) ; "You went out and caught your own froglegs this weekend."
	(Format @global100 232 32) ; "You crawled around on your knees chasing snails this weekend."
	(Format @global100 232 33) ; "You spent your weekend thinking about work. Eccch."
	(Format @global100 232 34) ; "You spent your weekend trying to remove the mildew between the shower tiles."
	(Format @global100 232 35) ; "You spent the weekend listening to the newlyweds in the next apartment set up a new waterbed."
	(Format @global100 232 36) ; "This weekend, you won first prize in a beauty contest and collected $10. Whoops, wrong game."
	(Format @global100 232 37) ; "This weekend, you closed your curtains, locked your doors, turned off the lights, and ate presweetened morning breakfast cereal, with little marshmallows!"
	(Format @global100 232 38) ; "You played stickball this weekend with the neighborhood kids and ended up wrenching your back and spraining your ankle."
	(Format @global100 232 39) ; "You read a romance novel, NURSE'S TURN TO CRY, in one sitting."
	(Format @global100 232 40) ; "You took a long hot bath this weekend and emerged looking like a California Raisin."
	(Format @global100 232 41) ; "You watched a torrid romance movie, LIBRARIAN'S DILEMMA, this weekend."
	(Format @global100 232 42) ; "One of your fillings came loose this weekend. It's a good thing you're handy with a soldering iron."
	(Format @global100 232 43) ; "You spent the weekend examining yourself under the fluorescent lights in the bathroom. Eccch!"
	(Format @global100 232 44) ; "You spent the weekend wondering if black holes were lit with black lights."
	(Format @global100 232 45) ; "This weekend, you hung out at the mall, filled up on junk food, and made your mother ashamed of you."
	(Format @global100 232 46) ; "You went bowling with friends this weekend."
	(Format @global100 232 47) ; "You played two rounds of golf this weekend."
	(Format @global100 232 48) ; "This weekend, you had to bail your nephew out of jail."
	(Format @global100 232 49) ; "You had your marble repainted this weekend."
	(Format @global100 232 50) ; "You played in a volleyball tournament this weekend."
	(Format @global100 232 51) ; "You took a friend out to an expensive restaurant this weekend."
	(Format @global100 232 52) ; "You went to San Diego to play in the Over The Line Tournament."
	(Format @global100 232 53) ; "You went to Las Vegas in a $20,000 car and came back in a $200,000 Greyhound bus."
	(Format @global100 232 54) ; "You tried to drive to Hawaii to watch a surfing contest."
	(Format @global100 232 55) ; "You went scuba diving in La Jolla."
	(Format @global100 232 56) ; "You went deep sea fishing this weekend."
	(Format @global100 232 57) ; "You volunteered to take the local scouts to Disneyland."
	(Format @global100 232 58) ; "You drove the senior citizens' bus this weekend and they drove you - crazy."
	(Format @global100 232 59) ; "You helped several little old ladies cross the street to get to their aerobics class."
	(Format @global100 232 60) ; "You visited a sick friend in the hospital. REALLY!"
)

(procedure (localproc_1 &tmp temp0)
	(= local0 0)
	(for ((= temp0 21)) (<= temp0 33) ((++ temp0))
		(if
			(and
				(= local1 ((global302 durables:) objectAtIndex: temp0))
				(local1 quantity:)
				(not (Random 0 (* 4 ((global302 durables:) size:))))
			)
			(= local0 (- temp0 20))
			(if (== global421 local0)
				(= local0 0)
			else
				(= global421 local0)
				(break)
			)
		)
	)
	(return local0)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(if (or (< temp0 1) (> temp0 58)) ; UNINIT, UNINIT
		(= temp0 (Random 17 58))
	)
	(= temp0 param1)
	(Display (global302 actualName:) dsFONT 4 dsCOORD 13 35 dsBACKGROUND -1 dsCOLOR 0 dsWIDTH 155 dsALIGN alCENTER)
	(Display 232 temp0 dsFONT 4 dsCOORD 13 47 dsBACKGROUND -1 dsCOLOR 0 dsWIDTH 155 dsALIGN alCENTER)
	(if (proc0_11)
		(if (< (proc0_11) param2)
			(= param2 (proc0_11))
		)
		(Display
			(Format @global100 232 61 (if (not global563) param2 else global569)) ; "You spent $%d."
			dsFONT
			4
			dsCOORD
			59
			100
			dsBACKGROUND
			-1
			dsCOLOR
			0
			dsALIGN
			alCENTER
		)
		(if (not global563)
			(= global569 param2)
			(proc0_10 (- 0 param2))
		)
	)
	(if (not global563)
		(++ global563)
		(cond
			((or (== (global302 playing:) 29) (== gTheCursor 997))
				(Timer
					set60ths:
						weekendComputerScript
						(proc0_18 (+ (- temp0 1) 230))
				)
				(if (not global427)
					(DoAudio audSTOP)
				)
			)
			(global427
				(proc0_18 (+ (- temp0 1) 230))
			)
		)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance weekend of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(DoAudio audRATE 11025)
			(proc0_17 3)
			(= local8 -1)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= client param1)
			(gASong play: 9)
			(weekendComputerScript state: -1 cycles: 0 seconds: 0)
			(if (== (global302 playing:) 29)
				(self setScript: weekendComputerScript)
			)
			(= global413 0)
			(= local3
				(if (proc0_11)
					(Random 5 20)
				else
					0
				)
			)
			(= local4 (Random 15 55))
			(= local5
				(if (< global372 8)
					(Random 15 55)
				else
					(Random 50 100)
				)
			)
			(self
				window: global38
				add: background weekendText exitButton
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(proc0_9 self keyMouseList exitButton)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(DoAudio audSTOP)
		(gASong fade:)
		(KeyMouse
			setList:
				(if prevDialog
					(prevDialog keyMouseList:)
				else
					gMainKeyMouseList
				)
		)
		(keyMouseList release: dispose:)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(SetPort 0)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp0
		(DisposeScript 232)
	)

	(method (draw)
		(super draw:)
		(if global518
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
		)
	)
)

(instance background of DIcon
	(properties
		view 608
		priority 9
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		key 120
		view 250
		priority 15
	)
)

(instance weekendText of DText
	(properties)

	(method (draw &tmp [temp0 54])
		(self setPort:)
		(cond
			((!= local8 -1)
				(= local7 (Random 1 20))
				(localproc_2 local8 local7)
			)
			(
				(and
					(= local1 ((global302 consumables:) objectAtIndex: 37))
					(local1 quantity:)
				)
				(= local8 14)
				(= local7 local4)
				(localproc_2 14 local4)
				(local1 quantity: 0)
			)
			(
				(and
					(= local1 ((global302 consumables:) objectAtIndex: 38))
					(local1 quantity:)
				)
				(= local8 15)
				(= local7 local4)
				(localproc_2 15 local4)
				(local1 quantity: 0)
			)
			(
				(and
					(= local1 ((global302 consumables:) objectAtIndex: 39))
					(local1 quantity:)
				)
				(= local8 16)
				(= local7 local4)
				(localproc_2 16 local4)
				(local1 quantity: 0)
			)
			((= local0 (localproc_1))
				(= local8 local0)
				(= local7 local3)
				(localproc_2 local0 local3)
			)
			(else
				(while (== global421 (= local8 (Random 17 58)))
					1
				)
				(= global421 local8)
				(if (>= local8 58)
					(proc0_13 (Random 2 4))
				)
				(= local6 0)
				(if (proc0_11)
					(= local6
						(cond
							((<= local8 44)
								(if (< (proc0_11) local3)
									(proc0_11)
								else
									local3
								)
							)
							((<= local8 52)
								(if (< (proc0_11) local4)
									(proc0_11)
								else
									local4
								)
							)
							((< (proc0_11) local5)
								(proc0_11)
							)
							(else local5)
						)
					)
				)
				(= local7 local6)
				(localproc_2 local8 local6)
			)
		)
		(self resetPort:)
	)

	(method (cycle)
		(super cycle: &rest)
		(if (and (== (weekendComputerScript state:) 2) (== (DoAudio audPOSITION) -1))
			(weekendComputerScript cue:)
		)
	)
)

(instance weekendComputerScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(= cycles 1)
			(event type: evKEYBOARD x: 160 y: 100)
			(switch state
				(2
					(= cycles 0)
				)
				(3
					(= cycles 100)
				)
				(4
					(event message: KEY_x)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)
)

