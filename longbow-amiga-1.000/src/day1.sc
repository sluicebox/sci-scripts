;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use n013)
(use Wat)
(use verseScript)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	day1 0
	day3 1
	day4 2
	day5 3
	day6A 4
	day6B 5
	day8 6
	day9 7
	day12 8
	setup 9
)

(local
	[local0 2]
	local2
	local3
	[local4 4] = [1018 10 2 0]
	[local8 4] = [1018 11 2 0]
	[local12 4] = [1018 12 2 0]
	[local16 5] = [1018 13 1 2 0]
	[local21 5] = [1018 15 1 2 0]
	[local26 5] = [1018 17 1 1 0]
	[local31 5] = [1018 19 1 2 0]
)

(instance day1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(gEgo stopUpd:)
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 1)
				(character1
					name: {woman}
					lookStr: 16
					view: 110
					setLoop: 0
					posn: 325 85
					init:
					setCycle: Walk
					setMotion: MoveTo 254 98 self
				)
			)
			(1
				(character2
					name: {flunky}
					lookStr: 18
					view: 110
					setLoop: 6
					posn: 325 65
					setStep: 3 2
					init:
					setCycle: Walk
					setMotion: MoveTo 240 100 self
				)
			)
			(2
				(= local2 0)
				(character1 lookStr: 17 setLoop: 1)
				(= ticks 120)
			)
			(3
				(character1 stopUpd:)
				(character2 setLoop: 2 setCel: 0)
				(= ticks 20)
			)
			(4
				(character1 hide:)
				(character2 setCel: 1 stopUpd:)
				(= ticks 90)
			)
			(5
				(character2 cycleSpeed: 12 setCycle: CT 2 1 self)
			)
			(6
				(character2 setCycle: CT 1 -1 self)
			)
			(7
				(character2 setCycle: CT 3 1 self)
			)
			(8
				(character2 setCycle: CT 1 -1 self)
			)
			(9
				(= ticks 60)
			)
			(10
				(character2 setCycle: CT (- (character2 lastCel:) 1) 1 self)
			)
			(11
				(character2 setCel: (character2 lastCel:) stopUpd:)
				(character1
					posn: 236 105
					setLoop: 0
					setCel: 4
					setCycle: Walk
					show:
					stopUpd:
				)
				(= ticks 6)
			)
			(12
				(character1 posn: 232 107 setMotion: MoveTo 40 152)
				(character2
					view: 755
					posn: 225 106
					setLoop: 4
					cycleSpeed: 6
					setStep: 2 1
					setCycle: Walk
					setMotion: MoveTo 40 152 self
				)
			)
			(13
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSFX2 fade: 0 20 12 1)
		(SetFlag 44)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(if (gCast contains: character2)
			(character2 dispose: delete:)
		)
		(Wat travelDir: 3 enterDir: 3)
		(DisposeScript 18)
	)
)

(instance day3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 2)
				(character1
					name: {beggar}
					lookStr: 20
					view: 55
					setLoop: 0
					posn: 325 75
					cycleSpeed: 12
					moveSpeed: 12
					init:
					setCycle: Walk
					setMotion: MoveTo 40 152 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(SetFlag 49)
		(gSFX2 fade: 0 30 8 1)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(Wat travelDir: 3 enterDir: 3)
		(DisposeScript 18)
	)
)

