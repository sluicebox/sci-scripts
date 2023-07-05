;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	local0
	local1
	local2
	local3 = -1
	[local4 16] = [0 189 0 0 187 0 187 135 211 155 216 164 209 172 121 189]
	[local20 18] = [155 189 248 182 257 174 254 165 234 152 202 136 202 0 319 0 319 189]
	[local38 24] = [0 189 0 0 50 0 82 85 41 85 68 123 159 123 176 130 209 154 218 162 211 172 120 189]
	[local62 26] = [163 189 248 177 255 167 189 131 189 123 241 123 241 105 197 97 147 86 100 86 71 0 319 0 319 189]
	[local88 46] = [0 189 0 0 319 0 319 189 165 189 177 185 232 177 252 175 253 165 229 147 180 125 243 125 243 105 210 100 145 85 37 85 67 123 160 123 179 130 216 158 216 167 205 173 125 189]
)

(instance rm510 of KQ6Room
	(properties
		noun 3
		picture 510
		horizon 0
		north 540
		south 520
	)

	(method (init)
		(if (IsFlag 8)
			(self
				addObstacle:
					(poly1After type: PBarredAccess points: @local38 size: 12 yourself:)
					(poly2After type: PBarredAccess points: @local62 size: 13 yourself:)
			)
		else
			(self
				addObstacle:
					(poly1Before type: PBarredAccess points: @local4 size: 8 yourself:)
					(poly2Before type: PBarredAccess points: @local20 size: 9 yourself:)
			)
		)
		(super init: &rest)
		(if (== gPrevRoomNum north)
			(gEgo init: reset: 2 posn: 102 99)
			(gGlobalSound2 number: 917 flags: 1 loop: -1 play:)
		else
			(gEgo init: reset: 3 posn: 146 187)
		)
		(if (== ((gInventory at: 2) owner:) gCurRoomNum) ; brick
			(brick init:)
		)
		(archer init: ignoreActors: 1 setPri: 10)
		(if (IsFlag 8)
			(archer setLoop: 6 ignoreActors: 1 addToPic:)
		)
		(statue2 init:)
		(wall init:)
		(roseFeature init:)
		(trees init:)
		(garden init:)
		(gazebo init:)
		(path init:)
		(rocks init:)
		(gEgo setScale: Scaler 100 67 190 86 actions: egoUseShieldCode)
		(roses init: setPri: 5)
		(if (IsFlag 9)
			(roses setLoop: 0 cel: 7 noun: 16 ignoreActors: 1 addToPic:)
		else
			(roses setLoop: 2 cel: 0)
		)
		(if (not (IsFlag 98))
			(SetFlag 98)
			(genie init: setScript: genieSummoning)
			(glint1 init: hide:)
			(glint2 init: hide:)
			(genieSong play:)
		else
			(gGame handsOn:)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(not (IsFlag 8))
					(== (gEgo onControl: 1) 2)
					(!= script walkPastArcher)
					(!= script walkPastArcherGenie)
					(not (== gPrevRoomNum north))
				)
				(gGame handsOff:)
				(if (gCast contains: genie)
					(genie setScript: 0)
					(self setScript: walkPastArcherGenie)
				else
					(self setScript: walkPastArcher 0 0)
				)
			)
			(script 0)
			((and (== (gEgo onControl: 1) 128) (== (roses loop:) 2))
				(gGame handsOff:)
				(self setScript: rosesClose)
			)
			((and (== (gEgo onControl: 1) 128) (== (roses loop:) 0))
				(gCurRoom newRoom: north)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber south) (not script) (gCast contains: genie))
			(gGame handsOff:)
			(genie setScript: 0)
			(self setScript: genieMadScript 0 1)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (gCast contains: genie)
				(theConv add: -1 noun theVerb add: -1 noun theVerb 9 init:)
				(return 1)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance glint1 of Prop
	(properties
		view 902
		signal 16384
	)
)

(instance glint2 of Prop
	(properties
		view 902
		signal 16384
	)
)

