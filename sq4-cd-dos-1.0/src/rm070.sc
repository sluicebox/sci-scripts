;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use Talker)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use User)
(use System)

(public
	rm070 0
)

(local
	local0
	local1
	[local2 26] = [5 0 45 127 5 0 53 122 5 0 61 117 5 0 69 112 5 0 77 107 5 0 85 102 -32768 0]
	local28
)

(procedure (localproc_0 param1)
	(= local0 (Display param1 dsWIDTH 300 dsCOORD 6 1 dsALIGN alLEFT dsFONT 69 dsCOLOR global129 dsSAVEPIXELS))
	(Display param1 dsWIDTH 300 dsCOORD 6 1 dsALIGN alLEFT dsFONT 68 dsCOLOR global130)
)

(procedure (localproc_1)
	(if local0
		(Display 70 0 dsRESTOREPIXELS local0)
		(= local0 0)
	)
)

(instance rm070 of SQRoom
	(properties
		picture 70
	)

	(method (init)
		(Load rsVIEW 70)
		(super init:)
		(aSound init:)
		(if (== ((gInventory at: 5) owner:) 70) ; jar
			(theJar init:)
		)
		(blotter init:)
		(dr init: stopUpd:)
		(grid init:)
		(euroTrip init:)
		(theShadow init:)
		(theDesk init:)
		(theWires init:)
		(thePipes init:)
		(theRoom init:)
		(gEgo
			init:
			normal: 0
			view: 70
			loop: 0
			cel: 0
			illegalBits: -32766
			x: 223
			y: -2
			xStep: 3
			yStep: 15
		)
		(HandsOff)
		(self setScript: fallScript)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 166 126 264 129 265 160 137 160
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 275 82 319 10 319 183 296 162
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 9 189 29 174 298 174 316 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 162 43 162 49 171 0 171
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 166 73 144 0 319 0 272 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 138 0 162 74 87 127 71 127 46 144 56 144 47 151 45 160 0 160 0 0
					yourself:
				)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local28 (StepOn gEgo 2))
				(gCurRoom setScript: enterSewer)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gLongSong number: 815 vol: 127 loop: -1 playBed:)
				(gEgo setLoop: 0 setCycle: 0 setMotion: MoveTo 223 89 self)
			)
			(2
				(aSound init: number: 115 loop: 1 play:)
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(3
				(NormalEgo 0 0)
				(gEgo illegalBits: -32766 setHeading: 180)
				(= seconds 2)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance drScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: PolyPath 50 150 self)
			)
			(1
				(gEgo setPri: 13 setHeading: 270 self)
			)
			(2
				(aSound number: 816 play:)
				(gEgo
					view: 70
					normal: 0
					setLoop: 4
					cel: 0
					illegalBits: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(aSound play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(4
				(aSound play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 0 setLoop: 1)
				(= cycles 1)
			)
			(6
				(aSound number: 810 loop: 1 play:)
				(dr setCycle: MCyc @local2 self)
			)
			(7
				(dr setPri: 3 stopUpd:)
				(= local28 1)
				(aSound number: 811 play:)
				(= seconds 1)
			)
			(8
				(HandsOn)
				(NormalEgo 1)
				(gEgo illegalBits: -32768)
				(gFeatures addToFront: drOpening eachElementDo: #init doit:)
				(self dispose:)
			)
		)
	)
)

(instance buttonScript of Script
	(properties)

	(method (init)
		(if (not (gKeyDownHandler contains: self))
			(gKeyDownHandler addToFront: self)
		)
		(if (not (gMouseDownHandler contains: self))
			(gMouseDownHandler addToFront: self)
		)
		(if (not (gDirectionHandler contains: self))
			(gDirectionHandler addToFront: self)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if local0
			(event claimed: 1)
			(= seconds 0)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 195 159 self)
			)
			(1
				(gEgo
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 2) self
				)
			)
			(2
				(gEgo view: 70 normal: 0 setLoop: 7 setCycle: Beg self)
			)
			(3
				(if (not (IsFlag 34))
					(gNarrator say: 1) ; "Ah! A button. Perhaps I'll give it a press."
				)
				(SetScore 54 10)
				(gEgo view: 70 setLoop: 7 setCycle: End self)
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
			)
			(4
				(aSound number: 812 loop: 1 play:)
				(= seconds 2)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(= seconds 1)
			)
			(7
				(NormalEgo 3 0)
				(gEgo y: (+ (gEgo y:) 2) setHeading: 0 self)
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
			)
			(8
				(if (not (IsFlag 34))
					(SetFlag 34)
					(aSound init: number: 813 loop: 1 play:)
					(if (== ((gInventory at: 5) owner:) gCurRoomNum) ; jar
						(theJar stopUpd:)
					)
					(gEgo stopUpd:)
					(hologram init: cycleSpeed: 12 setCycle: End)
					(= seconds 3)
				else
					(gNarrator say: 2) ; "Nothing happens."
					(HandsOn)
					(self dispose:)
				)
			)
			(9
				(hologramHead init: cycleSpeed: 12 setCycle: RandCycle)
				(hologram setLoop: 2 posn: 170 83 setCycle: RandCycle)
				(= cycles 1)
			)
			(10
				(gLongSong number: 814 loop: -1 play:)
				(theProfessor say: 1 self) ; ""Data Entry 22795: This message is to whomever may be so fortunate as to find it. I am Professor Lloyd, lead designer of the Xenon Super Computer Project, the ultimate in artificial intelligence."
			)
			(11
				(theProfessor say: 2 self) ; "The computer was designed to enhance our lives but, instead, ended up being the ruin of us all.""
			)
			(12
				(theProfessor say: 3 self) ; ""We made the mistake of tying it into the most important facets of our existence here on Xenon including our weather control and defense systems."
			)
			(13
				(theProfessor say: 4 self) ; "It seemed like a sound idea at the time and all proceeded well for about three years.""
			)
			(14
				(theProfessor say: 5 self) ; ""It was around then that a deep space salvage operation recovered what appeared to be some sort of antiquated data storage unit contained in a flimsy cardboard box on which the words "Leisure Suit Larry" were imprinted."
			)
			(15
				(theProfessor say: 6 self) ; "On its back was the picture of a not particularly wholesome gentleman, but that's another story.""
			)
			(16
				(theProfessor say: 7 self) ; ""My counterparts exhibited shameful behavior as they tore open the box to get at its contents. I could not understand the commotion it generated. The data was uploaded into the Super Computer for analysis."
			)
			(17
				(theProfessor say: 8 self) ; "As a result, a crippling virus spread through the machine like a bad social disease. All control of the computer was lost.""
			)
			(18
				(theProfessor say: 9 self) ; "All screens went blank, then these words were displayed by the monitors and uttered by the vocal outputs - "WILCO MUST PAY!"
			)
			(19
				(theProfessor say: 10 self) ; "From that day forth the possessed computer waged war on the inhabitants of Xenon using our own weapons against us. Some managed to escape to other planets.""
			)
			(20
				(theProfessor say: 11 self) ; ""Those of us who remained stayed to fight the machines and robots under its control. It was a bloody war. Those of us that were not killed were taken captive and 'modified.'"
			)
			(21
				(theProfessor say: 12 self) ; "These 'cyborgs' infiltrated the loyal ranks of resistance, rooting out almost all of our hiding places and exposing us to the mechanical menace. Some of these poor souls still wander the streets.""
			)
			(22
				(theProfessor say: 13 self) ; ""As of this recording, we are down to only a handful of rebels. My health is deteriorating rapidly. To make matters worse, I've just learned that the computer has unraveled the mysteries of time travel."
			)
			(23
				(theProfessor say: 14 self) ; "I've sent my two best men to attempt to steal this new technology. If you are not a machine then perhaps they were successful. Please realize - YOU are Xenon's last hope.""
			)
			(24
				(gLongSong fade:)
				(hologram setCycle: 0)
				(hologramHead setCycle: 0)
				(= seconds 2)
			)
			(25
				(aSound play:)
				(hologramHead dispose:)
				(hologram setLoop: 1 setCel: 4 posn: 160 81 setCycle: Beg self)
			)
			(26
				(gLongSong number: 815 vol: 127 play:)
				(hologram dispose:)
				(HandsOn)
				((gEgo _head:) startUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance jarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 197 165 self)
			)
			(1
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
				(Face gEgo theJar self)
			)
			(2
				(gNarrator say: 3) ; "You take the jar into custody."
				(SetScore 53 5)
				(gEgo get: 5) ; jar
				(theJar dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterSewer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 63 136 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo view: 70 setLoop: 8 cel: 0 setCycle: End self)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 85)
			)
		)
	)
)

