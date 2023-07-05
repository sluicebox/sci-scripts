;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use rgCastle)
(use KQ6Print)
(use n913)
(use Inset)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm880 0
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

(instance rm880 of CastleRoom
	(properties
		noun 3
		picture 880
		horizon 0
		vanishingX 318
		vanishingY 69
		minScaleSize 95
	)

	(method (init)
		(LoadMany rsVIEW 882 881 880)
		(if
			(and
				((ScriptID 80 0) tstFlag: #rFlag3 512) ; rgCastle
				(not ((ScriptID 80 0) tstFlag: #rFlag2 1)) ; rgCastle
				(not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
			)
			((ScriptID 80 0) guardTimer: 0 setFlag: #rFlag2 1) ; rgCastle
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 62 70 62 135 93 143 117 148 155 148 190 149 221 143 234 134 234 125 224 116 201 108 181 104 181 70
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 100 118 119 115 132 113 143 117 143 125 110 125
					yourself:
				)
		)
		(if (<= (gEgo y:) 136)
			(gEgo posn: 170 123)
		else
			(gEgo posn: 98 128)
		)
		(gEgo
			init:
			reset: 0
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(= local0 (OneOf ((gInventory at: 26) owner:) 880 gEgo)) ; nail
		(gFeatures add: roomFeatures pillar eachElementDo: #init)
		(portrait init: stopUpd:)
		(if (== ((gInventory at: 27) owner:) 850) ; nightingale
			(bird init:)
		)
		(if (== ((gInventory at: 26) owner:) 880) ; nail
			(nail init:)
		)
		(super init: &rest)
		((ScriptID 1015 6) talkWidth: 150 x: 15 y: 20) ; tlkGuardDog1
		((ScriptID 1015 7) talkWidth: 135 x: 160 y: 20) ; tlkGuardDog2
		(cond
			(((ScriptID 80 0) tstFlag: #rFlag1 256) ; rgCastle
				((ScriptID 80 0) clrFlag: #rFlag1 256) ; rgCastle
				(self setScript: enterRoomScr 0 guardsTakeBird)
			)
			(((ScriptID 80 0) tstFlag: #rFlag2 1) ; rgCastle
				(self setScript: enterRoomScr 0 watchGuardsComeBack)
			)
			((!= ((gInventory at: 27) owner:) 730) ; nightingale
				((ScriptID 80 5) ; guard1
					init:
					setPri: 5
					ignoreActors:
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 200 87
					setScript: guardsPatrol
				)
				((ScriptID 80 6) ; guard2
					init:
					setPri: 5
					ignoreActors:
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 212 87
				)
			)
			(else 0)
		)
		(if (not script)
			(gGame handsOn:)
		)
		((ScriptID 80 0) clrFlag: #rFlag3 256) ; rgCastle
	)

	(method (warnUser param1)
		(switch param1
			(2
				(KQ6Print posn: -1 10 font: gUserFont say: 0 1 0 3 1 init:) ; "Alexander hears the guards approaching from the stairs."
				(watchGuardsComeBack start: -1)
				(if (not script)
					(self setScript: watchGuardsComeBack)
				else
					(if (gTheDoits contains: portraitInset)
						(portraitInset dispose:)
					)
					(script next: watchGuardsComeBack)
				)
				(hideEgo caller: watchGuardsComeBack)
				((hideEgo caller:) setScript: waitForEgoToHide)
			)
			(1
				(gMessager say: 1 0 5 1) ; "From downstairs, Alexander hears the first wafting strains of music. Hmmm. It's beautiful music...."
				(if (not script)
					(self setScript: waitedToLongToEscape)
				else
					(script next: waitedToLongToEscape)
					(if (gTheDoits contains: portraitInset)
						(portraitInset dispose:)
					)
				)
			)
			(else
				(super warnUser: param1 &rest)
			)
		)
	)

	(method (doit)
		(if (& (= local6 (gEgo onControl: 1)) $4002)
			(self newRoom: 850)
		)
		(super doit: &rest)
	)

	(method (dispose)
		((ScriptID 80 5) setScript: 0 setPri: -1) ; guard1
		((ScriptID 80 6) setPri: -1) ; guard2
		(super dispose:)
	)

	(method (setScript param1)
		(if (IsObject param1)
			(if (hideEgo caller:)
				(waitForEgoToHide register: (+ (waitForEgoToHide register:) 1))
				(param1 next: waitForEgoToHide)
				((hideEgo caller:) setScript: param1 &rest)
			else
				(super setScript: param1 &rest)
			)
		else
			(super setScript: param1 &rest)
		)
	)

	(method (scriptCheck &tmp temp0)
		(= temp0 0)
		(if (!= ((gInventory at: 27) owner:) 730) ; nightingale
			(gMessager say: 0 0 112 0 0 899) ; "There's no time for that now! There are guard dogs on patrol just on the other side of that pillar!"
		else
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance enterRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(switch register
					(guardsTakeBird
						((ScriptID 80 0) setFlag: #rFlag3 128) ; rgCastle
						(gMessager say: 1 0 2 1 self) ; "The mechanical song echoes in the corridor. Alexander hears the sound of boots pounding as the guard dogs come to investigate."
					)
					(watchGuardsComeBack
						(gMessager say: 1 0 3 1 self) ; "Alexander hears the guards approaching from the stairs."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(register start: -1)
				(gCurRoom setScript: register)
				(hideEgo caller: register)
				(gGame handsOn:)
				((hideEgo caller:) setScript: waitForEgoToHide)
			)
		)
	)
)

(instance waitedToLongToEscape of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 964)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) setFlag: #rFlag3 128) ; rgCastle
				(= cycles 4)
			)
			(1
				(gMessager say: 1 0 5 2 self) ; "It's wedding music!!!!!"
			)
			(2
				(gMessager say: 1 0 5 3 self) ; "The music has attracted the guards' attention. Alexander hears them coming down the hallway."
			)
			(3
				(self setScript: hideEgo self 1)
			)
			(4
				(= seconds 2)
			)
			(5
				((ScriptID 80 5) setMotion: MoveTo 108 98) ; guard1
				((ScriptID 80 6) setMotion: MoveTo 79 114 self) ; guard2
			)
			(6
				(gMessager say: 1 0 5 4 self) ; "Just a minute, Wolf, I want to pay my respects to the king and queen before we go down for the weddin'."
			)
			(7
				(Face (ScriptID 80 6) (ScriptID 80 5) self) ; guard2, guard1
			)
			(8
				(gMessager say: 1 0 5 5 self) ; "What a nice idea, Bay. I will too."
			)
			(9
				((ScriptID 80 5) setPri: -1) ; guard1
				((ScriptID 80 6) setPri: -1) ; guard2
				((ScriptID 80 5) setMotion: MoveTo 161 111 self) ; guard1
				((ScriptID 80 6) setMotion: DPath 94 129 122 128) ; guard2
			)
			(10
				(gMessager say: 1 0 5 6 self) ; "Hey! It's a man!"
			)
			(11
				(gMessager say: 1 0 5 7 self) ; "I bet he was the one what tried to trick us with that metal bird!"
			)
			(12
				(self setScript: hideEgo self)
			)
			(13
				(gMessager say: 1 0 5 8 self oneOnly: 0) ; "It WAS me, actually. Sorry. But now I really must get down to that wedding."
			)
			(14
				(gCurRoom moveOtherGuard: 1)
				(gCurRoom spotEgo: (proc80_7))
			)
		)
	)
)

(instance walkGuardsOutPartial of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (not register)
			(if ((ScriptID 80 0) tstFlag: #rFlag3 128) ; rgCastle
				((ScriptID 80 5) posn: 200 87) ; guard1
				((ScriptID 80 6) posn: 212 87) ; guard2
			else
				((ScriptID 80 5) posn: 37 113) ; guard1
				((ScriptID 80 6) posn: 57 120) ; guard2
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gEgo x:) 126)
					(= local2 159)
					(= local3 94)
					(= local4 169)
					(= local5 98)
				else
					(= local2 93)
					(= local3 105)
					(= local4 112)
					(= local5 108)
				)
				(= cycles 1)
			)
			(1
				((ScriptID 80 5) ; guard1
					init:
					setPri: 5
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					setMotion: MoveTo local2 local3
				)
				((ScriptID 80 6) ; guard2
					init:
					setPri: 5
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					setMotion: MoveTo local4 local5 self
				)
			)
			(2
				((ScriptID 80 5) setPri: -1) ; guard1
				((ScriptID 80 6) setPri: -1) ; guard2
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance takeDownPicture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 5 10 0 self) ; "Alexander checks behind the portrait."
			)
			(1
				(nail init:)
				(portrait hide:)
				(gEgo
					view: 882
					setScale: 0
					scaleX: 128
					scaleY: 128
					loop: 1
					cel: 0
					x: 216
					y: 118
					cycleSpeed: 8
					normal: 0
					setCycle: End self
				)
			)
			(2
				(portrait show: posn: 214 111 stopUpd:)
				(gEgo loop: 2 cel: 0 x: 216 y: 118 setCycle: End self)
			)
			(3
				(if (or (== next waitForEgoToHide) (not next))
					(gGame handsOn:)
				)
				(if (not (SetFlag 87))
					(gGame givePoints: 3)
				)
				(= local0 1)
				(gEgo reset: 6 posn: 205 112)
				(self dispose:)
			)
		)
	)
)

(instance replacePicture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 5 12 0 self) ; "Alexander puts the heavy portrait back on the wall."
			)
			(1
				(gEgo
					view: 882
					setScale: 0
					scaleX: 128
					scaleY: 128
					loop: 2
					cel: 4
					x: 216
					y: 118
					cycleSpeed: 8
					normal: 0
					setCycle: Beg self
				)
			)
			(2
				(portrait hide:)
				(gEgo loop: 1 cel: 6 x: 216 y: 118 setCycle: Beg self)
			)
			(3
				(portrait posn: 223 87 show: stopUpd:)
				(nail dispose:)
				((gInventory at: 26) owner: 0) ; nail
				(if (or (== next waitForEgoToHide) (not next))
					(gGame handsOn:)
				)
				(= local0 0)
				(gEgo reset: 6 posn: 205 112)
				(self dispose:)
			)
		)
	)
)

