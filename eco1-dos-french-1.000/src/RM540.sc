;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	RM540 0
)

(local
	[local0 19] = [294 285 268 276 260 284 269 258 279 289 263 272 261 284 273 283 268 253 256]
	[local19 19] = [43 41 41 45 47 48 49 51 51 53 54 56 61 58 61 63 65 57 63]
	[local38 19] = [273 278 268 276 282 260 267 286 275 252 262 269 282 256 279 287 276 249 262]
	[local57 19] = [158 155 153 150 152 150 148 148 144 146 144 145 144 142 141 143 139 138 138]
	local76
	local77
	local78
	local79
	local80
)

(instance RM540 of EcoRoom
	(properties
		picture 901
		style -32761
		north 561
		picAngle 80
		vanishingX 180
		vanishingY 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 324)
					(if (< ((User curEvent:) x:) 180)
						(Narrator init: 2) ; "The eerie glow from the flashlight fish reveals a small cave. There seems to be an opening to the northeast."
					else
						(Narrator init: 3) ; "Some sort of soft algae has grown all over the walls of the cave. It has an unpleasant smell."
					)
				else
					(Narrator init: 17) ; "Adam can't see anything clearly."
				)
			)
			(3 ; Do
				(if (IsFlag 324)
					(super doVerb: theVerb invItem)
				else
					(Narrator init: 25) ; "Adam doesn't want to put his hand there unless he can see what he's touching first."
				)
			)
			(4 ; Inventory
				(cond
					((IsFlag 324)
						(super doVerb: theVerb invItem)
					)
					((and (== invItem 23) (== global233 2)) ; jar
						(self setScript: releaseFish)
					)
					(else
						(Narrator init: 33) ; "That's not very illuminating."
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 324)
						(Narrator init: 39) ; "The flashlight fish doesn't answer."
					)
					((IsFlag 73)
						(super doVerb: 5)
					)
					(else
						(self setScript: scareDel)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (notify)
		(if argc
			(if (not (IsFlag 324))
				(Palette palSET_INTENSITY 116 155 0)
				(Palette palSET_INTENSITY 156 255 0)
			else
				(Palette palSET_INTENSITY 116 155 100)
				(Palette palSET_INTENSITY 156 255 (Min (+ 15 (* 14 global244)) 100))
			)
		else
			(self setScript: releaseFish)
		)
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= north
			(if (IsFlag 334)
				560
			else
				(ClearFlag 107)
				561
			)
		)
		(self
			setScript:
				(switch gPrevRoomNum
					(561
						(= picture 540)
						fromToxicWasteInSuit
					)
					(560
						(= picture 540)
						fromToxicCaveScript
					)
					(else fromEntranceScript)
				)
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 45 118 125 166 125 189 161 189 172 173 244 166 297 103 247 103 275 67 269 43 216 43 216 61 111 118 121 56 45 69
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 160 153 115 153 117 136 156 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 220 118 226 140 160 140 155 126 159 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 211 162 158 162 171 144 199 144
					yourself:
				)
		)
		(chest cel: (IsFlag 95))
		(super init:)
		(if (!= gPrevRoomNum 520)
			(= local80 (List new:))
			(for ((= temp0 0)) (< temp0 19) ((++ temp0))
				(if (< temp0 global244)
					((= temp3 (Rock new:))
						posn: [local38 temp0] [local57 temp0]
						setPri: 6
						init:
					)
				else
					((= temp3 (Rock new:))
						posn: [local0 temp0] [local19 temp0]
						init:
					)
				)
				(local80 add: temp3)
			)
		)
		(gFeatures add: caveExit)
		(if (IsFlag 324)
			(gFeatures
				add: toxicCaveEntrance spiderWeb stalactite stalagmite caveExit
			)
		)
		(gFeatures eachElementDo: #init)
		(if (>= global244 14)
			(toxicCaveEntrance approachVerbs: 3) ; Do
		)
		(= temp2 (if (not (IsFlag 334)) 543 else 420))
		(if (!= (gLongSong number:) temp2)
			(gLongSong number: temp2 loop: -1 play:)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((gEgo inRect: 53 90 103 142)
				(self newRoom: 520)
			)
			((>= (gEgo y:) 88) 0)
			((and (not local77) (>= global244 14))
				(if (== north 561)
					(= local77 1)
					(= local79 1)
					((ScriptID 2 0) init: 9 1) ; Delphineus, "No! It's too dangerous to go in there. I can sense things you can't and I have a very bad feeling about this! You need more protection to swim into water like that."
				else
					(gCurRoom setScript: toToxicCave)
				)
			)
			((and (not local78) (< global244 6))
				(= local78 1)
				(= local79 1)
				((ScriptID 2 0) init: 16 1) ; Delphineus, "You might get cut if you swim through there. Too many rocks!"
			)
			((not local79)
				(= local79 1)
				(Narrator init: 20) ; "The opening still isn't big enough to swim through."
			)
		)
		(super doit: &rest)
		(Palette palANIMATE 34 42 6)
	)

	(method (newRoom)
		(gCurRoom drawPic: 541 -32759)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (IsObject local80)
			(local80 dispose:)
		)
		(Palette palSET_INTENSITY 0 255 100)
		(gDelph setScript: 0)
		(super dispose: &rest)
	)
)

