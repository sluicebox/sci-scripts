;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm321 0
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
	local9
	local10
	local11
	local12
	local13
)

(instance rm321 of Rm
	(properties
		noun 15
		picture 321
		style 3
	)

	(method (dispose)
		(ClearFlag 193)
		(SetFlag 95)
		(DisposeScript 964)
		(DisposeScript 942)
		(= global275 26)
		(super dispose:)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 302 189 226 155 227 143 202 142 191 137 136 142 129 151 81 155 76 169 50 170 25 102 102 52 190 52 190 50 101 50 20 102 44 170 3 173 3 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 221 175 169 185 147 177 151 160 195 151 220 158
					yourself:
				)
		)
		(LoadMany rsSCRIPT 969 964)
		(LoadMany rsVIEW 321 602 601 525 507 503)
		(LoadMany rsSOUND 8 13 2083 52 2035)
		(super init:)
		(SolvePuzzle 630 5 2)
		(onDesk init: setOnMeCheck: 26505)
		(onPlant init: setOnMeCheck: 26505)
		(onChair init: setOnMeCheck: 26505)
		(gryphonHead init: setOnMeCheck: 26505)
		(firePicture init: setOnMeCheck: 26505)
		(stairsPicture init: setOnMeCheck: 26505)
		(onSafe init: setOnMeCheck: 1 8)
		(self setRegions: 801) ; Town
		(sneakMusic init:)
		(tumbleMusic init:)
		(miscMusic init:)
		(= global275 52)
		(if (IsFlag 184)
			(= local6 1)
		)
		(if (IsFlag 183)
			(= local5 1)
			(safeDoor cel: (if (IsFlag 184) 1 else 0) init: stopUpd:)
		)
		(if (IsFlag 179)
			(= local4 1)
		)
		(NormalEgo)
		(gEgo
			posn: 163 188
			illegalBits: -30720
			init:
			setScript: comeOnInScript
		)
		(fireStone init: setCycle: Fwd)
		(fireBurns init: setCycle: Fwd)
		(chairBurns init: ignoreActors: setCycle: Fwd)
		(chestDrawer init: stopUpd:)
		(leftDoor ignoreActors: init: stopUpd:)
		(rightDoor ignoreActors: init: stopUpd:)
		(bottomDoor ignoreActors: init: stopUpd:)
		(if (not (IsFlag 179))
			(theVase
				illegalBits: 0
				ignoreActors:
				posn:
					(if (IsFlag 180) 224 else 228)
					(if (IsFlag 180) 150 else 120)
				setPri: 10
				init:
				stopUpd:
			)
		)
		(portrait
			posn:
				(if (not (IsFlag 183)) 229 else 238)
				(if (not (IsFlag 183)) 104 else 88)
			init:
			stopUpd:
		)
		(if (not (IsFlag 181))
			(candelabra setPri: 9 init: stopUpd:)
		)
		(if (not (IsFlag 182))
			(musicBox init: stopUpd:)
		)
		(sneakMusic play:)
	)

	(method (cue)
		(switch local10
			(1
				(gMessager say: 15 0 0 2) ; "The room smells vaguely of sauerkraut and bratwurst, with just a faint odor of smoke from pinewood. From somewhere in the house you can hear someone snoring."
			)
			(2
				(gMessager say: 15 0 0 5) ; "Boy, did YOU make a mistake!"
			)
			(3
				(gMessager say: 15 0 0 15) ; "SCREEEEEEEEEEEECH!"
			)
		)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((and (== (gEgo edgeHit:) 3) (not (IsFlag 193)))
				(if gNight
					(= global107 gDay)
					(gCurRoom newRoom: 320)
				else
					(EgoDead 20 21 4 0 602) ; "Otto and the Sheriff rise with the dawn, and find you in their house. Be a little more intelligent (and a lot faster) if you ever try something like this again."
				)
			)
			(
				(and
					(gEgo inRect: 26 165 69 168)
					(not local3)
					(not (IsFlag 196))
					(or (== (gEgo loop:) 7) (== (gEgo loop:) 3))
				)
				(= local3 1)
				(gEgo setScript: upScript)
			)
			(
				(and
					local3
					(gEgo inRect: 92 48 121 55)
					(not (IsFlag 196))
					(or (== (gEgo loop:) 5) (== (gEgo loop:) 1))
				)
				(= local3 0)
				(gEgo setScript: downScript)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(gCurRoom setScript: bustedScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onOpenSafe of Feature
	(properties
		x 229
		y 158
		noun 12
		nsTop 86
		nsLeft 224
		nsBottom 100
		nsRight 237
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((not local6)
						(gMessager say: 12 1 4) ; "It looks very sturdy, indeed."
					)
					((IsFlag 145)
						(gMessager say: 12 1 5) ; "There is an empty coin bag in the safe."
					)
					(else
						(gMessager say: 12 1 3) ; "Inside the safe is a bag of coins containing 50 silvers."
					)
				)
			)
			(4 ; Do
				(gEgo setScript: toTheSafe)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onDesk of Feature
	(properties
		x 81
		y 134
		noun 10
		nsTop 122
		nsLeft 65
		nsBottom 146
		nsRight 98
		approachX 89
		approachY 157
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 144)
					(gMessager say: 10 1 2) ; "You've looked in there already."
				else
					(gMessager say: 10 1 1) ; "Looks like solid oak."
				)
			)
			(4 ; Do
				(gEgo setScript: toTheDesk)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onSafe of Feature
	(properties
		x 229
		y 158
		z 40
		noun 12
		nsTop 87
		nsLeft 224
		nsBottom 101
		nsRight 235
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((not local6)
						(gMessager say: 12 1 4) ; "It looks very sturdy, indeed."
					)
					((IsFlag 145)
						(gMessager say: 12 1 5) ; "There is an empty coin bag in the safe."
					)
					(else
						(gMessager say: 12 1 3) ; "Inside the safe is a bag of coins containing 50 silvers."
					)
				)
			)
			(4 ; Do
				(gEgo setScript: toTheSafe)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onPlant of Feature
	(properties
		x 11
		y 166
		noun 11
		nsTop 147
		nsBottom 186
		nsRight 22
	)
)

(instance onChair of Feature
	(properties
		x 173
		y 157
		noun 9
		nsTop 140
		nsLeft 161
		nsBottom 174
		nsRight 185
	)
)

(instance onTable of Feature
	(properties
		x 197
		y 161
		noun 13
		nsTop 154
		nsLeft 185
		nsBottom 169
		nsRight 210
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 182)
					(gMessager say: 13 1 6) ; "A solid looking table."
				else
					(gMessager say: 13 1 7) ; "There is an ornately carved box sitting atop the oak table."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gryphonHead of Feature
	(properties
		x 272
		y 161
		z 86
		noun 7
		nsTop 56
		nsLeft 251
		nsBottom 95
		nsRight 294
	)
)

(instance firePicture of Feature
	(properties
		x 284
		y 167
		z 136
		noun 5
		nsLeft 251
		nsBottom 62
		nsRight 318
	)
)

(instance stairsPicture of Feature
	(properties
		x 37
		y 21
		noun 17
		nsBottom 42
		nsRight 74
	)
)

(instance portrait of View
	(properties
		noun 14
		approachX 219
		approachY 145
		view 321
		loop 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setScript: toThePortrait)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance candelabra of View
	(properties
		x 81
		y 125
		noun 1
		approachX 81
		approachY 130
		view 321
		loop 4
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: toTheCandelabra)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance musicBox of View
	(properties
		x 198
		y 158
		noun 8
		approachX 207
		approachY 174
		view 321
		loop 4
		cel 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: toTheBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safeDoor of Prop
	(properties
		x 224
		y 88
		noun 16
		view 321
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((not local6)
						(gMessager say: 16 1 4) ; "It looks very sturdy, indeed."
					)
					((IsFlag 145)
						(gMessager say: 16 1 5) ; "There is an empty coin bag in the safe."
					)
					(else
						(gMessager say: 16 1 12) ; "You see a bag full of silver coins."
					)
				)
			)
			(4 ; Do
				(gEgo setScript: toTheSafe)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireBurns of Prop
	(properties
		x 272
		y 160
		noun 4
		view 321
		loop 8
		signal 16384
		detailLevel 2
	)
)

(instance chairBurns of Prop
	(properties
		x 172
		y 179
		noun 2
		view 321
		loop 10
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance fireStone of Prop
	(properties
		x 261
		y 168
		noun 6
		view 321
		loop 9
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance egoHead of Prop
	(properties)
)

(instance chestDrawer of Prop
	(properties
		x 72
		y 130
		noun 3
		approachX 89
		approachY 157
		view 321
		loop 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 144)
					(gMessager say: 3 1 2) ; "You've looked in there already."
				else
					(gMessager say: 3 1 1) ; "Looks like solid oak."
				)
			)
			(4 ; Do
				(gEgo setScript: toTheDesk)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftDoor of Prop
	(properties
		x 102
		y 47
		view 321
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local9 1)
				(gEgo setScript: toTheLeftDoor)
			)
			(4 ; Do
				(gEgo setScript: toTheLeftDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 148
		y 47
		approachX 154
		approachY 50
		view 321
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local9 1)
				(gEgo setScript: toTheRightDoor)
			)
			(4 ; Do
				(gEgo setScript: toTheRightDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bottomDoor of Prop
	(properties
		x 146
		y 132
		approachX 148
		approachY 140
		view 321
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local9 1)
				(gMessager say: 15 0 0 23 self) ; "Someone (or someTHING) is snoring up a storm. You hear: "Nkaawww... rspft... honk... buh-buh-buh-buh-buh-buh-phweep.""
				(= local9 0)
			)
			(4 ; Do
				(gEgo setScript: toTheBottomDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stars of Prop
	(properties)
)

(instance pillow of Prop
	(properties)
)

(instance otto of Actor
	(properties)
)

(instance sheriff of Actor
	(properties)
)

(instance theVase of Actor
	(properties
		z 10
		noun 18
		approachX 219
		approachY 145
		view 321
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: toTheVase)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gerta of Actor
	(properties)
)

(instance comeOnInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor)
				(gEgo setMotion: PolyPath 163 169 self)
			)
			(1
				(if (and (!= gPrevRoomNum 0) (not (IsFlag 95)))
					(= cycles 8)
				else
					(HandsOn)
					(gEgo setScript: 0)
				)
			)
			(2
				(= local10 1)
				(gMessager say: 15 0 0 1 gCurRoom) ; "The people who own this house must have some money. Everything looks new and there is not a speck of dust visible."
				(= seconds 3)
			)
			(3
				(HandsOn)
				(gEgo setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance faceTheMusicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 193)
				(gMessager say: 15 0 0 3 self) ; "Gently and stealthily, you lift the lid on the little box."
			)
			(1
				(musicBox setCel: 3)
				(SetFlag 194)
				(miscMusic loop: 1 number: 13 play:)
				(otto
					view: 602
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: Walk
					stopUpd:
				)
				(= local10 2)
				(gMessager say: 15 0 0 4 gCurRoom) ; "As the little music box begins to play, you hear the Sheriff yell out: "Otto, stop playing with that music box and GO TO BED!""
				(= seconds 3)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10))
				(bottomDoor setCycle: End self)
			)
			(3
				(gEgo setHeading: 0)
				(otto setLoop: 1 cel: 1 posn: 178 120 setPri: 8)
				(self cue:)
			)
			(4
				(gEgo loop: 1)
				(otto setMotion: MoveTo 191 154 self)
			)
			(5
				(otto setLoop: 5 cel: 0 setCycle: Fwd)
				(= cycles 20)
			)
			(6
				(cond
					((gEgo has: 33) ; musicBox
						(gMessager say: 15 0 6) ; "Otto can't find the music box, but he's too dim and sleepy to figure it out, so he heads on back to bed"
					)
					((IsFlag 194)
						(miscMusic stop:)
						(gCurRoom setScript: unknown_321_30)
						(musicBox setCel: 2 forceUpd:)
						(ClearFlag 194)
					)
					(else
						(gMessager say: 15 0 9) ; "Otto stares sleepily at the closed music box for a moment and heads back to bed."
					)
				)
				(otto setLoop: 2 setCycle: Walk setMotion: MoveTo 178 136 self)
			)
			(7
				(otto dispose:)
				(bottomDoor setCycle: Beg self)
				(gEgo setMotion: MoveTo 217 179 self)
			)
			(8 0)
			(9
				(gMessager say: 15 0 0 6) ; "That was close! The goon must've been so dumb or sleepy or both that he didn't even see you standing there."
				(ClearFlag 193)
				(bottomDoor stopUpd:)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
			(10
				(sneakMusic stop:)
				(EgoDead 88 89 1 0 503) ; "Obviously, getting in the goon's way was not one of your brighter ideas. You've had it now!"
			)
		)
	)
)