(instance tripShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo theShadow self)
			)
			(1
				(gNarrator ; "NEIL'S EUROPEAN VACATION"
					modeless: 1
					returnVal: 0
					nMsgType: 1
					say:
						21
						self
						2
						64
						63
						20
						67
						315
						25
						global132
						26
						global129
						27
						1
						30
						310
				)
			)
			(2
				(screen init: setMotion: MoveTo 75 0 self)
			)
			(3
				(= seconds 1)
			)
			(4
				(screen view: 651)
				(gNarrator say: 26 self) ; "Hey, that looks like Vienna's Parliament! Not many people get a chance to see this before they die."
			)
			(5
				(screen view: 652)
				(gNarrator say: 27 self) ; "The stone structure vaguely reminds you of photos from Munich, where you've heard tales of beauty and mystery. Most people will never see such things before they die."
			)
			(6
				(screen view: 653)
				(gNarrator say: 28 self) ; "Isn't that Neil in Lucerne, Switzerland? What a good-looking guy. Most people will (unfortunately) never get to know Neil before they die."
			)
			(7
				(screen view: 650)
				(gNarrator say: 29 self) ; "Man, that was intense. Neil's Tip #37:     Do things before you die."
			)
			(8
				(screen view: 650 setMotion: MoveTo 75 -110 self)
			)
			(9
				(gNarrator ; "CREDITS: David & Russ for the ride to SF Mom & Dad for the plane ticket Patrick & his family for a place to stay Special Thanks to the Dutch coffee shops, the Swiss Posse, and the European women."
					returnVal: 0
					nMsgType: 1
					say:
						22
						self
						2
						64
						63
						20
						67
						315
						25
						global132
						26
						global129
						27
						1
						30
						310
				)
			)
			(10
				(= cycles 2)
			)
			(11
				(gNarrator ; "Aboriginies: Ceci, Gina, Laura, Melissa, Durwood, Shock-Lee, Dave, Ken, "That new guy" Ron, and...what the hell...Amy. Animal Wrangler: Chanin"
					returnVal: 0
					nMsgType: 1
					say:
						23
						self
						2
						64
						63
						20
						67
						315
						25
						global132
						26
						global129
						27
						1
						30
						310
				)
			)
			(12
				(= cycles 2)
			)
			(13
				(gNarrator ; "To my brothers on a mission with no permission...an inspirational name drop to Public Enemy: Chuck, Flav, & X. Nothin' fake, just that raw, hardcore shit."
					returnVal: 0
					nMsgType: 1
					say:
						24
						self
						2
						64
						63
						20
						67
						315
						25
						global132
						26
						global129
						27
						1
						30
						310
				)
			)
			(14
				(= cycles 2)
			)
			(15
				(gNarrator ; "Other thanks (randomly): Max, Beastie Boys, Carver man, Cube, Cypress Hill, Scott "the No Sellout Guy from Andromeda" Murphy, and atheists everywhere."
					returnVal: 0
					nMsgType: 1
					say:
						25
						self
						2
						64
						63
						20
						67
						315
						25
						global132
						26
						global129
						27
						1
						30
						310
				)
			)
			(16
				(HandsOn)
				(gNarrator nMsgType: -1 modeless: 0)
				(self dispose:)
			)
		)
	)
)

