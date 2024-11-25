;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(instance rm440 of LLRoom
	(properties
		lookStr {The F.B.I. laboratory is filled with interesting equipment, most of which baffles you.}
		picture 440
		style 12
		east 450
		west 430
	)

	(method (init)
		(SetFFRoom 450)
		(LoadMany rsSOUND 40 442)
		(LoadMany rsVIEW 440 432 440 442 444 1430 1440)
		(Load rsSCRIPT 941)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 140 192 140 231 130 251 138 305 125 293 113 271 102 0 102 0 0 319 0 319 189
					yourself:
				)
		)
		(gEgo init: normalize: x: 20)
		(if (not (IsFlag 43)) ; fFartMan
			(Load rsSOUND 443 444 445 446 447 448 449)
			(fartman init: setScript: sMix)
		)
		(HandsOff)
		(self setScript: sRoom)
		(super init:)
		(if (!= gPrevRoomNum 430)
			(gEgo y: 118 view: 570)
		)
		(door init: stopUpd:)
		(computer init: stopUpd:)
		(duck setCycle: Fwd init:)
		(machine init:)
		(contraption init:)
		(books init:)
		(desk init:)
		(southBank init:)
	)

	(method (dispose)
		(gTheMusic2 fade:)
		(super dispose:)
	)
)

