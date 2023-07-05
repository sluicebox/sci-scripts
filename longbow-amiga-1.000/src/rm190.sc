;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm190 0
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
	[local8 4] = [1190 39 1 0]
	[local12 4] = [1190 29 1 0]
	[local16 4] = [1190 30 1 0]
	[local20 4] = [1190 0 1 0]
	[local24 5] = [1190 1 1 1 0]
	[local29 6] = [1190 3 1 2 2 0]
	[local35 10] = [1190 6 2 1 2 1 3 2 1 0]
	[local45 14] = [1190 13 1 2 2 2 1 2 2 1 3 1 2 0]
	[local59 6] = [1190 24 2 1 2 0]
	[local65 10] = [1190 43 1 2 0 1190 32 1 1 0]
	[local75 4] = [1190 31 1 0]
	[local79 3] = [-1 {Simon} 6]
)

(procedure (localproc_0)
	(SetMessageColor 6)
	(Say &rest 80 {Simon})
)

(procedure (localproc_1)
	(cond
		((> (= local1 (Random 0 100)) 80)
			(= local0 (/ 120 global125))
		)
		((> local1 60)
			(= local0 (/ 160 global125))
		)
		((> local1 40)
			(= local0 (/ 200 global125))
		)
		((> local1 20)
			(= local0 (/ 240 global125))
		)
		(else
			(= local0 (/ 280 global125))
		)
	)
)

(procedure (localproc_2)
	(if (== global125 2)
		(= local2 (Random 6 8))
	else
		(= local2 (Random 4 7))
	)
	(cond
		((<= local2 5)
			(= local3 10)
		)
		((<= local2 7)
			(= local3 20)
		)
		((= local2 8)
			(= local3 70)
		)
	)
	(windFlags init:)
)

(instance rm190 of Rm
	(properties
		picture 190
		style 100
		horizon 145
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(HandsOff)
		(gAddToPics
			add: flagTree garland1 garland2 garland3
			eachElementDo: #init
			doit:
		)
		(localproc_1)
		(localproc_2)
		(gSFX number: 12 loop: -1 play:)
		(cond
			((and (== gPrevRoomNum 200) (not (IsFlag 43))) ; povGladeArchery
				(ClearFlag 43)
				(= local5 1)
			)
			((and (IsFlag 46) (== gPrevRoomNum 220)) ; forest
				(SetFlag 46)
				(ClearFlag 43)
				(= local5 1)
			)
			((and (IsFlag 73) (== gPrevRoomNum 220)) ; forest
				(ClearFlag 43)
				(= local5 1)
			)
			((== gDay 1)
				(if (or (not (IsFlag 46)) (and (IsFlag 46) (== gPrevRoomNum 200))) ; povGladeArchery
					(SetFlag 46)
					(SetFlag 43)
					((ScriptID 20) ; Will
						view: 160
						loop: 1
						posn: 235 183
						actions: willDoVerb
						init:
						stopUpd:
					)
					(anOutlaw approachVerbs: 5 3 4 init: ignoreActors: stopUpd:) ; Talk, Do, Inventory
				)
			)
			((and (not (== gDay 1)) (not (== gDay 7)))
				(= local5 1)
				(ClearFlag 43)
			)
		)
		(cond
			((== gEgoEdgeHit 4)
				(= local6 148)
				(= local7 165)
			)
			((== gEgoEdgeHit 2)
				(= local6 193)
				(= local7 175)
			)
			((IsFlag 43)
				(= local6 193)
				(= local7 175)
			)
			(else
				(= local6 148)
				(= local7 165)
			)
		)
		(cond
			((== gPrevRoomNum 220) ; forest
				(= temp0
					(switch gEgoEdgeHit
						(3 109)
						(1 175)
						(4 330)
						(2 -10)
					)
				)
				(= temp1
					(switch gEgoEdgeHit
						(3 142)
						(1 235)
						(4 154)
						(2 150)
					)
				)
			)
			((== gPrevRoomNum 200) ; povGladeArchery
				(= temp0 128)
				(= temp1 163)
				(= local6 148)
				(= local7 165)
			)
			(else
				(= temp0 330)
				(= temp1 154)
				(= local6 148)
				(= local7 165)
			)
		)
		(NormalEgo)
		(gEgo
			posn: temp0 temp1
			init:
			actions: egoShootingDoVerb
			setScript: imHere
		)
		(if (IsFlag 1)
			(ClearFlag 1)
			(= gForestRoomNum 42)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 -1 319 0 319 1 319 80 185 67 86 88 88 124 92 136 102 140 106 142 110 145 112 146 95 151 100 164 87 167 72 161 57 157 50 154 27 149 48 133 52 96 0 73 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 96 88 319 93 319 122 316 122 315 153 193 153 180 153 93 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 20 154 61 163 83 171 83 183 68 189 50 189 19 189 0 189 0 159
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 268 186 300 175 299 171 286 168 273 169 259 174 246 170 217 173 206 169 207 160 217 160 266 155 298 157 319 164 319 189 269 189
					yourself:
				)
		)
		(AddToFeatures rocks)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((gEgo edgeHit:)
				(if (and (== gDay 1) (IsFlag 45) (IsFlag 44))
					(HandsOff)
					(gCurRoom newRoom: 160)
				else
					(gCurRoom newRoom: 220) ; forest
				)
			)
			((not (-- local0))
				(localproc_2)
				(localproc_1)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1190 41 1) ; "To this green glade we come to practice our archery."
			)
			(10 ; Longbow
				(if (== global125 1)
					(Say 1190 42 1) ; "Sooth, I've no need for practice. One cannot improve upon perfection."
				else
					(gCurRoom newRoom: 200) ; povGladeArchery
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSFX fade: 0 20 12 1)
		(super dispose:)
	)
)

