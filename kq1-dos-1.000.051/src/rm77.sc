;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm77 0
)

(local
	local0
)

(procedure (localproc_0)
	(if (== (poofAway caller:) scared)
		((ScriptID 0 21) number: 27 loop: 1 play:) ; gameSound
	)
)

(instance rm77 of Rm
	(properties
		picture 77
		east 76
		west 78
	)

	(method (dispose)
		(SetFlag 7)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 170 171 172 174 173 179 178)
		(LoadMany rsSOUND 66 48)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(east 2)
				)
		)
		(super init:)
		(= local0 0)
		(switch gPrevRoomNum
			(east
				(if (not (IsFlag 7))
					(gEgo
						setScript:
							(cond
								((IsFlag 103) danceFever)
								((gEgo has: 6) scared) ; Four-leaf_Clover
								(else danceFever)
							)
					)
				)
				(gEgo posn: 315 (proc0_17 187 (gEgo y:) 173))
			)
			(west
				(gEgo posn: 3 (proc0_17 187 (gEgo y:) 175))
			)
			(else
				(gEgo posn: 150 180)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (not (gEgo has: 16)) ; Magic_Shield
			(shield init: stopUpd:)
		)
		(if (IsFlag 14)
			(sceptre init: stopUpd:)
		)
		(log1 init:)
		(log2 init:)
		(log3 init:)
		(log4 init:)
		(log5 init:)
		(log6 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(Said 'get,get,get,move,pull,lift/carpet,carpet')
					(Said 'look,look<below/carpet,carpet')
				)
				(Print 77 0) ; "Please don't move the carpet. It hides the Dandelion Wine stains on the floor."
			)
			((Said 'sit[<on,in,down][/throne]')
				(if (IsFlag 14)
					(Print 77 1) ; "What!? And sit on the jewelled sceptre?!?"
				else
					(Print 77 2) ; "You don't have time for that, Sir Graham."
				)
			)
			((Said 'eat,eat/mushroom')
				(if (gEgo has: 19) ; Mushroom
					(Print 77 3) ; "Eating the mushroom can get you out of a tight spot, but not at the moment."
				else
					(proc0_6) ; "You don't have anything that fits that description in your inventory."
				)
			)
			(
				(or
					(Said 'look,look/carpet,carpet')
					(proc0_14 event 152 112 186 161)
					(proc0_14 event 186 131 194 161)
					(proc0_14 event 143 131 151 161)
					(proc0_14 event 193 148 199 161)
					(proc0_14 event 137 149 142 161)
				)
				(Print 77 4) ; "This luxurious carpet is the product of the Leprechaun's magical weaving talents."
			)
			((or (Said 'look,look/throne') (proc0_14 event 148 85 192 112))
				(cond
					((gCast contains: king)
						(if (!= (king view:) 171)
							(Print 77 5) ; "The King of the Leprechauns is sitting on his stone throne, sceptre in hand."
						)
					)
					((IsFlag 14)
						(Print 77 6) ; "This is a rather simple stone throne, upon it sits the leprechaun kings jewelled sceptre."
					)
					(else
						(Print 77 7) ; "This is a rather simple stone throne, compared to King Edward's."
					)
				)
			)
			((or (Said 'look,look/scepter') (MousedOn sceptre event 3))
				(cond
					((gEgo has: 12) ; Sceptre
						(event claimed: 0)
					)
					((not (IsFlag 14))
						(Print 77 8) ; "There is no sceptre here."
					)
					((gEgo inRect: 151 110 177 115)
						(Print 77 9) ; "The sceptre is fashioned from gold and silver, and accented with emeralds."
					)
					(else
						(Print 77 10) ; "You can see a sceptre from where you are standing"
					)
				)
			)
			((or (Said 'look,look/shield') (MousedOn shield event 3))
				(cond
					((gEgo has: 16) ; Magic_Shield
						(event claimed: 0)
					)
					((gEgo inRect: 180 110 210 119)
						(Print 77 11) ; "The shield is made of titanium and is rimmed with jewels."
					)
					(else
						(Print 77 12) ; "You can see a shield from where you are standing."
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(Print 77 13) ; "This is the throne room of the Leprechaun King."
						(cond
							((and (>= (king signal:) 2) (<= (king signal:) 4))
								(cond
									((gEgo has: 16) ; Magic_Shield
										(Print 77 14) ; "The king has a sceptre."
									)
									((not (gEgo has: 16)) ; Magic_Shield
										(Print 77 15) ; "The king has a sceptre and there is a shield near the throne."
									)
								)
							)
							((and (IsFlag 14) (gEgo has: 16)) ; Magic_Shield
								(Print 77 16) ; "There is a sceptre on the throne."
							)
							((and (IsFlag 14) (not (gEgo has: 16))) ; Magic_Shield
								(Print 77 17) ; "There is a sceptre and shield near the throne."
							)
							((and (not (IsFlag 14)) (not (gEgo has: 16))) ; Magic_Shield
								(Print 77 18) ; "There is a shield near the throne."
							)
						)
					)
					((Said '/lep')
						(Print 77 19) ; "There are no leprechauns here."
					)
					((Said '/king,man')
						(cond
							((not (gCast contains: king))
								(Print 77 20) ; "The leprechaun King is not here."
							)
							((== (king view:) 171)
								(Print 77 21) ; "By playing your fiddle, the leprechaun King dances merrily away."
							)
							(else
								(Print 77 22) ; "The King of the Leprechauns is sitting on his throne."
							)
						)
					)
				)
			)
			((or (Said 'talk,talk/lep') (Said 'hello') (Said 'say/hello'))
				(if (gCast contains: king)
					(Print 77 23) ; "Unfortunately, you do not speak the language of the little folk."
				else
					(Print 77 24) ; "There are no Leprechauns here to talk to."
				)
			)
			((or (Said 'talk,talk/king,man') (Said 'hello') (Said 'say/hello'))
				(if (not (gCast contains: king))
					(Print 77 25) ; "The Leprechaun King is not here."
				else
					(Print 77 26) ; "The Leprechaun King, not understanding your words, ignores you."
				)
			)
			((Said 'get,get/shield')
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 71)
						(Print 77 27) ; "You've already accomplished that task."
					)
					((not (gEgo inRect: 180 110 210 119))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(else
						(Print 77 28) ; "You take the magic shield. Congratulations!"
						((ScriptID 0 21) number: 66 play:) ; gameSound
						(gEgo loop: 3 setMotion: 0 get: 16) ; Magic_Shield
						(SetScore 71 8)
						(shield dispose:)
					)
				)
			)
			((Said 'get,get/scepter')
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 72)
						(Print 77 27) ; "You've already accomplished that task."
					)
					((not (IsFlag 14))
						(Print 77 29) ; "The Leprechaun King took his sceptre with him."
					)
					((not (gEgo inRect: 151 110 177 115))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(else
						((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
						(Print 77 30) ; "You take the Leprechaun King's jewelled sceptre."
						(gEgo loop: 3 setMotion: 0 get: 12) ; Sceptre
						(ClearFlag 14)
						(SetScore 72 6)
						(sceptre dispose:)
					)
				)
			)
			((Said 'kill,shoot,capture/king')
				(if (gCast contains: king)
					(Print 77 31) ; "The Leprechaun King is just too cute to hurt."
				else
					(event claimed: 0)
					(super handleEvent: event)
				)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(& (OnControl PRIORITY (event x:) (event y:)) $a000)
				)
				(Print 77 32) ; "These rock formations were slowly created over thousands of years."
			)
			((Said '/stalactite,stalactite>')
				(cond
					((Said 'get,bend')
						(Print 77 33) ; "These are of no use to you, Sir Graham."
					)
					((Said 'look,look')
						(Print 77 32) ; "These rock formations were slowly created over thousands of years."
					)
				)
			)
		)
	)
)

