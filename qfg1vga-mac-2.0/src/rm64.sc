;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use n814)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Follow)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm64 0
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
	local14
	[local15 45] = [5 0 180 27 5 1 196 47 5 2 190 67 5 3 153 80 5 4 132 91 5 5 152 116 5 6 189 114 5 7 198 96 5 8 179 75 5 9 169 57 5 10 174 35 -32768]
)

(procedure (localproc_0)
	(EgoDead 84 85 0 0 516) ; "As the ghosts suck the life out of your body, and you crumple into the dust of the old graveyard, you think unspeakable thoughts of torture and torment directed at vicious programmers and insidious game designers. (But please buy our next game anyway!)"
)

(instance rm64 of Rm
	(properties
		noun 6
		picture 64
		style 8
	)

	(method (dispose)
		(gCurRoom setScript: unknown_64_33)
		(DisposeScript 942)
		(super dispose: &rest)
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 254 189 264 175 318 165 319 149 224 167 204 146 210 130 182 112 152 112 191 136 181 146 0 146
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 157 42 189 0 189 yourself:)
		)
		(LoadMany rsVIEW 63 516)
		(Load rsSCRIPT 942)
		(super init:)
		(theGrass init: setOnMeCheck: 1 2)
		(theTrees init: setOnMeCheck: 1 2)
		(theSky init: setOnMeCheck: 1 4)
		(crossStone init: setOnMeCheck: 26505)
		(graveStone init: setOnMeCheck: 26505)
		(grate init: setOnMeCheck: 26505)
		(theWall init: setOnMeCheck: 26505)
		(theMortuary init: setOnMeCheck: 26505)
		(gLongSong fade:)
		(if (and (not (gEgo has: 21)) (< (+ global256 1) gDay)) ; mandrake
			(mandrake setPri: 8 stopUpd: init:)
		)
		(if (and gNight (or (== gTimeOfDay 6) (== gTimeOfDay 7)))
			(Load rsSCRIPT 969)
			(= global275 37)
			(if (> (gGame detailLevel:) 3)
				(riser init: cycleSpeed: 24 setCycle: Fwd)
			)
			(longOne
				cycleSpeed: 18
				setLoop: 0
				setPri: 8
				illegalBits: 0
				ignoreActors:
				init:
				setScript: upThisTime
			)
			(longOneBottom
				cycleSpeed: 18
				setLoop: 2
				setPri: 8
				illegalBits: 0
				ignoreActors:
				init:
			)
			(twister
				init:
				setLoop: 6
				setPri: 8
				cycleSpeed: 12
				setScript: twistIt
			)
			(if (> (gGame detailLevel:) 3)
				(tumbler
					init:
					setLoop: 9
					setPri: 14
					illegalBits: 0
					ignoreActors:
					setCycle: End
					setScript: spinOnTree
				)
			)
			(swimmer
				init:
				setLoop: 4
				setPri: 14
				ignoreActors:
				cycleSpeed: 12
				setScript: swimRight
			)
			(ghostMusic init: play:)
		)
		(= global272 0)
		(= local1 (Random 0 7))
		(NormalEgo)
		(gEgo
			init:
			setPri: 13
			ignoreActors:
			ignoreControl: -32768
			actions: unusualDoVerb
		)
		(if (and gNight (IsFlag 168))
			(SolvePuzzle 682 2)
		)
		(switch gPrevRoomNum
			(72
				(gEgo posn: 160 188 setMotion: MoveTo 160 180)
				(if (and gNight (not (IsFlag 168)))
					(= global272 5)
					(self setScript: gotHim)
				else
					(self setScript: safeIntro)
				)
			)
			(63
				(gEgo posn: 1 172)
				(self setScript: safeIntro)
			)
			(else
				(gEgo posn: 44 177)
			)
		)
	)

	(method (cue)
		(switch local11
			(1
				(= local11 2)
				(gMessager say: 3 1 0 2 self) ; "Here lies an atheist..."
			)
			(2
				(= local11 3)
				(gMessager say: 3 1 0 3 self) ; "All dressed up and nowhere to go."
			)
			(3
				(if (gCast contains: mandrake)
					(gMessager say: 3 1 1) ; "Growing up out of the grave is an evil-looking plant with a slimy, poisonous sheen."
				else
					(gMessager say: 3 1 2) ; "The carving on most of the gravestones seems to have been either intentionally defaced or worn with time."
				)
			)
			(4
				(= local11 5)
				(gMessager say: 1 1 0 2 self) ; "Here lies Lester Moore Gored six times by a wild boar."
			)
			(5
				(gMessager say: 1 1 0 3) ; "No Les, no Moore."
			)
			(6
				(gMessager say: 6 0 9 2) ; "The root shrivels and twists in your hands until nothing is left. Astonished, you look at your empty hands."
			)
		)
	)

	(method (doit)
		(if (and (not (gEgo script:)) (== (gEgo edgeHit:) 3) (not local3))
			(gEgo setScript: walkOutTo72)
		)
		(if
			(and
				(not (gEgo script:))
				(not (== (gCurRoom script:) safeIntro))
				(< (gEgo x:) 5)
			)
			(gEgo setScript: walkTo63)
		)
		(cond
			(
				(and
					(< 68 (gEgo x:) 270)
					(< 120 (gEgo y:) 180)
					(not local2)
					(not (IsFlag 168))
					(not (IsFlag 164))
					gNight
				)
				(SetFlag 164)
				(= local9 1)
			)
			((IsFlag 164)
				(if
					(and
						(not local2)
						(or
							(< (gEgo distanceTo: riser) 35)
							(< (gEgo distanceTo: twister) 35)
							(< (gEgo distanceTo: swimmer) 35)
							(< (gEgo distanceTo: tumbler) 35)
							(< (gEgo distanceTo: longOne) 35)
						)
					)
					(= local2 1)
					(ClearFlag 164)
					(self setScript: gotHim)
				)
			)
			((and gNight (== local12 0))
				(= local12 1)
				(Load rsSCRIPT 969)
				(= global275 37)
				(longOne
					cycleSpeed: 18
					setLoop: 0
					setPri: 8
					illegalBits: 0
					ignoreActors:
					init:
					setScript: upThisTime
				)
				(longOneBottom
					cycleSpeed: 18
					setLoop: 2
					setPri: 8
					illegalBits: 0
					ignoreActors:
					init:
				)
				(twister
					init:
					setLoop: 6
					setPri: 8
					cycleSpeed: 12
					setScript: twistIt
				)
				(tumbler
					init:
					setLoop: 9
					setPri: 14
					illegalBits: 0
					ignoreActors:
					setCycle: End
					setScript: spinOnTree
				)
				(swimmer
					init:
					setLoop: 4
					setPri: 14
					ignoreActors:
					cycleSpeed: 12
					setScript: swimRight
				)
				(ghostMusic init: play:)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(switch (Random 1 3)
					(1
						(gMessager say: 6 1 13) ; "Nothing grows in the dirt of the old graveyard. Some of the graves appear to have been disturbed."
					)
					(2
						(gMessager say: 6 1 14) ; "The graves seemed to be placed haphazardly in the tiny graveyard. All appear to be old and poorly maintained."
					)
					(3
						(if gNight
							(gMessager say: 6 1 12) ; "It appears that the spirits frolic here during the dark hours."
						else
							(gMessager say: 6 1 11) ; "It's certainly creepy here even during the daylight hours."
						)
					)
				)
			)
			(50 ; detectMagicSpell
				(if gNight
					(gMessager say: 6 50 8) ; "What a surprise -- there's magic all around here! (After all, SOMETHING is making those spirits fly around, and it isn't the wind.)"
				else
					(gMessager say: 6 50) ; "You sense a spiritual coldness."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unusualDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 29) ; ghostOil
			(SetFlag 168)
			(ClearFlag 164)
			(if (== gHowFast 0)
				(= global200 300)
			else
				(= global200 150)
			)
			(if gNight
				(SolvePuzzle 682 2)
			)
			(gMessager say: 6 83 0) ; "You feel a tingling sensation as you rub the unguent all over your body."
			(= local14 1)
			(gEgo setScript: cueItScript)
		else
			(return 0)
		)
	)
)

