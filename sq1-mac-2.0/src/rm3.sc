;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use eRS)
(use Talker)
(use Osc)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm3 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 3
)

(procedure (localproc_0)
	(switch (Random 0 1)
		(0
			(Print 3 29) ; "You seem to be on the wrong level to do that."
		)
		(1
			(Print 3 30) ; "You need to go to the top level."
		)
	)
)

(instance rm3 of SQRoom
	(properties
		picture 3
		style 10
		east 4
		west 6
	)

	(method (init)
		(LoadMany rsVIEW 0 7 401 103)
		(leftDoor init: stopUpd:)
		(rightDoor init: stopUpd:)
		(rightPanelLights setCycle: Fwd init:)
		(leftPanelLights setCycle: Fwd init:)
		(gEgo init:)
		(self setRegions: 700) ; arcadaRegion
		(if (OneOf gPrevRoomNum west east)
			(= style (if (== gPrevRoomNum west) 12 else 11))
			(if (== global166 1)
				(= local0 1)
				(gSoundEffects number: 311 loop: 1 play:)
			)
		)
		(if (!= (gLongSong number:) 355)
			(gLongSong2 number: 353 loop: -1 flags: 1 play: 40)
			(backSound number: 340 loop: -1 play: 30)
			(if (== global166 1)
				(backSound fade: 127 25 10 0)
				(gLongSong2 fade: 127 25 10 0)
			else
				(backSound fade: 50 25 10 0)
				(gLongSong2 fade: 50 25 10 0)
			)
		)
		(droid init:)
		(if (== gHowFast 0)
			(droid stopUpd:)
		)
		(super init:)
		(gFeatures
			add: Computer holes lights mainComputer cartridgeSlots
			eachElementDo: #init
		)
		(if (IsFlag 8)
			(scientist
				init:
				posn: 224 88
				setLoop: 2
				cel: 0
				show:
				ignoreActors: 1
				stopUpd:
			)
		)
		(if (not (proc700_1 556 16))
			(if (== global166 1)
				(if (IsFlag 8)
					(self
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 83 253 83 252 90 237 93 203 91 189 84 175 84 173 78 166 70 147 70 160 79 163 92 136 92 122 81 118 68 99 68 74 76 63 84 0 84
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 0 93 56 93 31 122 31 144 61 171 156 185 253 170 282 147 281 121 260 94 319 92 319 189 0 189
								yourself:
							)
					)
				else
					(self
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 83 249 83 234 74 205 65 204 74 189 84 175 84 173 78 166 70 147 70 160 79 163 92 136 92 121 82 116 68 99 68 74 76 63 84 0 84
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 0 93 56 93 31 122 31 144 61 171 156 185 253 170 282 147 281 121 258 92 319 92 319 189 0 189
								yourself:
							)
					)
				)
				(switch global168
					(0
						(= global168 1)
					)
					(1
						(scientist
							init:
							hide:
							ignoreActors: 1
							setScript: scientistComeIn
						)
					)
				)
				(if (== gPrevRoomNum west)
					(leftDoor cel: 3 stopUpd:)
				)
				(if (== gPrevRoomNum east)
					(rightDoor cel: 3 stopUpd:)
				)
			else
				(gEgo setPri: 1)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 133 0 133
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 157 319 157 319 189 0 189
							yourself:
						)
				)
			)
		)
		(cond
			((== gPrevRoomNum 103)
				(gEgo view: 7 setLoop: 0 cel: 7 posn: 168 92 normal: 0)
				(cond
					((proc700_1 556 32)
						(droid posn: 183 64 setPri: 6)
						(self setScript: putCartAway)
					)
					((proc700_1 556 16)
						(self setScript: goGetCart)
					)
					(else
						(self setScript: riseFromComputer)
					)
				)
			)
			((== global166 1)
				(self setScript: enterRoom)
			)
		)
		(if (== global166 1)
			(Computer sightAngle: 45)
		)
		(if (and (== global166 2) (OneOf gPrevRoomNum west east))
			(HandsOn)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			((not local0)
				(cond
					((& temp0 $0002)
						(gSoundEffects number: 311 loop: 1 play:)
						(= local0 1)
						(leftDoor setCycle: End leftDoor)
					)
					((& temp0 $0008)
						(gSoundEffects number: 311 loop: 1 play:)
						(= local0 1)
						(rightDoor setCycle: End rightDoor)
					)
				)
			)
			((not (& temp0 $000a))
				(gSoundEffects number: 311 loop: 1 play:)
				(= local0 0)
				(if (leftDoor cel:)
					(leftDoor setCycle: Beg leftDoor)
				)
				(if (rightDoor cel:)
					(rightDoor setCycle: Beg rightDoor)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== global166 1)
					(Print 3 0) ; "This is the Data Archive of the Arcada. An interesting array of devices (none of of which you know how to operate) are provided for data study by those with proper clearance."
				else
					(Print 3 1) ; "This is an area of non-descript hallway beneath the Data Archive Storage Cabin."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(if local3
			(SetFlag 8)
			(= global168 3)
		)
		(if (!= (gLongSong number:) 355)
			(if (OneOf newRoomNumber west east)
				(backSound fade:)
				(gLongSong2 fade:)
			)
			(if (and (== newRoomNumber 103) (not (proc700_1 556 16)))
				(gLongSong2 number: 353 fade: 50 25 10 0)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(if (and (== global166 1) (OneOf gPrevRoomNum east west))
			(self setScript: enterRoom)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveFwd 30 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance scientistComeIn of Script
	(properties)

	(method (doit)
		(if
			(and
				(== state 1)
				(not (gCurRoom script:))
				(or (< (gEgo x:) 156) (> (gEgo y:) 132))
			)
			(self cue:)
		)
		(if (and (== state 14) (== (backSound prevSignal:) -1))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1 0)
			(2
				(if (> global172 30)
					(HandsOff)
					(backSound number: 301 loop: 1 flags: 1 play:)
					(gLongSong2 fade: 30 25 10 0)
					(gLongSong fade: 30 25 10 0)
					(= local3 1)
					(gSoundEffects number: 311 loop: 1 play:)
					(rightDoor setCycle: End self)
				else
					(self dispose:)
				)
			)
			(3
				(Face gEgo rightDoor self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo moveHead: 0)
				(rightDoor stopUpd:)
				(gEgo stopUpd:)
				(Print 3 2) ; "The door opens. A man you recognize as one of the head lab scientists stumbles into the room. He appears to be in serious need of some Abdo-Seal abdomen filler!"
				(scientist
					posn: 313 88
					show:
					setLoop: 4
					setCycle: Fwd
					setStep: 3 3
					setMotion: MoveTo 224 88 self
				)
			)
			(6
				(gSoundEffects number: 311 loop: 1 play:)
				(rightDoor setCycle: Beg rightDoor)
				(Print 3 3) ; "After only a few steps, he hits the floor with a disconcerting thud."
				(Face gEgo scientist)
				(scientist setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(7
				(gSoundEffects number: 522 loop: 1 play:)
				(scientist setLoop: 0 cel: 3 setCycle: End self)
			)
			(8
				(theDummy
					init:
					cycleSpeed: (if (<= gHowFast 1) 8 else 17)
					posn: (scientist x:) (scientist y:)
					setPri: (+ (scientist priority:) 1)
					setCycle: End self
				)
			)
			(9
				(theDummy dispose:)
				(scientist
					cel: 0
					setLoop: 2
					cycleSpeed: 20
					moveSpeed: 20
					setCycle: End self
				)
			)
			(10
				(= cycles 9)
			)
			(11
				(scientist setLoop: 3 setCycle: End self)
			)
			(12
				(scientist setLoop: 2 cel: 2 setCycle: Beg self)
			)
			(13
				(gEgo moveHead: 1)
				(HandsOn)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 83 253 83 252 90 237 93 203 91 189 84 175 84 173 78 166 70 147 70 160 79 163 92 136 92 122 81 118 68 99 68 74 76 63 84 0 84
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 93 56 93 31 122 31 144 61 171 156 185 253 170 282 147 281 121 260 94 319 92 319 189 0 189
							yourself:
						)
				)
				(= cycles 4)
			)
			(14 0)
			(15
				(scientist stopUpd:)
				(backSound
					number: 340
					loop: -1
					flags: 1
					play: 0
					fade: 127 25 10 0
				)
				(gLongSong2 fade: 127 25 10 0)
				(gLongSong fade: 127 25 10 0)
				(self dispose:)
			)
		)
	)
)

(instance talkScientist of Script
	(properties)

	(method (changeState newState &tmp [temp0 130])
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 fade: 30 25 10 0)
				(gLongSong fade: 30 25 10 0)
				(backSound number: 354 loop: -1 flags: 1 play:)
				(Face gEgo scientist)
				(scientist setLoop: 2 cel: 0 setCycle: End self)
			)
			(1
				(scientist setLoop: 3 setCycle: Fwd)
				(= cycles (if (<= gHowFast 1) 15 else 30))
			)
			(2
				(Print 3 4) ; "He begins to speak."
				(sciTalker
					init: sciBust sciEyes sciMouth
					say:
						{"The Star Generator is in danger! The Arcada is under attack! You'd better get off this scow if you value your life, Wilco."}
						0
						0
						0
						self
				)
			)
			(3
				(Format ; "Just before his systems cease all functions short of decay, he looks over toward the shelves full of cartridges and utters "%s". With one last gasp, his lifeless form slumps to the floor."
					@temp0
					3
					5
					(switch ((ScriptID 700 0) cartNumber:) ; arcadaRegion
						(1 {Black Holes})
						(2 {Stars})
						(3 {Magnetic Fields})
						(4 {Van Allen Belts})
						(5 {Astral Bodies})
						(6 {Quasars})
						(7 {Binary Systems})
						(8 {Orbits})
						(9 {Galaxies})
						(10 {Solar Flares})
						(11 {Moons})
						(12 {Plantary Formations})
						(13 {Constellations})
						(14 {Quadrants})
						(15 {Asteroids})
						(16 {Pulsars})
						(17 {Gravity})
						(18 {Meteors})
						(19 {Solar Systems})
						(20 {Warp Fields})
					)
				)
				(sciTalker say: @temp0 0 0 1 self)
				(SetScore 2 131)
			)
			(4
				(scientist setLoop: 2 setCel: 2 setCycle: Beg self)
			)
			(5
				(backSound fade:)
				(= seconds (if (<= gHowFast 1) 2 else 3))
			)
			(6
				(HandsOn)
				(scientist stopUpd:)
				(SetFlag 8)
				(backSound
					number: 340
					loop: -1
					flags: 1
					play: 0
					fade: 127 25 10 0
				)
				(gLongSong2 fade: 127 25 10 0)
				(gLongSong fade: 127 25 10 0)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 7 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 103)
			)
		)
	)
)