(instance fromEntranceScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(NormalEgo)
				(gEgo
					loop: 5
					heading: 135
					ignoreHorizon: 1
					init:
					posn: 86 80 28
					setMotion: MoveTo 124 173 self
				)
				(if (not (IsFlag 324))
					(Palette palSET_INTENSITY 116 155 0)
					(Palette palSET_INTENSITY 156 255 0)
				else
					(Palette palSET_INTENSITY 116 155 100)
					(Palette palSET_INTENSITY 156 255 (Min (+ 15 (* 14 global244)) 100))
				)
				(gCurRoom drawPic: 540 -32759)
				(= local80 (List new:))
				(for ((= temp0 0)) (< temp0 19) ((++ temp0))
					(if (< temp0 global244)
						((= temp1 (Rock new:))
							posn: [local38 temp0] [local57 temp0]
							setPri: 6
							init:
						)
					else
						((= temp1 (Rock new:))
							posn: [local0 temp0] [local19 temp0]
							init:
						)
					)
					(local80 add: temp1)
				)
			)
			(2
				(if (not (IsFlag 334))
					(NormalDelph)
					(gDelph
						init:
						setPri: 7
						posn: 41 158
						setScript: (ScriptID 127 0) 0 920 ; delSpeakScript
						setMotion: MoveTo 95 195 self
					)
				else
					(= ticks 1)
				)
				(if (and (>= global244 13) (not (IsFlag 334)))
					(glint init:)
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(if (< 1 global244 14)
					((ScriptID 2 0) init: 18 1 self) ; Delphineus, "You know, I think I can see something through that opening you're clearing."
				else
					(= ticks 1)
				)
			)
			(5
				(HandsOn)
				(if (not (IsFlag 324))
					(gCurRoom setScript: 0)
					(gEgo setScript: tooDarkScript)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance tooDarkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gDelph setMotion: MoveTo 156 176 self)
			)
			(1
				((ScriptID 2 0) init: 1 1 self) ; Delphineus, "Adam, I can't see where I'm going. Let's get out of here before we get hurt."
			)
			(2
				(= seconds 8)
			)
			(3
				(HandsOff)
				((ScriptID 2 0) init: 1 1 self) ; Delphineus, "Adam, I can't see where I'm going. Let's get out of here before we get hurt."
			)
			(4
				(gDelph setMotion: MoveTo 150 178)
				(gEgo setMotion: PolyPath 72 70 self)
			)
			(5
				(gCurRoom newRoom: 520)
			)
		)
	)
)