(instance garland1 of PicView
	(properties
		x 78
		y 129
		view 200
		loop 2
		priority 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 43)
					(if (not (IsFlag 77))
						(gCurRoom setScript: firstAboutGarland)
					else
						(gCurRoom setScript: garlandRepeatMsg)
					)
				else
					(Say 1190 37 1) ; "The garland is fixed well in place. I'd sooner leave it alone than have Will Scarlet scold me for moving it!"
				)
			)
			(2 ; Look
				(Say 1190 40 1) ; "The garland fastened to the tree is my target. No man is admitted to my band unless he can place an arrow within its center without touching a single leaf of the garland."
			)
			(10 ; Longbow
				(if (== global125 1)
					(Say 1190 42 1) ; "Sooth, I've no need for practice. One cannot improve upon perfection."
				else
					(gCurRoom newRoom: 200) ; povGladeArchery
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garland2 of PicView
	(properties
		x 39
		y 130
		view 200
		loop 2
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1190 40 1) ; "The garland fastened to the tree is my target. No man is admitted to my band unless he can place an arrow within its center without touching a single leaf of the garland."
			)
			(3 ; Do
				(if (IsFlag 43)
					(if (not (IsFlag 77))
						(gCurRoom setScript: firstAboutGarland)
					else
						(gCurRoom setScript: garlandRepeatMsg)
					)
				else
					(Say 1190 37 1) ; "The garland is fixed well in place. I'd sooner leave it alone than have Will Scarlet scold me for moving it!"
				)
			)
			(10 ; Longbow
				(if (== global125 1)
					(Say 1190 42 1) ; "Sooth, I've no need for practice. One cannot improve upon perfection."
				else
					(gCurRoom newRoom: 200) ; povGladeArchery
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garland3 of PicView
	(properties
		x 96
		y 131
		view 200
		loop 2
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1190 40 1) ; "The garland fastened to the tree is my target. No man is admitted to my band unless he can place an arrow within its center without touching a single leaf of the garland."
			)
			(10 ; Longbow
				(if (== global125 1)
					(Say 1190 42 1) ; "Sooth, I've no need for practice. One cannot improve upon perfection."
				else
					(gCurRoom newRoom: 200) ; povGladeArchery
				)
			)
			(3 ; Do
				(if (IsFlag 43)
					(if (not (IsFlag 77))
						(gCurRoom setScript: firstAboutGarland)
					else
						(gCurRoom setScript: garlandRepeatMsg)
					)
				else
					(Say 1190 37 1) ; "The garland is fixed well in place. I'd sooner leave it alone than have Will Scarlet scold me for moving it!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windFlags of Prop
	(properties
		x 23
		y 101
		view 200
	)

	(method (init)
		(super init:)
		(self setLoop: local2 setPri: 12 setCycle: Fwd cycleSpeed: local3)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1190 46 1) ; "The bit of cloth tied to the tree tells how strongly the wind blows, and from which direction."
			)
			(3 ; Do
				(Say 1190 50 1) ; "The pennant is important for gauging the wind. My men would be most cross with me if I took it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flagTree of View
	(properties
		x 21
		y 159
		view 200
		loop 1
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1190 46 1) ; "The bit of cloth tied to the tree tells how strongly the wind blows, and from which direction."
			)
			(3 ; Do
				(Say 1190 50 1) ; "The pennant is important for gauging the wind. My men would be most cross with me if I took it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rocks of Feature
	(properties
		y 157
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 2 182 3 157 24 163 27 160 32 159 51 168 61 166 66 170 55 174 43 176 39 177 38 181 27 181 21 183
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1190 47 1) ; "I should take care not to ruin arrow by firing upon a rock."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance anOutlaw of Prop
	(properties
		x 260
		y 168
		approachX 211
		approachY 174
		view 200
		cel 1
		signal 16641
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo setScript: lookAtSimon)
			)
			(3 ; Do
				(localproc_0 1190 34 self) ; "'T-tis a great pleasure to meet you, sir."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(cond
					((not (IsFlag 78))
						(gCurRoom setScript: outlawFirstTalk)
					)
					((not (IsFlag 41))
						(localproc_0 1190 35 self) ; "I would dearly love to see you shoot, sir."
						(SetMessageColor 0)
					)
					(else
						(gCurRoom setScript: repeateClickTalk)
					)
				)
			)
			(10 ; Longbow
				(Say 1190 51 1) ; "Shoot my own man? That would be madness."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(localproc_0 1190 36 self) ; "I c-couldn't touch your horn, sir."
						(SetMessageColor 0)
					)
					(0 ; bucks
						(if (> (gMoney doit:) 0)
							(if (not (IsFlag 87))
								(gCurRoom setScript: giveSimonMoney)
							else
								(localproc_0 1190 45 self) ; "Thank you very much, sir."
								(SetMessageColor 0)
							)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance heDidNotFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(Converse 1 @local20 14 0 self) ; "Can it be? Has the famous Robin Hood at last wearied of the bow?"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firstConvDay1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 72)
				(= cycles 1)
			)
			(1
				(Converse 1 @local24 14 0 self) ; "Halloa, Master Hood! A glorious day for the bow."
			)
			(2
				(if (and (IsFlag 75) (not (SetFlag 216)))
					(Converse 2 @local29 999 0 14 1 self) ; "Will, the woman that was killed on Watling Street...."
				else
					(= cycles 1)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firstAboutGarland of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(Converse 3 @local35 999 0 14 3 @local79 1 self) ; "Nay, leave the garland where it is. There are two more set on further trees, if you need more of a challenge."
			)
			(2
				(HandsOn)
				(SetFlag 77)
				(self dispose:)
			)
		)
	)
)

(instance outlawFirstTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(Converse 3 @local45 999 0 @local79 1 14 3 self) ; "Tell me what brings you to the forest, young Simon."
			)
			(2
				(HandsOn)
				(SetFlag 78)
				(self dispose:)
			)
		)
	)
)

