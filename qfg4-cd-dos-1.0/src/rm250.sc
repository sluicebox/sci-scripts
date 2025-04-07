;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm250 of GloryRm
	(properties
		picture 250
		east 280
		south 260
	)

	(method (init)
		(= local2
			(cond
				((and (IsFlag 41) (== gPrevRoomNum 360)) 0)
				((and (not (IsFlag 48)) (or (IsFlag 37) (IsFlag 38))) 4)
				((and (not (IsFlag 76)) (IsFlag 48)) 5)
				((and (IsFlag 76) (>= gDay (+ global415 1))) 6)
				((and (IsFlag 74) (IsFlag 75) (>= gDay (+ global415 1))) 3)
				(
					(or
						(and
							(>= gDay (+ global415 1))
							(IsFlag 74)
							(not (IsFlag 75))
						)
						(and (IsFlag 74) (IsFlag 75) (== global415 gDay))
					)
					2
				)
				(
					(or
						(== global415 0)
						(and
							(IsFlag 74)
							(not (IsFlag 75))
							(== global415 gDay)
						)
					)
					1
				)
				(else 7)
			)
		)
		(if (not (OneOf gPrevRoomNum 280 260))
			(gLongSong number: 250 setLoop: -1 play:)
		)
		(Palette 2 66 85 100) ; PalIntensity
		(gEgo
			init:
			normalize:
			posn: 335 240
			setScaler: Scaler 100 79 176 132
		)
		(((ScriptID 6 0) new:) ; eFeatureR
			nsLeft: 289
			nsTop: 30
			nsBottom: 173
			nsRight: 319
			approachX: 319
			approachY: 155
			init:
		)
		(guildDoor init: setPri: 0 approachVerbs: 4 42 29 80) ; Do, theToolkit, theKeyRing, openSpell
		(guildWin init: approachVerbs: 4) ; Do
		(guildTopWin init: approachVerbs: 4) ; Do
		(guildWall init: approachVerbs: 4) ; Do
		(tombStone init: approachVerbs: 4) ; Do
		(archway init: approachVerbs: 4) ; Do
		(if
			(or
				(and (<= gTime 3) (not (OneOf local2 0 4)))
				(and
					(== local2 0)
					(<= gTime 3)
					(not
						(and (not (IsFlag 48)) (or (IsFlag 37) (IsFlag 38)))
					)
				)
			)
			(igor init: approachVerbs: 4 2 setScript: sIgorCarve) ; Do, Talk
			(stone init: approachVerbs: 4) ; Do
			(shovel init: approachVerbs: 4) ; Do
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 144 212 182 78 133 50 136 36 150 4 150 4 171 156 171 174 189 10 189 0 189
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 144 212 182 78 133 50 136 4 150 4 171 156 171 174 189 10 189 0 189
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(260
				(gEgo posn: 265 240)
				(= local0 216)
				(= local1 187)
			)
			(280
				(gEgo posn: 335 140)
				(= local0 293)
				(= local1 162)
			)
			(360
				(if (IsFlag 328)
					(gEgo
						view: 7
						setLoop: 3 1
						cel: 0
						posn: 135 126
						setScaler: Scaler 89 60 150 120
					)
				else
					(gEgo posn: 203 187 setPri: 51)
					(monkDoor setCel: (monkDoor lastCel:))
				)
			)
			(else
				(gEgo posn: 172 178)
			)
		)
		(if (IsFlag 41)
			(burnFeature init: approachVerbs: 4 33) ; Do, theGrapnel
			(if (== gPrevRoomNum 360)
				(monkDoor init: setPri: 17 approachVerbs: 4 28 42 29 43) ; Do, theLockpick, theToolkit, theKeyRing, theDarksign
				(fire1 init: setCycle: Fwd)
				(fire2 init: setCycle: Fwd)
			else
				(burntRemains init: setPri: 0 approachVerbs: 4 33) ; Do, theGrapnel
				(burntRemains1 init: setPri: 0 approachVerbs: 4 33) ; Do, theGrapnel
				(burntRemains2 init: setPri: 0 approachVerbs: 4 33) ; Do, theGrapnel
				(burntRemains3 init: setPri: 0 approachVerbs: 4 33) ; Do, theGrapnel
			)
		else
			(monkDoor init: setPri: 17 approachVerbs: 4 28 42 29 43) ; Do, theLockpick, theToolkit, theKeyRing, theDarksign
			(monkWall1 init: approachVerbs: 4 33) ; Do, theGrapnel
			(monkWall2 init: approachVerbs: 4 33) ; Do, theGrapnel
			(monkHighWin init: approachVerbs: 4) ; Do
			(hectMidLtArm init: approachVerbs: 4) ; Do
			(hectMidRtArm init: approachVerbs: 4) ; Do
			(hectLtArm init: approachVerbs: 4) ; Do
			(hectRtArm init: approachVerbs: 4) ; Do
			(monkWin1 init: approachVerbs: 4 33) ; Do, theGrapnel
			(monkWin2 init: approachVerbs: 4 33) ; Do, theGrapnel
			(hectapus init: approachVerbs: 4) ; Do
		)
		(super init: &rest)
		(if (gCast contains: igor)
			(heroTeller
				init:
					gEgo
					250
					16
					128
					(switch local2
						(0 19)
						(1 12)
						(2 11)
						(3 14)
						(5 15)
						(6 13)
					)
			)
		)
		(switch gPrevRoomNum
			(260
				(self setScript: sEnter)
			)
			(280
				(self setScript: sEnter)
			)
			(350
				(self setScript: sOutGuildDoor)
			)
			(360
				(if (IsFlag 328)
					(self setScript: sClimbOutMonks)
				else
					(self setScript: sExitMonks)
				)
			)
			(else
				(gGlory handsOn:)
			)
		)
		(if (not (IsFlag 41))
			(gGlory save: 1)
		)
	)

	(method (doit)
		(if
			(and
				(== (gCurRoom script:) (ScriptID 31 1)) ; sLevitate
				(>= (gEgo z:) 25)
				(not (IsFlag 41))
			)
			(gCurRoom setScript: sLevitateInMonks)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; levitateSpell
				(if gNight
					((ScriptID 31 0) init: 139 156 35 0 3) ; leviCode
				else
					(gMessager say: 18 6 34) ; "Somebody might see you if you try this during the day!"
				)
			)
			(181 ; ???
				(gMessager say: 0 181 0) ; MISSING MESSAGE
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 360 350)
			(gLongSong fade: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(cond
					((and (== local2 5) (gCast contains: igor))
						(SetFlag 76)
						(gMessager say: 17 6 18 0 self) ; "Igor very glad not to still be in grave. You Igor's friend now."
					)
					(
						(and
							(gCast contains: igor)
							(not (IsFlag 77))
							(not gNight)
						)
						(SetFlag 77)
						(= local6 1)
						(gMessager say: 18 6 16 0 self) ; "As you enter the northern part of town, you hear the sound of a chisel chipping away at a stone block. A man is carving gravestones at one end of the street."
					)
					((and (not (IsFlag 78)) gNight)
						(SetFlag 78)
						(= local6 1)
						(gMessager say: 18 6 17 0 self) ; "The stone carvings on the dark building seem to writhe in the moonlight. You get the feeling that they are hungry and waiting for something... or someone."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if (and local6 (== gHeroType 3)) ; Paladin
					(= local6 0)
					(gMessager say: 18 6 83 0 self) ; "A sense of great danger and hunger comes from near the door of the massive stone building."
				else
					(= cycles 1)
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 gEgoGait)
				(gEgo changeGait: 0 setMotion: MoveTo 187 183 self) ; walking
			)
			(1
				(gEgo setMotion: MoveTo 211 175 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gMessager say: 18 6 82 0 self) ; "You retrieve the Dark One Sign from the monastery door, then quickly step away before the hectapus can react."
			)
			(4
				(gEgo get: 25) ; theDarksign
				(monkDoor setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 961 loop: 1 play:)
				(gEgo
					setPri: -1
					changeGait: local5
					setMotion: MoveTo 210 180 self
				)
			)
			(6
				(if
					(and
						(IsFlag 41)
						(== gPrevRoomNum 360)
						(gCast contains: igor)
					)
					(gMessager say: 17 6 9 0 self) ; "If Igor get big Hero job, can he be pyromaniac too?"
				else
					(= cycles 1)
				)
			)
			(7
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 gEgoGait)
				(gEgo changeGait: 0 setMotion: MoveTo 211 175 self) ; walking
			)
			(1
				(gEgo setPri: 51 setMotion: MoveTo 187 183 self)
			)
			(2
				(gEgo setMotion: MoveTo 203 187 self)
			)
			(3
				(gEgo changeGait: local5 setHeading: 0 self)
			)
			(4
				(gEgo drop: 25) ; theDarksign
				(gMessager say: 6 43 0 0 self) ; "You push the Dark One Sign into the indentation on the door. It fits perfectly!"
			)
			(5
				(gLongSong2 number: 960 loop: 1 play:)
				(monkDoor setCycle: End self)
			)
			(6
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sIgorWarn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setHeading: 0)
				(igor loop: 1 cel: 1 setScript: 0)
				(= seconds 2)
			)
			(1
				(igor loop: 2 setCycle: End self)
			)
			(2
				(igor loop: 3 setCycle: Fwd)
				(= seconds 2)
			)
			(3
				(= local3 1)
				(Face gEgo (igor x:) (igor y:) self)
			)
			(4
				(gMessager say: 17 6 7 0 self) ; "Bad place. Very Bad Place. Go away. You be very sorry."
			)
			(5
				(igor cycleSpeed: 10)
				(= seconds 1)
			)
			(6
				(igor setCycle: End self)
			)
			(7
				(igor loop: 2 cel: 5)
				(= seconds 2)
			)
			(8
				(igor setCycle: Beg self)
			)
			(9
				(igor setScript: sIgorCarve)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sIgorCarve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(igor loop: 1 cel: 1)
				(= seconds 4)
			)
			(1
				(igor loop: 0 setCycle: Fwd)
				(= seconds (Random 3 15))
			)
			(2
				(igor setCycle: 0 loop: 1 cel: 1)
				(= seconds (Random 1 4))
			)
			(3
				(= state 0)
				(= cycles 1)
			)
		)
	)
)