(instance theGrass of Feature
	(properties
		x 151
		y 6
		noun 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 7 1) ; "The grass glows ghostly."
			else
				(gMessager say: 7 1 15) ; "The grass grows greener on the other side of the cemetery."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theTrees of Feature
	(properties
		x 151
		y 6
		noun 10
	)
)

(instance theSky of Feature
	(properties
		x 151
		y 6
		noun 9
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 9 1 0) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
			else
				(gMessager say: 9 1 15) ; "The sky is a piercing blue with scudding white clouds."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theWall of Feature
	(properties
		x 303
		y 29
		z 71
		noun 11
		nsTop 29
		nsLeft 304
		nsBottom 118
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if gNight
					(if (TrySkill 11 35 0) ; climbing
						(gEgo setScript: upTheWall)
					else
						(gMessager say: 11 4 0) ; "The wall is too difficult for your level of skill, but keep practicing."
					)
				else
					(gMessager say: 11 4 15) ; "You would have trouble convincing people you are a Hero if you climbed the wall into town during the day."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMortuary of Feature
	(properties
		x 134
		y 8
		z 93
		noun 8
		nsTop 8
		nsLeft 44
		nsBottom 74
		nsRight 224
	)
)

(instance graveStone of Feature
	(properties
		x 273
		y 50
		noun 3
		nsTop 50
		nsLeft 243
		nsBottom 143
		nsRight 304
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local11 1)
				(gMessager say: 3 1 0 1 gCurRoom) ; "The large tombstone seems to have a barely legible epitaph:"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance crossStone of Feature
	(properties
		x 65
		y 103
		noun 1
		nsTop 103
		nsLeft 46
		nsBottom 131
		nsRight 84
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local11 4)
			(gMessager say: 1 1 0 1 gCurRoom) ; "The large stone you are facing has been engraved with this message:"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance grate of Feature
	(properties
		x 151
		y 93
		noun 2
		nsTop 80
		nsLeft 128
		nsBottom 107
		nsRight 174
	)
)

(instance mandrake of View
	(properties
		x 214
		y 150
		noun 4
		view 63
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo inRect: 192 134 243 160)
					(gMessager say: 4 1 0) ; "Growing up out of the grave is an evil-looking plant with a slimy, poisonous sheen."
				else
					(gMessager say: 4 1 3) ; "The red root growing out of one of the graves has a strange and evil appearance."
				)
			)
			(4 ; Do
				(gEgo setScript: getRoot)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance riser of Prop
	(properties
		x 75
		y 145
		noun 5
		view 64
		loop 7
		signal 24576
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(switch (Random 0 1)
						(0
							(gMessager say: 5 1 5) ; "You see transparent, decaying, writhing, slimy, undead fragments of undulating ectoplasm!"
						)
						(1
							(gMessager say: 5 1 6) ; "I DO believe in spooks! I DO believe in spooks! I DO, I DO, I DO believe in spooks!!"
						)
					)
				else
					(gMessager say: 5 1 4) ; "You recall from somewhere that the most likely time to find ghosts is at night."
				)
			)
			(2 ; Talk
				(gEgo setScript: talkToGhosts)
			)
			(4 ; Do
				(gMessager say: 5 4 0 2) ; "You don't get ghosts. Ghosts get YOU!"
			)
			(16 ; dagger
				(gMessager say: 5 16 0 2) ; "Everything here is already dead."
			)
			(20 ; rock
				(gMessager say: 5 20 0 2) ; "Don't annoy the rock 'n roll ghosts, unless you want to twist and shout with them!"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance twister of Actor
	(properties
		x 259
		y 125
		noun 5
		view 64
		loop 6
		cel 3
		signal 24576
		illegalBits 0
	)

	(method (doVerb theVerb)
		(riser doVerb: theVerb &rest)
	)
)