(instance riseFromComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 9)
					(gEgo
						setLoop: 1
						cycleSpeed: 5
						moveSpeed: 5
						cel: 0
						setCycle: Osc 1 self
					)
				else
					(= cycles 3)
				)
			)
			(1
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 0
					setLoop: -1
					setCycle: StopWalk 60
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(3
				(HandsOn)
				(NormalEgo 2 0 60)
				(ClearFlag 9)
				(self dispose:)
			)
		)
	)
)

(instance goGetCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 302 loop: -1 play:)
				(= local5 1)
				(droid setCycle: CT 1 -1 setMotion: MoveTo 108 21 self)
			)
			(1
				(droid
					setLoop: 4
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 4 1 self
				)
			)
			(2
				(gSoundEffects number: 303 loop: 1 play:)
				(droid setCycle: End self)
			)
			(3
				(droid setMotion: DPath 102 51 132 64 183 64 self)
			)
			(4
				(gLongSong2 number: 353 loop: -1 play:)
				(droid setCycle: CT 9 -1 self)
			)
			(5
				(gCurRoom newRoom: 103)
			)
		)
	)
)

(instance putCartAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ffdf)) ; arcadaRegion, arcadaRegion
				(droid
					setLoop: 4
					cel: 8
					setMotion: DPath 132 64 102 51 108 21 self
				)
				(= local5 1)
			)
			(1
				(droid setCycle: CT 5 -1 self)
			)
			(2
				(gSoundEffects number: 303 loop: 1 play:)
				(droid setCycle: Beg self)
			)
			(3
				(droid
					setLoop: 3
					cel: 1
					setCycle: CT 5 1
					setPri: -1
					setMotion: MoveTo 170 37 self
				)
				(= local5 0)
			)
			(4
				(droid cel: 5 setCycle: CT 3 -1 self)
			)
			(5
				(client setScript: riseFromComputer)
			)
		)
	)
)