(instance sInGuildDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 108)
				(gLongSong2 number: 960 loop: 1 play:)
				(guildDoor setCycle: End self)
			)
			(1
				(gEgo setPri: 17 setMotion: MoveTo 35 128 self)
			)
			(2
				(guildDoor setCycle: Beg self)
			)
			(3
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 2)
			)
			(4
				(gEgo setPri: -1)
				(gGlory handsOn:)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance sOutGuildDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo loop: 0 posn: 35 128 setPri: 17)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 960 loop: 1 play:)
				(guildDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 81 138 self)
			)
			(3
				(gEgo setPri: -1)
				(guildDoor setCycle: Beg self)
			)
			(4
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 2)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHectapusDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 gEgoGait)
				(gEgo changeGait: 0 setMotion: MoveTo 211 175 self) ; walking
			)
			(1
				(gEgo setPri: 55 setMotion: MoveTo 187 183 self)
				(hectIncidental loop: 0 cel: 0 init: setCycle: End self)
			)
			(2 0)
			(3
				(gEgo setLoop: 3 1)
				(hectIncidental loop: 1 posn: 180 96 setCycle: Fwd)
				(= seconds 1)
			)
			(4
				(if (and (gCast contains: igor) (< (igor loop:) 2))
					(igor setLoop: 2 1 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(5
				(hectMidLtArm setCycle: Fwd)
				(hectMidRtArm setCycle: Fwd)
				(hectLtArm setCycle: End)
				(hectRtArm setCycle: End self)
			)
			(6
				(if (gCast contains: igor)
					(gMessager say: 17 6 8 0 self) ; "Nobody ever listen to Igor."
				else
					(= cycles 1)
				)
			)
			(7
				(EgoDead 33 250 978 1 912) ; "That hectapus has had the munchies ever since it got "stoned." Fortunately for it (but not for you), it occasionally gets its meals delivered right to the door."
			)
		)
	)
)