(instance unknown_321_30 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 15 0 8 1 self) ; "Otto, even in his sleepy state, winds the music box and closes the lid before he heads back to bed."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance vaseDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 15 0 0 7 self) ; "You take the vase carefully from the mantle and place it gently on the floor."
			)
			(1
				(SetFlag 180)
				(= local4 1)
				(theVase posn: 224 150)
				(self cue:)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance vaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LoadMany rsSOUND 2014)
				(gMessager say: 15 0 0 8) ; "As you reach toward the painting..."
				(theVase startUpd: setCycle: End self)
			)
			(1
				(self cue:)
			)
			(2
				(theVase
					setLoop: 6
					setCel: 0
					posn: 228 125
					setStep: 0 8
					setMotion: MoveTo 223 148 self
				)
			)
			(3
				(miscMusic loop: 1 number: 2014 play:)
				(theVase setCycle: End self)
			)
			(4
				(theVase setCel: 5 stopUpd:)
				(HandsOn)
				(= cycles 2)
			)
			(5
				(gMessager say: 15 0 0 9 self) ; "From somewhere upstairs, you hear the Sheriff shout: "Otto!""
			)
			(6
				(gEgo setScript: bustedScript)
			)
		)
	)
)

(instance bustedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(User canInput: 0)
				(LoadMany rsSOUND 2015)
				(otto
					view: 602
					setLoop: 1
					cel: 1
					posn: 170 131
					illegalBits: 0
					ignoreActors:
					setCycle: Walk
					setPri: 8
					init:
				)
				(sheriff
					view: 601
					illegalBits: 0
					ignoreActors:
					setLoop: 2
					cel: 0
					posn: 117 48
					setCycle: Walk
					init:
				)
				(bottomDoor
					loop: 7
					cel: 0
					posn: 146 133
					setPri: 9
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(miscMusic loop: 1 number: 2015 play:)
				(otto setPri: 10 setMotion: MoveTo 191 154 self)
				(leftDoor setCycle: End)
			)
			(2
				(sheriff setMotion: MoveTo 115 50 self)
			)
			(3
				(cond
					((> local13 2)
						(EgoDead 19 22 4 0 602) ; "Now you've done it! It's hard to be a hero when you're locked up for breaking and entering (or entering and breaking, as the case may be). Be a little more intelligent (and a lot quieter) if you ever try something like this again."
					)
					((== local1 2)
						(sneakMusic stop:)
						(EgoDead 145 146 1 0 503) ; "Naughty, naughty. The Sheriff and Otto arrive on the scene and arrest you for "blatant power-gaming". You have to *work* at it to become a *real* hero!"
					)
					(else
						(sneakMusic stop:)
						(gMessager say: 15 0 0 10 self) ; "Obviously, you shouldn't have done that!"
					)
				)
			)
			(4
				(= seconds 1)
			)
			(5
				(EgoDead 19 22 4 0 602) ; "Now you've done it! It's hard to be a hero when you're locked up for breaking and entering (or entering and breaking, as the case may be). Be a little more intelligent (and a lot quieter) if you ever try something like this again."
			)
		)
	)
)

