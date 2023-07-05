;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 876)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use RandCycle)
(use PolyPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	bagger 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(HandsOn)
	(if (not (gEgo normal:))
		(gTheIconBar disable: 0)
	)
)

(instance bagger of Rgn
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(10
				(bagLady setLoop: 4 setCycle: Walk posn: 210 97 init:)
			)
		)
		(if (== gDay 3)
			(cond
				((IsFlag 27) 0)
				((IsFlag 25)
					(bagLady posn: 156 117 loop: 2 cel: 0 init: stopUpd:)
				)
				((IsFlag 24)
					(bagLady posn: 156 117 loop: 0 cel: 11 init: stopUpd:)
					(lunch init:)
				)
				((and (IsFlag 19) (== gPrevRoomNum 10))
					(lunch init:)
					(gCurRoom setScript: escortIn)
				)
				((IsFlag 19)
					(lunch init:)
				)
				(else
					(lunch init: setScript: enterBagLady)
				)
			)
		)
	)
)

(instance escortIn of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath 117 99)
				(bagLadyMusic play:)
				(bagLady setMotion: MoveTo 167 117 self)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(bagInset init:)
				(Say bagInset 876 0) ; "I need ta sit and rest my aching bones, kiddo!"
				(= seconds 5)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bagInset dispose:)
				(bagLady setLoop: 0 cel: 0 posn: 156 117 setCycle: End self)
			)
			(4
				(SetFlag 24)
				(localproc_0)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterBagLady of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if (not (gCurRoom script:))
					(HandsOff)
					(LFX number: 935 play:)
					(if (== (gEgo normal:) 1)
						(self setScript: (ScriptID 21 2) self) ; sitScript
					else
						(= cycles 1)
					)
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(2
				(HandsOff)
				(gEgo loop: 0 cel: 0 setCycle: CT 6 1 self)
				(LFX fade:)
			)
			(3
				(= save1 1)
				(Say gEgo 876 1) ; "This is Officer Bonds."
				(= seconds 3)
			)
			(4
				(= save1 1)
				(Print 876 2 #at 10 10 #dispose) ; "The voice on the other end says..."Bonds, this is Smith... I'm sending up a woman, Carla Reed, who said she saw something at Oak Tree Mall night before last.""
				(= seconds 10)
			)
			(5
				(= save1 1)
				(Print 876 3 #at 10 10 #dispose) ; ""Don't get too close to her though. Her breath's enough to stun an elephant."
				(= seconds 8)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo setCycle: End)
				(= seconds 5)
			)
			(7
				(Print 876 4 #dispose #at 80 40) ; "You hear a knock at the door."
				(LFX number: 907 play:)
				((ScriptID 21 4) setCycle: End self) ; door
			)
			(8
				(proc0_17 30)
				(bagLadyMusic play:)
				(gCast addToFront: bagLady)
				(bagLady
					setLoop: 4
					setCycle: Walk
					posn: 263 94
					setMotion: MoveTo 210 97 self
					init:
				)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				((ScriptID 21 4) setCycle: Beg self) ; door
			)
			(10
				(LFX number: 908 play:)
				(= cycles 1)
			)
			(11
				(= save1 1)
				((ScriptID 21 4) stopUpd:) ; door
				(bagInset init:)
				(Animate (gCast elements:) 0)
				(Say bagInset 876 5) ; "Hello there Sonny boy! Since you're the only one here, I guess you're the one ta yak at."
				(= seconds 8)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bagInset dispose:)
				(bagLady setMotion: MoveTo 167 117 self)
			)
			(13
				(= save1 1)
				(bagInset init:)
				(Say bagInset 876 6) ; "I need ta sit and rest my aching bones kiddo!"
				(= seconds 5)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bagInset dispose:)
				(bagLady setLoop: 0 cel: 0 posn: 156 117 setCycle: End self)
			)
			(15
				(SetFlag 24)
				(localproc_0)
				(gEgo put: 38) ; busCard
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance bagLadyTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(cond
					((or (IsFlag 27) (IsFlag 74))
						(proc0_17 15)
						(bagInset init:)
						(Say bagInset 876 7) ; "I wanna go home."
						(= seconds 3)
						(= state 7)
					)
					((IsFlag 26)
						(bagInset init:)
						(switch local0
							(0
								(Say bagInset 876 8) ; "Speakin' of traumatic experiences, my ex-husband was a stockbroker on Wall Street. Now THERE'S a horror story for ya..."
							)
							(1
								(Say bagInset 876 9) ; "Speakin' of big, ugly, hairy, smelly brutes, have you heard the one about the gynecologist and the gorilla?"
							)
							(2
								(Say bagInset 876 10) ; "Speakin' of scavengin' at the mall, I bet I eat better 'n you! Last week I had sushi three times outta the dumpster next to Benny-HaHas."
							)
							(3
								(Say bagInset 876 11) ; "Speakin' of gettin' no respect, did you see that Dan Quayle was in town last week?"
							)
							(else
								(Say bagInset 876 12) ; "Are we just gonna gab?"
							)
						)
						(++ local0)
						(= seconds 8)
						(= state 6)
					)
					((IsFlag 25)
						(Print 876 13 #dispose) ; "You ask Ms. Reed to tell you exactly what she saw at Oak Tree Mall that night."
						(= seconds 6)
					)
					((IsFlag 24)
						(bagInset init:)
						(switch local1
							(0
								(Say bagInset 876 14) ; "I ain't eatin' in so long, my taste buds have amnesia!"
							)
							(1
								(Say bagInset 876 15) ; "You wouldn't happen to have any caviar on you, would ya? Smoked salmon? Canned tuna? A fish stick, maybe?"
							)
							(else
								(Say bagInset 876 16) ; "If I don't get some food soon,.. Say, is it getting dark in here? I-I feel...faint!"
							)
						)
						(++ local1)
						(= seconds 8)
						(= state 6)
					)
				)
			)
			(1
				(= save1 1)
				(bagInset init:)
				(Say bagInset 876 17) ; "I was at the mall, I was. Pickin' and choosin' over the goodies in that big bin out back. Shameful what people throw away..."
				(= seconds 10)
			)
			(2
				(= save1 1)
				(bagInset dispose:)
				((ScriptID 21 1) init:) ; sonnyInset
				(Say (ScriptID 21 1) 876 18) ; sonnyInset, "Ms. Reed please! Just stick to the incident with the man."
				(= seconds 7)
			)
			(3
				(= save1 1)
				(bagInset init:)
				((ScriptID 21 1) dispose:) ; sonnyInset
				(Say bagInset 876 19) ; "Outta nowheres comes this big side-of-beef type guy! Rams right inta me, he does! You'd think an old lady like me'd get a little respect!"
				(= seconds 6)
			)
			(4
				(= save1 1)
				(Say bagInset 876 20) ; "I don't ask for much - a dry spot ta lay my newspapers, a few modest hand-outs, a..."
				(= seconds 6)
			)
			(5
				(= save1 1)
				(bagInset dispose:)
				((ScriptID 21 1) init:) ; sonnyInset
				(Say (ScriptID 21 1) 876 21) ; sonnyInset, "Carla? I really need you to finish telling me about the man who knocked you down."
				(= seconds 6)
			)
			(6
				(= save1 1)
				(bagInset init:)
				((ScriptID 21 1) dispose:) ; sonnyInset
				(Say bagInset 876 22) ; "So I socks him, right? On his leg. Like ta have broken my hand, I did. And him - he just grins at me, right in my face. His ugly mug just grins at me lika devil or somethin'. I'll never forget that face!"
				(= seconds 10)
				(SetFlag 26)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bagInset dispose:)
				(localproc_0)
				(self dispose:)
			)
			(8
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bagInset dispose:)
				((ScriptID 21 1) init:) ; sonnyInset
				(Say (ScriptID 21 1) 876 23) ; sonnyInset, "Ok Carla, That should do it. I'll take you home now. You've been a big help."
				(= seconds 4)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				((ScriptID 21 1) dispose:) ; sonnyInset
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance getLunch of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo normal:) 1)
					(= cycles 1)
				else
					(self setScript: (ScriptID 21 3) self) ; standScript
				)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 83 122 self)
				(Print 876 24) ; "You grab the lunch."
			)
			(2
				(lunch dispose:)
				(gEgo setMotion: PolyPath 140 114 self)
			)
			(3
				(Print 876 25) ; "You give the lunch to the lady."
				(bagLady
					posn: (- (bagLady x:) 7) (- (bagLady y:) 3)
					loop: 1
					cel: 0
					setCycle: End self
				)
				(SetScore 141 5)
				(self setScript: (ScriptID 21 2) self) ; sitScript
			)
			(4)
			(5
				(= save1 1)
				(HandsOff)
				(bagInset init:)
				(Say bagInset 876 26) ; "Peanut butter and jelly! You guys are real 'gor-mets', ain't ya? Tanks."
				(= seconds 5)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bagInset dispose:)
				(SetFlag 25)
				(SetFlag 81)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance bagLady of Actor
	(properties
		lookStr {It's Carla Reed.}
		view 245
		loop 4
		signal 16385
		cycleSpeed 8
		moveSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (gCast contains: (ScriptID 21 5)) ; cInset
					((ScriptID 21 5) dispose:) ; cInset
				)
				(HandsOff)
				(gCurRoom setScript: bagLadyTalk)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bagInset of Prop
	(properties
		x 269
		y 186
		description {Pat Morales}
		view 246
		priority 15
		signal 16401
	)

	(method (init)
		(bagMouth posn: (+ (self x:) 1) (self y:) 37 setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(bagMouth dispose:)
	)
)

(instance bagMouth of Prop
	(properties
		description {Pat Morales}
		view 246
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance lunch of Prop
	(properties
		x 74
		y 196
		z 100
		lookStr {There's a brown bag sitting on the desk. It's probably someone's lunch.}
		view 234
		loop 2
		cel 2
		priority 7
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (gCast contains: bagLady)
					(gCurRoom setScript: getLunch)
				else
					(Print 876 27) ; "You have no need for that now."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bagLadyMusic of Sound
	(properties
		flags 1
		number 210
		loop -1
	)
)

(instance LFX of Sound
	(properties)
)