(instance sClimbIntoMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 328)
				(gMessager say: 18 6 13 0 self) ; "You find a good spot, then climb up the monastery wall."
			)
			(1
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					setLoop: 3 1
					cel: 0
					posn: 135 150
					setSpeed: 15
					setCycle: Walk
					setScaler: Scaler 89 60 150 120
					setMotion: MoveTo 135 120 self
				)
			)
			(2
				(gEgo cycleSpeed: local4)
				(gGlory handsOn:)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sClimbOutMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 328)
				(= cycles 2)
			)
			(1
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					setSpeed: 15
					setCycle: Walk
					setMotion: MoveTo 135 150 self
				)
			)
			(2
				(gEgo
					setSpeed: local4
					normalize: 3
					setMotion: MoveTo 135 155 self
				)
			)
			(3
				(if
					(and
						(IsFlag 41)
						(== gPrevRoomNum 360)
						(gCast contains: igor)
					)
					(gMessager say: 17 6 9 0 self) ; "If Igor get big Hero job, can he be pyromaniac too?"
				else
					(= cycles 1)
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGrapnelIntoMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 328)
				(gEgo
					view: 8
					loop: 0
					cel: 0
					x: 107
					y: 149
					setCycle: End self
				)
			)
			(1
				(gMessager say: 9 33 0 0 self) ; "You climb up to the window and slip through."
			)
			(2
				(gGlory handsOn:)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sLevitateInMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 328)
				(= cycles 1)
			)
			(1
				(gGlory handsOn:)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (showCases)
		(super showCases: 49 (not (IsFlag 267))) ; Introduce Yourself
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(switch local2
				(1
					(SetFlag 74)
				)
				(2
					(SetFlag 75)
				)
			)
			(= global415 gDay)
		)
		(return 1)
	)

	(method (sayMessage)
		(if (== iconValue 49) ; Introduce Yourself
			(SetFlag 267)
		)
		(super sayMessage: &rest)
	)
)

