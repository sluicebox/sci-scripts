;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
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
)

(instance rm390 of GloryRm
	(properties
		picture 390
	)

	(method (init)
		(= local6
			(cond
				((not (IsFlag 45)) 1)
				((IsFlag 45) 2)
				(else 0)
			)
		)
		(gEgo
			setPri: 152
			view: 7
			loop: 4
			cel: 7
			x: 234
			y: 60
			init:
			setScaler: Scaler 105 81 92 76
		)
		(gLongSong number: 340 setLoop: -1 play:)
		(gWalkHandler addToFront: self)
		(lWin init: approachVerbs: 4) ; Do
		(rWin init: approachVerbs: 4) ; Do
		(if (IsFlag 70)
			(lWin setCel: (lWin lastCel:))
			(rWin setCel: (rWin lastCel:))
		)
		(deskLid init: approachVerbs: 4) ; Do
		(if (IsFlag 349)
			(deskLid setCel: (deskLid lastCel:))
		)
		(podium init: approachVerbs: 4) ; Do
		(if (IsFlag 352)
			(podium setCel: (podium lastCel:))
		)
		(mug init: approachVerbs: 4) ; Do
		(if (IsFlag 351)
			(mug setCel: (mug lastCel:))
		)
		(if (not (IsFlag 343))
			(broom init: approachVerbs: 4) ; Do
		)
		(if (and (gEgo has: 44) (IsFlag 401)) ; theTorch
			(Palette 2 66 85 90) ; PalIntensity
			(SetFlag 373)
			(torchFx init:)
			(gEgo changeGait:)
		else
			(Palette 2 66 85 50) ; PalIntensity
		)
		(chestLid init: setPri: 86 approachVerbs: 4 63) ; Do, theLocket
		(lWardrobe init: approachVerbs: 4) ; Do
		(rWardrobe init: approachVerbs: 4) ; Do
		(if (== local6 1)
			(oldMan init: setPri: 185 approachVerbs: 4 37) ; Do, theThrowdagger
		)
		(musicBox init: setPri: 152 approachVerbs: 4) ; Do
		(door init: approachVerbs: 4) ; Do
		(lamp init: approachVerbs: 4) ; Do
		(chest init: approachVerbs: 4 63) ; Do, theLocket
		(bed init: approachVerbs: 4 37) ; Do, theThrowdagger
		(desk init: approachVerbs: 4) ; Do
		(frontDoor init: approachVerbs: 4) ; Do
		(couch init: approachVerbs: 4) ; Do
		(downChest init: approachVerbs: 4) ; Do
		(cabinet init: approachVerbs: 4) ; Do
		(tableChairs init: approachVerbs: 4) ; Do
		(stairs init: approachVerbs: 4) ; Do
		(frontSteps init: approachVerbs: 4) ; Do
		(pillar1 init: approachVerbs: 4) ; Do
		(pillar2 init: approachVerbs: 4) ; Do
		(railing1 init: approachVerbs: 4) ; Do
		(railing2 init: approachVerbs: 4) ; Do
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 314 126 307 126 307 130 301 130 301 139 316 144 316 161 273 183 273 157 252 141 91 141 91 149 52 161 17 161 17 156 11 156 57 78 133 78 133 87 122 87 122 91 194 91 239 76 218 76 194 88 177 88 135 85 135 75 55 75 7 156 0 156 0 189 270 189 319 165 319 130 314 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 87 153 176 153 152 182 81 182 61 167 61 162
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 228 174 216 186 161 186 173 174
					yourself:
				)
		)
		(super init: &rest)
		(RemapColors 1 253 112 175 62) ; ByRange
		(self setScript: sInWindow)
	)

	(method (handleEvent event)
		(if
			(and
				(== local6 1)
				(== ((gTheIconBar getCursor:) view:) 940)
				(< (gEgo y:) 115)
				(!= gEgoGait 2) ; sneaking
			)
			(gLongSong2 number: 987 loop: 1 play:)
			(gCurRoom setScript: sEgoCreaks)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doTorch param1)
		(if param1
			(torchFx init:)
			(SetFlag 373)
			(gEgo changeGait:)
			(Palette 2 66 85 90) ; PalIntensity
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91 ; jugglingLightsSpell
				(if (== local6 2)
					(gMessager say: 20 6 44) ; "You think about it, and decide that casting that spell would attract too much attention to your location."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(Palette 2 66 85 100) ; PalIntensity
		(ClearFlag 373)
		(gEgo changeGait: gEgoGait)
		(gLongSong fade: 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sInWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 70)
				(= seconds 2)
			)
			(1
				(= local0 (gEgo cycleSpeed:))
				(gEgo addHonor: -5 cycleSpeed: 10 setCycle: Beg self)
			)
			(2
				(lWin setCycle: Beg self)
				(rWin setCycle: Beg self)
				(gEgo
					setPri: -1
					x: 221
					y: 79
					normalize: 3
					setHeading: 180 self
				)
			)
			(3 0)
			(4 0)
			(5
				(gEgo cycleSpeed: local0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOutWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 70)
				(gLongSong2 number: 143 loop: 1 play:)
				(lWin setCycle: End self)
				(rWin setCycle: End self)
			)
			(1 0)
			(2
				(if (and (== local6 1) (!= (oldMan cel:) (oldMan lastCel:)))
					(oldMan setCycle: End)
				)
				(gEgo
					setPri: 152
					view: 7
					loop: 4
					cel: 0
					x: 234
					y: 60
					setCycle: CT 7 1 self
				)
			)
			(3
				(gGlory handsOn:)
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance sKillOldMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(oldMan setCycle: End self)
			)
			(1
				(gMessager say: 20 6 22 0 self) ; "You easily manage to slit the throat of the defenseless old man. Dead men tell no tales, eh?"
			)
			(2
				(oldMan setCycle: Beg self)
			)
			(3
				(gMessager say: 18 6 23 0 self) ; "What has happened to me? I do not understand."
			)
			(4
				(EgoDead 24 0 0 0 912)
			)
		)
	)
)

