;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use Teller)
(use n026)
(use PolyPath)
(use Polygon)
(use Blk)
(use Feature)
(use Track)
(use LoadMany)
(use Wander)
(use Chase)
(use Orbit)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm770 0
)

(local
	local0
	local1
	local2
	[local3 5]
	[local8 8] = [0 5 6 7 -9 -8 -10 999]
	[local16 2]
	[local18 11] = [0 -21 -18 -32 -22 -27 -28 -26 -19 -20 999]
	[local29 2]
)

(procedure (localproc_0)
	(gLongSong3 number: 772 setLoop: -1 play: 127)
	(SetFlag 137)
	(cond
		((== global394 0)
			(++ global394)
			(guardian moveSpeed: 2 cycleSpeed: 2)
			(gEgo addHonor: -20)
		)
		((== global394 1)
			(++ global394)
			(guardian moveSpeed: 0 cycleSpeed: 0)
			(gEgo addHonor: -30)
		)
		((== global394 2)
			(gEgo setScript: willSpin)
		)
		((== global394 3)
			(guardian setScript: kickHimOut)
		)
	)
)

(instance rm770 of Rm
	(properties
		noun 10
		picture 770
		vanishingY -25
	)

	(method (init)
		(SetFlag 132)
		(= [local16 0] @local8)
		(= [local29 0] @local18)
		(LoadMany rsVIEW 6 771)
		(super init:)
		(gLongSong2 stop:)
		(gLongSong2 number: 914 setLoop: -1 play: 127)
		(gLongSong3 number: 771 setLoop: -1 play: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 110 189 319 189 319 106 241 98 220 115 134 119 39 119
					yourself:
				)
		)
		(mushrooms init:)
		(globes init:)
		(vines init:)
		(upperGlobes init:)
		(plant init:)
		(bigVine init:)
		(if (IsFlag 51)
			(gem1 init:)
			((= [local3 1] (gem1 new:))
				loop: 0
				cel: 1
				x: 174
				y: 137
				init:
				addToPic:
			)
			((= [local3 2] (gem1 new:))
				loop: 0
				cel: 0
				x: 168
				y: 144
				init:
				addToPic:
			)
			((= [local3 3] (gem1 new:))
				loop: 0
				cel: 0
				x: 149
				y: 140
				init:
				addToPic:
			)
			((= [local3 4] (gem1 new:))
				loop: 0
				cel: 1
				x: 159
				y: 143
				init:
				addToPic:
			)
		)
		(gEgo x: 304 y: 134 setScale: 189 init: noun: 4 normalize:)
		(guardian
			maxScale: 200
			moveSpeed: 4
			ignoreHorizon: 1
			observeBlocks: deCage
			init:
			setScript: guardianOrbits
		)
		(egoTell init: gEgo @local18 @local29)
		(cond
			((== global394 1)
				(guardian moveSpeed: 2 cycleSpeed: 2)
			)
			((== global394 2)
				(guardian moveSpeed: 0 cycleSpeed: 0)
			)
		)
		(gEgo setScript: egoEnters)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				(localproc_0)
			)
			(83 ; forceBoltSpell
				(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				(localproc_0)
			)
			(32 ; theHorn
				(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				(localproc_0)
			)
			(20 ; theDaggers
				(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				(localproc_0)
			)
			(33 ; theRocks
				(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				(localproc_0)
			)
			(74 ; Sleep
				(if (gCast contains: guardian)
					(gMessager say: 3 6 33) ; "There is too much energy in the air for you to fall asleep here."
				else
					(self setScript: goToBed)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gLongSong3 stop:)
		(UnLoad 128 6)
		(UnLoad 128 771)
		(LoadMany 0 986 964 955 970 949)
		(DisposeClone gem1)
		(super dispose:)
	)
)

(instance goToBed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 179 148 self)
			)
			(1
				(gEgo view: 35 loop: 0 cel: 0 x: 198 setCycle: End self)
			)
			(2
				(if (= temp0 (PalVary pvGET_CURRENT_STEP))
					(if (< temp0 64)
						(PalVary pvCHANGE_TICKS 3)
						(= seconds 5)
					else
						(self cue:)
					)
				else
					(PalVary pvINIT 310 3)
					(IsFlag 81)
					(= seconds 15)
				)
			)
			(3
				(PalVary pvREVERSE 3)
				(ClearFlag 81)
				(= seconds 4)
			)
			(4
				((ScriptID 7 7) init: 5 40) ; egoSleeps
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					normalize: 6
					cel: 6
					x: 179
					changeGait: 0 ; walking
					code: outCheck
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance gemsAppear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guardTell dispose:)
				(guardian show: setMotion: MoveTo 171 100 self)
				(= local0 0)
				(gEgo normalize: noun: 4)
			)
			(1
				(= seconds 3)
			)
			(2
				(gem1 init:)
				((= [local3 1] (gem1 new:)) loop: 0 cel: 1 x: 174 y: 137 init:)
				((= [local3 2] (gem1 new:)) loop: 0 cel: 0 x: 168 y: 144 init:)
				((= [local3 3] (gem1 new:)) loop: 0 cel: 0 x: 149 y: 140 init:)
				((= [local3 4] (gem1 new:)) loop: 0 cel: 1 x: 159 y: 143 init:)
				(DrawPic (gCurRoom picture:) 9)
				(= cycles 2)
			)
			(3
				(guardian setMotion: Wander 75 observeBlocks: deCage)
				(gem1 stopUpd:)
				([local3 1] addToPic:)
				([local3 2] addToPic:)
				([local3 3] addToPic:)
				([local3 4] addToPic:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance willSpin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if local1
					(gEgo setScript: kickHimOut)
				else
					(gEgo setScript: egoSpins)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsGem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 181 146 self)
				(if (not (IsFlag 51))
					(gEgo get: 36 addHonor: 20 solvePuzzle: 326 5) ; theGem
					(SetFlag 51)
				else
					(= global394 3)
					(gMessager say: 1 6 31) ; "We only offered you one gem! You have returned kindness with greed."
					(guardian setScript: kickHimOut)
				)
			)
			(1
				(if (not (== global394 3))
					(gEgo view: 4 loop: 1 cel: 0 setCycle: End self)
				)
			)
			(2
				(gem1 dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance kickHimOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCast contains: guardian))
					(guardian init: observeBlocks: deCage)
				)
				(HandsOff)
				(gEgo code: 0 moveSpeed: 0 setMotion: 0)
				(guardian
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo (gEgo x:) (gEgo y:) self
				)
			)
			(1
				(guardian ignoreBlocks: deCage setMotion: MoveTo 304 134 self)
				(gEgo
					view: 6
					setScale:
					setLoop: 2
					setCel: 1
					setCycle: 0
					setMotion: tracker guardian
				)
			)
			(2
				(EgoDead) ; "It's all over for now. Please try again."
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gMessager say: 3 6 17) ; "You find yourself in a strange, cavelike hole in the tree. There is a feeling of peace and serenity within, and the scent of strange flowers."
				(gEgo setMotion: PolyPath 181 146 self)
			)
			(2
				(gEgo code: outCheck)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoSpins of Script
	(properties)

	(method (doit)
		(if (< (guardianOrbits state:) 2)
			(gEgo
				setHeading:
					(GetAngle
						(gEgo x:)
						(gEgo y:)
						(guardian x:)
						(guardian y:)
					)
			)
		)
		(if (and (== (guardianOrbits state:) 2) (== state 0))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 5 cel: 0)
			)
			(1
				(gEgo view: 6 loop: 3 setCycle: End)
				(= seconds 3)
			)
			(2
				(gEgo loop: 9 cel: 0 setCycle: End self)
			)
			(3
				(proc0_13)
				(self dispose:)
			)
		)
	)
)

