;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm031 0
	Lt__Hamilton 1
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm031 of PQRoom
	(properties
		picture 31
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 118 97 139 89 142 78 168 82 173 79 132 67 126 69 133 73 128 75 128 89 64 110 64 120 23 150 41 176 70 155 240 155 240 148 200 132 122 112
					yourself:
				)
		)
		(super init:)
		(ClearFlag 37)
		(switch global211
			(8
				(cond
					((IsFlag 36)
						(= local7 2)
						(carol dispose:)
					)
					((IsFlag 37)
						(= local5 1)
						(= local7 2)
					)
				)
				(steveSit init: stopUpd:)
				(= local8 1)
			)
			(global211
				14
				(carol setScript: franticCarol)
			)
		)
		(HandsOn)
		(gEgo init: posn: 50 175)
		(self posn: 90 145 setScript: (ScriptID 896 1)) ; sWI
		(carol init:)
		(patronBob init:)
		(phone init:)
		(booth init:)
		(menu init:)
		(pie init:)
		(restroomDoor init:)
		(lightSwitch init:)
		(counterTop init:)
		(kitchen init:)
		(dirtyWindow init:)
		(sugar init:)
		(napkins init:)
		(carolsFloor init:)
		(stools init:)
		(if local8
			(theCupoCoffee init: stopUpd:)
		)
		(gLongSong number: 300 loop: -1 fade: 127 15 5 0)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (gEgo mover:) local9)
			(self setScript: standUp)
		)
		(cond
			(script 0)
			((& (= temp0 (gEgo onControl: 0)) $0002)
				(self posn: 42 147 setScript: (ScriptID 896 2) 0 30) ; sWO
			)
		)
	)

	(method (dispose)
		(gLongSong fade: 55 15 5 0)
		(super dispose:)
	)
)

(instance talkToSteve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local9
					(= cycles 1)
				else
					(self dispose:)
					(gCurRoom setScript: sitDown)
				)
			)
			(1
				(self dispose:)
				(if (<= local7 3)
					(switch (++ local7)
						(1
							(gEgo setScript: talkToSteveFirst self)
						)
						(2
							(gMessager say: 15 2 9 0 self) ; "So anyway, did you get an ID on the guy?"
						)
						(3
							(gMessager say: 15 2 10 0 self) ; "Come on, 'fess up. You're the one who's been making old Dooley's life a living hell, aren't you?"
						)
						(4
							(gMessager say: 15 2 17 0 self) ; "You're talked out. Perhaps it's time to hit the road."
							(= local0 1)
							(-- local7)
						)
					)
				)
			)
			(2 0)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 171 120 self)
			)
			(1
				(gEgo
					view: 248
					setLoop: 1
					setPri: 10
					setCel: 0
					posn: 185 121
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 0)
				(= local9 1)
				(if (and (== local7 0) local8)
					(gCurRoom setScript: talkToSteveFirst)
				else
					(= cycles 1)
				)
			)
			(3
				(if (and (not local0) (== local6 1) (== global211 9))
					(HandsOff)
					(gEgo setScript: talkAboutCall)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance talkToSteveFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(steveSit setLoop: 1 setCycle: End)
				(HandsOff)
				(= local7 1)
				(carol
					view: 241
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 263 110 self
				)
			)
			(1
				(gMessager say: 15 2 7 0 self) ; "Hi, buddy, glad you could make it. So what's up? How's your shift going?"
			)
			(2
				(steveSit stopUpd:)
				(carol
					view: 241
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 209 98 self
				)
			)
			(3
				(carol view: 241 setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gMessager say: 21 0 8 0 self) ; "Lordy, couldn't you boys discuss something a little less...disgusting? You're gonna scare off my customers. Here's your coffee. You want any pie?"
			)
			(5
				(carol view: 242 loop: 0 cel: 10 setCycle: Beg self)
			)
			(6
				(carol setCycle: End self)
			)
			(7
				(carol
					view: 241
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 263 110 self
				)
			)
			(8
				(gMessager say: 21 0 8 6 self) ; "It isn't us scaring off her customers. It's this liquid fertilizer she serves as coffee, hah!"
			)
			(9
				(= seconds 5)
			)
			(10
				(gMessager say: 15 2 9 0 self) ; "So anyway, did you get an ID on the guy?"
				(= local7 2)
			)
			(11
				(phoneRing play:)
				(= seconds 6)
			)
			(12
				(carol
					view: 241
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 195 92 self
				)
			)
			(13
				(carol setLoop: 3 cel: 0 setCycle: End)
				(phoneRing stop:)
				(= seconds 4)
			)
			(14
				(carol setLoop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(15
				(gMessager say: 21 0 4 0 self) ; "Sonny! You gotta phone call over here!"
			)
			(16
				(carol setLoop: 6 setCycle: Walk setMotion: MoveTo 263 110)
				(= local5 1)
				(SetFlag 37)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(steveSit setLoop: 1 setCycle: Beg)
				(HandsOff)
				(= local3 ((User curEvent:) x:))
				(= local4 ((User curEvent:) y:))
				(gEgo
					setLoop: 1
					setCel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(1
				(steveSit stopUpd:)
				(NormalEgo)
				(= local9 0)
				(gEgo
					setPri: -1
					posn: 171 120
					setMotion:
						MoveTo
						(- (gEgo x:) 20)
						(+ (gEgo y:) 5)
						self
				)
			)
			(2
				(HandsOn)
				(= register (CueObj client:))
				(if
					(and
						(IsObject register)
						(!= register stools)
						(register approachX:)
					)
					(gEgo
						setMotion:
							PolyPath
							(register approachX:)
							(register approachY:)
					)
				else
					(gEgo setMotion: PolyPath local3 local4)
				)
				(self dispose:)
			)
		)
	)
)

(instance answerPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 247 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 10 4 4 0 self) ; "Hello. This is Officer Sonny Bonds."
			)
			(2
				(SetScore 162 2)
				(NormalEgo)
				(= local6 1)
				(= local5 0)
				(= global211 9)
				(self dispose:)
			)
		)
	)
)