(instance releaseFish of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90 self setScript: 0)
			)
			(1
				(gEgo setCycle: 0 view: 540 setLoop: 2 cel: 0)
				(= cycles 20)
			)
			(2
				(Narrator init: 27 self) ; "Adam holds out the glowing jar. The flashlight fish senses the friendly dark of the cave."
			)
			(3
				(gEgo cycleSpeed: 20 setCycle: End self)
				(Palette palSET_INTENSITY 116 155 100)
			)
			(4
				(SetScore 10 324)
				(Narrator init: 28 self) ; "Gathering courage, it swims out of the jar and settles down between two rocks."
			)
			(5
				(= seconds 2)
			)
			(6
				((ScriptID 2 0) init: 26 1 self) ; Delphineus, "What a relief! Now I can see where I'm going."
			)
			(7
				(Narrator init: 42 self) ; "Adam puts the empty jar into his recycle bag."
			)
			(8
				(gEgo put: 23) ; jar
				(SetScore 10 324)
				(gFeatures
					add:
						toxicCaveEntrance
						spiderWeb
						stalactite
						stalagmite
						caveExit
					eachElementDo: #init
				)
				(NormalEgo)
				(gEgo z: 28 heading: 90 loop: 0)
				(self dispose:)
			)
		)
	)
)

(instance scareDel of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 26 self) ; "Adam's voice echoes weirdly in the dark cave."
			)
			(1
				((ScriptID 2 0) init: 14 1 self) ; Delphineus, "Don't do that again! You scared me!"
			)
			(2
				((ScriptID 2 1) init: 7 1 self) ; Adam, "Sorry about that."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance fromToxicCaveScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(toxicCaveEntrance approachVerbs: 3) ; Do
				(gEgo
					ignoreHorizon: 1
					init:
					posn: 278 63
					z: 28
					setMotion: MoveTo 230 107 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance fromToxicWasteInSuit of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo
					ignoreHorizon: 1
					init:
					view: 542
					posn: 254 51 0
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 243 77 self
				)
				(NormalDelph)
				(gDelph
					init:
					setPri: 7
					posn: 41 158
					setMotion: MoveTo 95 195
				)
			)
			(1
				(gEgo
					view: 541
					posn: 225 98 28
					setLoop: 3
					cel: 6
					cycleSpeed: 20
					setCycle: Beg self
				)
			)
			(2
				(gEgo setLoop: 2 cel: 10 setCycle: Beg self)
				(ClearFlag 97)
				(glint init: cel: 0)
				(toxicCaveEntrance approachVerbs: 3) ; Do
			)
			(3
				(if (IsFlag 134)
					(= ticks 1)
				else
					(self setScript: foundToxicWaste self)
					(SetFlag 134)
				)
			)
			(4
				(NormalEgo)
				(gEgo posn: 227 102 28 setMotion: MoveTo 218 130 self)
			)
			(5
				(= temp0
					(cond
						(
							(and
								(not (or (gEgo has: 26) (IsFlag 332))) ; steelCable
								(not (or (gEgo has: 27) (IsFlag 331))) ; float
							)
							24
						)
						((not (or (gEgo has: 26) (IsFlag 332))) 23) ; steelCable
						((not (or (gEgo has: 27) (IsFlag 331))) 22) ; float
						(else 25)
					)
				)
				((ScriptID 2 0) init: temp0 1 self) ; Delphineus
				(delTalkAfterToxicCave register: temp0)
				(gDelph talkScript: delTalkAfterToxicCave)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance foundToxicWaste of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 42 0 self) ; Adam, "Whew, that suit's hot. I had to get it off for a second."
			)
			(1
				((ScriptID 2 1) say: 43 0 self) ; Adam
			)
			(2
				((ScriptID 2 1) say: 49 1 self) ; Adam
			)
			(3
				((ScriptID 2 0) init: 19 1 self) ; Delphineus, "What do we do now?"
			)
			(4
				((ScriptID 2 1) init: 44 0 self) ; Adam, "I know I shouldn't touch them. My dad's been real clear with me about that. He's done a lot of research into salvaging this sort of stuff."
			)
			(5
				((ScriptID 2 1) say: 45 1 self) ; Adam
			)
			(6
				((ScriptID 2 0) init: 20 1 self) ; Delphineus, "Can't you figure something out?"
			)
			(7
				((ScriptID 2 1) init: 46 1 self) ; Adam, "I'm working on it."
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance toToxicCave of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo ignoreHorizon: 1 setMotion: MoveTo 309 44 self)
			)
			(1
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance pullRock of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					setCycle: 0
					setPri: 13
					view: 805
					setCycle: Fwd
					y: (- (gEgo y:) 28)
					z: 0
					setMotion:
						MoveTo
						(- (register x:) 24)
						(- (register y:) 5)
						self
				)
			)
			(2
				(register startUpd: setPri: 6)
				(gEgo
					view: 543
					setLoop: 2
					cel: 0
					cycleSpeed: 22
					setCycle: CT 10 1 self
				)
			)
			(3
				(gSoundEffects number: 541 loop: 1 play:)
				(gEgo
					setCycle: End
					setStep: 1 2
					setMotion: MoveTo (gEgo x:) 80
				)
				(register
					setMotion:
						MoveTo
						[local38 global244]
						[local57 global244]
						self
				)
				(++ global244)
				(Palette palSET_INTENSITY 156 255 (Min (+ 15 (* 14 global244)) 120))
			)
			(4
				(gSoundEffects number: 540 loop: 1 play:)
				(switch global244
					(1
						(Narrator init: 31 self) ; "Adam reaches up and pulls on one of the brownish rocks. It falls easily to the floor of the cave. A strange, green light seeps through the small hole."
					)
					(2
						(Narrator init: 19 self) ; "Another rock pulls out easily. It must not have been there very long."
					)
					(4
						(self setScript: easyRocks self)
					)
					(7
						(Narrator init: 32 self) ; "The greenish color of the water intensifies as the rocks come out."
					)
					(10
						(self setScript: dontStop self)
					)
					(13
						(toxicCaveEntrance approachVerbs: 3) ; Do
						(= ticks 1)
					)
					(else
						(if (and (>= global244 14) (not (IsFlag 334)))
							(SetScore 5 325)
							(self setScript: showGlint self)
						else
							(= ticks 1)
						)
					)
				)
			)
			(5
				(register stopUpd:)
				(NormalEgo)
				(gEgo heading: 0 loop: 3 y: (+ (gEgo y:) 36) z: 28)
				(= local79 0)
				(self dispose:)
			)
		)
	)
)