(instance theDummy of Prop
	(properties
		description {scientist}
		sightAngle 45
		lookStr {The old scientist doesn't appear healthy. In fact, his small intestine is about to unwind onto the floor.}
		view 401
		loop 1
		signal 16400
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(if (== global166 1)
			(switch theVerb
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 3 6) ; "No amount of money will put this man's lungs back in his chest."
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(localproc_0)
		)
	)
)

(instance leftDoor of Prop
	(properties
		x 15
		y 76
		description {electric door}
		lookStr {This is a door. Perhaps it leads elsewhere.}
		view 103
		loop 1
		cycleSpeed 4
	)

	(method (cue)
		(gEgo setPri: -1)
		(self setPri: -1 stopUpd:)
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 298
		y 77
		description {electric door}
		lookStr {It's an automatic door.}
		view 103
		loop 2
		cycleSpeed 4
	)

	(method (cue)
		(gEgo setPri: -1)
		(self setPri: -1 stopUpd:)
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance rightPanelLights of Prop
	(properties
		x 245
		y 48
		description {lights}
		lookStr {These panel lights are here just for decoration and don't actually have anything to do with the Data Archive Unit.}
		view 103
		loop 6
		signal 16384
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance leftPanelLights of Prop
	(properties
		x 104
		y 39
		description {lights}
		lookStr {These lights have something to do with the Data Archive Unit, though you don't really know what. They do seem to indicate that the unit is still operational.}
		view 103
		loop 7
		signal 16384
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance scientist of Actor
	(properties
		description {scientist}
		sightAngle 45
		approachX 236
		approachY 103
		view 401
		cycleSpeed 7
		moveSpeed 7
	)

	(method (init)
		(super init: &rest)
		(if (== global166 1)
			(self approachVerbs: 2 5 3 4) ; Look, Talk, Do, Inventory
		)
	)

	(method (doVerb theVerb invItem)
		(if (== global166 1)
			(switch theVerb
				(2 ; Look
					(cond
						((IsFlag 8)
							(Print 3 7) ; "It's a grisly sight. You can't tell where the toasted synthetic fabrics end and the fused organic material begins. There is nothing you can do for him now."
						)
						(local1
							(Print 3 8) ; "You see a man dressed in a lab coat. He appears to be ailing in a major way."
						)
						(else
							(Print 3 9) ; "A large laser hole has been burned in his uniform, giving you a nice view of previously unexposed tissue. Struggling painfully, he props himself up on one elbow."
							(= local1 1)
						)
					)
				)
				(3 ; Do
					(if (IsFlag 8)
						(Print 3 10) ; "You can do nothing more for the fused flesh-heap of a man."
					else
						(gCurRoom setScript: talkScientist)
					)
				)
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 3 6) ; "No amount of money will put this man's lungs back in his chest."
						)
						(0 ; Cartridge
							(Print 3 11) ; "In his present condition (dead) he can't make any use of the data cartridge."
						)
						(1 ; keyCard
							(Print 3 12) ; "If you give the keycard to the dead scientist, you won't be able to use the special elevators."
						)
						(15 ; Widget
							(Print 3 13) ; "The widget apparently has no power to raise the dead."
						)
						(2 ; Gadget
							(Print 3 14) ; "The handy dandy translation gadget will not enable you to communicate with the dead."
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(5 ; Talk
					(if (IsFlag 8)
						(Print 3 15) ; "His audible forms of communication will be limited to what he can convey through the venting of bodily gases."
					else
						(gCurRoom setScript: talkScientist)
					)
				)
				(12 ; Smell
					(if (IsFlag 8)
						(Print 3 16) ; "He didn't smell all that great when he was alive."
					else
						(Print 3 17) ; "The smell of freshly sheared copper fills the air around the damaged scientist."
					)
				)
				(11 ; Taste
					(Print 3 18) ; "You wouldn't want to do that. Trust me."
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(localproc_0)
		)
	)
)

(instance droid of Actor
	(properties
		x 170
		y 37
		description {data retrieval droid}
		lookStr {data retrieval droid lookStr}
		view 103
		loop 3
		cel 3
		signal 10240
		cycleSpeed 2
		moveSpeed 2
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== gHowFast 0)
			(return)
		else
			(if (or mover local5)
				(= local6 2)
			)
			(if (and (not mover) (== local6 2) (not local5))
				(= local7 0)
				(= local6 (Random 1 0))
			)
			(if (<= (-- local7) 0)
				(= local7 3)
				(= temp0 0)
				(switch local6
					(2
						(if (> z 0)
							(= temp0 (- z 1))
						)
						(if (< z 0)
							(= temp0 (+ z 1))
						)
					)
					(1
						(if (> (= temp0 (+ z 1)) 2)
							(= local6 0)
						)
					)
					(else
						(if (< (= temp0 (- z 1)) -2)
							(= local6 1)
						)
					)
				)
				(self z: temp0)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(if (== global166 1)
			(switch theVerb
				(2 ; Look
					(Printf ; "This is a Model DX Cartridge Retrieval Unit. Its function is to retrieve and return cartridges from and to the storage unit. It is currently %s."
						3
						19
						(if local4 {holding a cartridge} else {empty})
					)
				)
				(3 ; Do
					(Print 3 20) ; "You can't reach it. Even if you did, the pinchers look quite nasty."
				)
				(5 ; Talk
					(Print 3 21) ; "It doesn't respond to human voice commands. It only works through the data archive console."
				)
				(12 ; Smell
					(Print 3 22) ; "I wouldn't be violating his airspace if I were you."
				)
				(11 ; Taste
					(Print 3 22) ; "I wouldn't be violating his airspace if I were you."
				)
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 3 23) ; "You figure the robot probably works for batteries."
						)
						(0 ; Cartridge
							(Print 3 24) ; "You decide that the cartridge is too important to give back to the robot."
						)
						(1 ; keyCard
							(Print 3 25) ; "You see no slot on the robot that would fit the keycard."
						)
						(15 ; Widget
							(Print 3 26) ; "The widget, being magnetic, sticks to the robot's outer casing. You remove it again with some difficulty."
						)
						(2 ; Gadget
							(Print 3 27) ; "Since the robot does not speak, the translator has nothing to translate."
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
		else
			(localproc_0)
		)
	)
)

(instance Computer of Feature
	(properties
		x 160
		y 63
		nsTop 41
		nsLeft 124
		nsBottom 86
		nsRight 197
		description {Data retreval console}
		sightAngle 45
		onMeCheck 4
		approachX 168
		approachY 92
		lookStr {This is the operation console of the Data Archive Unit. There is a CRT and chair.}
	)

	(method (init)
		(super init: &rest)
		(if (== global166 1)
			(self approachVerbs: 3 2) ; Do, Look
		)
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(switch theVerb
				(3 ; Do
					(gCurRoom setScript: sitDown)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(localproc_0)
		)
	)
)

(instance cartridgeSlots of Feature
	(properties
		description {data cartridges}
		sightAngle 45
		onMeCheck 16
		lookStr {The data cartridges are stored in these secure storage modules.}
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance mainComputer of Feature
	(properties
		description {main computer}
		sightAngle 45
		onMeCheck 64
		lookStr {The Data Archive System secures its sophisticated electronic information in cartridges housed in these storage modules.}
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance lights of Feature
	(properties
		description {lights}
		sightAngle 45
		onMeCheck 128
		lookStr {These things hanging from the ceiling, which look like blowfish-on-a-rope, are actually lighting fixtures for the operation console.}
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
			(super doVerb: theVerb &rest)
		else
			(localproc_0)
		)
	)
)

(instance holes of Feature
	(properties
		description {holes}
		sightAngle 45
		onMeCheck 256
		lookStr {Through the metallic lattice you glimpse still another hallway below.}
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(if (== global166 1)
					(super doVerb: theVerb &rest)
				else
					(Print 3 28) ; "You can see a well-lit room above."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sciTalker of Talker
	(properties
		x 5
		y 29
		nsTop 99
		nsLeft 212
		view 503
	)
)

(instance sciBust of View
	(properties
		view 503
		cel 1
	)
)

(instance sciEyes of Prop
	(properties
		nsTop 27
		nsLeft 16
		view 503
		loop 1
		cycleSpeed 12
	)
)

(instance sciMouth of Prop
	(properties
		nsTop 44
		nsLeft 24
		view 503
		loop 2
		cycleSpeed 50
	)
)

(instance backSound of Sound
	(properties)
)