(instance talkAboutCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 15 2 12 0 self) ; "What was that all about?"
			)
			(1
				(HandsOn)
				(SetFlag 36)
				(self dispose:)
			)
		)
	)
)

(instance franticCarol of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carol
					view: 242
					ignoreActors: 1
					illegalBits: 0
					setLoop: 0
					setCycle: Osc 1 self
				)
			)
			(1
				(carol stopUpd:)
				(= seconds 5)
			)
			(2
				(carol setLoop: 3 setCycle: Walk setMotion: MoveTo 240 110 self)
			)
			(3
				(carol view: 242 setLoop: 1 setCycle: Osc 1 self)
			)
			(4
				(carol stopUpd:)
				(= seconds 5)
			)
			(5
				(carol setLoop: 5 setCycle: Walk setMotion: MoveTo 203 99 self)
			)
			(6
				(self changeState: 0)
			)
			(7
				(carol setLoop: 8)
				(Face carol gEgo)
				(= cycles 15)
			)
			(8
				(if (== global211 15)
					(gMessager say: 13 2 3 4 self) ; "They're gettin' scared to come in at all. Can you do somethin', Sonny?"
				else
					(SetScore 163 3)
					(= global211 15)
					(gMessager say: 13 2 3 0 self) ; "Hello, Carol. I got a call stating that you want me to check something out. What's the problem?"
				)
			)
			(9
				(self changeState: 0)
			)
		)
	)
)

(instance fixTheCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(patronBob
					setLoop: 0
					ignoreActors: 1
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(patronBob stopUpd:)
				(= seconds 10)
			)
			(2
				(if (and local8 (not local9))
					(steveSit setLoop: 0 setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (and local8 (not local9))
					(steveSit stopUpd:)
				)
				(patronBob setLoop: 1 cycleSpeed: 8 setCycle: Osc 1 self)
			)
			(4
				(patronBob stopUpd:)
				(= seconds 10)
			)
			(5
				(self init:)
			)
		)
	)
)