(instance easyRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 12 1 self) ; Delphineus, "Hey, those are coming out, no problemo!"
			)
			(1
				((ScriptID 2 1) init: 5 1 self) ; Adam, "Yeah, it feels more to me like somebody put these here."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dontStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "I think something's happening to the water, Adam. I'm getting dizzy. My sonar feels a little off or something."
			)
			(1
				((ScriptID 2 1) init: 8 1 self) ; Adam, "Should I stop?"
			)
			(2
				((ScriptID 2 0) init: 17 1 self) ; Delphineus, "No, we've got to find out what's on the other side."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance showGlint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 5 self) ; "The light strikes something hidden behind the rocks."
			)
			(1
				(if (not (gCast contains: glint))
					(glint init:)
				)
				(glint cel: 0 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance putOnSuit of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 238 113 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(SetScore 10 329)
				(SetFlag 97)
				(gEgo
					setCycle: 0
					view: 541
					posn: 225 70 0
					setLoop: 2
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(if (IsFlag 147)
					(+= state 2)
					(Narrator init: 43 self) ; "Adam puts on the protective suit."
				else
					(SetFlag 147)
					(Narrator init: 14 self) ; "Adam feels an immediate relief. Whatever was in the water was making it really hard to think."
				)
			)
			(5
				(if
					(and
						(or (gEgo has: 27) (IsFlag 331)) ; float
						(or (gEgo has: 26) (IsFlag 332)) ; steelCable
					)
					((ScriptID 2 0) init: 7 1 self) ; Delphineus, "Adam, I can't go any farther. Whatever is in this water is really affecting me. I'll wait right here as long as I can take it."
				else
					((ScriptID 2 0) init: 21 1 self) ; Delphineus, "I guess it's okay if you go look. I can't go through there - this junk in the water is getting to me. Be careful, though, I don't think we've found all the things the Oracle spoke of."
				)
			)
			(6
				(Narrator init: 15 self) ; "Adam signals "okay" to Delphineus."
			)
			(7
				(gEgo
					view: 542
					posn: 243 77
					setLoop: 3
					setMotion: MoveTo 254 51 self
				)
			)
			(8
				(gCurRoom newRoom: 561)
			)
		)
	)
)