(instance day4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 3)
				(character1
					name: {poacher}
					lookStr: 17
					view: 110
					setLoop: 3
					posn: 325 75
					init:
					setCycle: Walk
					setMotion: MoveTo 256 100
				)
				(character2
					name: {flunky}
					lookStr: 19
					view: 755
					setLoop: 4
					posn: 315 70
					init:
					setCycle: Walk
					setMotion: MoveTo 240 100 self
				)
			)
			(1
				(character1 setLoop: 4)
				(character2 view: 110 setLoop: 5 setCel: 0)
				(= ticks 6)
			)
			(2
				(character1 hide:)
				(character2 setCel: 1)
				(= ticks 90)
			)
			(3
				(character2 cycleSpeed: 12 setCycle: CT 2 1 self)
			)
			(4
				(character2 setCycle: CT 1 -1 self)
			)
			(5
				(character2 setCycle: CT 3 1 self)
			)
			(6
				(character2 setCycle: CT 1 -1 self)
			)
			(7
				(= ticks 60)
			)
			(8
				(character2 setCycle: CT (- (character2 lastCel:) 1) 1 self)
			)
			(9
				(= ticks 6)
			)
			(10
				(character2 setCel: (character2 lastCel:))
				(character1
					posn: 236 105
					setLoop: 3
					setCel: 4
					setCycle: Walk
					show:
				)
				(= ticks 6)
			)
			(11
				(character1 posn: 232 107 setMotion: MoveTo 40 152)
				(character2
					view: 755
					posn: 225 106
					setLoop: 4
					cycleSpeed: 6
					setStep: 2 1
					setCycle: Walk
					setMotion: MoveTo 40 142 self
				)
			)
			(12
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSFX2 fade: 0 30 8 1)
		(SetFlag 47)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(if (gCast contains: character2)
			(character2 dispose: delete:)
		)
		(Wat travelDir: 3 enterDir: 3)
		(DisposeScript 18)
	)
)

(instance day5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 9)
				(character1
					name: {fMonk}
					lookStr: 21
					view: 106
					setLoop: 0
					posn: 325 70
					init:
					setCycle: Walk
					setMotion: MoveTo 197 104 self
				)
				(character2
					name: {aMonk}
					lookStr: 22
					view: 25
					setLoop: 6
					posn: 60 152
					init:
					setCycle: Walk
					setMotion: MoveTo 188 116
				)
			)
			(1
				(= cycles 35)
			)
			(2
				(character1 setMotion: MoveTo 20 152)
				(character2 setMotion: MoveTo 335 75 self)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (== (Wat whichChar:) 9)
			(if (< (Wat qFight:) 160)
				(Wat whichChar: 4 travelDir: 3 enterDir: 3)
			else
				(Wat whichChar: 5 travelDir: 1 enterDir: 1)
			)
		)
		(gSFX2 fade: 0 30 8 1)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(if (gCast contains: character2)
			(character2 dispose: delete:)
		)
		(DisposeScript 18)
	)
)

(instance day6A of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 5)
				(if (= temp4 (Random 0 1))
					(= temp0 40)
					(= temp1 152)
					(= temp2 325)
					(= temp3 75)
				else
					(= temp0 325)
					(= temp1 75)
					(= temp2 40)
					(= temp3 152)
				)
				(character1
					name: {aMonk}
					lookStr: 22
					view: 25
					setLoop: (if temp4 6 else 5)
					posn: temp0 temp1
					init:
					setCycle: Walk
					setMotion: MoveTo temp2 temp3 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(Wat
			travelDir: (if (< (character1 heading:) 180) 1 else 3)
			enterDir: (if (< (character1 heading:) 180) 1 else 3)
		)
		(gSFX2 fade: 0 30 8 1)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(DisposeScript 18)
	)
)

(instance day6B of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 4)
				(= temp4 1)
				(if (= temp4 (Random 0 1))
					(= temp0 40)
					(= temp1 152)
					(= temp2 325)
					(= temp3 75)
				else
					(= temp0 325)
					(= temp1 75)
					(= temp2 40)
					(= temp3 152)
				)
				(character1
					name: {fMonk}
					lookStr: 21
					view: 106
					setLoop: temp4
					posn: temp0 temp1
					init:
					setCycle: Walk
					setMotion: MoveTo temp2 temp3 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(Wat
			travelDir: (if (< (character1 heading:) 180) 1 else 3)
			enterDir: (if (< (character1 heading:) 180) 1 else 3)
		)
		(gSFX2 fade: 0 30 8 1)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(DisposeScript 18)
	)
)

(instance day8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 6)
				(character1
					name: {puck}
					lookStr: 23
					view: 53
					loop: 5
					posn: 325 75
					init:
					setCycle: Walk
					setMotion: MoveTo 40 152 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSFX2 fade: 0 30 8 1)
		(SetFlag 135)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(Wat travelDir: 3 enterDir: 3)
		(DisposeScript 18)
	)
)

(instance day9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 7)
				(character1
					name: {jeweler}
					lookStr: 24
					view: 72
					setLoop: 5
					posn: 325 75
					init:
					setCycle: Walk
					setMotion: MoveTo 40 152 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSFX2 fade: 0 30 8 1)
		(SetFlag 28)
		(super dispose:)
		(if (gCast contains: character1)
			(character1 dispose: delete:)
		)
		(Wat travelDir: 3 enterDir: 3)
		(DisposeScript 18)
	)
)