(instance longOne of Actor
	(properties
		x 268
		y 102
		noun 5
		view 64
		signal 24576
		illegalBits 0
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb)
		(riser doVerb: theVerb &rest)
	)
)

(instance longOneBottom of Actor
	(properties
		x 269
		y 135
		noun 5
		view 64
		loop 2
		signal 24576
		illegalBits 0
	)

	(method (doVerb theVerb)
		(riser doVerb: theVerb &rest)
	)

	(method (doit)
		(longOneBottom posn: (+ (longOne x:) 1) (+ (longOne y:) 33))
		(super doit:)
	)
)

(instance tumbler of Actor
	(properties
		x 168
		y 77
		noun 5
		view 64
		loop 9
		signal 24576
		illegalBits 0
	)

	(method (doVerb theVerb)
		(riser doVerb: theVerb &rest)
	)
)

(instance swimmer of Actor
	(properties
		x 200
		y 180
		noun 5
		view 64
		loop 4
		signal 24576
		illegalBits 0
	)

	(method (doVerb theVerb)
		(riser doVerb: theVerb &rest)
	)
)

(instance upTheWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 275 153 self)
			)
			(1
				(gEgo setMotion: MoveTo 313 150 self)
			)
			(2
				(gEgo
					view: 517
					setLoop: 0
					cel: 0
					posn: 313 120
					ignoreHorizon:
				)
				(self cue:)
			)
			(3
				(if (TrySkill 11 35 0) ; climbing
					(gEgo setCycle: Fwd setMotion: MoveTo 313 42 self)
				else
					(gEgo setScript: notGoodEnough)
				)
			)
			(4
				(gEgo loop: 1 cel: 0 posn: 312 24 setCycle: End self)
			)
			(5
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance notGoodEnough of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Fwd setMotion: MoveTo 313 100 self)
			)
			(1
				(gEgo setCycle: 0 setCel: 0 setMotion: MoveTo 313 120 self)
			)
			(2
				(gMessager say: 6 0 0 1) ; "Climbing this wall is too difficult for your current skill level, but keep practicing."
				(NormalEgo)
				(gEgo view: 0 posn: 313 150)
				(self cue:)
			)
			(3
				(gEgo setMotion: MoveTo 200 167 self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance gotHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(riser setPri: 7 cycleSpeed: 24 setCycle: Fwd)
				(twister
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				(swimmer
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				(tumbler
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				(longOne setScript: peekABoo)
				(gEgo setMotion: 0)
				(= ticks 360)
			)
			(1
				(gEgo view: 516 setLoop: 0 setCycle: End self)
			)
			(2
				(localproc_0)
			)
		)
	)
)

(instance safeIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gPrevRoomNum 63)
					(gEgo setMotion: MoveTo 44 177 self)
				else
					(self cue:)
				)
			)
			(1
				(cond
					(
						(or
							(== gPrevRoomNum 63)
							(and gNight (IsFlag 114))
							(and (not gNight) (IsFlag 54))
						)
						(= ticks 60)
					)
					((and (> gTimeOfDay 5) (not (IsFlag 168)))
						(client setScript: gotHim)
					)
					(else
						(= seconds 1)
					)
				)
			)
			(2
				(cond
					((IsFlag 54)
						(self cue:)
					)
					(gNight
						(self cue:)
					)
					(else
						(gMessager say: 6 0 0 2 self) ; "This must be the town graveyard. What a run-down place!"
					)
				)
			)
			(3
				(cond
					(gNight
						(gMessager say: 6 0 8 1 self) ; "It appears that the spirits frolic here during the dark hours."
					)
					((IsFlag 54)
						(self cue:)
					)
					(else
						(gMessager say: 6 0 10 1 self) ; "It's certainly creepy here even during the daylight hours."
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

(instance getRoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setPri: 13
					setMotion: MoveTo 214 165 self
				)
			)
			(1
				(if (== gTimeOfDay 6)
					(gEgo get: 21) ; mandrake
				)
				(gEgo setLoop: 3)
				(mandrake dispose:)
				(= cycles 2)
			)
			(2
				(if (== gTimeOfDay 6)
					(gMessager say: 6 0 7) ; "You wrench the mandrake plant free from the tombstone on which it has grown. You hear a scream like that of a dying child as you yank the root from the ground."
					(SolvePuzzle 683 6)
				else
					(= local11 6)
					(gMessager say: 6 0 9 1 gCurRoom) ; "You wrench the mandrake plant free from the tombstone on which it has grown. Somehow you thought this would be a lot harder. You wonder if you did this right."
					(= global256 gDay)
				)
				(NormalEgo)
				(gEgo setPri: 13 setMotion: MoveTo 185 (mandrake y:) self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance twistIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local10 1)
				(twister
					setLoop: 6
					setCel: 1
					setPri: 12
					ignoreActors:
					illegalBits: 0
					startUpd:
					setMotion: MoveTo 216 101 self
				)
			)
			(1
				(twister setMotion: MoveTo 277 54 self)
				(= local4 (twister x:))
				(= local5 (twister y:))
			)
			(2
				(++ local10)
				(= local6 local4)
				(= local7 local5)
				(= local4 (Random 20 210))
				(= local5 (Random 54 130))
				(twister setCycle: CT local10 1 self)
				(if local9
					(twister setMotion: Follow gEgo 30)
				else
					(twister setMotion: MoveTo local4 local5 self)
				)
			)
			(3
				(if (> local10 8)
					(= local10 0)
				)
				(self cue:)
			)
			(4
				(-- global272)
				(= ticks 300)
			)
			(5
				(self changeState: 2)
			)
		)
	)
)