(instance chestOpenTalk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 1 self) ; Delphineus, "Bizarre, what is it?"
			)
			(1
				((ScriptID 2 1) init: 3 0 self) ; Adam, "I've seen clothes like this - they protect your skin from chemicals."
			)
			(2
				((ScriptID 2 1) say: 4 1 self) ; Adam
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance chestClosedTalk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator posn: -1 140 init: 6 self) ; "A metal box has been concealed in the pile of rocks."
			)
			(1
				((ScriptID 2 1) init: 2 1 self) ; Adam, "There's a label here, Delphineus. 'Joe's Dumping - You Pump it, We Dump it.' Sounds like a bunch of jerks to me."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance delTalkAfterToxicCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: register 1 self) ; Delphineus
			)
			(1
				(self dispose:)
			)
		)
	)
)

(class Rock of Actor
	(properties
		approachX 255
		approachY 78
		yStep 6
		view 543
		priority 1
		signal 30736
		illegalBits 0
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(3 ; Do
				(cond
					((not (IsFlag 324))
						(Narrator init: 17) ; "Adam can't see anything clearly."
					)
					((> y 130)
						(Narrator init: 22) ; "Adam has no use for the rocks."
					)
					(else
						(= temp0 (local80 at: global244))
						(gCurRoom setScript: pullRock 0 temp0)
					)
				)
			)
			(2 ; Look
				(cond
					((> y 130)
						(Narrator init: 21) ; "The rocks that were clogging the hole have fallen to the floor of the cave."
					)
					(global244
						(Narrator init: 40) ; "There are still some rocks clogging the way out."
					)
					(else
						(Narrator init: 4) ; "The flashlight fish's steady glow reveals an opening clogged with brownish rocks. It looks almost like a "wall of stones!""
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 18) ; "Adam's afraid he might bend the trident."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 252
		y 101
		approachX 250
		approachY 109
		view 823
		signal 16384
	)

	(method (init)
		(self approachVerbs: 2 3) ; Look, Do
		(super init: &rest)
	)

	(method (cue)
		(self cel: 0 setCycle: End)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showChestInset)
			)
			(3 ; Do
				(gCurRoom setScript: showChestInset)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance toxicCaveEntrance of Feature
	(properties
		x 260
		y 10
		onMeCheck 16384
		approachX 262
		approachY 50
	)

	(method (doVerb theVerb invItem)
		(if (not (IsFlag 324))
			(gCurRoom doVerb: theVerb invItem)
		else
			(switch theVerb
				(3 ; Do
					(if (< global244 15)
						(Narrator init: 34) ; "The greenish substance leaks through the opening. Just beyond Adam sees large shapes. However, it's not clear what they are yet."
					)
				)
				(2 ; Look
					(cond
						((not global244)
							(Narrator init: 4) ; "The flashlight fish's steady glow reveals an opening clogged with brownish rocks. It looks almost like a "wall of stones!""
						)
						((>= global244 14)
							(Narrator init: 35) ; "The greenish, glowing light is so intense that Adam can't make out what's beyond."
						)
						(else
							(Narrator init: 34) ; "The greenish substance leaks through the opening. Just beyond Adam sees large shapes. However, it's not clear what they are yet."
						)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance spiderWeb of Feature
	(properties
		onMeCheck 8192
		lookStr 36
	)

	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 37) ; "The dead sea fan is beyond help."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stalactite of Feature
	(properties
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(gCurRoom setScript: stalTalk)
				)
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator init: 23) ; "Adam should try to stay away from the walls. He might get cut."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stalagmite of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb)
		(stalactite doVerb: &rest)
	)
)

(instance stalTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 13 1 self) ; Delphineus, "Are the ones that go down the stalagmites or the stalactites? I can't ever remember."
			)
			(1
				((ScriptID 2 1) init: 6 1 self) ; Adam, "There's a trick for remembering that. Can't think of it, though. The stalagmites go up. The stalactites hang down. If you don't know that, you've never played a Space Quest."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance caveExit of Feature
	(properties
		x 99
		y 114
		onMeCheck 1024
		approachX 72
		approachY 90
		lookStr 41
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(gCurRoom newRoom: 520)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chestInset of View
	(properties
		x 170
		y 298
		z 200
		view 540
		priority 11
		signal 18448
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (not (InRect nsLeft nsTop nsRight nsBottom event))
			(event claimed: 1)
			((gCurRoom script:) cue:)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance chest of View
	(properties
		x 173
		y 299
		z 200
		view 540
		loop 1
		priority 13
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(if cel
			(switch theVerb
				(2 ; Look
					(if (IsFlag 148)
						(Narrator init: 44) ; "Between the rocks is a box with a protective suit in it. The suit is designed for handling dangerous chemicals."
					else
						(SetFlag 148)
						(gEgo setScript: chestOpenTalk)
					)
				)
				(3 ; Do
					(= cel 0)
					(ClearFlag 95)
					(suitInChest dispose:)
					(self forceUpd:)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(switch theVerb
				(2 ; Look
					(gEgo setScript: chestClosedTalk)
				)
				(3 ; Do
					((ScriptID 2 1) init: 1 1) ; Adam, "Bummer, it's locked!"
				)
				(4 ; Inventory
					(switch invItem
						(4 ; rag
							(Narrator posn: -1 154 init: 11) ; "Adam eases the lock with the oily rag."
							(SetScore 5 327)
						)
						(25 ; boxKey
							(if (IsFlag 327)
								(if (IsFlag 150)
									(chest cel: 1 forceUpd:)
									(if (not (IsFlag 97))
										(suitInChest init: stopUpd:)
									)
									(SetFlag 95)
								else
									(SetFlag 150)
									(gEgo setScript: openChest)
								)
							else
								(Narrator posn: -1 154 init: 10) ; "The key turns halfway in the lock and then stops. It seems that saltwater has rusted the mechanism."
							)
						)
						(12 ; trident
							(Narrator posn: -1 154 init: 9) ; "There's no telling what's in the box. Better not risk damaging the contents!"
						)
						(30 ; hackSaw
							(Narrator posn: -1 154 init: 9) ; "There's no telling what's in the box. Better not risk damaging the contents!"
						)
						(else
							(if (IsFlag 327)
								(super doVerb: theVerb invItem)
							else
								(Narrator posn: -1 154 init: 13) ; "The lock needs easing. That won't help."
							)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance openChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chest cel: 1 forceUpd:)
				(Narrator posn: -1 154 init: 30 self) ; "The key turns smoothly in the oiled lock. The box pops open to reveal a suit of protective clothing."
			)
			(1
				(if (not (IsFlag 97))
					(suitInChest init: stopUpd:)
				)
				(SetScore 5 328)
				(SetFlag 95)
				(= seconds 3)
			)
			(2
				((ScriptID 2 0) init: 3 1 self) ; Delphineus, "Bizarre, what is it?"
			)
			(3
				((ScriptID 2 1) init: 3 0 self) ; Adam, "I've seen clothes like this - they protect your skin from chemicals."
			)
			(4
				((ScriptID 2 1) init: 4 1 self) ; Adam, "Armor for a modern knight... Do you suppose this is it?"
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance suitInChest of View
	(properties
		x 173
		y 300
		z 200
		view 540
		loop 1
		cel 2
		priority 14
		signal 22544
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gEgo setScript: chestOpenTalk)
			)
			(3 ; Do
				(= local76 1)
				((gCurRoom script:) cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance showChestInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCast eachElementDo: #stopUpd)
				(= ticks 3)
			)
			(1
				(chestInset init: show: stopUpd:)
				(chest init: stopUpd:)
				(SetScore 5 326)
				(if (and (IsFlag 95) (not (IsFlag 97)))
					(suitInChest init: stopUpd:)
				)
				(= cycles 10)
			)
			(2
				(Narrator posn: -1 154 init: 6 self) ; "A metal box has been concealed in the pile of rocks."
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 0)
			)
			(4
				(HandsOn)
				(chest hide:)
				(suitInChest hide:)
				(chestInset hide:)
				(= cycles 3)
			)
			(5
				(chest dispose:)
				(suitInChest dispose:)
				(chestInset dispose:)
				(= ticks 3)
			)
			(6
				(gCast eachElementDo: #startUpd)
				(= ticks 3)
			)
			(7
				(if local76
					(= local76 0)
					(client setScript: putOnSuit)
				else
					(self dispose:)
				)
			)
		)
	)
)

