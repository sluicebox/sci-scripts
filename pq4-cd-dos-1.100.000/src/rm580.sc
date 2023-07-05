;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use TellerIcon)
(use n030)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm580 0
	chesterTalker 1
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
)

(instance rm580 of Room
	(properties
		picture 580
	)

	(method (init)
		(mySign init:)
		(wall init:)
		(counter init:)
		(if (gPqFlags test: 148)
			(if (== gDay 5)
				(gPqFlags set: 90)
			)
			(gGame handsOff:)
			(crim init:)
			(self setScript: sEnter)
		else
			(gGame handsOn:)
			(door init:)
			(topDoor init:)
		)
		(super init: &rest)
		(if (IsHiRes)
			(hiResSign init:)
		)
		(gWalkHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(if (gPqFlags test: 148)
				(if (== gDay 3)
					(gMessager say: 1 2 26 0 self) ; "Don't forget the Short Stop tonight, Detective."
				else
					(gMessager say: 1 2 12 0 self) ; "See you later, Detective Carey."
				)
			else
				(self cue:)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(self newRoom: 570)
	)
)

(instance mySign of Feature
	(properties
		noun 5
		nsLeft 197
		nsTop 28
		nsRight 267
		nsBottom 66
		sightAngle 40
		x 232
		y 47
	)
)

(instance counter of Feature
	(properties
		noun 6
		nsLeft 197
		nsTop 28
		nsRight 267
		nsBottom 66
		sightAngle 40
		x 232
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 114 176 110 203 119 204 124 191 126 75 133
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (gPqFlags test: 148))
			(if (Message msgSIZE 580 noun theVerb 10 1)
				(gMessager say: noun theVerb 10)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		noun 3
		nsLeft 62
		nsTop -1
		nsRight 188
		nsBottom 147
		sightAngle 40
		x 125
		y 10
	)
)

(instance wall of Feature
	(properties
		noun 4
		nsLeft 49
		nsRight 274
		nsBottom 147
		sightAngle 40
		x 161
		y 1
	)
)

(instance topDoor of View
	(properties
		noun 3
		x 136
		y 115
		view 579
	)
)

(instance crimTell of Teller
	(properties)

	(method (showCases)
		(if (== global145 6)
			(gPqFlags set: 150)
		)
		(super
			showCases:
				5
				(== global145 1)
				4
				(== global145 1)
				6
				(== global145 1)
				7
				(and (== global145 1) (gPqFlags test: 89))
				23
				(== global145 2)
				19
				(== global145 2)
				18
				(== global145 2)
				22
				(== global145 3)
				25
				(== global145 3)
				24
				(== global145 3)
				30
				(== global145 5)
				29
				(== global145 5)
				32
				(== global145 5)
				33
				(== global145 5)
				31
				(== global145 5)
				34
				(== global145 6)
				35
				(== global145 6)
				36
				(== global145 7)
				39
				(== global145 8)
				38
				(== global145 8)
				41
				(== global145 8)
				40
				(== global145 8)
				37
				(== global145 8)
				20
				(and (gPqFlags test: 51) (> gDay global149))
		)
	)
)

(instance crim of Prop
	(properties
		noun 1
		x 119
		y 117
		view 584
		loop 1
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 noun)
		(= noun 1)
		(switch theVerb
			(2 ; Talk
				(if (and (or (== global145 9) (== global145 10)) (> local0 0))
					(if (== global145 10)
						(switch local0
							(1
								(gMessager say: 1 2 48) ; "Hello, John."
								(++ local0)
							)
							(2
								(gMessager say: 1 2 49) ; "Julie, is there anything to report concerning the toxicology tests on any of the victims?"
								(++ local0)
							)
							(3
								(gMessager say: 1 2 50) ; "Anything on the lastest two Does?"
								(++ local0)
							)
							(4
								(gMessager say: 1 2 51) ; "Thanks, Julie. I'll keep that in mind."
								(++ local0)
							)
							(5
								(gMessager say: 1 2 52) ; "Thanks for everything, Julie."
								(++ local0)
							)
							(else
								(gMessager say: 1 2 53) ; "Julie... ah..."
							)
						)
					else
						(switch local0
							(1
								(gMessager say: 1 2 42) ; "Hello Chester. I found out that the abandoned car belongs to a Social Services worker named Luella Parker. She matches the description of Jane Doe 1201-K."
								(++ local0)
							)
							(2
								(gMessager say: 1 2 43) ; "How about the armbone DNA, Chester?"
								(++ local0)
							)
							(3
								(gMessager say: 1 2 44) ; "Anything new with the toxicology tests? Anything back from Quantico?"
								(++ local0)
							)
							(4
								(gMessager say: 1 2 45) ; ""Thanks, Julie."
								(++ local0)
							)
							(5
								(gMessager say: 1 2 46) ; "What kind of a name is Julie, anyway?"
								(++ local0)
							)
							(else
								(gMessager say: 1 2 47) ; "I'll be seeing you, Julie."
							)
						)
					)
				else
					(cond
						((== ((gInventory at: 11) owner:) 580) ; handgun
							(self setScript: giveGun)
						)
						((== global145 5)
							(if (gPqFlags test: 178)
								(gMessager say: 1 2 56) ; "Chester, please accept my apologies. That was very uncharacteristic behavior for me. It's the stress I'm under."
							else
								(gMessager say: 1 2 28) ; "Lieutenant Block is a by-the-book man, Chester. I respect him for it."
							)
						)
						(else
							(gMessager say: 1 2 11) ; "Hello, Chester."
						)
					)
					(crimTell init: self 580 2 5)
				)
			)
			(39 ; pills
				(if (gPqFlags test: 50)
					(self setScript: takeStuff 1 theVerb 0 0)
				else
					(gGame points: 1 76)
					(self setScript: takeStuff 1 2 2)
					(gPqFlags set: 50)
				)
			)
			(34 ; boneBaggie
				(if (gPqFlags test: 152)
					(self setScript: takeStuff 1 34 14 0)
				else
					(gGame points: 1 75)
					(gPqFlags set: 152)
					(self setScript: takeStuff 1 34 13 0)
				)
			)
			(4 ; Do
				(switch global150
					(0
						(++ global150)
						(gMessager say: 1 4 13) ; "Detective Carey, I view your action as sexual harassment and find your behavior objectionable. Please stop touching me."
					)
					(1
						(++ global150)
						(gMessager say: 1 4 14) ; "Detective Carey, if you do not stop I will be forced to report this incident to my supervisor. Please stop and end this here and now."
					)
					(2
						(++ global150)
						(gMessager say: 1 4 15) ; "Sexual harassment is a violation of Federal and State law, and City and Department policy."
					)
					(else
						(if (== global150 6)
							(proc30_0 1 4 54 1 580)
						else
							(gMessager say: 1 4 15) ; "Sexual harassment is a violation of Federal and State law, and City and Department policy."
						)
						(++ global150)
					)
				)
			)
			(17 ; glue
				(if (gPqFlags test: 51)
					(gMessager say: 1 17 14) ; "Detective, I already have a sample. Believe me, I don't need anymore than I already have."
				else
					(gGame points: 1 73)
					(self setScript: takeStuff 1 theVerb 0 0)
				)
			)
			(10 ; ammoBaggie
				(gGame points: 1 74)
				(self setScript: takeStuff 1 theVerb 0 0)
			)
			(14 ; hickmanStuff
				(self setScript: takeStuff 1 theVerb 0 0)
			)
			(11 ; washStuff
				(self setScript: takeStuff 1 theVerb 0 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(= noun temp0)
	)
)

(instance giveGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(crim view: 582 loop: 5 cel: 0 setCycle: End self)
			)
			(1
				(gNarrator modeless: 2)
				(gMessager say: 1 2 17 0 self) ; "Thanks, Chester. I appreciate it."
				(gGame points: 3)
				(gEgo get: 11) ; handgun
				((gInventory at: 12) owner: 0) ; shotgun
				(crim view: 581 loop: 0)
				(crim cel: (crim lastCel:) setCycle: Beg self)
			)
			(2)
			(3
				(gNarrator modeless: 1)
				(gGame handsOn:)
				(crim setScript: blink)
			)
		)
	)
)

(instance takeStuff of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(= local1 param2)
		(= local2 param3)
		(= local3 param4)
		(= local4 param5)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(crim view: 581 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(cond
					((== local2 17)
						(if (not (gPqFlags test: 51))
							(gPqFlags set: 51)
							(= global149 gDay)
							(gMessager say: 1 17 0 1 self) ; "Chester, I'd like you to take a look at this and see if you can match it to the glue found in Hickman's eyes. I purchased it in the neighborhood where Hickman was found... I know it's a long shot."
						else
							(= ticks 30)
						)
					)
					((== local3 2)
						(gMessager say: 1 2 2 1 self) ; "Chester, I found these at Hickman's. Apparently he was taking them regularly. Could he have overdosed on these things?"
					)
					(else
						(= ticks 30)
					)
				)
			)
			(2
				(crim
					view: 582
					loop:
						(switch local2
							(39 4)
							(2 4)
							(34 3)
							(17 2)
							(10 1)
							(14 0)
							(11 0)
						)
				)
				(crim cel: (crim lastCel:) setCycle: Beg self)
			)
			(3
				(crim view: 584 loop: 1)
				(crim cel: (crim lastCel:) setCycle: Beg self)
			)
			(4
				(if (== local2 17)
					(gMessager say: 1 17 0 2 self) ; "Hold on. Detective. I only need a sample."
				else
					(= ticks 30)
				)
			)
			(5
				(crim setCycle: End self)
			)
			(6
				(cond
					((== local2 17)
						(self cue:)
					)
					((== local3 2)
						(gMessager sayRange: 1 2 2 2 3 self) ; "Detective, these are Valium, five milligrams. Hickman weighed, what would you say, 170 pounds?"
					)
					(else
						(gMessager say: local1 local2 local3 local4 self)
					)
				)
			)
			(7
				(crim
					view: 582
					loop:
						(switch local2
							(39 4)
							(2 4)
							(34 3)
							(17 2)
							(10 1)
							(14 0)
							(11 0)
						)
					cel: 0
					setCycle: End self
				)
			)
			(8
				(crim view: 581 loop: 0)
				(crim cel: (crim lastCel:) setCycle: Beg self)
			)
			(9
				(crim setScript: blink)
				(gGame handsOn:)
			)
		)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crim view: 584 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(crim setCycle: Beg self)
			)
			(2
				(= state -1)
				(= ticks (Random 120 240))
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gGlobalSound0 flags:))
				(gGlobalSound0 pause:)
				(sFx number: 400 setLoop: 1 play: self)
			)
			(1
				(gGlobalSound0 pause: 0)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soundScript)
				(crim setCycle: End self)
			)
			(1
				(crim view: 580 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(crim setScript: blink)
				(cond
					((== ((gInventory at: 11) owner:) 580) ; handgun
						(gMessager say: 1 2 16 0 self) ; "Hello, Detective. Here to pick up your firearms? They're all ready."
					)
					((== global145 5)
						(if (gPqFlags test: 178)
							(gMessager say: 1 2 55 0 self) ; "Hello, Carey. Before you say anything I have to tell you that your drinking to the point of unconsciousness last night embarassed and shocked me. I'll have you know that I pride myself on my reputation. Asking you to join us appears to have been a mistake."
						else
							(gMessager say: 1 2 27 0 self) ; "Hello, Carey. That was some encounter with your lieutenant last night. I almost recieved a 181. I'll never do that again."
						)
					)
					((== global145 10)
						(gMessager say: 1 2 48 1 self) ; "Hello, John."
					)
					(else
						(gMessager say: 1 2 3 1 self) ; "Hello, Detective. How can I help you?"
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hiResSign of View
	(properties
		noun 5
		x 194
		y 67
		view 5801
	)
)

(instance chesterTalker of Narrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(= audModNum (param1 at: 0))
		(= audNoun (param1 at: 1))
		(= audVerb (param1 at: 2))
		(= audCase (param1 at: 3))
		(= audSequence (param1 at: 4))
		(if (ResCheck 146 audModNum audNoun audVerb audCase audSequence) ; CHUNK
			(= ticks (DoAudio audPLAY audModNum audNoun audVerb audCase audSequence))
		)
		(chesterTalkerHead
			cel: 0
			init:
			setPri: (+ (crim priority:) 1)
			setCycle: RandCycle (* (/ ticks 2) 2) 0 1
			cycleSpeed: 10
		)
	)

	(method (dispose)
		(if (!= gCurRoomNum 225)
			(chesterTalkerHead dispose:)
		)
		(super dispose: &rest)
	)
)

(instance chesterTalkerHead of Prop
	(properties
		x 119
		y 117
		view 583
	)
)

(instance sFx of Sound
	(properties)
)