(instance swimRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer
					view: 64
					setLoop: 4
					setPri: 14
					ignoreActors:
					illegalBits: 0
					setCycle: Fwd
				)
				(= ticks 30)
			)
			(1
				(if local9
					(swimmer setMotion: Follow gEgo 30)
				else
					(swimmer
						setMotion: MoveTo (Random 110 210) (Random 140 187) self
					)
				)
			)
			(2
				(-- global272)
				(switch (Random 1 2)
					(1
						(swimmer setCycle: 0 setMotion: 0 setLoop: 4 setCel: 4)
					)
					(2
						(swimmer
							setMotion: MoveTo (+ (gEgo x:) 100) (gEgo y:)
						)
					)
				)
				(= ticks (Random 60 120))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance peekABoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(longOneBottom cel: 0 setPri: 15 setCycle: Fwd)
				(longOne
					posn: 268 102
					setLoop: 0
					startUpd:
					setPri: 15
					setCel: 0
					setCycle: End
					setMotion: Follow gEgo 30
				)
			)
		)
	)
)

(instance upThisTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(longOne
					posn: 153 108
					setCel: 4
					setLoop: 0
					setMotion: MoveTo 148 26 self
				)
				(longOneBottom setLoop: 2)
			)
			(1
				(= ticks (Random 180 240))
			)
			(2
				(longOne cel: 0 setCycle: End self)
			)
			(3
				(longOne setCycle: CT 4 1 setMotion: MoveTo 153 118 self)
			)
			(4
				(= ticks (Random 120 180))
			)
			(5
				(switch (Random 1 2)
					(1
						(longOne setScript: upThird)
					)
					(2
						(longOne setScript: upSecond)
					)
				)
			)
		)
	)
)