(instance danceFever of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (< local0 ((ScriptID 0 21) prevSignal:)) ; gameSound
			(= local0 ((ScriptID 0 21) prevSignal:)) ; gameSound
			((ScriptID 0 21) prevSignal: 0) ; gameSound
			(playPoofAway cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(king init: stopUpd:)
				(girl1 init: stopUpd:)
				(girl2 init: stopUpd:)
				(man1 init: stopUpd:)
				(man2 init: stopUpd:)
				(man3 init: stopUpd:)
				(drummer init: stopUpd:)
				(harpist init: stopUpd:)
				(man4 init: stopUpd:)
				(= cycles 1)
			)
			(1
				(Print 77 34) ; "Overhearing the fiddle music you played in the hallway, the Leprechauns have begun to dance! As they do, they pop away in a fit of merrymaking."
				(if (>= global101 1)
					(girl1 setCycle: Fwd)
					(girl2 setCycle: Fwd)
					(man1 setCycle: Fwd)
					(man2 setCycle: Fwd)
					(man3 setCycle: Fwd)
					(king setCycle: Fwd)
					(drummer setCycle: Fwd)
					(harpist setCycle: Fwd)
				)
				((ScriptID 0 21) number: 48 loop: 1 init: play:) ; gameSound
				(if (>= global101 1)
					(man4 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (>= global101 1)
					(man4 loop: 0 cel: 0 setCycle: Fwd)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(3
				(self setScript: playPoofAway self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(poof dispose:)
				(SetFlag 14)
				(sceptre init:)
				(king setCycle: Fwd setLoop: 2 setMotion: MoveTo 178 120 self)
			)
			(5
				(king setMotion: MoveTo 152 160 self)
			)
			(6
				(king setMotion: MoveTo 174 176 self)
			)
			(7
				(HandsOn)
				(king setMotion: MoveTo 104 186 self)
			)
			(8
				(king setMotion: MoveTo -10 173 self)
			)
			(9
				(king dispose:)
				(self dispose:)
			)
		)
	)
)

(instance scared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(king view: 170 loop: 0 cel: 0 init: stopUpd:)
				(girl1 loop: 2 cel: 0 init: stopUpd:)
				(girl2 loop: 2 cel: 1 init: stopUpd:)
				(man1 loop: 3 cel: 0 init: stopUpd:)
				(man2 loop: 3 cel: 1 init: stopUpd:)
				(man4 loop: 2 init: stopUpd:)
				(drummer loop: 1 init: stopUpd:)
				(harpist loop: 1 init: stopUpd:)
				(man3 init: loop: 2 cel: 0 cycleSpeed: 1 stopUpd:)
				(if (>= global101 1)
					(man3 setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(Print 77 35) ; "The Leprechauns, sensing the power of your four-leaf clover, begin to vanish."
				(self setScript: poofAway self)
			)
			(2
				(HandsOff)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(poof cel: 0 posn: (king x:) (king y:) setCycle: CT 7 1 self)
			)
			(3
				(king dispose:)
				(HandsOn)
				(poof setCycle: End self)
			)
			(4
				(poof dispose:)
				(self dispose:)
			)
		)
	)
)

(instance poofAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(poof
					init:
					cel: 0
					posn: (man1 x:) (man1 y:)
					setCycle: CT 7 1 self
				)
			)
			(1
				(man1 dispose:)
				(if (== (poofAway caller:) scared)
					((ScriptID 0 21) number: 27 init: loop: 1 play:) ; gameSound
				)
				(poof setCycle: End self)
			)
			(2
				(poof cel: 0 posn: (man2 x:) (man2 y:) setCycle: CT 7 1 self)
			)
			(3
				(man2 dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(4
				(poof cel: 0 posn: (man3 x:) (man3 y:) setCycle: CT 7 1 self)
			)
			(5
				(man3 dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(6
				(poof cel: 0 posn: (girl1 x:) (girl1 y:) setCycle: CT 7 1 self)
			)
			(7
				(girl1 dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(8
				(poof cel: 0 posn: (girl2 x:) (girl2 y:) setCycle: CT 7 1 self)
			)
			(9
				(girl2 dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(10
				(poof cel: 0 posn: (man4 x:) (man4 y:) setCycle: CT 7 1 self)
			)
			(11
				(man4 dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(12
				(poof
					cel: 0
					posn: (drummer x:) (drummer y:)
					setCycle: CT 7 1 self
				)
			)
			(13
				(drummer dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(14
				(poof
					cel: 0
					posn: (harpist x:) (harpist y:)
					setCycle: CT 7 1 self
				)
			)
			(15
				(harpist dispose:)
				(localproc_0)
				(poof setCycle: End self)
			)
			(16
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance playPoofAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 0)
			)
			(1
				(HandsOff)
				(poof
					init:
					cel: 0
					posn: (man1 x:) (man1 y:)
					setCycle: CT 7 1 self
				)
			)
			(2
				(man1 dispose:)
				(poof setCycle: End self)
			)
			(3
				(= cycles 0)
			)
			(4
				(poof cel: 0 posn: (man2 x:) (man2 y:) setCycle: CT 7 1 self)
			)
			(5
				(man2 dispose:)
				(poof setCycle: End self)
			)
			(6
				(= cycles 0)
			)
			(7
				(poof cel: 0 posn: (man3 x:) (man3 y:) setCycle: CT 7 1 self)
			)
			(8
				(man3 dispose:)
				(poof setCycle: End self)
			)
			(9
				(= cycles 0)
			)
			(10
				(poof cel: 0 posn: (girl1 x:) (girl1 y:) setCycle: CT 7 1 self)
			)
			(11
				(girl1 dispose:)
				(poof setCycle: End self)
			)
			(12
				(= cycles 0)
			)
			(13
				(poof cel: 0 posn: (girl2 x:) (girl2 y:) setCycle: CT 7 1 self)
			)
			(14
				(girl2 dispose:)
				(poof setCycle: End self)
			)
			(15
				(= cycles 0)
			)
			(16
				(poof cel: 0 posn: (man4 x:) (man4 y:) setCycle: CT 7 1 self)
			)
			(17
				(man4 dispose:)
				(poof setCycle: End self)
			)
			(18
				(= cycles 0)
			)
			(19
				(poof
					cel: 0
					posn: (drummer x:) (drummer y:)
					setCycle: CT 7 1 self
				)
			)
			(20
				(drummer dispose:)
				(poof setCycle: End self)
			)
			(21
				(= cycles 0)
			)
			(22
				(poof
					cel: 0
					posn: (harpist x:) (harpist y:)
					setCycle: CT 7 1 self
				)
			)
			(23
				(harpist dispose:)
				(poof setCycle: End self)
			)
			(24
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance king of Actor
	(properties
		x 168
		y 97
		view 171
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 77 36) ; "The King of the Leprechauns is dancing away! Even the King enjoys a good party."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shield of View
	(properties
		x 196
		y 108
		view 170
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 77 11) ; "The shield is made of titanium and is rimmed with jewels."
			)
		)
	)
)

(instance sceptre of View
	(properties
		x 165
		y 88
		view 171
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 77 9) ; "The sceptre is fashioned from gold and silver, and accented with emeralds."
			)
		)
	)
)

(instance girl1 of Prop
	(properties
		x 41
		y 88
		description {leprechaun}
		view 172
	)
)

(instance girl2 of Prop
	(properties
		x 250
		y 131
		description {leprechaun}
		view 172
		loop 1
	)
)

(instance man1 of Prop
	(properties
		x 25
		y 86
		description {leprechaun}
		view 174
	)
)

(instance man2 of Prop
	(properties
		x 137
		y 114
		description {leprechaun}
		view 174
		loop 1
	)
)

(instance man3 of Prop
	(properties
		x 167
		y 134
		description {leprechaun}
		view 174
		loop 2
	)
)

(instance man4 of Prop
	(properties
		x 116
		y 138
		description {leprechaun}
		view 173
		loop 1
	)
)

(instance drummer of Prop
	(properties
		x 211
		y 126
		view 179
	)
)

(instance harpist of Prop
	(properties
		x 231
		y 110
		view 178
	)
)

(instance poof of Prop
	(properties
		view 170
		loop 2
	)

	(method (doVerb))
)

(instance log1 of NewFeature
	(properties
		x 59
		y 54
		noun '/timber,beam,branch,timber,beam'
		nsTop 24
		nsLeft 54
		nsBottom 85
		nsRight 64
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The huge wooden columns help support the cave ceiling.}
	)
)

(instance log2 of NewFeature
	(properties
		x 101
		y 78
		noun '/timber,beam,branch,timber,beam'
		nsTop 54
		nsLeft 97
		nsBottom 102
		nsRight 106
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The huge wooden columns help support the cave ceiling.}
	)
)

(instance log3 of NewFeature
	(properties
		x 135
		y 51
		noun '/timber,beam,branch,timber,beam'
		nsTop 21
		nsLeft 130
		nsBottom 82
		nsRight 140
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The huge wooden columns help support the cave ceiling.}
	)
)

(instance log4 of NewFeature
	(properties
		x 193
		y 47
		noun '/timber,beam,branch,timber,beam'
		nsTop 18
		nsLeft 189
		nsBottom 77
		nsRight 198
		description {log5}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The huge wooden columns help support the cave ceiling.}
	)
)

(instance log5 of NewFeature
	(properties
		x 247
		y 68
		noun '/timber,beam,branch,timber,beam'
		nsTop 32
		nsLeft 241
		nsBottom 104
		nsRight 253
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The huge wooden columns help support the cave ceiling.}
	)
)

(instance log6 of NewFeature
	(properties
		x 299
		y 98
		noun '/timber,beam,branch,timber,beam'
		nsTop 80
		nsLeft 295
		nsBottom 116
		nsRight 303
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The huge wooden columns help support the cave ceiling.}
	)
)