(instance guardsTakeBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 2)
				((ScriptID 80 0) clrFlag: #rFlag3 128) ; rgCastle
				(self setScript: leaveConvScr self)
			)
			(1
				(roomConv add: -1 1 0 2 2 add: -1 1 0 2 3 init: self) ; "Look at this, Wolf! A metal bird!", "Sure is, Bay. How do you suppose a metal bird got in here?"
			)
			(2
				(self setScript: leaveConvScr self)
			)
			(3
				(roomConv
					add: -1 1 0 2 4 ; "You got me, but there's somethin' weird about.... Hey! Could this be Cassima's nightingale, do you think?"
					add: -1 1 0 2 5 ; "What? You lapdog! The princess's nightingale isn't some tin thing!"
					add: -1 1 0 2 6 ; "How do you know? Have you seen it?"
					add: -1 1 0 2 7 ; "Well. No, but...."
					add: -1 1 0 2 8 ; "I don't know, Bay. Humans can be pretty strange. <Growf> With THEIR sense of smell, maybe she wouldn't even know it wasn't real. I say we take it downstairs to Captain Saladin. He'll know what to do with it."
					add: -1 1 0 2 9 ; "What about our post?"
					add: -1 1 0 2 10 ; "Jowels and Mite are in the other hallway. They can handle it for five minutes. Think about how happy the princess'd be to get her nightingale back."
					add: -1 1 0 2 11 ; "And then there's that reward money and my missus...."
					add: -1 1 0 2 12 ; "Right, Wolf. Let's go."
					init: self
				)
			)
			(4
				(self setScript: leaveConvScr self)
			)
			(5
				(roomConv add: -1 1 0 2 13 10 10 init: self) ; "Alexander hears the guard dogs' boots clank noisily on the staircase leading down to the grand hall."
			)
			(6
				(self setScript: hideEgo self)
			)
			(7
				((gInventory at: 27) owner: 730) ; nightingale
				((ScriptID 80 0) guardTimer: 301 setFlag: #rFlag1 512) ; rgCastle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveConvScr of Script
	(properties)

	(method (dispose)
		(= start (+ state 1))
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 5) ; guard1
					init:
					setPri: 5
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 200 87
					setMotion: MoveTo 93 105 self
				)
				((ScriptID 80 6) ; guard2
					init:
					setPri: 5
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 212 87
					setMotion: MoveTo 112 108 self
				)
			)
			(1 0)
			(2
				((ScriptID 80 5) setHeading: 180 self) ; guard1
			)
			(3
				(self dispose:)
			)
			(4
				((ScriptID 80 5) setMotion: MoveTo 90 108 self) ; guard1
			)
			(5
				((ScriptID 80 5) setHeading: 180 self) ; guard1
			)
			(6
				(= cycles 4)
			)
			(7
				((ScriptID 80 5) view: 884 loop: 0 cel: 0 setCycle: CT 5 1 self) ; guard1
			)
			(8
				(bird dispose:)
				((ScriptID 80 5) setCycle: End self) ; guard1
			)
			(9
				(self dispose:)
			)
			(10
				(gGlobalSound fadeTo: 700 -1)
				((ScriptID 80 5) ; guard1
					view: 724
					loop: 2
					setCycle: StopWalk -1
					setMotion: MoveTo 52 111
				)
				((ScriptID 80 6) setMotion: MoveTo 52 120 self) ; guard2
			)
			(11
				((ScriptID 80 5) dispose:) ; guard1
				((ScriptID 80 6) dispose:) ; guard2
				(= state -1)
				(self dispose:)
			)
		)
	)
)