(instance day12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: 115 loop: -1 play:)
				(Wat whichChar: 8)
				(character1
					name: {knight}
					lookStr: 25
					view: 105
					cel: 1
					posn: 221 107
					init:
				)
				(AddToAddToPics littleJohn friarTuck)
				(= ticks 60)
			)
			(1
				(character1 cel: 0)
				(= ticks (Random 30 120))
			)
			(2
				(character1 cel: 1)
				(= ticks (Random 60 300))
			)
			(3
				(-= state 3)
				(self cue:)
			)
		)
	)

	(method (dispose)
		(gSFX2 fade: 0 30 8 1)
		(super dispose:)
		(character1 dispose: delete:)
		(gAddToPics eachElementDo: #dispose)
		(Wat travelDir: 3)
		(DisposeScript 18)
	)
)

(instance character1 of Actor
	(properties
		yStep 1
		priority 10
		signal 24592
		xStep 2
	)

	(method (doit)
		(if (IsFlag 148)
			(ClearFlag 148)
			(self setStep: 4 2)
		)
		(super doit:)
	)

	(method (dispose)
		(if (!= gDay 12)
			(Wat setScript: (Wat theTimer:))
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(switch view
					(110
						(if (== gDay 1)
							(Wat whichChar: 1)
						else
							(Wat whichChar: 3)
						)
					)
					(55
						(Wat whichChar: 2)
					)
					(106
						(Wat whichChar: 4)
					)
					(25
						(Wat whichChar: 5)
					)
					(53
						(Wat whichChar: 6)
					)
					(72
						(Wat whichChar: 7)
					)
					(105
						(Wat whichChar: 8)
					)
				)
				(gEgo setMotion: PChase self 10)
				(if (< heading 180)
					(Wat travelDir: 1 enterDir: 1 section: 3)
					(= gForestRoomNum 55)
				else
					(Wat travelDir: 3 enterDir: 3 section: 5)
					(= gForestRoomNum 87)
				)
			)
			(5 ; Talk
				(if (== (gCurRoom script:) day5)
					(Say 1018 5) ; "If I wish to speak with one of these monks, I should get closer."
				else
					(Say 1018 3) ; "The sight of an outlaw yelling from this ridge would only make yonder traveler vanish quickly."
				)
			)
			(10 ; Longbow
				(switch view
					(110
						(if local2
							(Say 1018 1) ; "What a cowardly act that would be from here, against an unarmed woman."
						else
							(Say 1018 0) ; "Master archer though I am, they're both moving, and I might strike the wrong target. I'd best take no chances from here."
						)
					)
					(55
						(Say 1018 2) ; "What a cowardly act that would be from here, against an unarmed man."
					)
					(106
						(Say 1018 6) ; "I would be a coward indeed to kill a man from ambush when he's armed only with a quarterstaff."
					)
					(25
						(Say 1018 2) ; "What a cowardly act that would be from here, against an unarmed man."
					)
					(53
						(Say 1018 7) ; "I'd be a base murderer to shoot that sturdy Yeoman from here without cause."
					)
					(72
						(Say 1018 2) ; "What a cowardly act that would be from here, against an unarmed man."
					)
					(105
						(Say 1018 8) ; "I wouldn't dream of firing upon the Queen's Knight!"
					)
				)
			)
			(4 ; Inventory
				(Say 1018 9) ; "I can hardly give anything away from here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance character2 of Actor
	(properties
		yStep 1
		priority 10
		signal 24592
		xStep 2
	)

	(method (doit)
		(if (IsFlag 148)
			(ClearFlag 148)
			(self setStep: 4 2)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setMotion: PChase self 10)
				(if (< heading 180)
					(Wat travelDir: 1 enterDir: 1 section: 3)
					(= gForestRoomNum 55)
				else
					(Wat travelDir: 3 enterDir: 3 section: 5)
					(= gForestRoomNum 87)
				)
				(cond
					((== view 25)
						(Wat whichChar: 5)
					)
					((or (== view 110) (== view 755))
						(if (== gDay 1)
							(Wat whichChar: 1)
						else
							(Wat whichChar: 3)
						)
					)
				)
			)
			(5 ; Talk
				(switch view
					(110
						(Say 1018 4) ; "I'll accomplish nothing by yelling from here except to alarm the Sheriff's man, giving him a chance to escape."
					)
					(755
						(Say 1018 4) ; "I'll accomplish nothing by yelling from here except to alarm the Sheriff's man, giving him a chance to escape."
					)
					(25
						(Say 1018 5) ; "If I wish to speak with one of these monks, I should get closer."
					)
					(else
						(Say 1018 3) ; "The sight of an outlaw yelling from this ridge would only make yonder traveler vanish quickly."
					)
				)
			)
			(10 ; Longbow
				(switch view
					(110
						(Say 1018 0) ; "Master archer though I am, they're both moving, and I might strike the wrong target. I'd best take no chances from here."
					)
					(755
						(Say 1018 0) ; "Master archer though I am, they're both moving, and I might strike the wrong target. I'd best take no chances from here."
					)
					(106
						(Say 1018 6) ; "I would be a coward indeed to kill a man from ambush when he's armed only with a quarterstaff."
					)
					(25
						(Say 1018 2) ; "What a cowardly act that would be from here, against an unarmed man."
					)
				)
			)
			(4 ; Inventory
				(Say 1018 9) ; "I can hardly give anything away from here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance setup of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 151 152 153)
				(ScriptID 19) ; John
				(HandsOff)
				(gEgo setHeading: 135 self)
			)
			(1
				(gEgo stopUpd:)
				((ScriptID 19) ; John
					posn: 330 200
					ignoreActors: 1
					init:
					setCycle: StopWalk 152
					setMotion: MoveTo 229 177 self
				)
			)
			(2
				(= ticks 12)
			)
			(3
				(Converse @local4 3 13 self 0) ; "Glad you decided to come. I saw a Sheriff's man head up the road a while back."
			)
			(4
				(if (IsFlag 45)
					(self cue:)
				else
					(Converse @local8 3 13 self 0) ; "But I've a mind to go around to the Widow's cottage and say hello to her sons before they leave for Nottingham again."
				)
			)
			(5
				(Converse @local12 3 13 self 0) ; "You might want to stay and watch for the fellow to return, in case he's up to mischief."
			)
			(6
				(if (IsFlag 45)
					(Converse @local21 3 13 self) ; "Thanks for the warning, John."
				else
					(Converse @local16 3 13 self) ; "Thanks for the warning. Mayhap I'll stop by and see the Widow myself later on."
				)
			)
			(7
				(if (gEgo has: 1) ; horn
					((ScriptID 19) setMotion: MoveTo 330 200 self) ; John
				else
					((ScriptID 19) setMotion: MoveTo 330 200) ; John
					(= seconds 3)
				)
			)
			(8
				(if (gEgo has: 1) ; horn
					(HandsOn)
					((ScriptID 19) dispose:) ; John
					(self dispose:)
				else
					((ScriptID 19) setMotion: 0) ; John
					(Face (ScriptID 19) gEgo self) ; John
					(= notKilled 1)
				)
			)
			(9
				(= ticks 30)
			)
			(10
				(Converse 1 @local26 13 3 self) ; "Oh, and Tuck caught up to me to give you your horn."
			)
			(11
				((ScriptID 19) ; John
					setMotion:
						PolyPath
						(+ (gEgo x:) 5)
						(+ (gEgo y:) 10)
						self
				)
			)
			(12
				(Face (ScriptID 19) gEgo self) ; John
			)
			(13
				(= notKilled 1)
				(gEgo get: 1) ; horn
				(Converse @local31 1 13 self) ; "That was foolish of me and good of Tuck."
			)
			(14
				((ScriptID 19) setMotion: PolyPath 330 200 self) ; John
			)
			(15
				(HandsOn)
				((ScriptID 19) dispose:) ; John
				(gEgo startUpd: setHeading: 45)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(SetFlag 137)
		(DisposeScript 18)
	)
)

(instance littleJohn of PicView
	(properties
		x 191
		y 111
		lookStr 25
		view 105
		loop 1
	)
)

(instance friarTuck of PicView
	(properties
		x 243
		y 103
		lookStr 25
		view 105
		loop 1
		cel 1
	)
)