(instance brick of View
	(properties
		x 254
		y 156
		noun 5
		view 510
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gEgo setScript: getBrick)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance genie of Actor
	(properties
		x 214
		y 101
		noun 7
		view 514
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; peppermint
				(gGame handsOff:)
				(genie setScript: 0)
				(gCurRoom setScript: genieEatsPeppermint)
			)
			(2 ; Talk
				(if local0
					(gGame handsOff:)
					(gCurRoom setScript: interruptGenieScript 0 2)
				else
					(gGame handsOff:)
					(gCurRoom setScript: interruptGenieScript 0 1)
					(++ local0)
				)
			)
			(5 ; Do
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(else
				(gGame handsOff:)
				(gCurRoom setScript: interruptGenieScript 0 theVerb)
			)
		)
	)
)

(instance archer of Prop
	(properties
		x 238
		y 137
		z 79
		noun 10
		view 510
		loop 1
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 1 5 2) ; Look, Do, Talk
				(if (IsFlag 8)
					(gMessager say: noun theVerb 13 0)
				else
					(gMessager say: noun theVerb 14 0)
				)
			)
			((== theVerb 17) ; shield
				(gGame handsOff:)
				(gCurRoom setScript: walkPastArcher 0 1)
			)
			((== theVerb 39) ; brick
				(gMessager say: noun theVerb 0 0) ; "Throwing the brick at the stone archer might scratch his marble, but it won't stop the archer's vigilant watch over the path!"
			)
			((IsFlag 8)
				(gMessager say: noun 0 13 0) ; "The stone archer has lost his arrow and has no more interest in Alexander."
			)
			(else
				(gMessager say: noun 0 14 0) ; "The stone archer would undoubtedly shoot Alexander long before he managed to climb up the wall to try that!"
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (!= loop 6) (not (gCurRoom script:)))
			(self
				cel:
					(-
						8
						(/ (- (GetAngle x y (gEgo x:) (gEgo y:)) 105) 17)
					)
			)
			(if (!= cel local3)
				(creak play:)
				(= local3 cel)
			)
		)
	)
)

(instance fx of Sound
	(properties)
)

(instance genieSong of Sound
	(properties
		flags 1
		number 510
		loop -1
	)
)

(instance creak of Sound
	(properties
		number 513
	)
)

(instance statue2 of Feature
	(properties
		noun 11
		onMeCheck 4
	)
)

(instance wall of Feature
	(properties
		noun 4
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 5 2) ; Look, Do, Talk
			(super doVerb: theVerb)
		else
			(gMessager say: 4 0 0 1) ; "Using that on the wall would not help anything."
		)
	)
)

(instance path of Feature
	(properties
		noun 6
		onMeCheck 34
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 5) (== theVerb 2)) ; Look, Do, Talk
			(super doVerb: theVerb)
		else
			(gMessager say: 6 0 0 1) ; "The path, like destiny, cannot be altered."
		)
	)
)

(instance roses of Prop
	(properties
		x 85
		y 80
		noun 15
		view 513
		priority 14
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 1 2 5) ; Look, Talk, Do
				(cond
					(
						(not
							(or
								(== (roses loop:) 0)
								(and (== (roses loop:) 2) (== (roses cel:) 0))
							)
						)
						(gMessager say: noun theVerb 0)
					)
					((== noun 16)
						(gMessager say: noun theVerb 0)
					)
					(else
						(gazebo doVerb: theVerb &rest)
					)
				)
			)
			((OneOf theVerb 28 39 8 30 25 12 94 70 71 26 20 34) ; spellBook, brick, dagger, feather, holeInTheWall, map, participle, royalRing, rose, ???, tinderBox, tomato
				(cond
					(
						(not
							(or
								(== (roses loop:) 0)
								(and (== (roses loop:) 2) (== (roses cel:) 0))
							)
						)
						(gMessager say: noun theVerb 0 0)
					)
					((== noun 16)
						(gMessager say: noun 0 0) ; "Alexander doesn't need to do anything further with the rose hedge clippings."
					)
					(else
						(gazebo doVerb: theVerb &rest)
					)
				)
			)
			((== theVerb 16) ; scythe
				(cond
					(
						(not
							(or
								(== (roses loop:) 0)
								(and (== (roses loop:) 2) (== (roses cel:) 0))
							)
						)
						(gGame handsOff:)
						(gCurRoom setScript: cutEmBaby)
					)
					((== noun 16)
						(gMessager say: noun 0 0) ; "Alexander doesn't need to do anything further with the rose hedge clippings."
					)
					(else
						(gazebo doVerb: theVerb &rest)
					)
				)
			)
			(
				(not
					(or
						(== (roses loop:) 0)
						(and (== (roses loop:) 2) (== (roses cel:) 0))
					)
				)
				(gMessager say: noun 0 0) ; "That won't help Alexander get through the magical hedges."
			)
			((== noun 16)
				(gMessager say: noun 0 0) ; "Alexander doesn't need to do anything further with the rose hedge clippings."
			)
			(else
				(gazebo doVerb: theVerb &rest)
			)
		)
	)
)