(instance openSafeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 145))
					(gEgo get: 0 50) ; silver
				)
				(HandsOff)
				(miscMusic number: 2035 loop: 1 play:)
				(if (not (IsFlag 184))
					(safeDoor setCycle: End self)
				else
					(= seconds 2)
				)
			)
			(1
				(SolvePuzzle 633 1 2)
				(if (not (IsFlag 184))
					(++ local1)
					(onOpenSafe init:)
					(gMessager say: 15 0 0 24 self) ; "Ah, got it!"
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(if (IsFlag 145)
					(gMessager say: 15 0 5 1 self) ; "There is an empty coin bag in the safe."
				else
					(gMessager say: 15 0 11 1 self) ; "You see a bag of coins."
				)
			)
			(4
				(SetFlag 184)
				(= local6 1)
				(= ticks 30)
			)
			(5
				(if (not (IsFlag 145))
					(SetFlag 145)
					(SolvePuzzle 634 1 2)
					(gMessager say: 15 0 4 1 self) ; "You find fifty silvers and add them to your collection. You then put the empty bag back in the safe."
				else
					(self cue:)
				)
			)
			(6
				(HandsOn)
				(gEgo cycleSpeed: local12 moveSpeed: local11)
				(self dispose:)
			)
		)
	)
)

(instance raisePainting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(safeDoor cel: (if (IsFlag 184) 1 else 0) init: stopUpd:)
				(portrait posn: 238 88)
				(SetFlag 183)
				(= cycles 2)
			)
			(1
				(gMessager say: 15 0 0 11 self) ; "By lifting the painting, you can see what certainly must be a safe, hidden in the wall."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance robDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: 0 3) ; silver
				(HandsOff)
				(chestDrawer setCycle: End self)
			)
			(1
				(SetFlag 144)
				(gMessager say: 15 0 0 12 self) ; "In the desk drawers is an assortment of mostly worthless objects, but you also find three silvers, which you take."
			)
			(2
				(SolvePuzzle 631 1 2)
				(chestDrawer setCycle: Beg self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lowerPainting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(portrait posn: 229 104)
				(ClearFlag 183)
				(= cycles 2)
			)
			(1
				(gMessager say: 15 0 0 13 self) ; "You carefully lower the painting into its original position."
			)
			(2
				(HandsOn)
				(safeDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bottomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(= cycles 1)
			)
			(1
				(otto
					view: 602
					init:
					setLoop: 1
					setCel: 5
					posn: 165 126
					setCycle: Walk
					hide:
				)
				(gEgo setMotion: MoveTo 186 140 self)
			)
			(2
				(bottomDoor setCycle: End self)
			)
			(3
				(otto illegalBits: 0 ignoreActors: show:)
				(= cycles 1)
			)
			(4
				(gEgo
					setLoop: 3
					setCycle: Rev
					setMotion: MoveTo 196 142 self
				)
			)
			(5
				(gEgo setCycle: 0 setHeading: 270)
				(NormalEgo)
				(= ticks 30)
			)
			(6
				(otto setMotion: MoveTo 181 134 self)
			)
			(7
				(= ticks 60)
			)
			(8
				(sneakMusic stop:)
				(EgoDead 98 99 4 0 602) ; "It's hard to be a hero when you're sitting in a jail cell. The Sheriff apologized for your broken arm, but he did warn you (didn't he?) that Otto was only partly trained. Now, you'll probably be more careful when you're robbing someone."
			)
		)
	)
)