(instance sRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 20 (gEgo y:) self)
			)
			(1
				(twit init: setCycle: StopWalk -1 setMotion: MoveTo 40 100 self)
			)
			(2
				(if (IsFlag 44) ; fHasFBINumber
					(HandsOn)
					(self dispose:)
				else
					(SetFlag 44) ; fHasFBINumber
					(= seconds 2)
				)
			)
			(3
				(Say Commander_Twit 440 0 #dispose) ; "Patti, please step over here to the computer for a moment," says Twit. "I need to take care of your indoctrination paperwork."
				(= seconds 3)
			)
			(4
				(twit setMotion: MoveTo 133 100 self)
				(gEgo cycleSpeed: 6 moveSpeed: 6 setMotion: PolyPath 114 105)
			)
			(5
				(= ticks 60)
			)
			(6
				(twit view: 442 setLoop: 0 setCycle: RandCycle)
				(= ticks 60)
			)
			(7
				(soundFX number: 442 loop: -1 flags: 0 play:)
				(computer startUpd: setCycle: RandCycle)
				(= seconds 4)
			)
			(8
				(Say Commander_Twit 440 1 #dispose #caller self) ; "First, let's get you a contact telephone number."
			)
			(9
				(= seconds 4)
			)
			(10
				(Points 1)
				(Say Commander_Twit 440 2 #dispose) ; "Ah, here's one: 556-2779."
				(= seconds 3)
			)
			(11
				(Say Commander_Twit 440 3 #dispose) ; "Now let's issue you a computer account number."
				(= seconds 2)
			)
			(12
				(Say Commander_Twit 440 4 #dispose) ; "Here we go. How about BB-30,7. Now for your E-mail ID number."
				(= seconds 3)
			)
			(13
				(Say Commander_Twit 440 5 #dispose) ; "65493756. And your official password is..."
				(= seconds 2)
			)
			(14
				(Say Commander_Twit 440 6 #dispose) ; "...MAKING WOOPY. How appropriate. Now I'll apply for security clearance for you...."
				(= seconds 2)
			)
			(15
				(Say Commander_Twit 440 7 #dispose) ; "Granted. And you need some sort of codename; everybody who's anybody around here has a codename."
				(= seconds 2)
			)
			(16
				(Say gEgo 440 8 #at -1 185) ; ""How about `Agent 88'?" you suggest."
				(= ticks 90)
			)
			(17
				(Say Commander_Twit 440 9 #dispose) ; "Okay, let's see if that's taken."
				(= seconds 3)
			)
			(18
				(Say Commander_Twit 440 10 #dispose #caller self) ; "Well, it appears it was used once, but that was years ago!"
			)
			(19
				(soundFX loop: 1 flags: 1 stop:)
				(computer setCycle: 0 stopUpd:)
				(twit view: 432 setCycle: StopWalk -1 setHeading: 180 self)
			)
			(20
				(Say Commander_Twit 440 11 #dispose) ; "And now all you have left is your Official Departmental Medical Checkup and then we'll be ready to fit you with your `Safety First Field Locator Device.'"
				(SetFFRoom 0)
				(gEgo
					moveSpeed: (gGame egoMoveSpeed:)
					cycleSpeed: (gGame egoMoveSpeed:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToDoc of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				state
				(not register)
				(< (gEgo x:) 231)
				(< (gEgo x:) (- (twit x:) 10))
			)
			(= register 1)
			(gEgo cycleSpeed: 6 moveSpeed: 6 setMotion: PolyPath 231 108)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say Commander_Twit 440 12 #dispose #caller self) ; "That's the door to Dr. Phil Hopian's office. Let's go in there now. He'll fit you with your `Field Locator Device.'"
			)
			(1
				(twit
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: MoveTo 260 100 self
				)
			)
			(2
				(door setCycle: End self)
				(soundFX number: 40 setLoop: 1 play:)
			)
			(3
				(twit setCycle: 0)
				(Say Commander_Twit 440 13 #dispose #caller self) ; "Agent, uh, 88, I'd like you to meet our staff physician, Dr. Phil Hopian. Dr. Hopian, this is Agent 88! Don't worry about a thing, Patti: you're in good hands with Dr. Hopian!"
			)
			(4
				(Say Dr__Phil_Hopian 440 14 #dispose #caller self) ; "Nice to meet you, Patti. Come inside and take off all your clothes!"
			)
			(5
				(gEgo setMotion: MoveTo 286 106 self)
			)
			(6
				(Say gEgo 440 15 #at -1 185) ; ""Wow. Fast worker!" you think."
				(= cycles 10)
			)
			(7
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(8
				(Say Dr__Phil_Hopian 440 16 #dispose #caller self) ; ""Assume the position!" he barks."
			)
			(9
				(= seconds 3)
			)
			(10
				(Say Dr__Phil_Hopian 440 17 #dispose #caller self) ; "Oops. Sorry. I used to be a field agent! Old habits, you know."
			)
			(11
				(door setCycle: Beg self)
				(soundFX number: 41 setLoop: 1 play:)
			)
			(12
				(TPrint 440 18) ; "You enter his office, slip behind a screen and remove your clothes, replacing them with one of those wonderful hospital gowns that leave nothing to the imagination."
				(TPrint 440 19) ; "Oh, well. Things could be worse. At least the good doctor is also a good looker!"
				(gTheMusic2 fade:)
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance sFart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gTheCursor 1 500 500)
				(SetFlag 43) ; fFartMan
				(Say Commander_Twit 440 20 #dispose #caller self) ; "Ah, yes, Patti. I see you're interested in one of my pet projects, which I find fascinating. This man has developed a high-yield, space-age polymer, macrobiotic, flatulence-inducing powder."
			)
			(1
				(Face gEgo fartman)
				(= seconds 2)
			)
			(2
				(Say Commander_Twit 440 21 #dispose #caller self) ; "We feel it will be excellent for those times we find it necessary to destabilize a public leader by humiliating him during a major public appearance or state function!"
			)
			(3
				(= seconds 3)
			)
			(4
				(fartman setScript: 0 setCycle: End self)
			)
			(5
				(fartman setLoop: 1 setCel: 0 cycleSpeed: 24 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(soundFX number: 444 setLoop: 1 play:)
				(fartman setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(= seconds 3)
			)
			(9
				(soundFX number: 445 play:)
				(fartman setLoop: 3 setCel: 0 setCycle: CT 2 1 self)
			)
			(10
				(= seconds 2)
			)
			(11
				(fartman setCycle: End setPri: 11 setMotion: MoveTo 235 32 self)
				(soundFX number: 446 play:)
			)
			(12
				(soundFX number: 447 play:)
				(fartman setCel: 8 setMotion: MoveTo 293 71 self)
			)
			(13
				(soundFX number: 448 play:)
				(fartman setCel: 8 setMotion: MoveTo 252 135 self)
			)
			(14
				(soundFX number: 449 play:)
				(fartman setMotion: MoveTo 159 14 self)
			)
			(15
				(soundFX number: 448 play:)
				(fartman setMotion: MoveTo 112 149 self)
			)
			(16
				(soundFX number: 449 play:)
				(fartman setMotion: MoveTo 114 17 self)
			)
			(17
				(soundFX number: 447 play:)
				(fartman setMotion: MoveTo 169 138 self)
			)
			(18
				(soundFX number: 448 play:)
				(fartman setMotion: MoveTo 240 11 self)
			)
			(19
				(soundFX number: 449 play:)
				(fartman setMotion: MoveTo 288 68 self)
			)
			(20
				(soundFX number: 448 play:)
				(fartman setMotion: MoveTo 252 135 self)
			)
			(21
				(soundFX number: 443 setLoop: -1 play:)
				(fartman setCel: 8 setLoop: 4 setMotion: MoveTo 183 76 self)
			)
			(22
				(fartman
					setLoop: 5
					setCycle: Fwd
					setStep: 12 2
					cycleSpeed: 6
					setMotion: MoveTo -50 (fartman y:) self
				)
			)
			(23
				(fartman dispose:)
				(soundFX fade:)
				(= seconds 3)
			)
			(24
				(Say Commander_Twit 440 22 #dispose #caller self) ; "Well, well. That seems to be progressing nicely! However, a lighter dosage may well be preferable!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance twit of Actor
	(properties
		x -15
		y 100
		description {Commander Twit}
		lookStr {He's the perfect image of a man more interested in science than in his own self-image!}
		view 432
		cel 2
		signal 16384
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (self mover:))
				(not (gCurRoom script:))
				(< x 133)
				(> (- (gEgo x:) (self x:)) 20)
			)
			(self setMotion: MoveTo (Min 133 (+ x 10)) y)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 23) ; "There's nothing you can do to Commander Twit that he hasn't done already."
			)
			(5 ; Talk
				(if (not (IsFlag 43)) ; fFartMan
					(HandsOff)
					(gCurRoom setScript: sFart)
				else
					(Say Commander_Twit 440 24 #dispose) ; "Whenever you're through exploring this area, Patti, please feel free to enter Dr. Hopian's office."
				)
			)
			(10 ; Zipper
				(TPrint 440 25) ; "Perish the thought!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 282
		y 99
		description {Doctor Hopian's door}
		lookStr {Through this door lies the offices of Dr. Phil Hopian, F.B.I. gynecologist.}
		view 440
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sToDoc)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance computer of Prop
	(properties
		x 133
		y 61
		description {the computer}
		sightAngle 40
		lookStr {If only you had paid attention when Larry chattered on and on about his computer. You know nothing about this computer and are sure you'll be unable to do anything with it.}
		view 440
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 26) ; "You are afraid to touch any computer keyboard that doesn't have MIDI built in!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fartman of Actor
	(properties
		x 173
		y 157
		yStep 12
		view 444
		signal 24576
		cycleSpeed 24
		illegalBits 0
		xStep 12
	)

	(method (doVerb)
		(Points 3 101)
		(HandsOff)
		(gCurRoom setScript: sFart)
	)
)

(instance sMix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 1 1 self)
			)
			(1
				(= seconds (Random 2 4))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance duck of Prop
	(properties
		x 45
		y 167
		z 7
		description {the duck}
		sightAngle 40
		lookStr {If it drinks like a duck, and it quacks like a duck, it must be an experiment.}
		view 440
		loop 3
		priority 14
		signal 16400
		detailLevel 3
	)
)

(instance Commander_Twit of Talker
	(properties
		name {Commander Twit}
		nsTop 15
		nsLeft 40
		view 1430
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust twitBust)
		(= eyes twitEyes)
		(= mouth twitMouth)
		(super init: &rest)
	)
)

(instance twitBust of Prop
	(properties
		view 1430
		loop 1
	)
)

(instance twitEyes of Prop
	(properties
		view 1430
		loop 2
		cycleSpeed 30
	)
)

(instance twitMouth of Prop
	(properties
		nsTop 47
		nsLeft 11
		view 1430
		cycleSpeed 8
	)
)

(instance Dr__Phil_Hopian of Talker
	(properties
		name {Dr. Phil Hopian}
		nsTop 15
		nsLeft 50
		view 1440
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust peltBust)
		(= eyes peltEyes)
		(= mouth peltMouth)
		(super init: &rest)
	)
)

(instance peltBust of Prop
	(properties
		view 1440
		loop 1
	)
)

(instance peltEyes of Prop
	(properties
		nsTop 18
		nsLeft 13
		view 1440
		loop 2
		cycleSpeed 30
	)
)

(instance peltMouth of Prop
	(properties
		nsTop 21
		nsLeft 14
		view 1440
		cycleSpeed 8
	)
)

(instance machine of Feature
	(properties
		x 215
		y 47
		nsTop -1
		nsLeft 170
		nsBottom 95
		nsRight 261
		description {the machine}
		sightAngle 40
		lookStr {This machine does something, you feel quite certain.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 27) ; "You have not a clue as to what this machine may do!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance contraption of Feature
	(properties
		x 114
		y 160
		z 34
		nsTop 115
		nsLeft 94
		nsBottom 137
		nsRight 134
		description {the chemistry set}
		sightAngle 40
		lookStr {This must be the source of the flatulence powder.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 28) ; "You'll never be able to duplicate the F.B.I.'s "secret formula" of eleven natural herbs and spices."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 166
		nsTop 144
		nsBottom 189
		nsRight 319
		description {the workbench}
		sightAngle 40
		lookStr {Lots of chemicals, beakers, and junk food wrappers fill this workbench.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 29) ; "After seeing the results of Commander Twit's earlier experiments, you think it best not to touch anything here unless truly necessary."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 41
		y 88
		z 30
		nsTop 49
		nsLeft 28
		nsBottom 68
		nsRight 55
		description {the books}
		sightAngle 40
		lookStr {These books are filled with Latin phrases. The only Latin phrases you know would get a sailor thrown out of a bar in Tijuana!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 30) ; "You don't have time to read a book now, Patti!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 81
		y 87
		z 17
		nsTop 54
		nsBottom 88
		nsRight 162
		description {the desk}
		sightAngle 40
		lookStr {This desk doesn't contain any secret documents; they all were burned in the big fire last week!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 440 31) ; "You open the drawer and look inside. There's nothing in there but a few charred slips of paper."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