(instance returningConvScr of Script
	(properties)

	(method (dispose param1)
		(if param1
			(= start (+ state 1))
		else
			(= start 0)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				((ScriptID 80 5) ; guard1
					init:
					setPri: 5
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 37 113
					setMotion: MoveTo 93 105 self
				)
				((ScriptID 80 6) ; guard2
					init:
					setPri: 5
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 57 120
					setMotion: MoveTo 112 108 self
				)
			)
			(2 0)
			(3
				(if (OneOf ((gInventory at: 26) owner:) 880 gEgo) ; nail
					(+= state 4)
				)
				(self cue:)
			)
			(4
				(Face (ScriptID 80 5) (ScriptID 80 6)) ; guard1, guard2
				(Face (ScriptID 80 6) (ScriptID 80 5) self) ; guard2, guard1
			)
			(5
				(self dispose: 1)
			)
			(6
				((ScriptID 80 5) setHeading: 45) ; guard1
				((ScriptID 80 6) setHeading: 45 self) ; guard2
			)
			(7
				(self dispose: 1)
			)
			(8
				(if (OneOf ((gInventory at: 26) owner:) 880 gEgo) ; nail
					(hideEgo caller: 0)
					(= caller 0)
					(gCurRoom setScript: pictureDownGetEgo)
				else
					((ScriptID 80 5) setMotion: MoveTo 200 87 self) ; guard1
					((ScriptID 80 6) setMotion: MoveTo 212 87) ; guard2
				)
			)
			(9
				(self dispose: 0)
			)
		)
	)
)