(instance leftScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(self cue:)
			)
			(1
				(gEgo setMotion: MoveTo 125 50 self)
			)
			(2
				(sheriff
					view: 601
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: Walk
					stopUpd:
				)
				(leftDoor setCycle: End self)
			)
			(3
				(sheriff
					setLoop: 2
					cel: 0
					posn: 114 45
					setMotion: MoveTo 131 45
				)
				(gEgo setLoop: 3 setMotion: MoveTo 132 49 self)
			)
			(4
				(gEgo setHeading: 0)
				(= ticks 30)
			)
			(5
				(SetFlag 196)
				(gEgo
					view: 525
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 111 53 self
				)
			)
			(6
				(NormalEgo)
				(tumbleMusic play:)
				(gEgo
					view: 507
					setCycle: Fwd
					yStep: 12
					xStep: 9
					illegalBits: 0
					ignoreActors:
					setLoop: 0
					setMotion: DPath 90 51 64 71 27 93 self
				)
			)
			(7
				(tumbleMusic stop:)
				(self cue:)
			)
			(8
				(tumbleMusic play:)
				(gEgo
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: DPath 27 97 36 121 44 146 self
				)
			)
			(9
				(sheriff setLoop: 2)
				(gEgo
					view: 507
					setLoop: 2
					setCel: 0
					setCycle: 0
					setMotion: 0
					posn: 52 183
				)
				(egoHead view: 507 setLoop: 3 setCel: 0 posn: 51 156 init:)
				(stars
					view: 507
					setLoop: 4
					setCel: 0
					posn: 48 159
					init:
					setCycle: Fwd
				)
				(tumbleMusic stop:)
				(= cycles 20)
			)
			(10
				(EgoDead 130 131 1 0 503) ; "When it comes to breaking in, it looks like the only thing broken is your head! When at last you come to your senses, you find yourself in a jail cell. By the time you get out of here, you'll be too old to be a hero."
			)
		)
	)
)

