;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use DScript)
(use Osc)
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
	rm32 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm32 of SQRoom
	(properties
		picture 32
		east 31
		west 33
	)

	(method (init &tmp temp0)
		(LoadMany rsVIEW 22 132 946 610)
		(LoadMany rsSOUND 430 424 433 396 397 398 399)
		(= style (if (== gPrevRoomNum west) 12 else 11))
		(if (== gPrevRoomNum 4)
			(gEgo posn: 160 180)
			(= global166 2)
		)
		(if (== global166 2)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 183 160 183 244 168 257 185 258 187 319 187 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 134 25 139 24 152 0 152
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 181 282 177 253 153 227 153 195 154 163 151 146 140 121 133 74 126 48 125 43 132 30 136 12 134 6 123 0 121 0 0 319 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 116 166 118 161 132 153 151 154 152 166 140 174 122 171
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 27 147 28 140 49 132 73 129 90 135 92 146 74 154 53 155 28 153
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 79 0 58 49 57 107 73 165 81 213 77 319 72 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 57 290 57 225 64 183 67 138 68 112 66 100 62 56 48 0 48
						yourself:
					)
			)
		)
		(if (not (IsFlag 23))
			(Load rsSOUND 423)
			(ggyer init:)
			(geyser init: setCycle: Fwd)
			(door init: ignoreActors: 0)
		else
			(plug init:)
		)
		(gEgo init: ignoreActors: 0)
		(= local2 0)
		(acidPool init:)
		(lowerledge init:)
		(upperledge init:)
		(if (== global166 2)
			(acidVapor init:)
			(fallingAcid init: setScript: acidDoYourThing)
		else
			(drop1 init: hide: setScript: drop1Falling)
			(drop2 init: hide: setScript: drop2Falling)
			(drop3 init: hide: setScript: drop3Falling)
			(drop4 init: hide: setScript: drop4Falling)
			(drop5 init: hide: setScript: drop5Falling)
			(drop6 init: hide: setScript: drop6Falling)
			(drop7 init: hide: setScript: drop7Falling)
			(drop8 init: hide: setScript: drop8Falling)
			(drop9 init: hide: setScript: drop9Falling)
		)
		(super init:)
		(HandsOn)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(local5 0)
			((and (== global166 1) (> (gEgo x:) 202))
				(= local5 1)
				(SetScore 3 147)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 32 0) ; "Nothing to do there."
			)
			(5 ; Talk
				(if (IsFlag 23)
					(Print 32 1) ; "You can't hear anything over the steam, and that includes your own voice."
				else
					(Print 32 2) ; "Your words echo about the cavern, apparently not destined to fall on the ears of others."
				)
			)
			(12 ; Smell
				(Print 32 3) ; "The sulfur in the air is much stronger in here. Each inhalation packs a bit of afterburn as well."
			)
			(11 ; Taste
				(Print 32 4) ; "Nothing worth tasting there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoTouchesAcid of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local0 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== global166 1)
						(Print 32 5) ; "Not from here."
					)
					((& (gEgo onControl: 0) $2000)
						(HandsOff)
						(gEgo setMotion: PolyPath 170 153 self)
					)
					(else
						(Print 32 5) ; "Not from here."
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 174 152 self)
			)
			(2
				(gEgo
					view: 22
					cycleSpeed: 8
					setLoop: 9
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(3
				(gSoundEffects number: 430 loop: 0 play:)
				(gEgo setCycle: CT 8 1 self)
			)
			(4
				(gSoundEffects number: 454 loop: 1 play: self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo setLoop: 10 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(7
				(= local4 1)
				(gLongSong number: 472 loop: -1 play:)
				(viewBox init: stopUpd:)
				(heads init: stopUpd:)
				(mouth1 init:)
				(mouth2 init:)
				(= cycles 5)
			)
			(8
				(Print 32 6 #dispose #at 15 20) ; "Well, Scott, it looks like Roger has done it again."
				(mouth1 setCycle: RandCycle 15)
				(= seconds 3)
			)
			(9
				(Print 32 7 #dispose #at 15 20) ; "It sure does, Mark. Let's run that one again with the aid of our new How-He-Blew-It Cam(tm) and Chalkboard(tm)."
				(mouth2 setCycle: RandCycle 25)
				(= seconds 10)
			)
			(10
				(gModelessDialog dispose:)
				(= cycles 20)
			)
			(11
				(mouth2 setCycle: RandCycle 20)
				(Print 32 8 #dispose #at 15 40) ; "I have to say that carefully, Mark. Every time we mention something with a trademark or copyright, the lawyers come out to feed."
				(= seconds 7)
			)
			(12
				(gModelessDialog dispose:)
				(= cycles 10)
			)
			(13
				(= seconds 4)
			)
			(14
				(= cycles 5)
			)
			(15
				(mouth1 cycleSpeed: 6 setCycle: RandCycle 10)
				(mouth2 cycleSpeed: 6 setCycle: RandCycle 10)
				(= cycles 2)
			)
			(16
				(self
					save1:
						(Display ; "Instant Replay!!!"
							32
							9
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= cycles 6)
			)
			(17
				(self restore:)
				(= cycles 1)
			)
			(18
				(self
					save1:
						(Display ; "Instant Replay!!!"
							32
							9
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global132
							dsSAVEPIXELS
						)
				)
				(++ local1)
				(= cycles 6)
			)
			(19
				(self restore:)
				(= cycles 2)
				(if (< local1 4)
					(= state 15)
				)
			)
			(20
				(= cycles 10)
			)
			(21
				(gEgo cycleSpeed: 8 setCycle: Beg self)
			)
			(22
				(gEgo cycleSpeed: 8 setLoop: 9 cel: 0 setCycle: CT 5 1 self)
				(mouth1 setCycle: RandCycle 15)
				(arrowThing init: setCycle: End)
				(= seconds 2)
			)
			(23 0)
			(24
				(Print 32 10 #dispose #at 15 40) ; "Now, this is where Roger makes the fatal move."
				(gEgo setCycle: CT 8 1 self)
				(circleThing init: setCycle: End)
				(= seconds 4)
			)
			(25 0)
			(26
				(gEgo cel: 7)
				(= cycles 10)
			)
			(27
				(gEgo cycleSpeed: 8 setCycle: End self)
				(mouth1 setCycle: RandCycle 10)
				(circleThing dispose:)
				(arrowThing dispose:)
			)
			(28
				(= seconds 2)
			)
			(29
				(Print 32 11 #at 15 40 #dispose) ; "And we can all see the result of that mistake."
				(gEgo setLoop: 10 cel: 0 setCycle: End)
				(= seconds 5)
			)
			(30
				(gModelessDialog dispose:)
				(Print 32 12) ; "I don't know about you, Scott. Personally, I like to know exactly what I'm messing with before I actually mess with it. I guess he'll know better next time. Ouch."
				(= seconds 4)
			)
			(31
				(viewBox dispose:)
				(heads dispose:)
				(mouth1 dispose:)
				(mouth2 dispose:)
				(= cycles 20)
			)
			(32
				(EgoDead 938 0 0 32 13) ; "Sure, you've died a few deaths before, but this one really burns you. Planets are depending on you. Seeing you do stuff like this is definitely making them nervous."
			)
		)
	)
)

(instance egoPlugsGeyser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 270 189 self)
			)
			(1
				(Face gEgo geyser self)
			)
			(2
				(gEgo view: 22 setLoop: 5 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(gSoundEffects number: 424 loop: 0 play:)
				(plug init:)
				(geyser dispose:)
				(ggyer dispose:)
				(SetScore 4 145)
				(gEgo put: 7 32) ; Rock
				(SetFlag 23)
				(gEgo setCycle: End self)
			)
			(4
				(gSoundEffects number: 433 loop: 1 play:)
				(door ignoreActors: 1 cycleSpeed: 10 setCycle: End self)
			)
			(5
				(gSoundEffects stop:)
				(NormalEgo 1 1 61)
				(gEgo setMotion: MoveTo 270 185 self)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance circleThing of Prop
	(properties
		x 186
		y 123
		view 610
		priority 13
		signal 16400
		cycleSpeed 8
	)
)

(instance arrowThing of Prop
	(properties
		x 160
		y 134
		view 610
		loop 1
		priority 13
		signal 16400
		cycleSpeed 8
	)
)

(instance viewBox of View
	(properties
		x 227
		y 16
		view 946
		loop 3
		priority 13
		signal 16400
	)
)

(instance heads of View
	(properties
		x 226
		y 8
		view 946
		priority 14
		signal 16400
	)
)

(instance mouth1 of Prop
	(properties
		x 250
		y 36
		view 946
		loop 1
		priority 15
		signal 16400
		cycleSpeed 5
	)
)

(instance mouth2 of Prop
	(properties
		x 271
		y 39
		view 946
		loop 2
		cel 2
		priority 15
		signal 16400
		cycleSpeed 5
	)
)

(instance helmet of View
	(properties
		x 170
		y 153
		description {a spacesuit helmet}
		view 22
		loop 6
		signal 16384
	)
)

(instance ggyer of Feature
	(properties
		x 245
		y 172
		description {geyser}
		onMeCheck 512
		approachX 270
		approachY 187
	)

	(method (doVerb)
		(geyser doVerb: &rest)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Inventory
	)
)

(instance geyser of Prop
	(properties
		x 246
		y 187
		z 15
		description {geyser}
		onMeCheck 512
		approachX 270
		approachY 187
		view 132
		loop 5
		cel 1
		priority 15
		signal 16400
		cycleSpeed 10
	)

	(method (doit)
		(super doit:)
		(if (and (== cel 2) (!= local3 cel))
			(geyserSound loop: 0 play:)
		)
		(= local3 cel)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Inventory
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 23)
					(Print 32 14) ; "This is the steam geyser that you plugged."
				else
					(Print 32 15) ; "This is a pulsating steam geyser."
				)
			)
			(3 ; Do
				(Print 32 16) ; "I wouldn't be touching that directly. It's hot!"
			)
			(11 ; Taste
				(Print 32 17) ; "Yes, a good steam-cleaning might seem in order right now, considering all the the things you've dragged it over lately. It's the facial peel that is of concern."
			)
			(12 ; Smell
				(Print 32 18) ; "You get a whiff of sulfur in the steam-heated air."
			)
			(5 ; Talk
				(Print 32 19) ; ""SSSSSS SSSSSSSSSSSS SSS SSSSSS SSSSS SSSSS SSSS" is its response."
			)
			(4 ; Inventory
				(switch invItem
					(7 ; Rock
						(gCurRoom setScript: egoPlugsGeyser)
					)
					(4 ; Knife
						(Print 32 20) ; "Why? Do you plan to practice some auto-surgery techiques? May we suggest a lobotomy?"
					)
					(6 ; Broken_Glass
						(Print 32 21) ; "It just steams up."
					)
					(else
						(Print 32 22) ; "Bad idea."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plug of View
	(properties
		x 244
		y 173
		view 132
		loop 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(switch theVerb
				(2 ; Look
					(Print 32 23) ; "That piece of stalagmite sure makes a good plug!"
				)
				(3 ; Do
					(Print 32 24) ; "Ooo. Bad idea. It's a bit hot."
				)
				(5 ; Talk
					(Print 32 25) ; "You poor, deprived being!"
				)
				(11 ; Taste
					(Print 32 24) ; "Ooo. Bad idea. It's a bit hot."
				)
				(12 ; Smell
					(Print 32 26) ; "The smell of sulfur seems to be dissipating."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 32 27) ; "You are on the wrong level to do that."
		)
	)
)

(instance upperledge of Feature
	(properties
		x 154
		y 40
		onMeCheck 2054
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== global166 1)
					(Print 32 28) ; "This is an upper pathway in a slightly smaller chamber of the underground complex. Near the middle section of the path, the acid drops have formed a pattern of little holes. No, it's not a dot-to-dot puzzle."
				else
					(Print 32 29) ; "This is an upper pathway which is inaccessible from here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lowerledge of Feature
	(properties
		x 159
		y 137
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((& (gEgo onControl: 0) $4000)
						(if (== (door cel:) 0)
							(Print 32 30) ; "Your view is restricted by the closed door."
						else
							(Print 32 31) ; "You'll need to move further into the room to receive a better view."
						)
					)
					((== global166 2)
						(Print 32 32) ; "This is a slightly smaller chamber in the underground complex. There is a path above which is not accessible from here. There is a pool on the right side."
					)
					(else
						(Print 32 33) ; "This is the lower ledge for this room. You can't reach it from here -- try going back down."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 272
		y 177
		view 132
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 32 34) ; "It's an odd, closed door with no apparent mechanism for opening it."
			)
			(3 ; Do
				(Print 32 35) ; "You are unable to open the door by hand."
			)
			(5 ; Talk
				(Print 32 36) ; "No amount of screaming will open this door."
			)
			(12 ; Smell
				(Print 32 37) ; "Smells pretty much like a strange door which has stood next to a sulfur-spewing geyser for a long period of time."
			)
			(11 ; Taste
				(Print 32 38) ; "It tastes like rotten Krebble eggs!"
			)
			(4 ; Inventory
				(Print 32 39) ; "That doesn't seem to have any effect on the door."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance acidPool of Feature
	(properties
		x 197
		y 133
		description {acid pool}
		sightAngle 45
		onMeCheck 1024
		lookStr {acid Pool}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((& (gEgo onControl:) $4000)
						(Print 32 5) ; "Not from here."
					)
					((& (gEgo onControl:) $2000)
						(Print 32 40) ; "You gaze intently at the greenish pool of liquid, the first real sign of moisture on the planet. The pool seems to have no bottom. The gentle dripping has a soothing effect on your frazzled nerves. A small plume of mist rises as each drop hits the pool's surface."
					)
					((== global166 1)
						(Print 32 41) ; "You can't see anything from up here."
					)
					(else
						(proc0_15)
					)
				)
			)
			(3 ; Do
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(gEgo setScript: egoTouchesAcid)
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(12 ; Smell
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(gEgo setScript: egoTasteAcid 0 2)
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(11 ; Taste
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(gEgo setScript: egoTasteAcid 0 1)
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(5 ; Talk
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(Print 32 42) ; "Drip, drip, drip. It must be talking to you."
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(4 ; Inventory
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(Print 32 43) ; "Nah, not here. Try using it somewhere else."
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance acidDoYourThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fallingAcid show: cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(if (not local4)
					(poolDrop loop: 0 play: (if (== global166 1) 70 else 127))
				)
				(acidVapor show: cel: 0 setCycle: Fwd)
				(fallingAcid setCycle: End self)
			)
			(2
				(fallingAcid hide:)
				(= cycles 30)
			)
			(3
				(acidVapor hide:)
				(= cycles (Random 30 120))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance fallingAcid of Actor
	(properties
		x 195
		y 135
		view 132
		loop 2
		cycleSpeed 4
		moveSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(Print 32 44) ; "From tiny cracks in the ceiling several small drops of liquid succumb to the influence of gravity."
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(else
				(acidPool doVerb: theVerb &rest)
			)
		)
	)
)

(instance acidVapor of Prop
	(properties
		x 194
		y 130
		view 132
		loop 4
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((& (gEgo onControl:) $4000)
						(Print {You can't do that from here.})
					)
					((& (gEgo onControl:) $2000)
						(Print 32 45) ; "A light-green mist floats gently upward after each drop of liquid hits the surface of the pool."
					)
					((== global166 1)
						(Print {You can't do that from here.})
					)
				)
			)
			(else
				(acidPool doVerb: theVerb &rest)
			)
		)
	)
)

(instance poolDrop of Sound
	(properties
		number 396
	)
)

(instance geyserSound of Sound
	(properties
		number 423
	)
)

(instance dripSound of Sound
	(properties)
)

(class AcidDrop of Actor
	(properties
		description {a small drop of green liquid}
		yStep 3
		view 132
		loop 1
		signal 18432
		illegalBits 0
		ctrlColor 0
		theScript 0
		tarY 0
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			(
				(and
					(self
						inRect:
							(+ (gEgo nsLeft:) 3)
							(gEgo nsTop:)
							(- (gEgo nsRight:) 3)
							(- (gEgo nsBottom:) 3)
					)
					(& (gEgo onControl: 1) ctrlColor)
					(== local2 0)
				)
				(gEgo setScript: egoHitByAcidDrop)
				(= local2 1)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 32 46) ; "From tiny cracks in the ceiling several small green drops fall in a gently rhythmic pattern that stimulates your alpha levels. They make a heckuva great rust remover, too."
			)
			(3 ; Do
				(Print 32 47) ; "There's nothing you can do to these from here."
			)
			(12 ; Smell
				(Print 32 48) ; "They're hard to catch, but you do get a slight burning sensation."
			)
			(11 ; Taste
				(Print 32 49) ; "They're hard to catch. You might need to get right under them."
			)
			(5 ; Talk
				(Print 32 50) ; "They're too busy falling right now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drop1 of AcidDrop
	(properties
		x 115
		tarY 72
	)
)

(instance drop2 of AcidDrop
	(properties
		x 124
		tarY 69
	)
)

(instance drop3 of AcidDrop
	(properties
		x 132
		tarY 70
	)
)

(instance drop4 of AcidDrop
	(properties
		x 141
		tarY 70
	)
)

(instance drop5 of AcidDrop
	(properties
		x 157
		tarY 76
	)
)

(instance drop6 of AcidDrop
	(properties
		x 163
		tarY 70
	)
)

(instance drop7 of AcidDrop
	(properties
		x 175
		tarY 78
	)
)

(instance drop8 of AcidDrop
	(properties
		x 189
		tarY 77
	)
)

(instance drop9 of AcidDrop
	(properties
		x 196
		tarY 69
	)
)

(instance egoHitByAcidDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(= cycles 1)
			)
			(1
				(gSoundEffects number: 430 loop: 1 play:)
				(gLongSong2 number: 455 loop: 1 play:)
				(gEgo
					view: 22
					setLoop: (if (OneOf (gEgo loop:) 1 5 7) 8 else 7)
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(= seconds 5)
			)
			(3
				(Print 32 51 #at 50 100) ; "You are unpleasantly surprised by a drop of searing acid which bores its way to your feet."
				(= cycles 3)
			)
			(4
				(EgoDead 938 0 0 32 52) ; "Now, that's some seriously deep pain."
			)
		)
	)
)

(instance drop1Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop2Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop3Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop4Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop5Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop6Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop7Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop8Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance drop9Falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 60))
			)
			(1
				(if (< (client tarY:) 73)
					(client ctrlColor: 4)
				)
				(client
					show:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (client x:) 20 self
				)
			)
			(2
				(client setMotion: MoveTo (client x:) (client tarY:) self)
				(if (> (client tarY:) 72)
					(client setPri: 12)
				)
			)
			(3
				(if (not local4)
					(dripSound
						number: (Random 397 399)
						loop: 1
						play: (if (== global166 1) 127 else 50)
					)
				)
				(client setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(client hide: y: 0 setPri: 1)
				(= cycles 3)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance egoTasteAcid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== global166 1)
						(Print {You can't do that from here.})
						(self dispose:)
					)
					((& (gEgo onControl: 0) $2000)
						(HandsOff)
						(gEgo setMotion: PolyPath 170 153 self)
					)
					(else
						(Print {You can't do that from here.})
					)
				)
			)
			(1
				(gEgo view: 22 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(helmet init:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(switch register
					(1
						(Print 32 53 #at 50 10) ; "You lean over to drink from the tempting pool of liquid. As your lips touch the fluid, you feel a pain which could be likened to kissing a lit rocket nozzle. Now you know what they mean when they say 'Don't drink the water.'"
					)
					(2
						(Print 32 54 #at 50 10) ; "You lean over the pool to get a good solid whiff, and WHOOA! Talk about clean sinuses!"
					)
				)
				(= cycles 9)
			)
			(4
				(gSoundEffects number: 430 loop: 0 play:)
				(gEgo setLoop: 2 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(5
				(gEgo setLoop: 11 cel: 0 setCycle: Osc 1 self)
			)
			(6
				(gEgo setLoop: 12 cel: 0 setCycle: End self)
			)
			(7
				(EgoDead 938 0 0 32 55) ; "That's right. You have no head. That darn pool must be filled with acid. You obviously can't go on living that way."
			)
		)
	)
)