(instance guardianOrbits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guardian setCycle: Fwd setMotion: Wander 75)
				(= seconds 10)
			)
			(1
				(guardian
					z: (+ (gEgo z:) 20)
					ignoreBlocks: deCage
					setMotion: Orbit gEgo 25 0 0 45
				)
				(= seconds 15)
			)
			(2
				(proc0_13)
				(guardian setMotion: Chase gEgo 0 self)
			)
			(3
				(egoTell dispose:)
				(guardTell init: gEgo @local8 @local16)
				(= local0 1)
				(gEgo view: 772 loop: 1 noun: 1 setCycle: End)
				(guardian hide:)
				(gMessager say: 3 6 2 0 self) ; "You seem to hear voices coming from inside your head."
			)
			(4
				(switch global394
					(0
						(gMessager say: 1 6 1) ; "Welcome to the Mother of the World. We are the Guardian."
					)
					(1
						(gMessager say: 1 6 3) ; "We are the Guardian of the Mother of the World. Why did you try to do us harm?"
					)
					(2
						(gMessager say: 1 6 4) ; "We are the Guardian of the Mother of the World. Why did you try to harm us?"
					)
				)
				(proc0_13)
				(= local1 1)
				(gCurRoom setScript: contactScript)
				(self dispose:)
			)
		)
	)
)

