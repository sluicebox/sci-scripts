;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use Print)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm740 0
	torchEff 1
	doRitual 2
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
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 2]
	local23
	local24
	local25
)

(instance rm740 of GloryRm
	(properties
		noun 1
		picture 740
	)

	(method (init)
		(ClearFlag 6)
		(fLowerHold init: approachVerbs: 33 10) ; theGrapnel, Jump
		(fLowerPath init:)
		(fUpperPath init:)
		(altarHead init:)
		(altarBowl init:)
		(altarBase init:)
		(island init:)
		(upperShelf init:)
		(lowerShelf init:)
		(bridge init:)
		(bridgeLedge init:)
		(spoutPillar init:)
		(roomExit init:)
		(rock init:)
		(littleLedge init:)
		(lowLedge init:)
		(fSteps init:)
		(gWalkHandler addToFront: fSteps)
		(gLongSong number: 200 setLoop: -1 play:)
		(super init: &rest)
		(RemapColors 2 254 60) ; ByPercent
		(RemapColors 1 253 112 175 62) ; ByRange
		(SetFlag 373)
		(gEgo
			init:
			x: 75
			y: 43
			normalize:
			changeGait:
			setScaler: Scaler 77 37 175 47
		)
		(gCurRoom addObstacle: (roomPoly init: yourself:))
		(Palette 2 66 85 local0) ; PalIntensity
		(torchEff init: setScaler: gEgo setCycle: RandCycle)
		(aRock init:)
		(= local13 0)
		(self setScript: (ScriptID 741 1)) ; enterScript
		(gGlory save: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; glideSpell
				(if (IsFlag 340)
					(gMessager say: 16 11 9) ; "This isn't a safe place to cast the Glide spell. It may prove useful in another part of the Blood Cave, however."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(89 ; levitateSpell
				(switch local13
					(0
						((ScriptID 31 0) init: 96 167 30 0 2) ; leviCode
					)
					(1
						(if (> (gEgo x:) 135)
							(gMessager say: 0 89 0 0) ; "Levitation could prove useful here, but you're not standing in a very good place for it. Try a different spot."
							(return 1)
						else
							(gCurRoom setScript: sLowerLevitate)
						)
					)
					(5
						(gCurRoom setScript: sAltarLevitate)
					)
					(4
						(gCurRoom setScript: sAltarLevitate)
					)
					(else
						(gMessager say: 0 89 0 0) ; "Levitation could prove useful here, but you're not standing in a very good place for it. Try a different spot."
						(return 1)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 340)
					(gMessager say: 1 1 2) ; "The eerie cave is now alive with pulsing, flowing acid "blood," the slightest touch of which would mean a painful and agonizing death."
				else
					(gMessager say: 1 1 1) ; "You are in an eerie cave that appears to have been formed by red lava. It's a LONG way down to the pits between the narrow passageways."
				)
				(return 1)
			)
			(56 ; theAmulet
				(gMessager say: 0 56 0 0) ; "That won't help you here."
				(return 1)
			)
			(47 ; theBones
				(gMessager say: 0 47 0 0) ; "This is no fit place for a burial."
				(return 1)
			)
			(14 ; theBonsai
				(gMessager say: 0 14 0 0) ; "You should have planted that earlier. It will never survive in this cave."
				(return 1)
			)
			(67 ; theBoneRit
				(gMessager say: 0 67 0 0) ; "This is not the proper place for that Ritual."
				(return 1)
			)
			(69 ; theBloodRit
				(gMessager say: 0 69 0 0) ; "The Blood Ritual must be used on the Altar Head."
				(return 1)
			)
			(70 ; theBreathRit
				(gMessager say: 0 70 0 0) ; "This is not the proper place for that Ritual."
				(return 1)
			)
			(179 ; ???
				(gMessager say: 0 179 0 0) ; "This is not the proper place for that Ritual."
				(return 1)
			)
			(33 ; theGrapnel
				(gMessager say: 0 33 0 0) ; "You missed."
				(return 1)
			)
			(74 ; theHeartRit
				(gMessager say: 0 74 0 0) ; "This is not the proper place for that Ritual."
				(return 1)
			)
			(72 ; theSenseRit
				(gMessager say: 0 72 0 0) ; "This is not the proper place for that Ritual."
				(return 1)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(if (== local13 0)
						(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
					else
						(gMessager say: 0 159 0 0) ; "You can't jump there."
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
				(return 1)
			)
			(60 ; theWillowisp
				(gMessager say: 0 60 0 0) ; "The tiny creature cringes in its flask. It will have nothing to do with this place!"
				(return 1)
			)
			(104 ; Sleep all night
				(gMessager say: 0 104 0 0) ; "To fall asleep here would surely mean your death!"
				(return 1)
			)
			(81 ; detectMagicSpell
				(gMessager say: 0 81 0 0) ; "This entire cave is suffused with dark, eldritch magic. It seems to be entirely formed of water -- or blood -- magic. The strongest enchantment surrounds the stone head on the right side."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (and (== (gCurRoom script:) (ScriptID 31 1)) (>= (gEgo z:) 25)) ; sLevitate
			(= local16 (gEgo z:))
			(gCurRoom setScript: sLevitating)
		)
		(super doit:)
	)

	(method (dispose)
		(gWalkHandler delete: fSteps)
		(gLongSong fade: 0)
		(if script
			(script dispose:)
		)
		(DisposeScript 741)
		(super dispose:)
	)
)

(instance sAltarLevitate of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 2)
			(cond
				((== (gEgo z:) 0)
					(self cue:)
				)
				((== local13 4)
					(gEgo z: (+ (gEgo z:) 1))
					(local17 z: (gEgo z:))
				)
				(else
					(gEgo z: (- (gEgo z:) 1))
					(local17 z: (gEgo z:))
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local13 4)
					(gEgo setMotion: PolyPath 233 51 self)
				else
					(gEgo setMotion: PolyPath 230 76 self)
				)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				((= local17 (Prop new:))
					view: 17
					setLoop: 4 1
					x: (gEgo x:)
					y:
						(if (== local13 4)
							(+ (gEgo y:) 25)
						else
							(+ (gEgo y:) 1)
						)
					setCycle: Fwd
					setScaler:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					priority: (gEgo priority:)
					signal: 16385
					init:
				)
				(= ticks 6)
			)
			(2
				(if (== local13 4)
					(gEgo setLoop: 2 setMotion: JumpTo 230 76 self)
				else
					(gEgo setMotion: JumpTo 233 51 self)
				)
			)
			(3 0)
			(4
				(gEgo trySkill: 29) ; levitateSpell
				(local17 hide: dispose:)
				(if (== local13 4)
					(= local13 5)
					(gCurRoom addObstacle: (altarPoly init: yourself:))
				else
					(= local13 4)
					(gCurRoom addObstacle: (lowerLedgePoly init: yourself:))
				)
				(gEgo normalize:)
				(gLongSong2 stop:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLevitating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local13 1)
				(gEgo
					posn: (gEgo x:) (gEgo y:) local16
					setMotion: JumpTo 107 145 self
				)
			)
			(1
				(gEgo normalize:)
				(gCurRoom addObstacle: (lowerPondPoly init: yourself:))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLowerLevitate of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 3)
			(if (== (gEgo z:) 0)
				(self cue:)
			else
				(gEgo z: (- (gEgo z:) 1))
				(local17 z: (gEgo z:))
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 107 145 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo posn: 107 145)
				((= local17 (Prop new:))
					view: 17
					setLoop: 4 1
					x: (gEgo x:)
					y: (+ (gEgo y:) 1)
					setCycle: Fwd
					setScaler:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					priority: (gEgo priority:)
					signal: 16385
					init:
				)
				(= ticks 6)
			)
			(2
				(gEgo setMotion: JumpTo 96 167 self)
			)
			(3 0)
			(4
				(gEgo trySkill: 29) ; levitateSpell
				(local17 hide: dispose:)
				(= local13 0)
				(gCurRoom addObstacle: (roomPoly init: yourself:))
				(gEgo normalize:)
				(gLongSong2 stop:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doRitual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo use: 53) ; theBloodRit
				(sndDarkRumble play:)
				(gLongSong mute: 0 5)
				(= ticks 280)
			)
			(1
				(if (not (IsFlag 340))
					(gMessager say: 2 69 0 0 self) ; "You unroll the scroll containing the Blood Ritual. The words are visible at last and you begin to perform the Ritual."
				else
					(self cue:)
				)
			)
			(2
				(sndWater play:)
				(= local3 (acidBlood new:))
				(local3
					view: 740
					x: 261
					y: 94
					z: 40
					setLoop: 0 1
					cel: 0
					setPri: 83
					init:
					setCycle: End self
				)
			)
			(3
				(local3 setLoop: 1 1 setCycle: Fwd)
				(= ticks 15)
			)
			(4
				(= local4 (acidBlood2 new:))
				(local4
					view: 740
					x: 221
					y: 97
					setLoop: 2 1
					cel: 0
					init:
					setCycle: End self
				)
			)
			(5
				(local4 setLoop: 3 1 setCycle: Fwd)
				(= ticks 15)
			)
			(6
				(= local6 (bloodProp new:))
				(local6
					view: 740
					x: 261
					y: 156
					signal: 20481
					noun: 17
					setLoop: 6 1
					cel: 0
					init:
					setCycle: End self
				)
			)
			(7
				(local6 setLoop: 7 1 setCycle: Fwd)
				(= ticks 30)
			)
			(8
				(= local7 (bloodProp new:))
				(= local8 (bloodProp new:))
				(= local9 (bloodProp new:))
				(= local10 (bloodProp new:))
				(= local11 (bloodProp new:))
				(local7
					view: 740
					x: 141
					y: 2
					signal: 20481
					noun: 17
					setLoop: 8 1
					cel: 0
					init:
					setCycle: End self
				)
				(local8
					view: 740
					x: 23
					y: 60
					signal: 20481
					noun: 17
					setLoop: 13 1
					cel: 0
					init:
					setCycle: End
				)
				(local10
					view: 740
					x: 203
					y: 153
					setPri: 180
					signal: 20481
					noun: 17
					setLoop: 4 1
					cel: 0
					init:
					setCycle: End
				)
			)
			(9
				(local7 setLoop: 9 1 setCycle: Fwd)
				(local8 setLoop: 14 1 setCycle: Fwd)
				(local9
					view: 744
					setLoop: 5 1
					setCel: 0
					noun: 17
					posn: 266 178
					signal: 20481
					init:
					setCycle: Fwd
				)
				(local11
					view: 744
					setLoop: 11 1
					setCel: 0
					noun: 17
					posn: 168 152
					signal: 20481
					init:
					setCycle: Fwd
				)
				(local10 setLoop: 5 1 setCycle: Fwd)
				(= ticks 30)
			)
			(10
				(if (not (IsFlag 340))
					(gMessager say: 16 6 7 0 self) ; "A thick, putrescent liquid now oozes and flows through the cave. It looks highly corrosive and in general like something you'd best avoid."
					(SetFlag 340)
				else
					(self cue:)
				)
			)
			(11
				(gEgo solvePuzzle: 455 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPullsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local13 0)
					(gEgo setMotion: PolyPath 96 167 self)
				else
					(gEgo setMotion: PolyPath 109 146 self)
				)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo view: 7 setLoop: 4 1 setCel: 0 posn: 109 146)
				(if (== local13 0)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(2
				(if (== local13 0)
					(gCurRoom addObstacle: (lowerPondPoly init: yourself:))
					(= local13 1)
				else
					(gCurRoom addObstacle: (roomPoly init: yourself:))
					(gEgo posn: 100 167)
					(= local13 0)
				)
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJumpThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 15) ; acrobatics
				(= local1 (gEgo cycleSpeed:))
				(cond
					((and (== local13 5) (> (gEgo y:) 74))
						(gEgo setMotion: PolyPath 235 74 self)
					)
					((== local13 0)
						(gMessager say: 5 159 4 0 self) ; "You move as close as you can get to the island, then try a death-defying acrobatic leap towards it."
					)
					((and (== local13 3) local14)
						(gMessager say: 5 159 4 0 self) ; "You move as close as you can get to the island, then try a death-defying acrobatic leap towards it."
					)
					(else
						(self cue:)
					)
				)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
			)
			(1
				(gEgo view: 30 setLoop: 3 1 setCel: 0 setSpeed: 6)
				(switch local13
					(0
						(gEgo setCycle: CT 8 1 setMotion: JumpTo 172 41 self)
					)
					(2
						(gEgo setCycle: CT 8 1 setMotion: JumpTo 146 50 self)
					)
					(3
						(if local14
							(gEgo
								setCycle: CT 8 1
								setMotion: JumpTo 172 41 self
							)
						else
							(gEgo
								setCycle: CT 8 1
								setMotion: JumpTo 233 51 self
							)
						)
					)
					(4
						(if local15
							(gEgo
								setCycle: CT 8 1
								setMotion: JumpTo 208 26 self
							)
						else
							(gEgo
								setCycle: CT 8 1
								setMotion: JumpTo 235 74 self
							)
						)
					)
					(5
						(gEgo setCycle: CT 8 1 setMotion: JumpTo 233 51 self)
					)
					(1
						(gEgo setCycle: CT 8 1 setMotion: JumpTo 96 167 self)
					)
				)
			)
			(2
				(gEgo normalize:)
				(switch local13
					(0
						(= local13 2)
						(gCurRoom addObstacle: (islandPoly init: yourself:))
					)
					(2
						(= local13 0)
						(gCurRoom addObstacle: (roomPoly init: yourself:))
					)
					(3
						(if local14
							(= local14 0)
							(= local13 2)
							(gCurRoom addObstacle: (islandPoly init: yourself:))
						else
							(= local13 4)
							(gCurRoom
								addObstacle: (lowerLedgePoly init: yourself:)
							)
						)
					)
					(4
						(if local15
							(= local15 0)
							(= local13 3)
							(gCurRoom
								addObstacle: (highLedgePoly init: yourself:)
							)
						else
							(= local13 5)
							(gCurRoom addObstacle: (altarPoly init: yourself:))
						)
					)
					(5
						(= local13 4)
						(gCurRoom addObstacle: (lowerLedgePoly init: yourself:))
					)
					(1
						(= local13 0)
						(gCurRoom addObstacle: (roomPoly init: yourself:))
					)
				)
				(= ticks 6)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoYouWanta of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 15) ; acrobatics
				(= local1 (gEgo cycleSpeed:))
				(gMessager say: 6 159 3 1 self) ; "The upper shelf looks pretty distant. It would take an incredible feat of acrobatics to make it from here. You're not sure if you can make it or not."
			)
			(1
				(gGlory handsOn:)
				(if
					(= temp0
						(Print
							addText: 6 159 3 2 0 0 740 ; "Do you really want to make the attempt?"
							addButton: 1 16 6 17 1 20 55 740 ; "Yes"
							addButton: 0 16 6 18 1 100 55 740 ; "No"
							init:
						)
					)
					(self cue:)
				else
					(self setScript: sJumpThere)
				)
			)
			(2
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(if (== (gEgo trySkill: 2 300) 1) ; agility
					(gEgo
						view: 30
						setLoop: 3 1
						setCel: 0
						setSpeed: 6
						setCycle: CT 8 1
						setMotion: JumpTo 208 26 self
					)
				else
					(self setScript: (ScriptID 741 2)) ; sFallsBoom
				)
			)
			(3
				(gEgo normalize:)
				(= local13 3)
				(gCurRoom addObstacle: (highLedgePoly init: yourself:))
				(= ticks 6)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoOnUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 (gEgo cycleSpeed:))
				(= local2 (gEgo moveSpeed:))
				(if (< (gEgo y:) 130)
					(= local18 1)
					(gEgo setMotion: PolyPath 225 118 self)
				else
					(= local18 0)
					(gEgo setMotion: PolyPath 210 155 self)
				)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local24 gEgoGait)
				(if local18
					(gEgo
						changeGait: 1 ; running
						moveSpeed: 6
						cycleSpeed: 6
						setLoop: 0 1
						setMotion: MoveTo 247 118 self
					)
				else
					(gEgo
						changeGait: 1 ; running
						moveSpeed: 6
						cycleSpeed: 6
						setMotion: MoveTo 222 146 self
					)
				)
			)
			(2
				(if local18
					(self cue:)
				else
					(gEgo setMotion: MoveTo 247 140 self)
				)
			)
			(3
				(if local18
					(self cue:)
				else
					(gEgo setMotion: MoveTo 257 129 self)
				)
			)
			(4
				(gEgo setMotion: MoveTo 271 119 self)
			)
			(5
				(gEgo setMotion: MoveTo 293 113 self)
			)
			(6
				(gEgo setLoop: 1 1 setMotion: MoveTo 269 104 self)
			)
			(7
				(gEgo setLoop: 0 1 setMotion: MoveTo 289 96 self)
			)
			(8
				(gEgo setLoop: 1 1 setMotion: MoveTo 280 85 self)
			)
			(9
				(gEgo
					moveSpeed: local2
					cycleSpeed: local1
					changeGait: local24
					normalize:
					setMotion: MoveTo 244 87 self
				)
			)
			(10
				(gCurRoom addObstacle: (altarPoly init: yourself:))
				(= local13 5)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 (gEgo cycleSpeed:))
				(= local2 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 280 85 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local24 gEgoGait)
				(gEgo
					changeGait: 1 ; running
					moveSpeed: 6
					cycleSpeed: 6
					setLoop: 0 1
					setMotion: MoveTo 289 96 self
				)
			)
			(2
				(gEgo setLoop: 1 1 setMotion: MoveTo 269 104 self)
			)
			(3
				(gEgo setLoop: 0 1 setMotion: MoveTo 293 113 self)
			)
			(4
				(gEgo setLoop: 1 1 setMotion: MoveTo 271 119 self)
			)
			(5
				(if local18
					(self cue:)
				else
					(gEgo setMotion: MoveTo 257 129 self)
				)
			)
			(6
				(if local18
					(self cue:)
				else
					(gEgo setMotion: MoveTo 247 140 self)
				)
			)
			(7
				(if local18
					(gEgo setMotion: MoveTo 247 118 self)
				else
					(gEgo setMotion: MoveTo 222 146 self)
				)
			)
			(8
				(if local18
					(gEgo setMotion: MoveTo 225 118 self)
				else
					(gEgo setMotion: MoveTo 210 155 self)
				)
			)
			(9
				(gCurRoom addObstacle: (lowerPondPoly init: yourself:))
				(if local18
					(gEgo
						moveSpeed: local2
						cycleSpeed: local1
						changeGait: local24
						normalize:
						setMotion: PolyPath (- (gEgo x:) 2) 118 self
					)
				else
					(gEgo
						moveSpeed: local2
						cycleSpeed: local1
						changeGait: local24
						normalize:
						setMotion: PolyPath (- (gEgo x:) 2) 155 self
					)
				)
			)
			(10
				(gEgo normalize:)
				(if
					(and
						(IsFlag 340)
						(not local23)
						(== (acidBlood2 script:) sLowerTimer)
					)
					(gMessager say: 16 6 20 0 self) ; "You've reached the end of the path -- if you go any farther this way, you'll fall into the acid pool."
				else
					(self cue:)
				)
			)
			(11
				(= local13 1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch local19
					(0
						(self setScript: (ScriptID 32) self 21) ; project
					)
					(1
						(if (== (gEgo has: 5) 1) ; theThrowdagger
							(gMessager say: 16 6 25) ; "You are down to your last dagger. You'd better hold on to it."
						else
							(gEgo use: 5) ; theThrowdagger
							(self setScript: (ScriptID 32) self 37) ; project
						)
					)
					(2
						(self setScript: (ScriptID 32) self 86) ; project
					)
					(3
						(self setScript: (ScriptID 32) self 88) ; project
					)
					(5
						(self setScript: (ScriptID 32) self 93) ; project
					)
					(4
						(self setScript: (ScriptID 32) self 79) ; project
					)
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(switch local19
					(0
						(gMessager say: 2 21 0 0 self) ; "The Altar remains unmarked."
					)
					(1
						(gMessager say: 2 37 0 0 self) ; "The Altar remains unmarked."
					)
					(2
						(gMessager say: 2 86 0 0 self) ; "Your spells have no effect on the Altar."
					)
					(3
						(gMessager say: 2 88 0 0 self) ; "Your spells have no effect on the Altar."
					)
					(5
						(gMessager say: 2 93 0 0 self) ; "Your spells have no effect on the Altar."
					)
					(4
						(gMessager say: 2 79 0 0 self) ; "Your spells have no effect on the Altar."
					)
				)
			)
			(3
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowTheGrapnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 10) ; throwing
				(gEgo trySkill: 11) ; climbing
				(gEgo setMotion: PolyPath 207 80 self)
			)
			(1
				(gEgo
					view: 8
					posn: 213 80
					setLoop: 2 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(pGrapnel init: setCycle: End self)
				(gEgo setLoop: 7 1 setCel: 0 posn: 212 79 setCycle: End)
			)
			(3
				(gEgo normalize: setMotion: PolyPath 229 77 self)
			)
			(4
				(gEgo view: 7 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(5
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local13 4)
				(gEgo setLoop: 4 1 setCel: 0 posn: 224 49 setCycle: End self)
			)
			(6
				(gCurRoom addObstacle: (lowerLedgePoly init: yourself:))
				(gEgo normalize: setMotion: PolyPath 235 49 self)
			)
			(7
				(gEgo view: 4 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(8
				(pGrapnel hide: dispose:)
				(= ticks 60)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local13 5)
				(gEgo trySkill: 11) ; climbing
				(gEgo setMotion: PolyPath 224 49 self)
			)
			(1
				(gEgo view: 7 setLoop: 4 1 setCel: 11 setCycle: Beg self)
			)
			(2
				(pGrapnel hide: dispose:)
				(gCurRoom addObstacle: (altarPoly init: yourself:))
				(gEgo posn: 222 77 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 209 47 self)
			)
			(1
				(gEgo trySkill: 0) ; strength
				(= local23 1)
				(Face gEgo (aRock x:) (aRock y:) self)
			)
			(2
				(aRock
					setStep: 10 10
					ignoreActors: 1
					setMotion: MoveTo 218 90 self
				)
			)
			(3
				(aRock setPri: 75 setMotion: MoveTo 218 98 self)
			)
			(4
				(aRock hide: dispose:)
				(local4 view: 744 setLoop: 1 1 setCycle: End)
				(= seconds 1)
			)
			(5
				(local6 view: 744 setLoop: 3 1 setCycle: End)
				(local9 setLoop: 6 1 setCycle: End)
				(local10 setLoop: 5 setCycle: End)
				(local11 setLoop: 12 1 setCycle: End)
				(= seconds 1)
			)
			(6
				(local6 hide: dispose:)
				(local9 hide: dispose:)
				(local10 hide: dispose:)
				(local11 hide: dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpperTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 9)
				(if local12
					(gEgo setScript: (ScriptID 32 0) self 86) ; project
				else
					(= local25 1)
					(gEgo setScript: (ScriptID 32 0) self 79) ; project
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(if local12
					(gMessager say: 17 86 0 0 self) ; "The "blood" is already boiling; your spell has no further effect."
				else
					(= local20 1)
					(local3 setCycle: 0 signal: (& (local3 signal:) $fffe))
					(local4 setCycle: 0 signal: (& (local4 signal:) $fffe))
					(local6 setCycle: 0 signal: (& (local6 signal:) $fffe))
					(local9 setCycle: 0 signal: (& (local9 signal:) $fffe))
					(local10 setCycle: 0 signal: (& (local10 signal:) $fffe))
					(local11 setCycle: 0 signal: (& (local11 signal:) $fffe))
					(self cue:)
				)
			)
			(3
				(if local12
					(= local12 0)
					(self dispose:)
				else
					(gMessager say: 16 6 11 0 self) ; "Your spell has temporarily stopped the flow of acid here."
				)
			)
			(4
				(gGlory handsOn:)
				(ClearFlag 9)
				(= seconds 20)
			)
			(5
				(= local20 0)
				(local3 setCycle: Fwd signal: (| (local3 signal:) $0001))
				(= ticks 6)
			)
			(6
				(gMessager say: 16 6 12 0 self) ; "The frozen acid has thawed and is beginning to flow again."
			)
			(7
				(gMessager say: 16 6 21 0 self) ; "The acid here won't stay frozen with fresh hot acid "blood" flowing into it."
			)
			(8
				(= local25 0)
				(acidBlood2 setScript: 0)
				(local4 setCycle: Fwd signal: (| (local4 signal:) $0001))
				(local6 show: setCycle: Fwd signal: (| (local6 signal:) $0001))
				(local9 setCycle: Fwd signal: (| (local9 signal:) $0001))
				(local10 setCycle: Fwd signal: (| (local10 signal:) $0001))
				(local11 setCycle: Fwd signal: (| (local11 signal:) $0001))
				(= ticks 6)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance sBurnedUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (not (IsFlag 340)) local23 local25)
					(self dispose:)
				else
					(gGlory handsOff:)
					(gEgo setPri: 0 setMotion: 0)
					(= ticks 30)
				)
			)
			(1
				(EgoDead 8 0 960 1)
			)
		)
	)
)