(instance rightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 507)
				(LoadMany rsSOUND 2015)
				(self cue:)
			)
			(1
				(gEgo illegalBits: 0)
				(rightDoor setPri: 0 setCycle: End self)
			)
			(2
				(gEgo
					setPri: (+ (rightDoor priority:) 1)
					setMotion: MoveTo 175 40 self
				)
			)
			(3
				(= local10 3)
				(gMessager say: 15 0 0 14 gCurRoom) ; "Uh Oh! As you see a pillow flying toward you, you hear the Sheriff's wife say..."
				(pillow
					view: 602
					loop: 6
					cel: 0
					posn: 184 19
					init:
					setPri: 1
					setCycle: Fwd
					startUpd:
				)
				(sheriff
					view: 601
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: Walk
					stopUpd:
				)
				(= seconds 3)
			)
			(4
				(pillow dispose:)
				(leftDoor setCycle: End)
				(sheriff
					setLoop: 2
					cel: 0
					posn: 115 42
					setMotion: MoveTo 131 51
				)
				(gEgo
					setLoop: 3
					setPri: -1
					setCycle: Rev
					setMotion: MoveTo 175 53 self
				)
			)
			(5
				(leftDoor stopUpd:)
				(sheriff setLoop: 4 setCel: 0)
				(gEgo
					view: 525
					setLoop: 0
					setCel: 0
					posn: 163 53
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: End self
				)
			)
			(6
				(gEgo
					view: 507
					setCycle: 0
					setPri: 9
					setCel: 0
					setLoop: 1
					posn: 178 25
					cel: 0
					setStep: 4 14
					setCycle: CT 1 1 self
				)
			)
			(7
				(gEgo setPri: 10 setCycle: CT 2 1 self)
			)
			(8
				(sheriff setCycle: End)
				(gEgo setCycle: Fwd setMotion: MoveTo 175 125 self)
				(gerta
					view: 602
					setLoop: 3
					setCel: 0
					posn: 187 42
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: End
				)
			)
			(9
				(sheriff stopUpd:)
				(gerta stopUpd:)
				(rightDoor stopUpd:)
				(gEgo posn: 175 143 setLoop: 6 setCel: 0)
				(stars
					view: 507
					loop: 4
					cel: 0
					posn: 176 148
					init:
					setCycle: Fwd
					startUpd:
				)
				(= cycles 2)
			)
			(10
				(otto
					view: 602
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: Walk
					stopUpd:
				)
				(bottomDoor
					setLoop: 7
					cel: 0
					posn: 146 132
					setPri: 9
					cycleSpeed: 3
					setCycle: CT 2 1 self
				)
			)
			(11
				(miscMusic loop: 1 number: 2015 play:)
				(bottomDoor setCel: 2 setCycle: CT 4 1 self)
				(otto setLoop: 1 cel: 1 posn: 149 121)
			)
			(12
				(otto setMotion: MoveTo 161 132 self)
			)
			(13
				(otto setLoop: 5 setPri: 10 setCycle: Fwd)
				(= cycles 18)
			)
			(14
				(sneakMusic stop:)
				(EgoDead 134 135 6 0 507) ; "You never dreamed a feather pillow could be so HARD! Or was it the floor? You also didn't realize how hard it is for a thief to be a Hero. The Thief of Baghdad never had this kind of luck!"
			)
		)
	)
)