(instance contactScript of Script
	(properties)

	(method (dispose)
		(gEgo code: outCheck)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13)
				(egoTell init: gEgo @local18 @local29)
				(gEgo view: 772 loop: 0 code: 0 normalize: 2 noun: 4)
				(= seconds 3)
			)
			(1
				(guardTell init: gEgo @local8 @local16)
				(gEgo view: 772 loop: 1 setCycle: Fwd noun: 1)
				(= seconds 3)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance goodBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guardTell dispose:)
				(egoTell dispose:)
				(gEgo normalize: noun: 4 actions: 0)
				(guardian show: setMotion: MoveTo 20 40 self)
			)
			(1
				(guardian dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance guardian of Actor
	(properties
		x 100
		y 100
		noun 1
		view 771
		signal 16384
	)
)

(instance gem1 of View
	(properties
		x 160
		y 138
		noun 12
		view 770
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: egoGetsGem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mushrooms of Feature
	(properties
		x 25
		y 170
		noun 2
		nsTop 151
		nsBottom 189
		nsRight 51
		sightAngle 180
	)
)

(instance globes of Feature
	(properties
		x 295
		y 157
		noun 5
		nsTop 126
		nsLeft 272
		nsBottom 188
		nsRight 319
		sightAngle 180
	)
)

(instance vines of Feature
	(properties
		x 91
		y 100
		noun 6
		nsTop 35
		nsLeft 54
		nsBottom 165
		nsRight 128
		sightAngle 180
	)
)

(instance upperGlobes of Feature
	(properties
		x 304
		y 58
		noun 9
		nsTop 39
		nsLeft 290
		nsBottom 78
		nsRight 319
		sightAngle 180
	)
)

(instance plant of Feature
	(properties
		x 194
		y 171
		noun 7
		nsTop 156
		nsLeft 162
		nsBottom 186
		nsRight 227
		sightAngle 180
	)
)

(instance bigVine of Feature
	(properties
		x 99
		y 107
		noun 8
		nsTop 52
		nsLeft 74
		nsBottom 163
		nsRight 125
		sightAngle 180
	)
)

(instance guardTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-9
				(and (== local0 1) (not (IsFlag 157)) (IsFlag 58))
				-8
				(and
					(== local0 1)
					(IsFlag 60)
					(not (gCast contains: gem1))
					(not (gEgo has: 36)) ; theGem
				)
				-10
				(and (== local0 1) (IsFlag 133) (not (gEgo has: 44))) ; theWood
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 2) (== local0 0)) ; Talk
			(gMessager say: 3 6 30) ; "There is no response."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doChild)
		(switch query
			(-8
				(gCurRoom setScript: gemsAppear)
				(gEgo noun: 1)
				(return query)
			)
			(else
				(return query)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-18
				(== local0 0)
				-32
				(== local0 1)
				-21
				(== local0 1)
				-22
				(== local0 1)
				-27
				(and (gEgo has: 39) (not ((gInventory at: 39) state:))) ; theOrchid, theOrchid
				-28
				(and (gEgo has: 39) ((gInventory at: 39) state:)) ; theOrchid, theOrchid
				-26
				(and (gEgo has: 37) local0) ; thePeaceWater
				-19
				(== local0 0)
				-20
				(== local0 1)
		)
	)

	(method (doChild)
		(switch query
			(-32
				(switch global394
					(0
						(return (= query -23))
					)
					(1
						(return (= query -24))
					)
					(2
						(return (= query -25))
					)
				)
			)
			(-20
				(gCurRoom setScript: goodBye)
				(return query)
			)
			(else
				(return query)
			)
		)
	)
)

(instance tracker of Track
	(properties)

	(method (doit &tmp temp0)
		(client
			x: (+ (who x:) 10)
			y: (+ (who y:) yOffset)
			z: (+ (who z:) zOffset)
		)
	)

	(method (init)
		(if argc
			(super init: &rest)
		)
	)
)

(instance deCage of Cage
	(properties
		top 25
		bottom 190
		right 320
	)
)

(instance deBase of Code ; UNUSED
	(properties)

	(method (doit param1)
		(Animate (gCast elements:) 0)
		(BaseSetter param1)
	)
)

(instance outCheck of Code
	(properties)

	(method (doit)
		(if (gEgo inRect: 300 100 319 189)
			(gCurRoom newRoom: 760)
		)
	)
)