(instance gazebo of Feature
	(properties
		noun 13
		onMeCheck 2048
	)
)

(instance roseFeature of Feature
	(properties
		noun 9
		onMeCheck 64
		approachX 51
		approachY 89
	)

	(method (onMe)
		(if (IsFlag 8)
			(self approachVerbs: 1 5) ; Look, Do
		)
		(return (super onMe: &rest))
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Do
				(cond
					((gEgo has: 38) ; rose
						(gMessager say: noun theVerb 20) ; "Alexander already has a white rose."
					)
					((IsFlag 8)
						(gGame handsOff:)
						(gCurRoom setScript: pickRoseScript)
					)
					(else
						(gMessager say: noun theVerb 14) ; "Alexander can't reach the rose hedges from this side of the wall."
					)
				)
			)
			((== theVerb 16) ; scythe
				(if
					(or
						(== (roses loop:) 0)
						(and (== (roses loop:) 2) (== (roses cel:) 0))
					)
					(gMessager say: noun theVerb 17) ; "Why would Alexander want to use the scythe on the lovely rose hedges?"
				else
					(gMessager say: noun theVerb 18) ; "Hacking at the rose hedges there would not help. That part of the hedge is not blocking the path."
				)
			)
			((OneOf theVerb 1 71 2) ; Look, rose, Talk
				(super doVerb: theVerb &rest)
			)
			((not (IsFlag 8))
				(gMessager say: noun 0 14) ; "Alexander can't do anything with the rose hedges from here."
			)
			((and (== (roses loop:) 2) (== (roses cel:) (roses lastCel:)))
				(gMessager say: noun 0 18) ; "There's no reason to use that there. That part of the hedge isn't blocking the path."
			)
			(else
				(gMessager say: noun 0 17) ; "There's no reason to use that on the lovely rose hedges."
			)
		)
	)
)

(instance garden of Feature
	(properties
		noun 14
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 8)
					(gMessager say: noun theVerb 13) ; "Alexander has enough trouble without digging around in the dirt for more!"
				else
					(gMessager say: noun theVerb 14) ; "Alexander can't reach the small garden from this side of the wall."
				)
			)
			(1 ; Look
				(if (gCast contains: genie)
					(gMessager say: noun theVerb 9) ; "A small garden plot is situated just past the wall."
				else
					(gMessager say: noun theVerb 8) ; "With the gardener gone, Alexander can see that the garden plot is hardly more than a fresh patch of dirt."
				)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(71 ; rose
				(gMessager say: noun theVerb 0) ; "The dirt 'garden' could well use some life, but sticking the rose in the soil will not a garden make."
			)
			(else
				(if (IsFlag 8)
					(gMessager say: noun 0 13) ; "Alexander doesn't have time to mess around with that dirt patch."
				else
					(gMessager say: noun 0 14) ; "Alexander can't do anything with the garden plot from this side of the wall."
				)
			)
		)
	)
)

(instance trees of Feature
	(properties
		noun 12
		onMeCheck 512
	)
)