(instance sGetWardrobeLoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(client setCycle: End self)
			)
			(1
				(if
					(or
						(and register (not local3))
						(and (not register) (not local2))
					)
					(gLongSong2 number: 143 loop: 1 play:)
					(if (== local6 1)
						(self setScript: sEgoCreaks self)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((and register (not (IsFlag 342)))
						(gMessager say: 20 6 19 0 self) ; "You search around in the wardrobe, but the only thing loose and portable is a garlic clove that has come loose from the garlic braid you see in here."
					)
					((and (not register) (not (IsFlag 341)))
						(gMessager say: 20 6 20 0 self) ; "In the pocket of one of the pairs of pants in here, you find some money. You add 20 Kopeks and 1 Crown to your purse."
					)
					(else
						(gMessager say: 20 6 39 0 self) ; "Looking inside, you find nothing left worth taking."
					)
				)
			)
			(3
				(cond
					(register
						(if (not (IsFlag 342))
							(if (not (IsFlag 389))
								(SetFlag 389)
							)
							(SetFlag 342)
							(gEgo get: 22 addHonor: -50) ; theGarlic
						)
					)
					((not (IsFlag 341))
						(if (not (IsFlag 389))
							(SetFlag 389)
						)
						(SetFlag 341)
						(++ global154)
						((gInventory at: 0) ; thePurse
							amount: (+ ((gInventory at: 0) amount:) 20) ; thePurse
						)
					)
				)
				(client setCycle: Beg self)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoCreaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(= cycles 5)
			)
			(1
				1
				(++ local1)
				(if (or register (>= local1 3))
					(oldMan setCycle: End self)
				else
					(= state 5)
					(switch local1
						(1
							(gMessager say: 20 6 14 0 self) ; "You hear a distinct "Creak!" This place hasn't been very well maintained."
						)
						(else
							(gMessager say: 20 6 15 0 self) ; "The old man stirs in his sleep and calls out, "Anna? Anna, is that you?" After a few moments he rolls over and returns to sleep."
						)
					)
				)
			)
			(2
				2
				(cond
					(register
						(gMessager say: 21 6 21 0 self) ; "What? Who are you? What are you doing here?"
					)
					((> (gEgo y:) 115)
						(= state 4)
						(gMessager say: 21 6 27 0 self) ; "What? Who is there? Dmitri, is that you?"
					)
					(else
						(gMessager say: 20 6 16 0 self) ; "Help, Vampires! Murderers! Help! Help me! Thieves! Help!"
					)
				)
			)
			(3
				3
				(= local5 gEgoGait)
				(gEgo changeGait: 1 setMotion: PolyPath 223 81 self) ; running
			)
			(4
				4
				(gEgo changeGait: local5)
				(gCurRoom setScript: sOutWindow)
			)
			(5
				(EgoDead 28 0 979 1 912)
			)
			(6
				6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpStairs of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(and
					(not (gEgo mover:))
					((gEgo cycler:) isKindOf: StopWalk)
					(== state 0)
				)
				(= register 1)
				(self changeState: state)
			)
			((and (== state 0) (>= (gEgo x:) 85))
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setScaler: Scaler 110 81 186 76)
				(torchFx setScaler: gEgo)
				(if register
					(gEgo setMotion: PolyPath 100 77 self)
				)
			)
			(1
				(gEgo setScaler: Scaler 105 81 92 76)
				(torchFx setScaler: gEgo)
				(gGlory handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sDownStairs of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(and
					(not (gEgo mover:))
					((gEgo cycler:) isKindOf: StopWalk)
					(== state 0)
				)
				(= register 1)
				(self changeState: state)
			)
			((and (== state 0) (>= (gEgo y:) 159))
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setScaler: Scaler 110 81 186 76)
				(torchFx setScaler: gEgo)
				(if register
					(gEgo setMotion: PolyPath 11 167 self)
				)
			)
			(1
				(gEgo setScaler: Scaler 110 85 186 132)
				(torchFx setScaler: gEgo)
				(gGlory handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sGetBroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 343)
				(gMessager say: 20 6 13 0 self) ; "As you reach for something to stow away in your pack, you find a small hand broom. You put it away in your pack before stopping to think that you really have no use for such a thing."
			)
			(1
				(if (not (IsFlag 389))
					(SetFlag 389)
				)
				(broom hide:)
				(gEgo get: 39 addHonor: -50) ; theBroom
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(chestLid setCycle: End self)
			)
			(1
				(cond
					((IsFlag 348)
						(= [gEgoStats 14] 0) ; honor
						(gMessager say: 20 6 40 0 self) ; "You have no morals, do you? Tsk, tsk."
					)
					(register
						(gEgo use: 42 addHonor: 100) ; theLocket
						(SetFlag 348)
						(gMessager say: 20 6 26 0 self) ; "You put the locket carefully back into the nightstand. You know that this is the one thing the old man would really miss if you took it."
					)
					((IsFlag 345)
						(gMessager say: 20 6 39 0 self) ; "Looking inside, you find nothing left worth taking."
					)
					(else
						(if (not (IsFlag 389))
							(SetFlag 389)
						)
						(SetFlag 345)
						(gEgo get: 42 addHonor: -50) ; theLocket
						((gInventory at: 0) ; thePurse
							amount: (+ ((gInventory at: 0) amount:) 18) ; thePurse
						)
						(gMessager say: 20 6 25 0 self) ; "Searching the nightstand, you find a small gold locket on a chain. It says "Love" on the outside in well-worn lettering. Inside, you see the tiny paintings of two faces."
					)
				)
			)
			(2
				(chestLid setCycle: Beg self)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoMusicBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(gLongSong number: 391 setLoop: -1 play:)
				(musicBox setCycle: Fwd)
				(if (== local6 2)
					(= state 3)
					(= seconds 6)
				else
					(= seconds 4)
				)
			)
			(1
				1
				(oldMan setCycle: End self)
			)
			(2
				2
				(gMessager say: 21 6 30 0 self) ; "Anna, is that you? Oh, Anna, how you love that music box I gave you. Anna, Anna, how I love you."
			)
			(3
				3
				(if (!= local1 2)
					(++ local1)
				)
				(oldMan setCycle: Beg self)
			)
			(4
				4
				(musicBox setCel: 0)
				(gLongSong fade: 0)
				(= seconds 1)
			)
			(5
				5
				(gLongSong number: 340 setLoop: -1 play:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 349)
				(deskLid setCycle: End self)
			)
			(1
				(if (not local4)
					(gLongSong2 number: 143 loop: 1 play:)
					(if (== local6 1)
						(self setScript: sEgoCreaks self)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 349)
				(deskLid setCycle: Beg self)
			)
			(1
				(if (not local4)
					(gLongSong2 number: 143 loop: 1 play:)
					(if (== local6 1)
						(self setScript: sEgoCreaks self)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoMug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(if (== (mug cel:) (mug lastCel:))
					(self changeState: 7)
				else
					(gEgo view: 31 loop: 0 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(1
				1
				(gMessager say: 12 4 11 0 self) ; "You pick up the ugly mug and carefully place it on the floor."
			)
			(2
				2
				(mug hide:)
				(gEgo setCycle: Beg self)
			)
			(3
				3
				(gEgo normalize: 6 setMotion: PolyPath 250 155 self)
			)
			(4
				4
				(gEgo setHeading: 90 self)
			)
			(5
				5
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				6
				(= state 12)
				(SetFlag 351)
				(mug cel: (mug lastCel:) show:)
				(gEgo setCycle: Beg self)
			)
			(7
				7
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				8
				(gMessager say: 12 4 12 0 self) ; "You return the ugly mug to its place on the chest."
			)
			(9
				9
				(mug hide:)
				(gEgo setCycle: Beg self)
			)
			(10
				10
				(gEgo normalize: 6 setMotion: PolyPath 259 165 self)
			)
			(11
				11
				(gEgo view: 31 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(12
				12
				(ClearFlag 351)
				(mug cel: 0 show:)
				(gEgo setCycle: Beg self)
			)
			(13
				13
				(gEgo normalize: 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDownChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(cond
					((== (mug cel:) 0)
						(mug setCycle: End self)
					)
					((IsFlag 352)
						(self changeState: 7)
					)
					(else
						(self changeState: 5)
					)
				)
			)
			(1
				1
				(gLongSong2 number: 964 loop: 1 play:)
				(if (== local6 2)
					(= cycles 1)
				else
					(++ local1)
					(gMessager say: 20 6 33 0 self) ; "What? Who? Anna, is that you?"
				)
			)
			(2
				2
				(if (>= local1 3)
					(oldMan setCycle: End self)
				else
					(self changeState: 8)
				)
			)
			(3
				3
				(gMessager say: 21 6 27 0 self) ; "What? Who is there? Dmitri, is that you?"
			)
			(4
				4
				(EgoDead 28 0 979 1 912)
			)
			(5
				5
				(SetFlag 352)
				(podium setCycle: End self)
			)
			(6
				6
				(= state 7)
				(gMessager say: 20 6 34 0 self) ; "You see that this is filled with junk."
			)
			(7
				(= state 7)
				(if (not (IsFlag 389))
					(SetFlag 389)
				)
				(SetFlag 346)
				(gEgo get: 5 addHonor: -50) ; theThrowdagger
				(++ global154)
				((gInventory at: 0) amount: (+ ((gInventory at: 0) amount:) 11)) ; thePurse, thePurse
				(gMessager say: 20 6 35 0 self) ; "Pawing around in the odds and ends, you pick up a dagger, one Crown, and eleven Kopeks as the only things worth taking."
			)
			(8
				8
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance broom of View
	(properties
		sightAngle 180
		x 251
		y 139
		view 390
		loop 11
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetBroom)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance torchFx of Prop
	(properties
		view 775
	)

	(method (init)
		(super init:)
		(self setScaler: Scaler 105 81 92 76 setCycle: RandCycle)
		(if (gEgo has: 44) ; theTorch
			(self show:)
		else
			(self hide:)
		)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= z (- (gEgo z:) 2))
		(super doit: &rest)
	)
)

(instance chestLid of Prop
	(properties
		noun 5
		sightAngle 180
		approachX 127
		approachY 87
		x 114
		y 79
		view 390
		signal 16385
	)

	(method (doVerb theVerb)
		(chest doVerb: theVerb &rest)
	)
)

(instance lWardrobe of Prop
	(properties
		noun 1
		sightAngle 180
		x 139
		y 74
		view 390
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sGetWardrobeLoot 0 0)
			)
			(32 ; theOil
				(= local2 1)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rWardrobe of Prop
	(properties
		noun 2
		sightAngle 180
		x 170
		y 77
		view 390
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sGetWardrobeLoot 0 1)
			)
			(32 ; theOil
				(= local3 1)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lWin of Prop
	(properties
		noun 3
		sightAngle 180
		approachX 234
		approachY 85
		x 250
		y 61
		priority 59
		fixPriority 1
		view 390
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(rWin doVerb: theVerb &rest)
	)
)

(instance rWin of Prop
	(properties
		noun 3
		sightAngle 180
		approachX 234
		approachY 85
		x 249
		y 61
		priority 59
		fixPriority 1
		view 390
		loop 4
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (== local6 2) (not gNight))
					(gMessager say: 20 6 42) ; "Somebody may see you climb out during the day."
				else
					(gCurRoom setScript: sOutWindow)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance podium of Prop
	(properties
		noun 11
		sightAngle 180
		approachX 262
		approachY 153
		x 283
		y 134
		view 390
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(downChest doVerb: theVerb &rest)
	)
)

(instance deskLid of Prop
	(properties
		noun 7
		sightAngle 180
		x 233
		y 124
		view 390
		loop 6
		signal 16385
	)

	(method (doVerb theVerb)
		(desk doVerb: theVerb &rest)
	)
)

(instance oldMan of Prop
	(properties
		noun 21
		sightAngle 180
		approachX 89
		approachY 76
		x 61
		y 71
		view 390
		loop 7
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sEgoCreaks 0 1)
			)
			(37 ; theThrowdagger
				(gCurRoom setScript: sKillOldMan)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance musicBox of Prop
	(properties
		noun 8
		sightAngle 180
		approachX 67
		approachY 158
		x 46
		y 131
		view 390
		loop 8
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sDoMusicBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mug of Prop
	(properties
		noun 12
		sightAngle 180
		x 273
		y 154
		priority 135
		fixPriority 1
		view 390
		loop 9
		signal 20481
	)

	(method (handleEvent event)
		(if (== (mug cel:) (mug lastCel:))
			(= approachX 250)
			(= approachY 155)
		else
			(= approachX 259)
			(= approachY 165)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 352)
					(gMessager say: 12 4 43) ; "Let's get a couple things straight: 1. The chest the mug was on is open,   so there's nowhere to place it. 2. The mug is so ugly you don't want it."
				else
					(gCurRoom setScript: sDoMug)
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
		noun 9
		sightAngle 180
		approachX 310
		approachY 126
		x 319
		y 126
		priority 120
		fixPriority 1
		view 390
		loop 10
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 23 4 36) ; "The door is locked and barred. It would be better if you did not go out this way -- it would make it obvious that someone has been here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 4
		nsTop 44
		nsRight 14
		nsBottom 62
		sightAngle 180
		approachX 100
		approachY 87
		x 7
		y 53
	)
)

(instance chest of Feature
	(properties
		noun 5
		nsLeft 97
		nsTop 67
		nsRight 129
		nsBottom 86
		sightAngle 180
		approachX 127
		approachY 87
		x 113
		y 76
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 345)
					(gMessager say: 5 1 4) ; "The chest contains an assortment of carefully folded women's clothing including a wedding dress and bridal veil along with an empty wallet."
				else
					(gMessager say: 5 1 3) ; "There is a footlocker next to the bed."
				)
			)
			(4 ; Do
				(if (IsFlag 345)
					(gCurRoom setScript: sOpenChest 0 0)
				else
					(gMessager say: 5 4 3) ; "The chest is locked."
				)
			)
			(42 ; theToolkit
				(cond
					((IsFlag 345)
						(gMessager say: 5 42 4) ; "The chest isn't locked."
					)
					((== (gEgo trySkill: 9 275) 1) ; pick locks
						(gCurRoom setScript: sOpenChest 0 0)
					)
					(else
						(gMessager say: 5 42 2) ; "Tsk! Such a terrible lack of trust around here. The old man has not only locked his chest, but seems to have used a good enough lock that it's beyond your abilities. (Or maybe you just need more practice.)"
					)
				)
			)
			(63 ; theLocket
				(gCurRoom setScript: sOpenChest 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bed of Feature
	(properties
		noun 6
		nsLeft 14
		nsTop 55
		nsRight 118
		nsBottom 80
		sightAngle 180
		approachX 89
		approachY 76
		x 66
		y 67
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 87 73 87 82 67 82 67 73
						yourself:
					)
					7
					1
					5
					sDownStairs
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local6 1)
					(gMessager say: 6 1 5) ; "The old man seems to be having a restless night. Every few minutes he shifts position in the bed. Occasionally you can hear him mutter "Anna?" in his sleep."
				else
					(gMessager say: 6 1 6) ; "With the old man gone, his bed lies empty. It's a plain bed much like yours at the inn."
				)
			)
			(4 ; Do
				(if (== local6 1)
					(gCurRoom setScript: sEgoCreaks 0 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(37 ; theThrowdagger
				(if (== local6 1)
					(gCurRoom setScript: sKillOldMan)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(heading dispose:)
		(super dispose: &rest)
	)
)

(instance desk of Feature
	(properties
		noun 7
		nsLeft 214
		nsTop 108
		nsRight 254
		nsBottom 136
		sightAngle 180
		x 234
		y 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 349)
					(if (IsFlag 350)
						(gMessager say: 7 1 7) ; "The desk is now empty except for the old book."
					else
						(gMessager say: 7 1 32) ; "You see some sort of potion and a book in the desk."
					)
				else
					(gMessager say: 7 1 8) ; "The desk consists of a simple table top closed in by two hinged doors. It doesn't have a lock."
				)
			)
			(4 ; Do
				(if (IsFlag 349)
					(cond
						((and (not local7) (IsFlag 350))
							(= local7 1)
							(gMessager say: 20 6 41) ; "You scan through the book in the old man's desk. It seems to be someone's diary. The author was working in Castle Borgov when the Boyar was still around and mentions a secret passage in the Boyar's crypt. Interesting..."
						)
						((not (IsFlag 350))
							(if (not (IsFlag 389))
								(SetFlag 389)
							)
							(SetFlag 350)
							(gEgo get: 3 addHonor: -50) ; theHeals
							(gMessager say: 20 6 32) ; "You find a small bottle of Healing Potion, which you take. You also find a large book too bulky to take with you."
						)
						((IsFlag 349)
							(gCurRoom setScript: sCloseDesk)
						)
					)
				else
					(gCurRoom setScript: sOpenDesk)
				)
			)
			(32 ; theOil
				(= local4 1)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontDoor of Feature
	(properties
		noun 9
		nsLeft 292
		nsTop 72
		nsRight 319
		nsBottom 123
		sightAngle 180
		approachX 310
		approachY 126
		x 305
		y 97
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 9 4 36) ; MISSING MESSAGE
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance couch of Feature
	(properties
		noun 10
		nsLeft 106
		nsTop 111
		nsRight 175
		nsBottom 132
		sightAngle 180
		x 140
		y 121
	)
)

(instance downChest of Feature
	(properties
		noun 11
		nsLeft 267
		nsTop 119
		nsRight 289
		nsBottom 146
		sightAngle 180
		approachX 262
		approachY 153
		x 278
		y 132
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 352)
					(gMessager say: 20 6 34) ; "You see that this is filled with junk."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (and (IsFlag 352) (IsFlag 346))
					(gMessager say: 20 6 39) ; "Looking inside, you find nothing left worth taking."
				else
					(gCurRoom setScript: sOpenDownChest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		noun 13
		nsLeft 33
		nsTop 99
		nsRight 77
		nsBottom 150
		sightAngle 180
		x 55
		y 124
	)
)

(instance tableChairs of Feature
	(properties
		noun 14
		nsLeft 67
		nsTop 132
		nsRight 155
		nsBottom 178
		sightAngle 180
		x 111
		y 155
	)
)

(instance stairs of Feature
	(properties
		noun 15
		nsLeft 2
		nsTop 102
		nsRight 23
		nsBottom 156
		sightAngle 180
		approachX 12
		approachY 165
		x 12
		y 129
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 0 155 20 155 20 160 0 160
						yourself:
					)
					7
					3
					6
					sUpStairs
				yourself:
			)
		)
	)

	(method (dispose)
		(heading dispose:)
		(super dispose: &rest)
	)
)

(instance frontSteps of Feature
	(properties
		noun 16
		nsLeft 274
		nsTop 130
		nsRight 319
		nsBottom 187
		sightAngle 180
		approachX 269
		approachY 189
		x 296
		y 108
		z -50
	)
)

(instance pillar1 of Feature
	(properties
		noun 17
		nsLeft 176
		nsTop -1
		nsRight 212
		nsBottom 182
		sightAngle 180
		x 194
		y 90
	)
)

(instance pillar2 of Feature
	(properties
		noun 17
		nsLeft 257
		nsRight 279
		nsBottom 138
		sightAngle 180
		x 268
		y 69
	)
)

(instance railing1 of Feature
	(properties
		noun 19
		nsTop 72
		nsRight 177
		nsBottom 100
		sightAngle 180
		approachX 149
		approachY 87
		x 88
		y 66
		z -20
	)
)

(instance railing2 of Feature
	(properties
		noun 19
		nsLeft 207
		nsTop 57
		nsRight 264
		nsBottom 93
		sightAngle 180
		approachX 220
		approachY 81
		x 235
		y 75
	)
)