(instance getNail of Script
	(properties)

	(method (dispose)
		(= start (= register 0))
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (= register (gEgo has: 26)) ; nail
					(gEgo put: 26 880) ; nail
				)
				(gGame handsOff:)
				(gEgo
					view: 882
					loop: 3
					cel: 0
					x: 204
					y: 115
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(if register
					(gMessager say: 9 64 0 0 self) ; "Alexander puts the nail back into the wall."
					(nail init:)
				else
					(gMessager say: 7 5 0 0 self) ; "Alexander pulls the nail out of the wall and keeps it."
					(gEgo get: 26) ; nail
					(nail dispose:)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo reset: 6 posn: 204 110)
				(if (not (SetFlag 88))
					(gGame givePoints: 1)
				)
				(if (or (== next waitForEgoToHide) (not next))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance lookAtPicture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 882
					loop: 0
					cel: 0
					x: 201
					y: 122
					setScale: 0
					scaleX: 128
					scaleY: 128
					normal: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(gMessager say: 4 1 0 0 self) ; "Alexander takes a closer look at the portrait on the wall."
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3 4 5)
				(portraitInset init: self gCurRoom)
			)
			(4
				(gGame handsOff:)
				(= register 0)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					reset: 6
					posn: (portrait approachX:) (portrait approachY:)
				)
				(if (or (hideEgo caller:) (not next))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance hideEgo of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(waitForEgoToHide register: 0)
				(++ state)
				(if
					(= temp0
						(cond
							(
								(and
									(!= (gCurRoom script:) waitedToLongToEscape)
									((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
								)
								(-- state)
								15
							)
							((== ((gInventory at: 27) owner:) 850) 16) ; nightingale
							(
								(and
									((ScriptID 80 0) tstFlag: #rFlag1 512) ; rgCastle
									(not ((ScriptID 80 0) tstFlag: #rFlag2 1)) ; rgCastle
								)
								(-- state)
								14
							)
							(else 0)
						)
					)
					(gMessager say: 8 5 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
			(2
				(if (or register (= register (>= (gEgo x:) 126)))
					(= start 8)
					(gEgo setMotion: PolyPath 170 123 self)
				else
					(= start 9)
					(= state 4)
					(gEgo setMotion: PolyPath 98 128 self)
				)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(= state 6)
				(gEgo
					view: 881
					setLoop: 4
					cel: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					x: 152
					y: 128
					normal: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(5
				(gEgo
					view: 881
					setLoop: 0
					cel: 0
					x: 107
					y: 130
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					cycleSpeed: 8
				)
				(= cycles 3)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(if (== client gCurRoom)
					(= state (- start 1))
					(= cycles 10)
				else
					(self dispose:)
				)
			)
			(8
				(= state 12)
				(= register 1)
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(= seconds 2)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo loop: 0 cel: 4 setCycle: Beg self)
			)
			(13
				(= start 0)
				(gEgo reset: 6)
				(if register
					(gEgo posn: 170 123)
				else
					(gEgo posn: 98 128)
				)
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance guardsPatrol of Script
	(properties)

	(method (doit)
		(if (& local6 $4002)
			(gCurRoom newRoom: 850)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(= start 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (hideEgo client:)
					(-- state)
					(hideEgo caller: self)
				else
					(gMessager say: 1 0 1 0 self) ; "Alexander hears the guards' footsteps pause for a moment, then start up again."
					((ScriptID 80 0) setFlag: #rFlag3 128) ; rgCastle
				)
			)
			(2
				(gGame handsOn:)
				(hideEgo caller: self)
				(self setScript: waitForEgoToHide)
			)
			(3
				(gGame handsOff:)
				(if register
					(++ state)
				)
				(self setScript: guardsWalk self)
			)
			(4
				(gMessager say: 1 0 6 2 self) ; "The guards pass the pillar, and Alexander sighs in relief. They didn't see him!"
			)
			(5
				(if register
					(++ state)
					(= seconds 3)
				else
					(= seconds 2)
				)
			)
			(6
				(gMessager say: 1 0 6 3 self) ; "The guards turn around at the staircase and head back."
			)
			(7
				((ScriptID 80 0) clrFlag: #rFlag3 128) ; rgCastle
				(if (OneOf ((gInventory at: 26) owner:) 880 gEgo) ; nail
					(gCurRoom setScript: pictureDownGetEgo)
				else
					(self setScript: guardsWalk self)
				)
			)
			(8
				(if register
					(gMessager say: 1 0 8 2 self) ; "And there they go."
				else
					(gMessager say: 1 0 6 4 self) ; "Phew! That was a close one."
				)
			)
			(9
				(self setScript: hideEgo self)
			)
			(10
				(gGame handsOn:)
				(= register 1)
				(= seconds 8)
			)
			(11
				(if (gCurRoom script:)
					(-- state)
					((gCurRoom script:) caller: self)
				else
					(gMessager say: 1 0 7 0 self) ; "The sound of footsteps grows louder as the guards in the main hallway turn and head back towards the stairs."
					((ScriptID 80 0) setFlag: #rFlag3 128) ; rgCastle
				)
			)
			(12
				(hideEgo caller: self)
				(self setScript: waitForEgoToHide)
			)
			(13
				(gGame handsOff:)
				(= state 2)
				(gMessager say: 1 0 8 1 self) ; "Here they come again."
			)
		)
	)
)

(instance guardsWalk of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if register
					(= temp0 200)
					(= temp1 87)
					(= temp2 212)
					(= temp3 87)
				else
					(= temp0 37)
					(= temp1 113)
					(= temp2 57)
					(= temp3 120)
				)
				((ScriptID 80 5) setMotion: MoveTo temp0 temp1 self) ; guard1
				((ScriptID 80 6) setMotion: MoveTo temp2 temp3 self) ; guard2
			)
			(1 0)
			(2
				(= register (not register))
				(self dispose:)
			)
		)
	)
)

(instance waitForEgoToHide of Script
	(properties)

	(method (dispose)
		(= seconds (= cycles 0))
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> register 2)
					(self cue:)
				else
					(= seconds 7)
				)
			)
			(1
				(gGame handsOff:)
				(if
					(and
						(<= register 2)
						(OneOf
							(gCurRoom script:)
							getNail
							takeDownPicture
							replacePicture
							lookAtPicture
						)
					)
					(-- state)
					((gCurRoom script:) caller: self)
				else
					(= temp0 (hideEgo caller:))
					(hideEgo caller: 0)
					(gCurRoom setScript: waitedTooLong 0 temp0)
				)
			)
		)
	)
)

(instance waitedTooLong of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(self setScript: walkGuardsOutPartial self)
			)
			(1
				((ScriptID 80 6) setHeading: 180 self) ; guard2
			)
			(2
				(switch register
					(watchGuardsComeBack
						(roomConv add: -1 1 0 21 1) ; "Hey! Look, Wolf! There's a man in the alcove! He must have been the one who tried to fool us with that fake bird!"
					)
					(guardsTakeBird
						(roomConv add: -1 1 0 20 1) ; "Hey! Look, Wolf! There's a metal bird on the floor! And there's a man in the alcove!"
					)
					(else
						(roomConv add: -1 1 0 17 1) ; "Hey! Look, Wolf! There's a man back here!"
					)
				)
				(roomConv init: self)
			)
			(3
				(Face gEgo (ScriptID 80 5) self) ; guard1
			)
			(4
				(= cycles 2)
			)
			(5
				(roomConv add: -1 1 0 17 2 add: -1 1 0 17 3 init: self) ; "Hello, there! Um...nice painting.", "Get 'em, Bay!"
			)
			(6
				(if (gEgo inRect: 57 117 124 169)
					(gCurRoom setScript: getEgo)
				else
					(gCurRoom spotEgo: (proc80_7))
				)
			)
		)
	)
)

(instance pictureDownGetEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(self
					setScript:
						walkGuardsOutPartial
						self
						(not ((ScriptID 80 0) tstFlag: #rFlag3 128)) ; rgCastle
				)
			)
			(2
				((ScriptID 80 6) setHeading: 180 self) ; guard2
			)
			(3
				(gMessager say: 1 0 19 1 self) ; "Hey! Look, Wolf! The king and queen's portrait fell down!"
			)
			(4
				(gMessager say: 1 0 19 2 self) ; "Er...sorry. I was just looking at it."
			)
			(5
				(self setScript: hideEgo self)
			)
			(6
				(gMessager say: 1 0 19 3 self) ; "Get 'em, Bay!"
			)
			(7
				(gCurRoom spotEgo: (proc80_7))
			)
		)
	)
)

