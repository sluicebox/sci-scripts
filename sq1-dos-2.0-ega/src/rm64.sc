;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use RangeOsc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use DPath)
(use Rev)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm64 0
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
)

(instance rm64 of SQRoom
	(properties
		lookStr {This is where the Sariens placed the Star Generator after lifting it from the Arcada.}
		picture 64
		east 58
		west 60
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(if (gEgo has: 13) ; Grenade
			(LoadMany rsSOUND 537 518 519 516 517 318 522 510)
		)
		(LoadMany rsVIEW 164)
		(Load rsSCRIPT 991 819)
		(switch gPrevRoomNum
			(west
				(= style 3)
				(if (== global166 1)
					(gEgo setPri: 2 posn: 5 54)
				else
					(gEgo posn: 5 175)
				)
			)
			(65
				(= global166 2)
				(= style 7)
				(self setScript: fromPad)
			)
			(else
				(= global166 1)
				(= style 2)
				(gEgo setPri: 2 posn: 315 54)
			)
		)
		(if (== global166 1)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 58 319 58 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 49 34 49 0 49
						yourself:
					)
			)
			(if (!= (DeltaurRegion numGrenades:) 2)
				(LoadMany rsVIEW 415 417)
				(if (== (DeltaurRegion egoStatus:) 1)
					(LoadMany rsVIEW 67)
				else
					(LoadMany rsVIEW 50)
				)
			)
			(LoadMany rsVIEW 42 479 67 50)
		else
			(if (IsFlag 47)
				(LoadMany rsVIEW 68 80)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 167 0 0 319 0 319 189 0 189 0 182 169 187 168 184 151 184 145 173 201 173 212 186 294 186 292 172 272 156 215 141 105 141 20 167
							yourself:
						)
				)
			else
				(LoadMany rsVIEW 471 91)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 135 175 186 175 195 187 127 187
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 301 189 262 156 246 152 204 141 158 141 117 141 56 155 16 168 0 168
							yourself:
						)
				)
			)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 153 145 153 171 117 170 106 159 121 143 198 143 215 158 205 169 169 171 169 145
						yourself:
					)
			)
		)
		(guard init:)
		(remote init:)
		(if (and (IsFlag 47) (== global166 2))
			(grenade init: hide: setScript: sputnik stopUpd:)
		)
		(if (and (IsFlag 53) (!= gPrevRoomNum 65))
			(generatorOn init:)
			(if (> (gGame detailLevel:) 1)
				(generatorOn setCycle: Fwd)
			)
		)
		(gFeatures
			add: upperLanding emitter tubes space starGenerator
			eachElementDo: #init
		)
		(gEgo init:)
		(super init:)
		(if (not (IsFlag 50))
			(leftShieldEmitter setCycle: Fwd init:)
			(rightShieldEmitter setCycle: Fwd setScript: pulse init:)
			(shield setCycle: Fwd init:)
			(remote setCycle: Fwd)
		else
			(remote stopUpd:)
		)
		(if (!= gPrevRoomNum 65)
			(gLongSong
				number: (if (IsFlag 50) 516 else 517)
				loop: 1
				flags: 1
				play:
				hold: 1
			)
		)
		(if
			(and
				(!= (DeltaurRegion egoStatus:) 1)
				(== global166 2)
				(not (IsFlag 47))
			)
			(LoadMany rsVIEW 471)
			(self setScript: killEgo)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 65)
			(gLongSong hold: 0)
		)
		(gEgo setCycle: 0 setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gEgo setCycle: 0 setPri: -1)
		(super dispose: &rest)
	)

	(method (doit)
		(if (not (IsFlag 53))
			(cond
				((> (gGame detailLevel:) 1)
					(if
						(and
							(not (rightShieldEmitter script:))
							(not (grenade script:))
							(not (IsFlag 50))
						)
						(rightShieldEmitter setScript: pulse)
					)
				)
				((and (rightShieldEmitter script:) (not (IsFlag 50)))
					(emitterSound stop:)
					(leftShieldEmitter show:)
					(rightShieldEmitter show:)
					(shield show:)
					(remote show:)
					(rightShieldEmitter setScript: 0)
				)
			)
		)
		(cond
			(script 0)
			((and (== global166 1) (!= (gEgo priority:) 2))
				(gEgo setPri: 2)
			)
			((& (gEgo onControl: 0) $0002)
				(if (IsFlag 50)
					(if (IsFlag 53)
						(self setScript: setToBlow)
					else
						(self setScript: toPad)
					)
				else
					(switch (++ local3)
						(1
							(self setScript: bumpOffShield)
						)
						(2
							(self setScript: toastEgo)
						)
					)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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
)

(instance leftShieldEmitter of Prop
	(properties
		x 19
		y 146
		description {leftShieldEmitter}
		lookStr {The left hand force field emitter, much like the right, radiates an unknown form of energy that keeps you from approaching the Star Generator.}
		view 164
		loop 3
		priority 12
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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

	(method (show)
		(super show:)
		(emitterSound loop: -1 play: hold: 1)
	)

	(method (hide)
		(super hide:)
		(emitterSound hold: 0)
	)

	(method (dispose)
		(emitterSound stop:)
		(super dispose:)
	)
)

(instance rightShieldEmitter of Prop
	(properties
		x 301
		y 145
		description {rightShieldEmitter}
		lookStr {The right hand force field emitter, in a fashion altogether similar to the left hand one, beams an inexplicable power into the vicinity of the Star Generator that makes it impossible to get near.}
		view 164
		loop 4
		priority 12
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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
)

(instance shield of Prop
	(properties
		x 161
		y 131
		description {shield}
		lookStr {Cowabunga, Wilco - this is IT! It's the unimaginably powerful Star Generator, which must not, at any cost, be allowed to remain in the hands of the evil Sariens! (but you knew that, right?)}
		view 164
		priority 11
		signal 16400
		cycleSpeed 6
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== global166 2)) ; Inventory
			(if (== invItem 14) ; Remote
				(if (not (IsFlag 50))
					(gCurRoom setScript: useRemote)
				else
					(Print 64 1) ; "There's no need to use the remote now, the force field is already off."
				)
			)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance generatorOn of Prop
	(properties
		x 161
		y 128
		description {generatorOn}
		lookStr {The pulsing energy surging from the Star Generator tells you that it has been activated and you had better quit hanging around staring at the pretty colors.}
		view 164
		loop 1
		priority 12
		signal 16400
		cycleSpeed 6
		detailLevel 1
	)
)

(instance remote of Prop
	(properties
		x 161
		y 138
		description {remote}
		approachX 161
		approachY 175
		lookStr {A receptor for somekind of remote control signal.}
		view 164
		loop 2
		priority 12
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(switch theVerb
				(3 ; Do
					(cond
						((not (IsFlag 50))
							(Print 64 2) ; "There is a force field around the Star Generator. You will need to turn if off first."
						)
						((IsFlag 53)
							(Print 64 3) ; "The Star Generator is already set to blow, Roger! Maybe you oughtta do the same!"
						)
						(else
							(gCurRoom setScript: toPad)
						)
					)
				)
				(4 ; Inventory
					(if (== invItem 14) ; Remote
						(if (not (IsFlag 50))
							(gCurRoom setScript: useRemote)
						else
							(Print 64 1) ; "There's no need to use the remote now, the force field is already off."
						)
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance starGenerator of RegionFeature
	(properties
		description {starGenerator}
		onMeCheck 10
		lookStr {Cowabunga, Wilco - this is IT! It's the unimaginably powerful Star Generator, which must not, at any cost, be allowed to remain in the hands of the evil Sariens! (but you knew that, right?)}
		level 3
	)

	(method (doVerb theVerb invItem)
		(cond
			((== global166 2)
				(switch theVerb
					(4 ; Inventory
						(if (== invItem 14) ; Remote
							(if (not (IsFlag 50))
								(gCurRoom setScript: useRemote)
							else
								(Print 64 1) ; "There's no need to use the remote now, the force field is already off."
							)
						else
							(super doVerb: theVerb invItem &rest)
						)
					)
					(2 ; Look
						(self
							x: ((gUser curEvent:) x:)
							y: ((gUser curEvent:) y:)
						)
						(super doVerb: theVerb invItem &rest)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			((== theVerb 2) ; Look
				(super doVerb: theVerb invItem &rest)
			)
			(else
				(Print 64 4) ; "You can't do that from up here."
			)
		)
	)
)

(instance grenade of Actor
	(properties
		lookStr {It's the used gas grenade.}
		view 164
		loop 5
		signal 16400
		cycleSpeed 6
		moveSpeed 2
	)
)

(instance guard2 of Actor
	(properties
		y 55
		view 417
		cycleSpeed 6
		moveSpeed 6
	)
)

(instance guard of Actor
	(properties
		x 161
		y 183
		approachX 130
		approachY 188
		yStep 3
		view 164
		loop 7
		signal 16384
		cycleSpeed 6
		xStep 5
		moveSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 5 12 11) ; Look, Talk, Smell, Taste
		(if (IsFlag 47)
			(self cel: 1 stopUpd:)
		else
			(self cel: 0 stopUpd:)
		)
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(switch theVerb
				(4 ; Inventory
					(switch invItem
						(13 ; Grenade
							(Print 64 5) ; "Don't you think you've gassed this guy enough?"
						)
						(0 ; Cartridge
							(Print 64 6) ; "You could drop the cartridge on his big ugly head, but you might damage the data. Better find something more suited to the task."
						)
						(19 ; Sarien_ID_Card
							(if (IsFlag 47)
								(Print 64 7) ; "You think he might be more interested in it if he were alive."
							else
								(gCurRoom setScript: showCard)
							)
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(2 ; Look
					(cond
						((not (IsFlag 47))
							(Print 64 8) ; "This is the biggest, toughest (not to mention ugliest) Sarien guard you have ever seen. At present he is diligently guarding the Star Generator from intruders such as yourself. He's wearing some sort of gadget on his belt, but from here you can't tell what its purpose might be."
							(if
								(and
									(<= 151 (gEgo x:) 171)
									(<= 163 (gEgo y:) 183)
								)
								(Print 64 9) ; "He's also wondering what your doing back there."
							)
						)
						((and (IsFlag 47) (not (gEgo has: 14))) ; Remote
							(Print 64 10) ; "You notice a remote control device on the guards belt."
						)
						(else
							(Print 64 11) ; "The guard lies in a red heap on the floor, overcome by the toxic gas from the grenade."
						)
					)
				)
				(5 ; Talk
					(if (not (IsFlag 47))
						(if (gEgo has: 0) ; Cartridge
							(Print 64 12) ; "This is a guy of few words, none of them for you."
						else
							(Print 64 13) ; "I can not answer any questions without proper ID."
						)
					else
						(Print 64 14) ; "This guy is more talkative dead than alive. He's dead silent."
					)
				)
				(3 ; Do
					(cond
						((not (IsFlag 47))
							(Print 64 15) ; "If you touch him, he might touch you back."
						)
						((and (IsFlag 47) (not (gEgo has: 14))) ; Remote
							(gCurRoom setScript: getRemote)
						)
						(else
							(Print 64 16) ; "The guard has nothing else of interest."
						)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(switch theVerb
				(2 ; Look
					(cond
						((not (IsFlag 47))
							(Print 64 17) ; "This is the biggest, toughest (not to mention ugliest) Sarien guard you have ever seen. At present he is diligently guarding the Star Generator from intruders such as yourself. He's wearing some sort of gadget on his belt, but from here you can't tell what its purpose might be."
						)
						((and (IsFlag 47) (not (gEgo has: 14))) ; Remote
							(Print 64 18) ; "You notice a remote control device on the guards belt."
						)
						(else
							(Print 64 19) ; "The guard lies in a red heap on the floor, overcome by the toxic gas from the grenade. Some kind of electronic gadget is hanging from his belt."
						)
					)
				)
				(4 ; Inventory
					(if (== invItem 13) ; Grenade
						(if (not (IsFlag 47))
							(gCurRoom setScript: dropTheGrenade)
						else
							(Print 64 5) ; "Don't you think you've gassed this guy enough?"
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
)

(instance toPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 12 setMotion: DPath 158 149 147 145 self)
			)
			(1
				(Face gEgo remote self)
			)
			(2
				(gEgo view: 68 setLoop: 5 cel: 0 setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 65)
			)
		)
	)
)

(instance fromPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					posn: 147 145
					view: 68
					setPri: 12
					setLoop: 5
					cel: 6
					setCycle: Beg self
				)
			)
			(1
				(if (IsFlag 53)
					(gLongSong hold: 0)
				)
				(proc703_1)
				(gEgo
					loop: 2
					setPri: 12
					setMotion: DPath 158 149 153 176 self
				)
			)
			(2
				(gEgo setPri: -1)
				(if (IsFlag 53)
					(Face gEgo generatorOn)
					(gEgo moveHead: 0)
					(generatorOn init: hide: setCycle: Fwd cycleSpeed: 51)
					(= register 4)
					(= ticks 18)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(gLongSong number: 516 loop: 0 play: hold: 1)
				(generatorOn cycleSpeed: register hide:)
				(= ticks (* register 6))
			)
			(4
				(generatorOn show:)
				(= ticks 18)
			)
			(5
				(if (-- register)
					(-= state 3)
				)
				(= ticks 18)
			)
			(6
				(generatorOn cycleSpeed: 6)
				(gEgo moveHead: 1)
				(DeltaurRegion setScript: (ScriptID 703 23)) ; countDown
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(leftShieldEmitter dispose:)
				(rightShieldEmitter dispose:)
				(gEgo setMotion: MoveTo 33 177 self)
			)
			(1
				(Print 64 20) ; "Oh no Roger! The guard has seen you and you're not wearing the helmet! You're in for it now Wilco!"
				(gEgo view: 41 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(gEgo cycleSpeed: 5 setCycle: RangeOsc -1 2 3)
				(= ticks 18)
			)
			(3
				(guard
					view: 471
					loop: 0
					cel: 0
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: End self
				)
			)
			(4
				(guard
					setLoop: 1
					cel: (guard lastCel:)
					posn: 137 183
					setCycle: Walk
					setMotion: MoveTo 76 177 self
				)
			)
			(5
				(gEgo
					view: 471
					setLoop: 4
					cel: 1
					posn: 104 124
					setCycle: Rev
					setPri: 15
					setCycle: 0
					hide:
				)
				(guard
					view: 471
					loop: 3
					cycleSpeed: 6
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(6
				(guard setCycle: RangeOsc 5 4 5 self)
			)
			(7
				(guard setCycle: RangeOsc 3 6 8 self)
			)
			(8
				(guard setCycle: CT 13 1 self)
			)
			(9
				(guard setCycle: End)
				(gEgo
					show:
					setStep: 8 8
					cycleSpeed: 6
					setCycle: Fwd
					setMotion: JumpTo 188 51 self
				)
			)
			(10
				(gEgo setMotion: JumpTo 319 190)
				(guard
					view: 471
					loop: 2
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(11
				(gEgo
					view: 471
					loop: 5
					cel: 0
					cycleSpeed: 6
					setMotion: 0
					setCycle: End
				)
				(= seconds 4)
			)
			(12
				(EgoDead 940 2 0 64 21) ; "Boy, you're no Marshall Dillon, that's for sure. And you were so close. You'll need to react a little faster and a little sharper than that. Well, throw a little bondo into that hole and get back in there."
				(self dispose:)
			)
		)
	)
)

(instance pulse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftShieldEmitter show:)
				(rightShieldEmitter show:)
				(= seconds (Random 1 5))
			)
			(1
				(leftShieldEmitter hide:)
				(rightShieldEmitter hide:)
				(= seconds (Random 1 5))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance bounceGrenade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 537 loop: 1 play:)
				(grenade setCycle: Fwd setMotion: JumpTo 157 125 self)
			)
			(1
				(guard view: 42 loop: 8 cel: 0 setCycle: CT 1 1)
				(grenade setCycle: Rev setMotion: JumpTo 160 96 self)
			)
			(2
				(grenade setMotion: JumpTo (gEgo x:) (- (guard y:) 5) self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance dropTheGrenade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 13) ; Grenade
				(= local0 ((gUser curEvent:) x:))
				(if (< (guard nsLeft:) local0 (guard nsRight:))
					(gEgo setMotion: PolyPath (guard x:) 57 self)
				else
					(gEgo
						setMotion: PolyPath ((gUser curEvent:) x:) 57 self
					)
				)
			)
			(1
				(if 0
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(if (== (DeltaurRegion egoStatus:) 2)
					(gEgo setLoop: (+ (gEgo loop:) 4))
				)
				(gEgo view: 42 cel: 0 setCycle: CT 6 1 self)
			)
			(2
				(grenade
					yStep: 4
					startUpd:
					view: 164
					setPri: 15
					setLoop: 5
					cel: 0
					posn: (- (gEgo x:) 3) (- (gEgo y:) 20)
					init:
				)
				(gEgo setCycle: End self)
			)
			(3
				(if
					(and
						(< (guard nsLeft:) local0 (guard nsRight:))
						(not (IsFlag 47))
					)
					(self setScript: bounceGrenade self)
				else
					(grenade
						setCycle: Fwd
						setMotion: JumpTo (gEgo x:) (- (guard y:) 5) self
					)
				)
			)
			(4
				(gSoundEffects number: 518 loop: 0 play:)
				(gLongSong2 number: 519 loop: 0 play:)
				(if
					(and
						(< (guard nsLeft:) local0 (guard nsRight:))
						(not (IsFlag 47))
					)
					(grenade dispose:)
					(SetFlag 47)
					(SetScore 5 168)
					(guard setScript: guardDies self)
				else
					(grenade view: 479 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(5
				(if (not (< (guard nsLeft:) local0 (guard nsRight:)))
					(grenade dispose:)
					(if (not (IsFlag 47))
						(Print 64 22) ; "The Sarien warrior is guarding the stolen Star Generator so intensly, he didn't notice the gas grenade exploding."
						(Print 64 23) ; "Actually, his walkman is cranked up too high."
					else
						(Print 64 24) ; "The dead Sarien guard might have noticed that, if he were alive."
					)
				)
				(gEgo
					setLoop: (+ (gEgo loop:) 2)
					cel: 0
					setCycle: End self
				)
			)
			(6
				(proc703_1)
				(gEgo loop: 2 setPri: 2)
				(if (and (not (DeltaurRegion numGrenades:)) (not (IsFlag 47)))
					(self setScript: shootTheEgo self)
				else
					(self cue:)
				)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance guardDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register 0)
				(guard view: 42 loop: 8 cycleSpeed: 6 setCycle: CT 8 1 self)
			)
			(1
				(guard cycleSpeed: 12 setCycle: RangeOsc 2 7 8 self)
			)
			(2
				(guard setCycle: RangeOsc 2 8 9 self)
			)
			(3
				(guard setCycle: CT 10 1 self)
			)
			(4
				(gSoundEffects number: 522 loop: 1 play:)
				(guard setCycle: RangeOsc 2 11 12 self)
			)
			(5
				(guard view: 164 setLoop: 7 setCel: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getRemote of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (< (gEgo x:) (guard x:)))
				(guard ignoreActors: 1 illegalBits: 0)
				(if register
					(gEgo
						ignoreControl: -32768
						setMotion: PolyPath 161 185 self
					)
				else
					(gEgo
						ignoreControl: -32768
						setMotion: PolyPath 213 181 self
					)
				)
			)
			(1
				(Face gEgo remote self)
			)
			(2
				(if register
					(gEgo setLoop: 5)
				else
					(gEgo setPri: (- (gEgo priority:) 1) setLoop: 4)
				)
				(gEgo view: 68 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(3
				(guard setCel: 2)
				(gEgo setCycle: CT (- (gEgo lastCel:) 1) -1 self)
			)
			(4
				(guard setCel: 1)
				(gEgo setCycle: CT (gEgo lastCel:) 1 self)
			)
			(5
				(Print 64 25) ; "You remove the device from the guard's belt. It looks like you have found the remote control that turns off the force field around the Star Generator."
				(gEgo setCycle: Beg self)
			)
			(6
				(proc703_1)
				(gEgo loop: 6)
				(= ticks 18)
			)
			(7
				(if register
					(gEgo setMotion: PolyPath 125 184 self)
				else
					(gEgo setMotion: PolyPath 226 178 self)
				)
			)
			(8
				(gEgo get: 14) ; Remote
				(SetScore 3 170)
				(Face gEgo remote)
				(gEgo observeControl: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance turnForceFieldOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rightShieldEmitter setScript: 0 dispose:)
				(leftShieldEmitter dispose:)
				(Print 64 26) ; "You press the stud on the remote and the force field around the Star Generator begins to deplete."
				(shield setLoop: 6 cel: 0 setCycle: End self)
			)
			(1
				(shield cycleSpeed: 2 setCycle: RangeOsc 4 0 0 self)
			)
			(2
				(gLongSong hold: 0 fade:)
				(shield dispose:)
				(SetScore 3 171)
				(self dispose:)
			)
		)
	)
)

(instance useRemote of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo 160 157 self)
			)
			(1
				(SetFlag 50)
				(cond
					((and (< (gEgo x:) 160) (< (gEgo y:) 157))
						(gEgo loop: 0)
					)
					((and (> (gEgo x:) 160) (< (gEgo y:) 157))
						(gEgo loop: 1)
					)
					((and (< (gEgo x:) 160) (> (gEgo y:) 157))
						(gEgo loop: 2)
					)
					(else
						(gEgo loop: 3)
					)
				)
				(gEgo view: 68 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(2
				(gSoundEffects number: 318 loop: 0 play:)
				(gEgo setCycle: Beg self)
			)
			(3
				(= register (+ (gEgo loop:) 4))
				(proc703_1)
				(gEgo loop: register)
				(self setScript: turnForceFieldOff self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toastEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (OneOf (gEgo loop:) 0 4 6)
					(= register 1)
				else
					(= register 0)
				)
				(if (== (DeltaurRegion egoStatus:) 1)
					(gEgo setLoop: 2)
				else
					(gEgo setLoop: 0)
				)
				(= local5 (+ (gEgo y:) 10))
				(if register
					(= local4 (- (gEgo x:) 30))
				else
					(= local4 (+ (gEgo x:) 30))
				)
				(gEgo
					loop: (+ (gEgo loop:) register)
					view: 80
					cel: 0
					cycleSpeed: 3
					setCycle: CT 13 1 self
					setMotion: JumpTo local4 local5
				)
			)
			(1
				(gEgo cycleSpeed: 10 setCycle: RangeOsc 5 11 13 self)
			)
			(2
				(EgoDead 945 0 0 64 27) ; "Ouch! That stings just a tad. You'll obviously need to disarm that baby before trying that again."
				(self dispose:)
			)
		)
	)
)

(instance showCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) 160)
					(gEgo setMotion: PolyPath 130 188 self)
				else
					(gEgo setMotion: PolyPath 196 188 self)
				)
			)
			(1
				(Face gEgo guard self)
			)
			(2
				(gEgo
					view: 91
					loop: (if (< (gEgo x:) 160) 0 else 1)
					cel: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(3
				(Printf 64 28 global184) ; "Sir, the destruct code is %d."
				(gEgo setCycle: Beg self)
			)
			(4
				(proc703_1)
				(gEgo
					loop: (if (gEgo loop:) 7 else 6)
					setHeading: (if (gEgo loop:) 315 else 45)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bumpOffShield of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 64 29) ; "It appears the shield is preventing you from getting to the Star Generator's control panel and boy is it hot. You'd better not try to get close to the Star Generator again."
				(gEgo setMotion: PolyPath 163 172 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sputnik of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (not (IsFlag 50))
					(leftShieldEmitter hide:)
					(rightShieldEmitter hide: setScript: 0)
				)
				(grenade
					lookStr: {Da Cnythuk}
					startUpd:
					show:
					setLoop: 8
					posn: 44 0
					setPri: 1
					cycleSpeed: 5
					moveSpeed: 3
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo 301 110 self
				)
			)
			(2
				(if (not (IsFlag 50))
					(rightShieldEmitter hide: setScript: pulse)
				)
				(grenade dispose:)
				(self dispose:)
			)
		)
	)
)

(instance setToBlow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 64 30) ; "The Star Generator is already set to blow Roger! You had better find someway to get a million miles from the Deltaur and quick!"
				(gEgo setMotion: PolyPath 163 172 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shootTheEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo 0 55 self)
			)
			(1
				(Print 64 31) ; "Oh No! Your rotten aim has attracted the attention of one of the patrol guards. You're in for it now!"
				(if (> (gEgo x:) 120)
					(= cycles 10)
				else
					(gEgo
						setCycle: Rev
						setLoop: 1
						setMotion: MoveTo 156 53 self
					)
				)
			)
			(2
				(gEgo setCycle: 0)
				(guard2 init: setCycle: Walk setMotion: MoveTo 36 55 self)
			)
			(3
				(guard2 view: 415 cel: 0 setCycle: End self)
			)
			(4
				(if (== (DeltaurRegion egoStatus:) 1)
					(gEgo view: 67)
				else
					(gEgo view: 50)
				)
				(gEgo setLoop: 1 cycleSpeed: 6 cel: 0 setCycle: End self)
			)
			(5
				(EgoDead 940 2 0 64 32) ; "Boy, you're no Marshall Dillon, that's for sure. And you were so close. You'll need to react a little faster be little sharper than that. Well, throw a little bondo into that whole and get back in there."
				(self dispose:)
			)
		)
	)
)

(instance upperLanding of RegionFeature
	(properties
		description {upper landing}
		onMeCheck 32
		lookStr {It's the walkway above the Star Generator.}
		level 3
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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
)

(instance emitter of RegionFeature
	(properties
		description {force field emitter }
		onMeCheck 16384
		lookStr {This is one of the force field's emitters.}
		level 3
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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
)

(instance tubes of RegionFeature
	(properties
		description {tubes}
		onMeCheck 16
		lookStr {The Wally Tubes look strangely empty without Thunder Agents in them.}
		level 3
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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
)

(instance space of RegionFeature
	(properties
		description {outer space }
		onMeCheck 512
		lookStr {Looking into the vast reaches of space gives you the curious illusion of being tiny, unimportant, insignificant, negligible, and totally irrelevant in the scheme of things. Then you realize it's not an illusion.}
		level 3
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(12 ; Pulseray_Laser_Pistol
					(if
						(or
							(and
								(== global166 1)
								(> ((gUser curEvent:) y:) 60)
							)
							(and
								(== global166 2)
								(< ((gUser curEvent:) y:) 61)
							)
						)
						(Print 64 0) ; "You can't shoot that from here."
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(13 ; Grenade
					(if (< (gEgo y:) 70)
						(gCurRoom setScript: dropTheGrenade)
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
)

(instance emitterSound of Sound
	(properties
		number 510
	)
)