(instance upSecond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(longOne
					posn: 270 87
					setCel: 4
					setCycle: End
					setMotion: MoveTo 273 23 self
				)
			)
			(1
				(= ticks (Random 180 240))
			)
			(2
				(longOne cel: 0 setCycle: End self)
			)
			(3
				(longOne setCycle: Beg setMotion: MoveTo 270 87 self)
			)
			(4
				(= ticks (Random 120 240))
			)
			(5
				(switch (Random 1 2)
					(1
						(longOne setScript: upThird)
					)
					(2
						(longOne setScript: upThisTime)
					)
				)
			)
		)
	)
)

(instance upThird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(longOne posn: 69 82 setCel: 4 setMotion: MoveTo 77 21 self)
			)
			(1
				(= ticks (Random 180 240))
			)
			(2
				(longOne cel: 0 setCycle: End self)
			)
			(3
				(longOne setCycle: CT 4 1 setMotion: MoveTo 69 82 self)
			)
			(4
				(= ticks (Random 60 240))
			)
			(5
				(switch (Random 1 2)
					(1
						(longOne setScript: upSecond)
					)
					(2
						(longOne setScript: upThisTime)
					)
				)
			)
		)
	)
)

(instance spinOnTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tumbler
					ignoreActors:
					illegalBits: 0
					posn: 168 77
					setLoop: 9
					setCel: 0
					show:
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(1
				(++ local8)
				(tumbler
					setLoop: 5
					posn: 180 27
					cycleSpeed: 12
					setCel: 0
					setCycle: MCyc @local15 tumbler
				)
				(if (and (== (gEgo x:) 174) (== (gEgo y:) 35))
					(self cue:)
				)
			)
			(2
				(tumbler setCel: 11 posn: 159 14)
				(if local9
					(tumbler setMotion: Follow gEgo 30)
				else
					(self cue:)
				)
			)
			(3
				(tumbler
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setMotion: MoveTo 173 (- (tumbler y:) 18) self
				)
			)
			(4
				(-- global272)
				(tumbler
					posn: (- (tumbler x:) 3) (- (tumbler y:) 5)
					setCel: 12
					setMotion: MoveTo 179 (- (tumbler y:) 11) self
				)
			)
			(5
				(tumbler
					posn: 186 (+ (tumbler y:) 5)
					setCel: 13
					setMotion: MoveTo 202 (- (tumbler y:) 20) self
				)
			)
			(6
				(tumbler hide:)
				(= ticks (Random 360 1000))
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance talkToGhosts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ local13)
				(self cue:)
			)
			(1
				(switch local13
					(1
						(gMessager say: 5 57 0 1 self) ; "The ghost won't say boo to you."
					)
					(2
						(gMessager say: 5 57 0 2 self) ; "You can't seem to have a meaningful conversation with the ghosts. Their thoughts are on another plane altogether."
					)
					(3
						(gMessager say: 5 57 0 3 self) ; "But are they friendly spirits? Just listen!  "Boo!"  Nope, guess not."
					)
					(4
						(gMessager say: 5 57 0 4 self) ; "Had I the ears to hear, or a mouth to speak, I'd do my best to make you shriek!"
					)
					(5
						(gMessager say: 5 57 0 5 self) ; "Casper he's not."
					)
					(6
						(gMessager say: 5 57 0 6 self) ; ""Boo hoo, I'm so unhappy here," says the ghost with a grave demeanor."
					)
				)
			)
			(2
				(if (== local13 6)
					(= local13 0)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOutTo72 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 72)
			)
		)
	)
)

(instance walkTo63 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 63)
			)
		)
	)
)

(instance cueItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(switch local14
					(1
						(gEgo use: 19) ; ghostOil
						(gEgo get: 11) ; flask
					)
				)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance unknown_64_33 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (== gNight 1)
					(= global275 26)
					(riser setCycle: 0 setScript: 0)
					(twister setMotion: 0 setCycle: 0 setScript: 0)
					(tumbler setMotion: 0 setCycle: 0 setScript: 0)
					(longOne setMotion: 0 setCycle: 0 setScript: 0)
					(longOneBottom setMotion: 0 setCycle: 0 setScript: 0)
					(swimmer setMotion: 0 setCycle: 0 setScript: 0)
					(SetFlag 114)
				else
					(SetFlag 54)
				)
				(= cycles 1)
			)
			(2
				(SetFlag 54)
				(ClearFlag 164)
				(self dispose:)
			)
		)
	)
)

(instance ghostMusic of Sound
	(properties
		number 12
		loop -1
	)
)