(instance drinkCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theCupoCoffee hide:)
				(HandsOff)
				(gEgo view: 248 setLoop: 0 setCycle: Osc 1 self)
			)
			(1
				(gEgo view: 248 setLoop: 0 setCel: 0)
				(= cycles 1)
			)
			(2
				(theCupoCoffee show:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance carol of Actor
	(properties
		x 218
		y 99
		noun 13
		approachX 110
		approachY 125
		view 241
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(cond
					((== global211 18)
						(++ global211)
						(Face carol gEgo)
						(if local10
							(gMessager say: 13 2 14) ; "Thanks again, Sonny. You're a sweetie."
						else
							(gMessager say: 13 2 13) ; "I don't think you'll have a problem with those motorcycles anymore, Carol. I suggested to them that they find another place to park."
							(= local10 1)
						)
					)
					((== global211 14)
						(franticCarol changeState: 7)
					)
					(else
						(gMessager say: 13 2) ; "Oh, honey, I'd love to talk but I got a couple orders up. Is everything okay? Good. Boy, my poodles are really barking today. I gotta soak these things in some epsom salts soon. Catch you later, Sonny."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(self delete:)
	)
)

(instance patronBob of Prop
	(properties
		x 99
		y 96
		noun 11
		view 229
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setScript: fixTheCoffee)
	)

	(method (dispose)
		(super dispose:)
		(self delete:)
	)
)

(instance steveSit of Prop
	(properties
		x 156
		y 116
		noun 15
		view 244
		loop 1
		priority 7
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(if local5
					(gMessager say: 15 2 11 1) ; "You better go take that call, buddy."
				else
					(self setScript: talkToSteve)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(self delete:)
	)
)

(instance theCupoCoffee of View
	(properties
		x 198
		y 89
		view 244
		loop 3
		priority 10
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local9
					(gEgo setScript: drinkCoffee)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Lt__Hamilton of Narrator
	(properties
		name {Lt. Hamilton}
		x 150
		y 20
		talkWidth 150
		showTitle 1
	)
)

(instance phone of Feature
	(properties
		x 250
		y 100
		noun 10
		sightAngle 40
		onMeCheck 4
		approachX 174
		approachY 83
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 4) ; Look, Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(if (== local5 1)
						(gCurRoom setScript: answerPhone)
					else
						(gMessager say: 10 4 5 1) ; "There's no one you need to call right now, Officer."
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance booth of Feature
	(properties
		noun 1
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance menu of Feature
	(properties
		noun 9
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pie of Feature
	(properties
		noun 5
		sightAngle 40
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance restroomDoor of Feature
	(properties
		noun 23
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lightSwitch of Feature
	(properties
		noun 17
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance counterTop of Feature
	(properties
		noun 6
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if local8
					(gMessager say: 6 1 1 1) ; "This is your usual caffeine-ingesting spot."
				else
					(gMessager say: 6 1 2 1) ; "A small group of mediocre coffee connoiseurs have stopped by to make sure no one has slipped in those pesky Fauxger's crystals."
				)
			)
			(4 ; Do
				(if local8
					(gMessager say: 6 4 1 1) ; "Try sitting on the stool, Bonds. Carol wouldn't appreciate you sitting on her counter."
				else
					(gMessager say: 6 4 2 1) ; "It's being used at this time. Don't you have anything better to do, Officer?"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stools of Feature
	(properties
		noun 7
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local8
					(HandsOff)
					(gCurRoom setScript: sitDown)
				else
					(gMessager say: 7 4 2 1) ; "Do you really want to touch something that's been the resting place for untold thousands of buns?"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance carolsFloor of Feature
	(properties
		noun 12
		sightAngle 40
		onMeCheck 16384
	)
)

(instance sugar of Feature
	(properties
		noun 18
		sightAngle 40
		onMeCheck 2048
	)
)

(instance napkins of Feature
	(properties
		noun 19
		sightAngle 40
		onMeCheck 4096
	)
)

(instance kitchen of Feature
	(properties
		noun 8
		sightAngle 40
		onMeCheck 1024
	)
)

(instance dirtyWindow of Feature
	(properties
		noun 3
		sightAngle 40
		onMeCheck 8192
	)
)

(instance phoneRing of Sound
	(properties
		number 937
		loop -1
	)
)