(instance rocks of Feature
	(properties
		noun 2
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 2 0 0 0) ; "This heavily-forested isle is dotted with rough granite rocks."
			)
			((OneOf theVerb 1 2 5) ; Look, Talk, Do
				(gMessager say: noun theVerb 0 0 0 0)
			)
			(else
				(gMessager say: noun 0 0 0 0 0) ; "There's no reason to use that on the rock."
			)
		)
	)
)

(instance interruptGenieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (genie script:))
				(genie script: 0)
				(= seconds 2)
			)
			(1
				(= local2 (genie loop:))
				(genie x: (- (genie x:) 9) y: (+ (genie y:) 12) setLoop: 6)
				(= ticks 1)
			)
			(2
				(switch register
					(1
						(gMessager say: 7 2 15 0 self) ; "I'm Alexander of Daventry. Who are you?"
					)
					(2
						(gMessager say: 7 2 16 0 self) ; "Tell me...."
					)
					(3
						(gMessager say: 1 0 3 0 self) ; "(STILL FRIENDLY) Come on through, I say! I can show you a path through the forest."
					)
					(4
						(gMessager say: 1 0 4 0 self) ; "(GROWING IRRITATED) Look, there's no point in hanging out here all day! I can show you the wondrous castle that lies in the middle of the island. Don't be so timid!"
					)
					(5
						(gMessager say: 1 0 5 1 self) ; "You aren't going to listen to me, are you? Well, we'll just see about that!"
					)
					(6
						(gMessager say: 1 0 2 0 self) ; "As Alexander continues down the path, he gets the strange feeling that he's being watched."
					)
					(else
						(if (== register 43)
							(gMessager say: 7 register 0 0 self) ; "I have this lamp...."
						else
							(gMessager say: 7 0 0 0 self) ; "Perhaps you'd find this interesting...."
						)
					)
				)
			)
			(3
				(glint1
					show:
					setPri: (+ (genie priority:) 1)
					posn: (- (genie x:) 3) (- (genie y:) 17)
				)
				(glint2
					show:
					setPri: (+ (genie priority:) 1)
					posn: (- (genie x:) 1) (- (genie y:) 17)
				)
				(= ticks 1)
			)
			(4
				(glint1 setCycle: End self)
				(glint2 setCycle: End self)
			)
			(5 0)
			(6
				(glint1 setCycle: Beg self)
				(glint2 setCycle: Beg self)
			)
			(7 0)
			(8
				(glint1 hide:)
				(glint2 hide:)
				(= seconds 2)
			)
			(9
				(if (gCast contains: genie)
					(genie
						loop: local2
						x: (+ (genie x:) 9)
						y: (- (genie y:) 12)
						script: local1
					)
				)
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance genieMadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genie x: (- (genie x:) 9) y: (+ (genie y:) 12) setLoop: 6)
				(= ticks 1)
			)
			(1
				(gMessager say: 1 0 5 1 self) ; "You aren't going to listen to me, are you? Well, we'll just see about that!"
			)
			(2
				(glint1
					show:
					setPri: (+ (genie priority:) 1)
					posn: (- (genie x:) 3) (- (genie y:) 17)
				)
				(glint2
					show:
					setPri: (+ (genie priority:) 1)
					posn: (- (genie x:) 1) (- (genie y:) 17)
				)
				(= ticks 1)
			)
			(3
				(glint1 setCycle: End self)
				(glint2 setCycle: End self)
			)
			(4 0)
			(5
				(glint1 setCycle: Beg self)
				(glint2 setCycle: Beg self)
			)
			(6 0)
			(7
				(glint1 hide:)
				(glint2 hide:)
				(= seconds 1)
			)
			(8
				(self setScript: genieOuttaHere self)
			)
			(9
				(gMessager say: 1 0 5 2 self) ; "That's odd. The gardener just disappeared."
			)
			(10
				(if register
					(gCurRoom newRoom: (gCurRoom south:))
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getBrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 251 160 self)
			)
			(1
				(= cycles 1)
			)
			(2
				(gEgo
					view: 511
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					setHeading: 0
					normal: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(brick dispose:)
				(gGame givePoints: 1)
				(gEgo get: 2 setCycle: End self) ; brick
			)
			(4
				(gEgo setHeading: 180 reset:)
				(= seconds 2)
			)
			(5
				(gGame handsOn:)
				(gMessager say: 5 5) ; "Alexander picks up the brick."
				(self dispose:)
			)
		)
	)
)