(instance igorTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 73 0)) ; igorTalker
	)

	(method (showCases)
		(super
			showCases:
				2 ; Name
				(not (IsFlag 267))
				32
				global431
				5 ; Crypt Key
				(and (OneOf local2 2 3) (IsFlag 205))
				3 ; Crypt Key
				(and (>= local2 5) (not (IsFlag 268)))
		)
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(switch local2
				(1
					(SetFlag 74)
				)
				(2
					(SetFlag 75)
				)
			)
			(= global415 gDay)
		)
		(return 1)
	)

	(method (sayMessage)
		(switch iconValue
			(2 ; Name
				(SetFlag 267)
			)
			(3 ; Crypt Key
				(gEgo get: 60) ; crypt-key
				(SetFlag 268)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance guildDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				29 ; Pick the Lock
				(and (not (IsFlag 108)) (gEgo has: 24)) ; theToolkit
				28 ; Unlock Door
				(and (not (IsFlag 108)) (gEgo has: 14) (gEgo has: 61)) ; theKeyRing, guild-key
				27 ; Break Door Open
				(not (IsFlag 108))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(26 ; Open Door
				(if (IsFlag 108)
					(self clean:)
					(gCurRoom setScript: sInGuildDoor)
				else
					(super sayMessage: &rest) ; The door is locked.
				)
			)
			(27 ; Break Door Open
				(if (== (gEgo trySkill: 0 275) 1) ; strength
					(self clean:)
					(gEgo addHonor: -20)
					(SetFlag 108)
					(gMessager say: 18 6 79) ; "You force the guild door open. It breaks right off its hinges."
					(gCurRoom setScript: sInGuildDoor)
				else
					(super sayMessage: &rest) ; You're not strong enough to force the door.
				)
			)
			(29 ; Pick the Lock
				(if gNight
					(if (== (gEgo trySkill: 9 250) 1) ; pick locks
						(self clean:)
						(gEgo addHonor: -20)
						(SetFlag 108)
						(gMessager say: 18 6 37) ; "After a bit of fiddling, then a little drumming, the lock opens with a musical "snick." You ain't whistlin' "Dixie"!"
						(gCurRoom setScript: sInGuildDoor)
					else
						(gMessager say: 18 6 10) ; "This seems to be a fairly difficult lock. You'll need more practice before you can pick it."
					)
				else
					(gMessager say: 18 6 35) ; "Somebody might see you if you try this during the day!"
				)
			)
			(28 ; Unlock Door
				(self clean:)
				(gEgo addHonor: 50)
				(SetFlag 108)
				(gMessager say: 18 6 36) ; "You unlock the door using the key the Burgomeister gave you."
				(gCurRoom setScript: sInGuildDoor)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance monkDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (IsFlag 41) (== gPrevRoomNum 360))
						(gMessager say: 18 6 81) ; "The intense flames within the monastery have grown with an unnatural swiftness and turned into a raging inferno! There's no way you could go back in there and survive."
					)
					((and (not local3) (<= gTime 3) (not (== local2 4)))
						(gCurRoom setScript: sIgorWarn)
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

	(method (sayMessage)
		(if (OneOf iconValue 26 27 31 29) ; Open Monastery Door, Force Door Open, Listen at Door, Pick Lock
			(self clean:)
			(gCurRoom setScript: sHectapusDeath)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance igor of Actor
	(properties
		noun 17
		approachX 44
		approachY 160
		x 21
		y 152
		priority 70
		fixPriority 1
		view 257
		signal 16385
	)

	(method (doit)
		(if
			(and
				(self cycler:)
				((self cycler:) isKindOf: Fwd)
				(== (self view:) 257)
				(== (self loop:) 0)
				(== (self cel:) 2)
				(not (& (self signal:) $0008))
			)
			(gLongSong3 number: 13 play:)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(igorTeller
			init:
				self
				250
				16
				123
				(switch local2
					(0 19)
					(1 12)
					(2 11)
					(3 14)
					(5 15)
					(6 13)
				)
		)
	)
)

(instance monkDoor of Prop
	(properties
		noun 6
		approachX 210
		approachY 175
		x 229
		y 174
		fixPriority 1
		view 250
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(monkDoorTeller init: self 250 16 145)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 28 42 29 43) ; theLockpick, theToolkit, theKeyRing, theDarksign
				(cond
					((and (IsFlag 41) (== gPrevRoomNum 360))
						(gMessager say: 18 6 81) ; "The intense flames within the monastery have grown with an unnatural swiftness and turned into a raging inferno! There's no way you could go back in there and survive."
					)
					((and (not local3) (<= gTime 3) (not (== local2 4)))
						(gCurRoom setScript: sIgorWarn)
					)
					(else
						(switch theVerb
							(28 ; theLockpick
								(gCurRoom setScript: sHectapusDeath)
							)
							(42 ; theToolkit
								(gCurRoom setScript: sHectapusDeath)
							)
							(29 ; theKeyRing
								(gCurRoom setScript: sHectapusDeath)
							)
							(else
								(gCurRoom setScript: sInMonks)
							)
						)
					)
				)
			)
			((== theVerb 80) ; openSpell
				(if gNight
					(gMessager say: 18 6 12) ; "You feel your spell being deflected towards the hectapus relief and its energy dissipating."
				else
					(gMessager say: 18 6 34) ; "Somebody might see you if you try this during the day!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance guildDoor of Prop
	(properties
		noun 1
		sightAngle 90
		approachX 65
		approachY 135
		x 63
		y 108
		view 250
		loop 3
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 108)
			(= heading
				(((ScriptID 49 0) new:) ; doorMat
					init:
						((Polygon new:)
							type: PNearestAccess
							init: 68 128 78 137 53 141 43 130
							yourself:
						)
						1
						7
						3
						sInGuildDoor
					yourself:
				)
			)
		else
			(guildDoorTeller init: self 250 16 144)
		)
	)

	(method (handleEvent event)
		(switch (event message:)
			(KEY_P
				(= approachX 120)
				(= approachY 149)
			)
			(JOY_DOWNRIGHT
				(= approachX 65)
				(= approachY 135)
			)
			(else
				(= approachX 79)
				(= approachY 138)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(42 ; theToolkit
				(cond
					((IsFlag 108)
						(gMessager say: 18 6 80) ; "You walk right on in."
						(gCurRoom setScript: sInGuildDoor)
					)
					(gNight
						(if (== (gEgo trySkill: 9 250) 1) ; pick locks
							(gEgo addHonor: -20)
							(SetFlag 108)
							(gMessager say: 18 6 37) ; "After a bit of fiddling, then a little drumming, the lock opens with a musical "snick." You ain't whistlin' "Dixie"!"
							(gCurRoom setScript: sInGuildDoor)
						else
							(gMessager say: 18 6 10) ; "This seems to be a fairly difficult lock. You'll need more practice before you can pick it."
						)
					)
					(else
						(gMessager say: 18 6 35) ; "Somebody might see you if you try this during the day!"
					)
				)
			)
			(29 ; theKeyRing
				(cond
					((IsFlag 108)
						(gMessager say: 18 6 80) ; "You walk right on in."
						(gCurRoom setScript: sInGuildDoor)
					)
					((gEgo has: 61) ; guild-key
						(gEgo addHonor: 50)
						(IsFlag 108)
						(gMessager say: 18 6 36) ; "You unlock the door using the key the Burgomeister gave you."
						(gCurRoom setScript: sInGuildDoor)
					)
					(else
						(gMessager say: 18 6 38) ; "You don't have a key that will open this door."
					)
				)
			)
			(80 ; openSpell
				(if gNight
					(cond
						((IsFlag 108)
							(gMessager say: 18 6 80) ; "You walk right on in."
							(gCurRoom setScript: sInGuildDoor)
						)
						((gEgo castSpell: 20)
							(gEgo addHonor: -20)
							(= global441 50)
							(= global442 110)
							(gCurRoom setScript: (ScriptID 13 0) 0 self) ; castOpenScript
						)
					)
				else
					(gMessager say: 18 6 35) ; "Somebody might see you if you try this during the day!"
				)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sInGuildDoor)
			)
			(else
				(super doVerb: theVerb &rest)
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

(instance fire1 of Prop
	(properties
		x 140
		y 105
		view 250
		loop 1
	)
)

(instance fire2 of Prop
	(properties
		x 181
		y 69
		view 250
		loop 4
	)
)

(instance hectIncidental of Prop
	(properties
		noun 7
		approachX 210
		approachY 175
		x 178
		y 78
		priority 221
		view 251
	)
)

(instance hectLtArm of Prop
	(properties
		noun 7
		approachX 210
		approachY 175
		x 184
		y 106
		priority 119
		view 251
		loop 2
	)
)

(instance hectRtArm of Prop
	(properties
		noun 7
		approachX 210
		approachY 175
		x 184
		y 106
		priority 119
		view 251
		loop 4
	)
)

(instance hectMidLtArm of Prop
	(properties
		noun 7
		approachX 210
		approachY 175
		x 184
		y 106
		priority 11
		view 251
		loop 6
	)
)

(instance hectMidRtArm of Prop
	(properties
		noun 7
		approachX 210
		approachY 175
		x 184
		y 106
		priority 11
		view 251
		loop 8
	)
)

(instance shovel of View
	(properties
		noun 20
		sightAngle 180
		x 69
		y 152
		z 50
		fixPriority 1
		view 250
		loop 5
		signal 16384
	)
)

(instance stone of View
	(properties
		noun 21
		sightAngle 180
		approachX 43
		approachY 146
		x 27
		y 175
		z 30
		fixPriority 1
		view 257
		loop 4
		signal 16384
	)
)

(instance burntRemains of View
	(properties
		noun 23
		sightAngle 180
		approachX 189
		approachY 175
		x 52
		y 60
		view 252
		signal 16384
	)
)

(instance burntRemains1 of View
	(properties
		noun 23
		sightAngle 180
		approachX 189
		approachY 175
		x 113
		y 25
		view 252
		cel 1
		signal 16384
	)
)

(instance burntRemains2 of View
	(properties
		noun 23
		sightAngle 180
		approachX 189
		approachY 175
		x 151
		y 116
		view 252
		cel 2
		signal 16384
	)
)

(instance burntRemains3 of View
	(properties
		noun 23
		sightAngle 180
		approachX 189
		approachY 175
		x 141
		y 175
		view 252
		cel 3
		signal 16384
	)
)

(instance burnFeature of Feature
	(properties
		noun 23
		nsLeft 106
		nsTop 23
		nsRight 319
		nsBottom 163
		sightAngle 180
		approachX 189
		approachY 175
		x 169
		y 95
	)
)

(instance guildWin of Feature
	(properties
		noun 2
		nsLeft 2
		nsTop 71
		nsRight 38
		nsBottom 119
		sightAngle 180
		x 20
		y 95
	)
)

(instance guildTopWin of Feature
	(properties
		noun 3
		nsLeft 31
		nsTop 1
		nsRight 87
		nsBottom 67
		sightAngle 180
		x 59
		y 34
	)
)

(instance guildWall of Feature
	(properties
		nsLeft 69
		nsTop 95
		nsRight 117
		nsBottom 138
		sightAngle 180
		x 93
		y 116
	)
)

(instance tombStone of Feature
	(properties
		noun 4
		nsLeft 54
		nsTop 137
		nsRight 151
		nsBottom 189
		sightAngle 180
		x 102
		y 163
	)
)

(instance monkWin1 of Feature
	(properties
		noun 5
		nsLeft 131
		nsTop 82
		nsRight 150
		nsBottom 102
		sightAngle 180
		approachX 135
		approachY 150
		x 140
		y 92
	)

	(method (handleEvent event)
		(monkWall1 handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gEgo trySkill: 11 250) 1) ; climbing
					(gCurRoom setScript: sClimbIntoMonks)
				else
					(gMessager say: 18 6 14) ; "The wall is too smooth to climb with your level of skill."
				)
			)
			(33 ; theGrapnel
				(if gNight
					(gCurRoom setScript: sGrapnelIntoMonks)
				else
					(gMessager say: 18 6 34) ; "Somebody might see you if you try this during the day!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monkWin2 of Feature
	(properties
		noun 5
		nsLeft 230
		nsTop 52
		nsRight 252
		nsBottom 76
		sightAngle 180
		x 241
		y 64
	)

	(method (handleEvent event)
		(monkWall1 handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(if gNight
					(gCurRoom setScript: sGrapnelIntoMonks)
				else
					(gMessager say: 18 6 34) ; "Somebody might see you if you try this during the day!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hectapus of Feature
	(properties
		noun 7
		nsLeft 149
		nsTop 74
		nsRight 223
		nsBottom 111
		sightAngle 180
		approachX 210
		approachY 175
		x 186
		y 92
	)
)

(instance archway of Feature
	(properties
		noun 8
		nsLeft 236
		nsTop 67
		nsRight 319
		nsBottom 186
		sightAngle 180
		x 277
		y 126
	)
)

(instance monkWall1 of Feature
	(properties
		noun 9
		nsLeft 94
		nsTop 50
		nsRight 172
		nsBottom 101
		sightAngle 180
		approachX 135
		approachY 150
		x 133
		y 75
	)

	(method (handleEvent event)
		(if (== (event message:) $0021) ; !
			(= approachX 107)
			(= approachY 149)
		else
			(= approachX 135)
			(= approachY 150)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gEgo trySkill: 11 250) 1) ; climbing
					(gCurRoom setScript: sClimbIntoMonks)
				else
					(gMessager say: 18 6 14) ; "The wall is too smooth to climb with your level of skill."
				)
			)
			(33 ; theGrapnel
				(if gNight
					(gCurRoom setScript: sGrapnelIntoMonks)
				else
					(gMessager say: 18 6 34) ; "Somebody might see you if you try this during the day!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monkWall2 of Feature
	(properties
		noun 9
		nsLeft 208
		nsTop 21
		nsRight 310
		nsBottom 69
		sightAngle 180
		approachX 135
		approachY 150
		x 259
		y 45
	)

	(method (handleEvent event)
		(monkWall1 handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(monkWall1 doVerb: theVerb &rest)
	)
)

(instance monkHighWin of Feature
	(properties
		noun 10
		nsLeft 128
		nsTop 24
		nsRight 143
		nsBottom 35
		sightAngle 180
		approachX 135
		approachY 150
		x 135
		y 29
	)
)