(instance repeateClickTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(Converse 2 @local65 999 0 @local79 1 self) ; "You see now the value of practice."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveSimonMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(Converse 2 @local59 999 0 @local79 2 self) ; "B-but I...nay, I don't deserve..."
			)
			(2
				(SetScore 10 87)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtSimon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1190 32 self) ; "He watches me with awe and a bit of fear, a look I've often seen on men new to our band."
			)
			(1
				(Say 1190 33 self) ; "He'll realize soon enough, I hope, that I'm only a man like other men....save perhaps that I shoot better than most."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance garlandRepeatMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 6)
			)
			(1
				(Converse 1 @local12 14 0 self) ; "Leave it be, Robin! You're as fussy as a mother hen."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance imHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath local6 local7 self)
			)
			(1
				(if (IsFlag 43)
					(gEgo setHeading: 90 self)
				else
					(self cue:)
				)
			)
			(2
				(NormalEgo)
				(= ticks 30)
			)
			(3
				(cond
					(
						(and
							(== gPrevRoomNum 200) ; povGladeArchery
							(== gDay 1)
							(== local5 0)
							(IsFlag 43)
							(not (IsFlag 41))
						)
						(gEgo setScript: heDidNotFire)
					)
					((== gDay 1)
						(if (not (IsFlag 72))
							(SetFlag 72)
							(gEgo setScript: firstConvDay1)
						else
							(self cue:)
						)
					)
					(else
						(self cue:)
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

(instance willDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2 ; Look
					(Say 1190 38 1) ; "He's a good man, Will is."
				)
				(3 ; Do
					(Converse 1 @local8 14 0) ; "You know I'll gladly give you bow or arrows if you need them, but I see you've no need for them."
				)
				(5 ; Talk
					(if (== gPrevRoomNum 200) ; povGladeArchery
						(Converse 1 @local75 14 0) ; "Keep shooting if you like. We've finished our practicing for the day."
					else
						(Converse 1 @local16 14 0) ; "'Tis a fine day for shooting."
						1
					)
				)
				(10 ; Longbow
					(Say 1190 51 1) ; "Shoot my own man? That would be madness."
				)
			)
		)
	)
)

(instance egoShootingDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(if (== invItem 1) ; horn
					(if (IsFlag 43)
						(Say 1190 48 1) ; "Will would think me mad if I winded my horn now."
					else
						(Say 1190 49 1) ; "There's no need to call my men for practice. They're free to do so when they choose."
					)
				)
			)
		)
	)
)