(instance walkPastArcher of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				register
				(< (gEgo y:) 160)
				(== state 1)
				(!= (gEgo view:) 511)
			)
			(gEgo normal: 0 view: 511 setLoop: 4)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gMessager say: 2 17 8 1 self) ; "Alexander decides to pass through the gate--preparing the shield just in case."
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(if (< (gEgo y:) 160)
						(gEgo normal: 0 view: 511 setLoop: 4)
					)
					(gEgo setMotion: PolyPath 205 150 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 511 normal: 0 cycleSpeed: 10 cel: 0)
				(if register
					(gEgo setLoop: 2)
				else
					(gEgo
						setPri: 11
						posn: (+ (gEgo x:) 2) (+ (gEgo y:) 4)
						setLoop: 1
					)
				)
				(= cycles 1)
			)
			(3
				(if register
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(4
				(fx number: 511 loop: 1 play: self)
				(archer setCel: 0 cycleSpeed: 10 setLoop: 2 setCycle: End)
			)
			(5
				(if register
					(fx number: 514 loop: 1 play:)
				else
					(fx number: 512 loop: 1 play:)
				)
				(gEgo setCycle: End self)
			)
			(6
				(if register
					(gEgo reset: 7 setCycle: Walk)
				)
				(= cycles 1)
			)
			(7
				(if register
					(gMessager say: 2 17 8 3 self) ; "The magic arrow completely shatters the shield! Good thing the arrow didn't hit Alexander!"
				else
					(gMessager say: 1 0 7 4 self) ; "The stone archer atop the gate released his arrow! Alexander is pierced to the heart!"
				)
			)
			(8
				(if register
					(gGame givePoints: 3)
					(SetFlag 8)
					(gEgo put: 43 510) ; shield
					(archer view: 510 setLoop: 6 setCel: 0)
					(= cycles 1)
					((gCurRoom obstacles:)
						delete: poly1Before
						delete: poly2Before
						add:
							(poly1After
								type: PBarredAccess
								points: @local38
								size: 12
								yourself:
							)
							(poly2After
								type: PBarredAccess
								points: @local62
								size: 13
								yourself:
							)
					)
				else
					(gGame handsOn:)
					(EgoDead 1) ; "That move was slightly arrow-neous!"
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkPastArcherGenie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 163)
				(genie x: (- (genie x:) 9) y: (+ (genie y:) 12) setLoop: 6)
				(gEgo
					view: 511
					normal: 0
					cycleSpeed: 10
					cel: 0
					setPri: 11
					posn: (+ (gEgo x:) 2) (+ (gEgo y:) 4)
					setLoop: 1
				)
				(= cycles 1)
			)
			(1
				(fx number: 511 loop: 1 play: self)
				(archer setCel: 0 cycleSpeed: 10 setLoop: 2 setCycle: End)
			)
			(2
				(fx number: 512 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(genie cycleSpeed: 15 setLoop: 7 setCycle: End self)
			)
			(4
				(genie setLoop: 8 cel: 0 setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(genie setCycle: Beg self)
			)
			(7
				(= cycles 2)
			)
			(8
				(genie setCycle: End self)
			)
			(9
				(= cycles 2)
			)
			(10
				(genie setCycle: Beg self)
			)
			(11
				(= cycles 2)
			)
			(12
				(genie setCycle: End self)
			)
			(13
				(= cycles 2)
			)
			(14
				(genie setCycle: Beg self)
			)
			(15
				(= cycles 2)
			)
			(16
				(glint1
					show:
					setPri: (+ (genie priority:) 1)
					posn: (+ (genie x:) 1) (- (genie y:) 41)
					setCycle: End self
				)
				(glint2
					show:
					setPri: (+ (genie priority:) 1)
					posn: (- (genie x:) 1) (- (genie y:) 41)
					setCycle: End self
				)
			)
			(17 0)
			(18
				(glint1 setCycle: Beg self)
				(glint2 setCycle: Beg self)
			)
			(19 0)
			(20
				(glint1 hide:)
				(glint2 hide:)
				(= cycles 2)
			)
			(21
				(gMessager say: 1 0 6 5 self) ; "Ha, ha, ha! Got you this time!"
			)
			(22
				(gGame handsOn:)
				(EgoDead 1) ; "That move was slightly arrow-neous!"
			)
		)
	)
)

(instance genieEatsPeppermint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genie setLoop: 7 setCel: 0 setCycle: End self)
			)
			(1
				(genie setLoop: 8 setCel: 0)
				(= cycles 2)
			)
			(2
				(theConv add: -1 7 67 0 1 init: self) ; "I have some peppermint leaves. Would you care for some?"
			)
			(3
				(glint1
					show:
					setPri: (+ (genie priority:) 1)
					posn: (- (genie x:) 1) (- (genie y:) 41)
				)
				(glint2
					show:
					setPri: (+ (genie priority:) 1)
					posn: (+ (genie x:) 1) (- (genie y:) 41)
				)
				(= ticks 1)
			)
			(4
				(glint1 setCycle: End self)
				(glint2 setCycle: End self)
			)
			(5 0)
			(6
				(glint1 setCycle: Beg self)
				(glint2 setCycle: Beg self)
			)
			(7 0)
			(8
				(glint1 hide:)
				(glint2 hide:)
				(= seconds 2)
			)
			(9
				(theConv
					add: -1 7 67 0 2 ; "Where'd you find that? I must know!"
					add: -1 7 67 0 3 ; "Why...in a rather narrow place."
					add: -1 7 67 0 4 ; "NEVER MIND! I must have it NOW!"
					init: self
				)
			)
			(10
				(fx number: 943 loop: 1 play:)
				(genie cycleSpeed: 3 setLoop: 5 setCycle: End self)
			)
			(11
				(genie
					posn: (+ (gEgo x:) 33) (- (gEgo y:) 5)
					setCycle: Beg self
				)
				(fx number: 943 loop: 1 play:)
			)
			(12
				(Face gEgo genie self)
			)
			(13
				(gEgo normal: 0 view: 514 setLoop: 11 cel: 0)
				(= cycles 2)
			)
			(14
				(theConv add: -1 7 67 0 5 add: -1 7 67 0 6 init: self) ; "Whoa! You certainly have a unique way of moving around!", "PEPPERMINT!"
			)
			(15
				(genie cycleSpeed: 15 setLoop: 10 cel: 0 setCycle: CT 2 1 self)
				(gEgo cel: 1)
			)
			(16
				(genie setCycle: End self)
				(gEgo put: 31 0 cel: 0) ; peppermint
			)
			(17
				(genie cycleSpeed: 3 setLoop: 5 setCycle: End self)
				(fx number: 943 loop: 1 play:)
			)
			(18
				(genie dispose:)
				(genieSong fade:)
				(gEgo normal: 1 reset:)
				(= ticks 1)
			)
			(19
				(theConv add: -1 7 67 0 7 init: self) ; "Well! He need only have asked for some!"
			)
			(20
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance genieDigging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genie setLoop: 0 cycleSpeed: 10 setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(genie setCycle: End self)
			)
			(2
				(genie setLoop: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(3
				(genie setCycle: End self)
			)
			(4
				(genie setLoop: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(5
				(genie setCycle: End self)
			)
			(6
				(self init:)
			)
		)
	)
)

(instance genieSummoning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: genieDigging)
				(gGame handsOff:)
				(gCurRoom setScript: interruptGenieScript self 6)
			)
			(1
				(= seconds 30)
			)
			(2
				(gGame handsOff:)
				(gCurRoom setScript: interruptGenieScript self 3)
			)
			(3
				(= seconds 30)
			)
			(4
				(gGame handsOff:)
				(gCurRoom setScript: interruptGenieScript self 4)
			)
			(5
				(= seconds 30)
			)
			(6
				(if (not (gCurRoom script:))
					(gGame handsOff:)
					(genie setScript: 0)
					(gCurRoom setScript: genieMadScript 0 0)
				else
					(= cycles 1)
				)
			)
			(7
				(self start: 6 init:)
			)
		)
	)
)