(instance sLowerTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 9)
				(if local12
					(gEgo setScript: (ScriptID 32 0) self 86) ; project
				else
					(= local25 1)
					(gEgo setScript: (ScriptID 32 0) self 79) ; project
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(if local12
					(gMessager say: 17 86 0 0 self) ; "The "blood" is already boiling; your spell has no further effect."
				else
					(acidBlood2 setCycle: 0)
					(local6 hide: setCycle: 0)
					(local11 hide:)
					(local10 hide:)
					(local9 hide:)
					(self cue:)
				)
			)
			(3
				(cond
					(local12
						(= local12 0)
						(self dispose:)
					)
					((not local20)
						(gMessager say: 16 6 21 0 self) ; "The acid here won't stay frozen with fresh hot acid "blood" flowing into it."
					)
					(else
						(gMessager say: 16 6 11 0 self) ; "Your spell has temporarily stopped the flow of acid here."
					)
				)
			)
			(4
				(gGlory handsOn:)
				(ClearFlag 9)
				(if (not local20)
					(= seconds 1)
				else
					(= seconds 15)
				)
			)
			(5
				(local4 setCycle: Fwd)
				(local6 show: setCycle: Fwd)
				(= local25 0)
				(local11 show:)
				(local10 show:)
				(local9 show:)
				(= ticks 6)
			)
			(6
				(if local20
					(gMessager say: 16 6 12 0 self) ; "The frozen acid has thawed and is beginning to flow again."
				else
					(self cue:)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance aRock of Actor
	(properties
		noun 12
		x 209
		y 57
		z 10
		view 741
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(if (== local13 5)
					(gCurRoom setScript: sThrowTheGrapnel)
				else
					(gMessager say: 7 159 3) ; "It's too far away."
				)
			)
			(4 ; Do
				(if (== local13 4)
					(if (IsFlag 340)
						(switch gHeroType
							(0 ; Fighter
								(gCurRoom setScript: sPushRock)
							)
							(3 ; Paladin
								(gCurRoom setScript: sPushRock)
							)
							(else
								(gMessager say: 12 4 0 0) ; "You can't budge it."
							)
						)
					else
						(gMessager say: 16 6 22) ; "You better not push the rock now. You may need to push it later."
					)
				else
					(gMessager say: 7 159 3) ; "It's too far away."
				)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(switch local13
						(3
							(gCurRoom setScript: sJumpThere)
						)
						(5
							(gCurRoom setScript: sJumpThere)
						)
						(4
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(else
							(gMessager say: 7 4 3) ; "It's too far away."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance acidBlood of Prop
	(properties
		noun 17
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; frostSpell
				(if local23
					(gMessager say: 16 6 26) ; "You don't need to do that. The blood can't harm you now."
				else
					(self setScript: sUpperTimer)
				)
			)
			(86 ; flameDartSpell
				(= local12 1)
				(self setScript: sUpperTimer)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance acidBlood2 of Prop
	(properties
		noun 17
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; frostSpell
				(if local23
					(gMessager say: 16 6 26) ; "You don't need to do that. The blood can't harm you now."
				else
					(self setScript: sLowerTimer)
				)
			)
			(86 ; flameDartSpell
				(= local12 1)
				(self setScript: sLowerTimer)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pGrapnel of Prop
	(properties
		x 222
		y 70
		view 8
		loop 6
		cel 7
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScaler: Scaler 51 38 73 52)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 340)
				(if local23
					(gCurRoom setScript: sClimbDown)
				else
					(gMessager say: 16 6 19) ; "Leave your rope there for now; you'll need it to get back down."
				)
			else
				(gCurRoom setScript: sClimbDown)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bloodProp of Prop
	(properties
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 79) ; frostSpell
			(gMessager say: 17 79 10) ; "There is too much "blood" near you for the Frostbite spell to affect it. The blood just keeps flowing and flowing."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance torchEff of Prop
	(properties
		view 775
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= z (+ (gEgo z:) 1))
		(super doit: &rest)
	)
)

(instance altarHead of Feature
	(properties
		noun 2
		nsLeft 248
		nsTop 13
		nsRight 308
		nsBottom 66
		x 278
		y 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(69 ; theBloodRit
				(switch local13
					(5
						(if (or (not (IsFlag 340)) (gEgo has: 53)) ; theBloodRit
							(gCurRoom setScript: doRitual)
						else
							(gMessager say: 17 4 0 0) ; "From the way the "blood" is gouging new channels in the rock, you suspect that touching it would probably be your last action."
						)
					)
					(else
						(gMessager say: 7 4 3) ; "It's too far away."
					)
				)
			)
			(4 ; Do
				(switch local13
					(5
						(gMessager say: 2 4 0 0) ; "The Altar feels strangely warm to your touch, but leaves a deeper chill somewhere within you."
					)
					(else
						(gMessager say: 5 4 3) ; "It feels pretty solid (and rather stone-like)."
					)
				)
			)
			(79 ; frostSpell
				(= local19 4)
				(gCurRoom setScript: sThrowIt)
			)
			(86 ; flameDartSpell
				(= local19 2)
				(gCurRoom setScript: sThrowIt)
			)
			(88 ; forceBoltSpell
				(= local19 3)
				(gCurRoom setScript: sThrowIt)
			)
			(93 ; lightningBallSpell
				(= local19 5)
				(gCurRoom setScript: sThrowIt)
			)
			(21 ; theRocks
				(gEgo use: 6) ; theRocks
				(= local19 0)
				(gCurRoom setScript: sThrowIt)
			)
			(37 ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 16 6 25) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(gEgo use: 5) ; theThrowdagger
					(= local19 1)
					(gCurRoom setScript: sThrowIt)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance altarBowl of Feature
	(properties
		noun 3
		nsLeft 246
		nsTop 71
		nsRight 278
		nsBottom 81
		x 262
		y 76
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1 0 0) ; "A bowl set beneath the Altar is partly filled with the still-viscous blood of many past victims. You can see black stains on the sides of the bowl, grim relics of Dark Priests with bad aim."
			)
			(else
				(altarHead doVerb: theVerb)
			)
		)
	)
)

(instance altarBase of Feature
	(properties
		noun 4
		nsLeft 197
		nsTop 72
		nsRight 308
		nsBottom 93
		x 252
		y 72
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch local13
					(4
						(gCurRoom setScript: sJumpThere)
					)
					(1
						(gCurRoom setScript: sGoOnUp)
					)
					(5
						(gMessager say: 2 4 0 0) ; "The Altar feels strangely warm to your touch, but leaves a deeper chill somewhere within you."
					)
					(else
						(gMessager say: 7 4 3) ; "It's too far away."
					)
				)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(switch local13
						(4
							(= local15 0)
							(gCurRoom setScript: sJumpThere)
						)
						(5
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(else
							(gMessager say: 7 4 3) ; "It's too far away."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance island of Feature
	(properties
		noun 5
		nsLeft 151
		nsTop 36
		nsRight 188
		nsBottom 54
		approachX 170
		approachY 42
		x 169
		y 45
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 1 10 4) ; Do, Look, Jump, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(gMessager say: 6 33 0 0) ; "You don't see a good place there to catch with the grapnel."
			)
			(4 ; Do
				(if (== local13 2)
					(gMessager say: 5 4 3) ; "It feels pretty solid (and rather stone-like)."
				else
					(gMessager say: 5 4 0 0) ; "You can't reach the island from here."
				)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(switch local13
						(0
							(gCurRoom setScript: sJumpThere)
						)
						(3
							(= local14 1)
							(gCurRoom setScript: sJumpThere)
						)
						(2
							(gMessager say: 5 159 3) ; "That would be considerably less impressive now that you're already on the island."
						)
						(else
							(gMessager say: 5 159 0 0) ; "You don't think you can make it that far. You'll have to approach a little closer to the island before trying such a feat."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperShelf of Feature
	(properties
		noun 6
		nsLeft 180
		nsTop 19
		nsRight 249
		nsBottom 37
		x 214
		y 28
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 63 39 86 39 85 48 63 47
						yourself:
					)
					6
					7
					3
					(ScriptID 741 0) ; sLeaveThisRoom
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(gMessager say: 6 33 0 0) ; "You don't see a good place there to catch with the grapnel."
			)
			(4 ; Do
				(gMessager say: 7 4 3) ; "It's too far away."
			)
			(1 ; Look
				(switch local13
					(2
						(gCurRoom setScript: sDoYouWanta)
					)
					(3
						(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
					)
					(else
						(gMessager say: 7 4 3) ; "It's too far away."
					)
				)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(switch local13
						(2
							(gCurRoom setScript: sDoYouWanta)
						)
						(3
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(4
							(= local15 1)
							(gCurRoom setScript: sJumpThere)
						)
						(else
							(gMessager say: 7 4 3) ; "It's too far away."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance lowerShelf of Feature
	(properties
		noun 7
		nsLeft 191
		nsTop 44
		nsRight 248
		nsBottom 62
		x 219
		y 53
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(if (== local13 5)
					(gCurRoom setScript: sThrowTheGrapnel)
				else
					(gMessager say: 7 159 3) ; "It's too far away."
				)
			)
			(4 ; Do
				(switch local13
					(3
						(gCurRoom setScript: sJumpThere)
					)
					(5
						(gCurRoom setScript: sJumpThere)
					)
					(4
						(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
					)
					(else
						(gMessager say: 7 4 3) ; "It's too far away."
					)
				)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(switch local13
						(3
							(gCurRoom setScript: sJumpThere)
						)
						(5
							(gCurRoom setScript: sJumpThere)
						)
						(4
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(else
							(gMessager say: 7 4 3) ; "It's too far away."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bridge of Feature
	(properties
		noun 8
		nsTop 74
		nsRight 67
		nsBottom 135
		x 33
		y 104
	)
)

(instance bridgeLedge of Feature
	(properties
		noun 9
		nsTop 29
		nsRight 57
		nsBottom 45
		x 28
		y 37
	)
)

(instance spoutPillar of Feature
	(properties
		noun 10
		nsLeft 89
		nsRight 127
		nsBottom 50
		x 108
	)
)

(instance roomExit of Feature
	(properties
		noun 11
		nsLeft 65
		nsTop 22
		nsRight 89
		nsBottom 45
		x 77
		y 33
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 455)
				(super doVerb: theVerb)
			else
				(gMessager say: 11 4 24 0) ; "The exit seems to be magically sealed, solid stone once more. You will need to perform the appropriate ritual to open it again."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rock of Feature
	(properties
		noun 12
		nsLeft 146
		nsTop 130
		nsRight 171
		nsBottom 154
		sightAngle 180
		x 158
		y 142
	)
)

(instance littleLedge of Feature
	(properties
		noun 13
		nsLeft 147
		nsTop 62
		nsRight 164
		nsBottom 72
		x 155
		y 67
	)
)

(instance lowLedge of Feature
	(properties
		noun 14
		nsLeft 216
		nsTop 173
		nsRight 285
		nsBottom 189
		x 250
		y 181
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 7 4 3) ; "It's too far away."
			)
			(10 ; Jump
				(gMessager say: 7 4 3) ; "It's too far away."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fLowerHold of Feature
	(properties
		noun 1
		nsLeft 90
		nsTop 130
		nsRight 140
		nsBottom 158
		approachX 103
		approachY 166
		x 94
		y 95
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local13 0)
					(gCurRoom setScript: sPullsUp)
				else
					(gMessager say: 7 4 3) ; "It's too far away."
				)
			)
			(10 ; Jump
				(switch local13
					(1
						(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
					)
					(else
						(gMessager say: 7 4 3) ; "It's too far away."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fUpperPath of Feature
	(properties
		noun 1
		nsLeft 126
		nsTop 48
		nsRight 151
		nsBottom 56
		x 126
		y 48
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 135 141 147 141 147 152 135 152
						yourself:
					)
					7
					5
					1
					sBurnedUp
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(switch local13
						(2
							(gCurRoom setScript: sJumpThere)
						)
						(0
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(1
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(else
							(gMessager say: 7 4 3) ; "It's too far away."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fLowerPath of Feature
	(properties
		noun 1
		nsLeft 82
		nsTop 164
		nsRight 122
		nsBottom 185
		x 82
		y 164
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 208 117 221 117 222 126 209 126
						yourself:
					)
					1
					7
					5
					sBurnedUp
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch local13
					(1
						(gCurRoom setScript: sPullsUp)
					)
					(0
						(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
					)
					(else
						(gMessager say: 7 4 3) ; "It's too far away."
					)
				)
			)
			(10 ; Jump
				(if (> [gEgoStats 2] 0) ; agility
					(cond
						((and (== local13 1) (== (gEgo trySkill: 2 200) 1)) ; agility
							(gCurRoom setScript: sJumpThere)
						)
						((== local13 0)
							(gMessager say: 0 159 23) ; "Why jump there when you can walk?"
						)
						(else
							(gMessager say: 7 4 3) ; "It's too far away."
						)
					)
				else
					(gMessager say: 5 1 0 0) ; "An "island" ledge looks as though it could be reachable by a skilled acrobat; the attempt would be death to anyone else."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSteps of Feature
	(properties
		noun 1
		x 246
		y 92
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 307 95 300 122 246 147 232 138 256 117 254 105 280 92
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (== (event message:) JOY_RIGHT) (self onMe: event))
			(event claimed: 1)
			(switch local13
				(1
					(gCurRoom setScript: sGoOnUp)
				)
				(5
					(gCurRoom setScript: sGoDown)
				)
				(else
					(event claimed: 0)
					(super handleEvent: event &rest)
				)
			)
		else
			(event claimed: 0)
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch local13
					(1
						(gCurRoom setScript: sGoOnUp)
					)
					(5
						(gCurRoom setScript: sGoDown)
					)
					(else
						(gCurRoom doVerb: theVerb)
					)
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance roomPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super
			init: 70 47 45 51 45 55 104 63 104 67 49 91 33 112 11 140 23 161 64 170 106 169 109 167 108 166 62 166 30 152 35 147 23 137 75 89 126 70 131 65 126 55 145 54 146 50 103 54 77 48 77 0 319 0 319 189 0 189 0 0 70 0
		)
	)
)

(instance lowerPondPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 94 138 108 147 128 147 143 143 173 157 193 156 213 158 208 153 171 153 143 141 127 145 108 145 98 138 98 134 132 133 147 129 153 124 241 127 256 123 252 118 222 116 202 121 152 121 140 129 131 128 94 132
		)
	)
)

(instance islandPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 159 42 170 43 183 43 180 40)
	)
)

(instance highLedgePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 188 25 201 27 237 27 236 22)
	)
)

(instance lowerLedgePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 202 48 208 50 248 50 245 46)
	)
)

(instance altarPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 245 74 225 74 215 76 199 79 199 82 208 87 257 89 267 86 276 87 292 84 300 81 292 80 287 83 280 85 274 83 265 84 250 87 209 85 201 81 226 76 244 76
		)
	)
)

(instance sndDarkRumble of Sound
	(properties
		number 202
	)
)

(instance sndWater of Sound
	(properties
		number 982
		loop -1
	)
)