(instance upScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (gEgo priority:))
				(gEgo setPri: 2 setLoop: 3 setMotion: PolyPath 26 110 self)
			)
			(1
				(gEgo setLoop: 0 setMotion: PolyPath 155 53 self)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(gEgo setMotion: MoveTo 155 53 self)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance downScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: PolyPath 34 103 self)
			)
			(1
				(gEgo setMotion: PolyPath 46 166 self)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(gEgo setMotion: MoveTo 46 175 self)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(gEgo setPri: local0)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 89)
				(= local8 157)
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(if (IsFlag 144)
					(gMessager say: 15 0 0 16 self) ; "You've already robbed the desk."
				else
					(gEgo setScript: robDesk)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toThePortrait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 219)
				(= local8 145)
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(cond
					((not local4)
						(gEgo setScript: vaseScript)
					)
					((not (IsFlag 183))
						(SetFlag 183)
						(= local5 1)
						(SolvePuzzle 632 1 2)
						(gEgo setScript: raisePainting)
					)
					(local6
						(gMessager say: 15 0 0 17 self) ; "You'd better shut the safe, first."
					)
					(else
						(gEgo setScript: lowerPainting)
					)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and local6 (not (IsFlag 145)))
					(gEgo get: 0 50) ; silver
				)
				(HandsOff)
				(= local7 219)
				(= local8 145)
				(= local11 (gEgo moveSpeed:))
				(= local12 (gEgo cycleSpeed:))
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo cycleSpeed: 6 moveSpeed: 6)
				(= ticks 30)
			)
			(4
				(= local7 0)
				(= local8 0)
				(cond
					((== local1 2)
						(gEgo setScript: bustedScript)
					)
					((and (TrySkill 9 0 (- global175 20)) (not (IsFlag 184))) ; pick locks
						(gEgo setScript: openSafeDoor)
					)
					((and (IsFlag 145) (IsFlag 184))
						(safeDoor setCycle: Beg)
						(ClearFlag 184)
						(= local6 0)
						(onOpenSafe dispose:)
						(gMessager say: 15 0 5 2 self) ; "Since you have already robbed the safe, you close the door, narrowly missing your fingers in the process."
					)
					(local6
						(SetFlag 145)
						(SolvePuzzle 634 1 2)
						(gMessager say: 15 0 4 1 self) ; "You find fifty silvers and add them to your collection. You then put the empty bag back in the safe."
					)
					((> (++ local13) 2)
						(gCurRoom setScript: bustedScript)
					)
					(else
						(gMessager say: 15 0 10 1 self) ; "Cracking safes looked a lot easier in the instruction book."
					)
				)
			)
			(5
				(gEgo cycleSpeed: local12 moveSpeed: local11)
				(= seconds 2)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheVase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 219)
				(= local8 145)
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(if (IsFlag 180)
					(SetFlag 179)
					(= local4 1)
					(gMessager say: 15 0 0 18 self) ; "You place the vase carefully in your pack beneath your cape."
					(SolvePuzzle 635 1 2)
					(theVase dispose:)
				else
					(gEgo setScript: vaseDown)
				)
			)
			(4
				(HandsOn)
				(if (IsFlag 180)
					(gEgo get: 31) ; vase
				)
				(self dispose:)
			)
		)
	)
)