(instance genieOuttaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genie cycleSpeed: 15 setLoop: 7 setCycle: End self)
			)
			(1
				(genie setLoop: 8 cel: 0 setCycle: End self)
			)
			(2
				(genie setCycle: Beg self)
			)
			(3
				(= cycles 2)
			)
			(4
				(genie setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(genie setCycle: Beg self)
			)
			(7
				(= cycles 2)
			)
			(8
				(genie setCycle: End self)
			)
			(9
				(= cycles 2)
			)
			(10
				(fx number: 943 loop: 1 play:)
				(genie cycleSpeed: 3 setLoop: 5 setCycle: End self)
			)
			(11
				(genieSong fade:)
				(genie dispose:)
				(self dispose:)
			)
		)
	)
)

(instance rosesClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 21 1 self) ; "Alexander walks forward to step onto the gazebo...."
			)
			(1
				(fx number: 484 loop: 1 play:)
				(roses setCycle: CT 11 1 self)
			)
			(2
				(roses setLoop: 1)
				((gCurRoom obstacles:)
					delete: poly1After
					delete: poly2After
					add: (polyHedge type: PBarredAccess points: @local88 size: 23 yourself:)
				)
				(gMessager say: 1 0 21 2 self) ; "But the rose hedges on either side of the path, sensing an intruder's presence, reach out their vines and blend together! The path is blocked!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cutEmBaby of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(OneOf state 2 4 5 7 8)
				(!= register (gEgo cel:))
				(OneOf (gEgo cel:) 0 2 4 6)
			)
			(= register (gEgo cel:))
			(fx play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register -1)
				(fx number: 516 loop: 1)
				(gGame givePoints: 3)
				(gEgo setMotion: PolyPath 90 88 self)
			)
			(1
				(gMessager say: 15 16 0 1 self) ; "Alexander wields the scythe, determined to get past the magical rose hedges."
			)
			(2
				(roses cycleSpeed: 50 setLoop: 0 cel: 0 setCycle: CT 8 1)
				(gEgo
					view: 531
					normal: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gMessager say: 15 16 0 2 self) ; "The leaves fly as Alexander tries to cut the branches faster than they can grow back together!"
			)
			(4
				(gEgo setLoop: 1 setCycle: End self)
			)
			(5
				(gEgo setLoop: 0 setCycle: End self)
			)
			(6
				(gMessager say: 15 16 0 3 self) ; "He sees light...."
			)
			(7
				(gEgo setLoop: 1 setCycle: End self)
			)
			(8
				(gEgo setLoop: 0 setCycle: End self)
			)
			(9
				(= cycles 7)
			)
			(10
				(gMessager say: 15 16 0 4 self) ; "He's through!"
			)
			(11
				(gEgo reset: 3)
				(SetFlag 9)
				(= cycles 1)
			)
			(12
				(gEgo
					ignoreHorizon: 1
					ignoreActors: 1
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 10)
						self
				)
			)
			(13
				(gEgo setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self)
			)
			(14
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance pickRoseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 531
					normal: 0
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo get: 38 reset: 5) ; rose
				(= cycles 1)
			)
			(2
				(if (not (SetFlag 137))
					(gGame givePoints: 1)
				)
				(gGame handsOn:)
				(gMessager say: 9 5 13) ; "Alexander takes a magnificent white rose from the rose hedges."
				(self dispose:)
			)
		)
	)
)

(instance theConv of Conversation
	(properties)
)

(instance egoUseShieldCode of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(17 ; shield
				(gGame handsOff:)
				(gCurRoom setScript: walkPastArcher 0 1)
				(return 1)
			)
		)
		(return 0)
	)
)

(instance poly1Before of Polygon
	(properties)
)

(instance poly2Before of Polygon
	(properties)
)

(instance poly1After of Polygon
	(properties)
)

(instance poly2After of Polygon
	(properties)
)

(instance polyHedge of Polygon
	(properties)
)