(instance screen of Sq4Actor
	(properties
		x 75
		y -110
		yStep 4
		view 650
		priority 14
		signal 24592
	)
)

(instance euroTrip of Sq4Feature
	(properties
		x 18
		y 155
	)

	(method (onMe param1)
		(return (InRect 0 180 8 190 param1))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; buckazoid
				(if (and (> (gEgo y:) 170) (< (gEgo x:) 60))
					(gCurRoom setScript: tripShow)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dr of Sq4Actor
	(properties
		x 45
		y 127
		z -16
		sightAngle 45
		view 70
		loop 5
		priority 9
		signal 18448
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local28)
					(HandsOff)
					(gCurRoom setScript: drScript)
				else
					(gNarrator say: 5) ; "You realize that this is the only way out, so you decide to leave it open."
				)
			)
			(1 ; Look
				(if local28
					(gNarrator say: 6) ; "There's an open hatch set into a cylindrical structure here. You recognize it as the entrance to the sewer system."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drOpening of Sq4Feature
	(properties
		x 49
		y 137
		z 33
		nsTop 85
		nsLeft 36
		nsBottom 123
		nsRight 63
		sightAngle 45
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 0) ; Do
			(1 ; Look
				(if (not local28)
					0
				else
					(gNarrator say: 7) ; "You peer into the darker area beyond the hatch frame and see nothing particularly revolting."
				)
			)
			(6 ; Smell
				(gNarrator say: 8) ; "It smells mysterious. You have the urge to play 'Name That Gas'."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theJar of Sq4View
	(properties
		x 197
		y 150
		z 22
		sightAngle 45
		view 70
		loop 6
		priority 12
		signal 16400
		lookStr 9 ; "It's an empty jar with a lid, neither of which does anything entertaining."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== ((gInventory at: 5) owner:) 70) ; jar
					(gEgo illegalBits: 0)
					(gCurRoom setScript: jarScript)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hologram of Sq4Prop
	(properties
		x 160
		y 81
		view 70
		loop 1
		signal 16384
	)
)

(instance hologramHead of Sq4Prop
	(properties
		x 167
		y 45
		view 70
		loop 3
		signal 16384
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 152
		z -82
		nsBottom 189
		nsRight 319
		sightAngle 180
		lookStr 10 ; "You've reached the Sewer Maintenance Office. Apparently this office has been long abandoned. Your janitorial instincts urge you to sweep up and do a little dusting, but you suppress those urges and concentrate on the task at hand."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 11) ; "The smell down here isn't as bad as you thought."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blotter of Sq4Feature
	(properties
		x 230
		y 155
		z 31
		nsTop 115
		nsLeft 211
		nsBottom 133
		nsRight 249
		sightAngle 45
		lookStr 12 ; "It's just an average old-fashioned desk blotter."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gEgo illegalBits: 0)
				(gCurRoom setScript: buttonScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grid of Sq4Feature
	(properties
		x 166
		y 83
		nsTop 76
		nsLeft 145
		nsBottom 91
		nsRight 188
		sightAngle 45
		onMeCheck 16448
		lookStr 13 ; "The strange little pedestal has wires running between it and the wall."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 14) ; "Nothing you can do to it here will be of benefit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theDesk of Sq4Feature
	(properties
		x 212
		y 123
		z 30
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 128
		lookStr 15 ; "The desk is not exactly executive caliber."
	)
)

(instance theWires of Sq4Feature
	(properties
		x 155
		y 75
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 32
		lookStr 16 ; "This heavy gauge wire disappears into the wall."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 17) ; "They won't come loose."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theShadow of Sq4Feature
	(properties
		x 227
		y 10
		nsLeft 198
		nsBottom 30
		nsRight 246
		sightAngle 45
		lookStr 18 ; "You notice the shadow cast on the wall by the inaccessible grate above."
	)
)

(instance thePipes of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 16
		lookStr 19 ; "A variety of pipes, coolant and otherwise, pass in, through and around the room."
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(4 ; Do
				(gNarrator say: 20) ; "They're well affixed."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

(instance theProfessor of Narrator
	(properties
		noun 8
		modeless 1
		talkerNum 8
	)

	(method (display &tmp temp0 temp1)
		(localproc_1)
		(if (> (+ x talkWidth) 318)
			(= temp1 (- 318 x))
		else
			(= temp1 talkWidth)
		)
		(if (not x)
			(= x (+ (- nsRight nsLeft) 5))
		)
		(localproc_0 &rest 64 x y 111 77 name 67 temp1)
	)

	(method (dispose)
		(localproc_1)
		(super dispose: &rest)
	)
)