(instance toTheCandelabra of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 81)
				(= local8 130)
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(SetFlag 181)
				(candelabra dispose:)
				(gMessager say: 15 0 0 19 self) ; "You place the candelabra carefully in your pack beneath your cape."
				(SolvePuzzle 636 1 2)
			)
			(4
				(HandsOn)
				(gEgo get: 32) ; candelabra
				(self dispose:)
			)
		)
	)
)

(instance toTheBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 207)
				(= local8 174)
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(gEgo illegalBits: 0 ignoreActors: 1)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(if (IsFlag 182)
					(musicBox dispose:)
					(miscMusic stop:)
					(gMessager say: 15 0 0 20 self) ; "You quickly toss the box into your pack."
					(onTable init:)
					(SolvePuzzle 637 1 2)
				else
					(SetFlag 182)
					(gEgo setScript: faceTheMusicScript)
				)
			)
			(4
				(HandsOn)
				(if (IsFlag 182)
					(gEgo get: 33) ; musicBox
				)
				(self dispose:)
			)
		)
	)
)

(instance toTheLeftDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 125)
				(= local8 47)
				(if (< (gEgo y:) 55)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 41 170 self)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self cue:)
				else
					(self setScript: upScript self)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(if (== local9 1)
					(gMessager say: 15 0 0 21 self) ; "There is some fairly loud snoring going on in this room. You hear: "Brckawwwww... zup-zup-zup-zup-zzzzz.""
					(= local9 0)
				else
					(gEgo setScript: leftScript)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheRightDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 154)
				(= local8 47)
				(if (< (gEgo y:) 55)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 41 170 self)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self cue:)
				else
					(self setScript: upScript self)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(if (== local9 1)
					(gMessager say: 15 0 0 22 self) ; "Very faintly, you hear snoring: "Prrrrrt... prrrrrt... prrrrrt.""
					(= local9 0)
				else
					(gEgo setScript: rightScript)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheBottomDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 148)
				(= local8 140)
				(if (< (gEgo y:) 55)
					(gEgo setMotion: PolyPath 118 51 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo y:) 55)
					(self setScript: downScript self)
				else
					(self cue:)
				)
			)
			(2
				(if (> local7 0)
					(NormalEgo)
					(gEgo setMotion: PolyPath local7 local8 self)
				else
					(self cue:)
				)
			)
			(3
				(= local7 0)
				(= local8 0)
				(if (== local9 1)
					(gMessager say: 15 0 0 23 self) ; "Someone (or someTHING) is snoring up a storm. You hear: "Nkaawww... rspft... honk... buh-buh-buh-buh-buh-buh-phweep.""
					(= local9 0)
				else
					(gEgo setScript: bottomScript)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sneakMusic of Sound
	(properties
		number 8
		loop -1
	)
)

(instance miscMusic of Sound
	(properties
		number 13
		priority 1
	)
)

(instance tumbleMusic of Sound
	(properties
		number 2083
		priority 1
	)
)