(instance nail of View
	(properties
		x 226
		y 60
		noun 7
		approachX 204
		approachY 115
		view 880
		loop 1
		cel 1
		priority 6
		signal 24593
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
		((gInventory at: 26) owner: 880) ; nail
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getNail)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bird of Prop
	(properties
		x 95
		y 110
		view 880
		loop 3
		signal 24576
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance portrait of View
	(properties
		heading 180
		noun 4
		sightAngle 40
		view 880
		loop 2
		priority 6
		signal 28689
	)

	(method (init)
		(if local0
			(self posn: 214 111)
		else
			(self posn: 223 87)
		)
		(super init: &rest)
		(self approachVerbs: 1 5) ; Look, Do
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
						(= approachX 198)
						(= approachY 116)
					)
					(and (= approachX 204) (= approachY 110))
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: lookAtPicture)
			)
			(5 ; Do
				(cond
					((not local0)
						(gCurRoom setScript: takeDownPicture)
					)
					((== ((gInventory at: 26) owner:) 880) ; nail
						(gCurRoom setScript: replacePicture)
					)
					(else
						(gMessager say: noun theVerb 13) ; "Alexander can't return the portrait to the wall now that he's taken the nail."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomFeatures of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(= approachX (= approachY (= _approachVerbs 0)))
		(return
			(or
				(and (not (InRect 71 39 251 144 param1)) (= noun 6))
				(and
					(& $0004 temp0)
					(= noun 9)
					(or
						(and
							(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
							(== (gTheIconBar curInvIcon:) (gInventory at: 26)) ; nail
							(= approachX 204)
							(= approachY 110)
							(= _approachVerbs -32768)
						)
						1
					)
				)
				(and (& $0008 temp0) (= noun 10))
				(and (& $4060 temp0) (= noun 5))
			)
		)
	)

	(method (doVerb theVerb)
		(switch noun
			(9
				(switch theVerb
					(64 ; nail
						(gCurRoom setScript: getNail)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(5
				(switch theVerb
					(5 ; Do
						(gMessager say: noun) ; "Alexander will have to walk out into the main hall if he wants to do something there."
					)
					(else
						(if (== (gKq6ApproachCode doit: theVerb) -32768)
							(gMessager say: noun) ; "Alexander will have to walk out into the main hall if he wants to do something there."
						else
							(super doVerb: theVerb)
						)
					)
				)
			)
			(6
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(= theVerb 5) ; Do
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillar of Feature
	(properties
		x 126
		y 123
		noun 8
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(if (hideEgo caller:)
				((hideEgo caller:) setScript: hideEgo)
			else
				(gCurRoom setScript: hideEgo 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance portraitInset of Inset
	(properties
		view 880
		disposeNotOnMe 1
		noun 11
	)

	(method (init)
		(= x (- 160 (/ (CelWide view loop cel) 2)))
		(= y (- 90 (/ (CelHigh view loop cel) 2)))
		(super init: &rest)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance getEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound stop:)
				(gGlobalSound2 number: 710 loop: -1 play:)
				((ScriptID 80 5) setMotion: MoveTo 78 109 self) ; guard1
				((ScriptID 80 6) setLoop: 2 setMotion: MoveTo 100 120) ; guard2
			)
			(1
				((ScriptID 80 5) setLoop: 2 setMotion: MoveTo 76 120 self) ; guard1
			)
			(2
				(= ticks 30)
			)
			(3
				(gGlobalSound2 fade:)
				(rgCastle
					rFlag1: (| (rgCastle rFlag1:) $2000)
					dungeonEntered: 3
				)
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance watchGuardsComeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 150)
				((ScriptID 1012 32) talkWidth: 100 x: 160 y: 10) ; tlkGeniePage
				((ScriptID 80 0) clrFlag: #rFlag2 1) ; rgCastle
				(= cycles 3)
			)
			(1
				(self setScript: returningConvScr self)
			)
			(2
				(roomConv
					add: -1 1 0 3 2 ; "If you didn't have the brain of a cat, Wolf, you'd have known that mechanical nightingale wasn't Cassima's nightingale!"
					add: -1 1 0 3 3 ; "Me? I was all for stayin' on patrol, but you wanted to show the thing to Saladin!"
					add: -1 1 0 3 4 ; "Well.... At least the Captain wasn't too mad. He's a good honest dog, Saladin is."
					add: -1 1 0 3 5 ; "Aye, <ruff>. Wish the same could be said of our...."
					add: -1 1 0 3 6 ; "HUSH! Do you want to be dazzled, you fool?"
					add: -1 1 0 3 7 -1 10 ; "Somewhere nearby, a door opens."
					init: self
				)
			)
			(3
				(self setScript: returningConvScr self)
			)
			(4
				(roomConv
					add: -1 1 0 3 8 ; "<ahem> Greetings, Shamir...sir."
					add: -1 1 0 3 9 -1 10 ; "A petulant voice snaps a response at the guards."
					add: -1 1 0 3 10 ; "The wedding is about to begin. Make sure everything's secure!"
					add: -1 1 0 3 11 ; "Yes, sir!"
					add: -1 1 0 3 12 -1 10 ; "Footsteps retreat down the hall towards the back hallway."
					add: -1 1 0 3 13 ; "Alexander hears the distant sound of chains rattling. A door opens...."
					add: -1 1 0 3 14 -1 10 ; "There's a small commotion and a woman's sharp cry."
					add: -1 1 0 3 15 ; "...Cassima!..."
					add: -1 1 0 3 16 -1 10 ; "Gradually the sounds fade away off to the east. All is silent."
					add: -1 1 0 3 17 ; "(KEEPING HIS VOICE LOW, BUT OUTRAGED)Here now! If it weren't for him bein' the vizier's page and all, I'd have somethin' to say about that!"
					add: -1 1 0 3 18 ; "<GRRR> Wonder where he's taking her? The wedding's the other way."
					add: -1 1 0 3 19 ; "You never know with that one. He's always showin' up when he shouldn't be and goin' where he oughtn't. Let's go check it out."
					init: self
				)
			)
			(5
				(self setScript: returningConvScr self)
			)
			(6
				(roomConv add: -1 1 0 3 20 -1 10 init: self) ; "The guard dogs seem to have stopped at the back hallway."
			)
			(7
				(self setScript: hideEgo self)
			)
			(8
				((ScriptID 80 0) weddingRemind: 125 clrFlag: #rFlag1 512) ; rgCastle
				((ScriptID 80 0) clrFlag: #rFlag2 1 setFlag: #rFlag1 2) ; rgCastle
				(= cycles 3)
			)
			(9
				(gGame handsOn:)
				(ClearFlag 150)
				(self dispose:)
			)
		)
	)
)

