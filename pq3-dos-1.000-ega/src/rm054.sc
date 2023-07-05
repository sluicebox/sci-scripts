;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm054 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm054 of PQRoom
	(properties
		picture 54
	)

	(method (init)
		(super init:)
		(computer init:)
		(desk init:)
		(poster init:)
		(fileCab init:)
		(counterRt init:)
		(counterLt init:)
		(trash init:)
		(printer init:)
		(door approachVerbs: 3 init:) ; Do
		(recruiter approachVerbs: 3 4 init:) ; Do, Inventory
		(walker setCycle: SyncWalk setScript: walkerScript init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 123 139 198 105 252 141 244 154 221 158 205 151 184 156 174 153 151 158
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 83 159 33 129 72 112 116 141
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 156 260 114 244 118 199 86 205 82 154 100 133 87 145 75 0 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 140 13 134 57 181 285 181 319 155 319 189 0 189
					yourself:
				)
		)
		(gEgo normal: 1 view: 4 setStep: 3 2 posn: 109 77 init:)
		(if (and (IsFlag 231) (not (gEgo has: 26))) ; miltaryRecord
			(printer cel: (printer lastCel:))
			(= local2 1)
		)
		(if (gEgo has: 26) ; miltaryRecord
			(= local0 (= local1 (= local3 1)))
		)
		(self setScript: enterScript)
	)

	(method (doit)
		(if (& (gEgo onControl: 1) $0002)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(super doit:)
	)
)

(instance enterScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorOpenSound play:)
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 124 94 self)
			)
			(2
				(door setCycle: Beg self)
			)
			(3
				(doorClosedSound play: self)
			)
			(4
				(= save1 1)
				(armyInset init:)
				(if (not (IsFlag 37))
					(Say armyInset 54 0) ; "Good day, Sir! Good day! You look like a man in need of a career."
					(= seconds 7)
				else
					(Say armyInset 54 1) ; "Reconsidering?"
					(= seconds 3)
					(+= state 2)
				)
			)
			(5
				(= save1 1)
				(Say armyInset 54 2) ; "You made an excellent choice! The army's the ONLY life for a man!"
				(= seconds 6)
			)
			(6
				(= save1 1)
				(Say armyInset 54 3) ; "Outdoor adventure, free room and board, good old-fashioned discipline! Get all those newfangled, namby-pamby, TV-zombie ideas out of your system and get your life back under control. Know what I mean?"
				(= seconds 10)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(armyInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorOpenSound play:)
				(door setCycle: End self)
			)
			(1
				(= save1 1)
				(if (not (IsFlag 37))
					(Face gEgo recruiter)
					(Animate (gCast elements:) 0)
					(armyInset init:)
					(Say armyInset 54 4) ; "Serving you is a pleasure, sir. Don't forget the U.S. Army if you ever need a change of careers!"
					(= seconds 8)
				else
					(= cycles 1)
				)
			)
			(2
				(= save1 1)
				(if (not (IsFlag 37))
					(SetFlag 37)
					(armyInset dispose:)
					(sonnyInset init:)
					(Say sonnyInset 54 5) ; "Thanks. I won't."
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(gEgo setMotion: MoveTo 109 77 self)
			)
			(4
				(door setCycle: Beg self)
			)
			(5
				(doorClosedSound play: self)
			)
			(6
				(gCurRoom newRoom: 31)
				(self dispose:)
			)
		)
	)
)

(instance walkerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 30))
			)
			(1
				(walker
					show:
					setLoop:
						(if (< (walker x:) 100)
							(Random 2 3)
						else
							(Random 0 1)
						)
					setMotion:
						MoveTo
						(if (< (walker x:) 100) 130 else 40)
						(if (< (walker x:) 100) 68 else 100)
						self
				)
			)
			(2
				(walker hide:)
				(self init:)
			)
		)
	)
)

(instance talkScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 151 126 self)
			)
			(1
				(= save1 1)
				(if (or local3 local0)
					(armyInset init:)
					(switch (Random 0 5)
						(0
							(Say armyInset 54 6) ; "You can even choose your first tour of duty."
						)
						(1
							(Say armyInset 54 7) ; "Remember, son. It's the best character builder a man could want."
						)
						(2
							(Say armyInset 54 8) ; "At the end of your six year enlistment, you'll be amazed at how the time just flew by."
						)
						(3
							(Say armyInset 54 9) ; "Just think of an exciting career in heavy tank repair!"
						)
						(4
							(Say armyInset 54 10) ; "You could become a career man. Look at what it's done for me."
						)
						(5
							(Say armyInset 54 11) ; "We have many exciting bases around the world, like Oklahoma."
						)
						(6
							(Say armyInset 54 12)
						)
						(7
							(Say armyInset 54 12)
						)
					)
					(= seconds 7)
				else
					(= local3 1)
					(sonnyInset init:)
					(Say sonnyInset 54 13) ; "Hmmm... That sounds terrific, but I already have got a good career, thanks."
					(= seconds 8)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(armyInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance photoScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(switch local4
					(3
						(Print 54 14 #dispose) ; "You show the photograph to the recruiting officer again."
					)
					(else
						(Print 54 15 #dispose) ; "You show the photograph of Jessie and Michael Bains to the recruiting officer."
					)
				)
				(= seconds 6)
			)
			(1
				(= save1 1)
				(switch local4
					(3
						(armyInset init:)
						(Say armyInset 54 16) ; "Well, why didn't you say who you were earlier? Of course I can get that information for you, Sergeant."
						(= seconds 8)
					)
					(else
						(sonnyInset init:)
						(Say sonnyInset 54 17) ; "Can you give me any information on this man? His name is Michael Bains. He should have a military record."
						(= seconds 8)
					)
				)
			)
			(2
				(switch local4
					(1
						(= save1 1)
						(sonnyInset dispose:)
						(armyInset init:)
						(Say armyInset 54 18) ; "That's privileged information there, boy! The U.S. Army doesn't hand out military records to just anyone!"
						(= seconds 8)
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(armyInset dispose:)
						(sonnyInset dispose:)
						(= cycles 1)
					)
				)
			)
			(3
				(switch local4
					(1
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(armyInset dispose:)
						(HandsOn)
						(self dispose:)
					)
					(2
						(= save1 1)
						(sonnyInset dispose:)
						(armyInset init:)
						(Say armyInset 54 19) ; "Let me see here, Sergeant..."
						(= seconds 5)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(armyInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(recruiter loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(5
				(self setScript: typeScript self)
			)
			(6
				(SetScore 182 3)
				(= save1 1)
				(armyInset init:)
				(Say armyInset 54 20) ; "Ah! Here we go. Michael Bains. Let me get you a printout."
				(= seconds 8)
			)
			(7
				(armyInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self setScript: typeScript self)
			)
			(8
				(recruiter setCycle: End)
				(= save1 1)
				(armyInset init:)
				(Say armyInset 54 21) ; "There you are, Sergeant. Hope it helps."
				(= seconds 7)
				(= local2 1)
				(SetFlag 231)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(armyInset dispose:)
				(printSound play:)
				(printer setCycle: End self)
			)
			(10
				(printSound stop:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance typeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(recruiter loop: 1 setCycle: CT 3 -1 self)
			)
			(1
				(recruiter loop: 1 setCycle: CT 6 1 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance IDScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Print 54 22 #dispose) ; "You show the recruiting officer your badge and identify yourself."
				(SetScore 181 3)
				(= seconds 6)
			)
			(1
				(= save1 1)
				(Print 54 23 #dispose) ; "He looks closely at your credentials, making sure they're legitimate. When he looks up, he seems more cooperative."
				(= seconds 8)
			)
			(2
				(= save1 1)
				(armyInset init:)
				(if local0
					(= local4 3)
					(photoScript start: 1)
					(client setScript: photoScript)
				else
					(Say armyInset 54 24) ; "Yes, Sir, Sergeant. And what can I do for you today?"
				)
				(= seconds 6)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(armyInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useMilitary of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(armyInset init:)
				(Say armyInset 54 25) ; "You can keep it, Sergeant. The U.S. Army's got it all in its data banks."
				(= seconds 7)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(armyInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getPrintOut of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 245 132 self)
			)
			(1
				(rustleSound play:)
				(= cycles 1)
			)
			(2
				(= save1 1)
				(Print 54 26) ; "You take the printout of Michael Bain's military record."
				(printer cel: 0 forceUpd:)
				(= cycles 1)
			)
			(3
				(rustleSound stop:)
				(= save1 1)
				(Print 54 27) ; "Browsing through Michael Bains' military record, you come across the following information."
				(= cycles 1)
			)
			(4
				(= save1 1)
				(Print 54 28) ; "Career Gunnery Sergeant. Exemplary record, bearing and behavior - beyond reproach. Behavior alteration noticed following brother's death (Jesse Bains) at the hands of the police. Admitted to military psychiatric facility following a particulary violent outburst. Two injured."
				(= cycles 1)
			)
			(5
				(= save1 1)
				(Print 54 29) ; "Returned to active duty, but began displaying more violent, antisocial behavior patterns. Unprovoked physical attacks reported. Medical discharge from army for psychological instability."
				(gEgo get: 26) ; miltaryRecord
				(SetScore 183 3)
				(= local2 0)
				(= cycles 1)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 121
		y 79
		approachX 124
		approachY 94
		lookStr {That's the exit.}
		view 568
		loop 1
		priority 4
		signal 16401
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance printer of Prop
	(properties
		x 242
		y 148
		z 24
		lookStr {It's a computer printer.}
		view 568
		priority 11
		signal 16401
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local2
					(HandsOff)
					(gCurRoom setScript: getPrintOut)
				else
					(Print 54 30) ; "The recruiter would no doubt flatten your face if you tried to walk out with his printer."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance recruiter of Prop
	(properties
		x 185
		y 150
		approachX 150
		approachY 126
		lookStr {This looks like the kind of man you want to take seriously.}
		view 565
		signal 1
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: talkScript)
			)
			(3 ; Do
				(Print 54 31) ; "I don't think that's a good idea."
			)
			(4 ; Inventory
				(switch invItem
					(6 ; photo
						(cond
							(local0
								(cond
									((or local2 (gEgo has: 26)) ; miltaryRecord
										(Print 54 32) ; "There's no need for that, he has already helped you."
									)
									(local1
										(= local4 3)
										(= local0 1)
										(HandsOff)
										(gCurRoom setScript: photoScript)
									)
									(else
										(Print 54 33) ; "Just showing him the photo again won't do any good."
									)
								)
							)
							(local1
								(= local4 2)
								(= local0 1)
								(HandsOff)
								(gCurRoom setScript: photoScript)
							)
							(else
								(= local4 1)
								(= local0 1)
								(HandsOff)
								(gCurRoom setScript: photoScript)
							)
						)
					)
					(26 ; miltaryRecord
						(HandsOff)
						(gCurRoom setScript: useMilitary)
					)
					(19 ; wallet
						(if (or local1 (IsFlag 37))
							(Print 54 34) ; "You have already identified yourself."
						else
							(= local1 1)
							(HandsOff)
							(gCurRoom setScript: IDScript)
						)
					)
					(1 ; gun
						(Print 54 35) ; "The recruiter is career army. He's not interested in seeing your puny weapons."
					)
					(2 ; handcuff
						(Print 54 35) ; "The recruiter is career army. He's not interested in seeing your puny weapons."
					)
					(16 ; nightStick
						(Print 54 35) ; "The recruiter is career army. He's not interested in seeing your puny weapons."
					)
					(else
						(Print 54 36) ; "The recruiter isn't interested."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance armyInset of View
	(properties
		x 269
		y 120
		view 567
		priority 15
		signal 17
	)

	(method (init)
		(rMouth
			posn: (self x:) (+ (self y:) 20)
			z: 20
			setCycle: RandCycle
			init:
		)
		(rEyes
			posn: (self x:) (+ (self y:) 10)
			z: 10
			setScript: rEyesScript
			init:
		)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(rMouth dispose:)
		(rEyes dispose:)
	)
)

(instance rMouth of Prop
	(properties
		view 567
		loop 1
		priority 15
		signal 17
		cycleSpeed 9
	)
)

(instance rEyes of Prop
	(properties
		view 567
		loop 2
		priority 15
		signal 17
		cycleSpeed 9
	)
)

(instance rEyesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(rEyes cel: (Random 0 5) setCycle: End self)
			)
			(2
				(= cycles 5)
			)
			(3
				(rEyes cel: 0)
				(= cycles 1)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sonnyInset of Prop
	(properties
		x 47
		y 122
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(sonnyShirt posn: (+ (self x:) 1) (+ (self y:) 61) init:)
		(sonnyMouth
			posn: (self x:) (+ (self y:) 20)
			z: 20
			setCycle: RandCycle
			init:
		)
		(sonnyEyes
			posn: (self x:) (+ (self y:) 30)
			z: 30
			init:
			setScript: sonnyEyesScript
		)
	)

	(method (dispose)
		(sonnyEyes setScript: 0 dispose:)
		(sonnyMouth dispose:)
		(sonnyShirt dispose:)
		(super dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance sonnyEyes of Prop
	(properties
		description {Sonny}
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance sonnyEyesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 5)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance walker of Actor
	(properties
		x 130
		y 68
		lookStr {A passerby.}
		view 569
		signal 16400
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance desk of Feature
	(properties
		x 191
		y 131
		onMeCheck 4096
		lookStr {The desk has a military neatness.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 54 37) ; "The desk is not yours."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poster of Feature
	(properties
		x 187
		y 46
		onMeCheck 2048
		lookStr {Just looking at all those posters makes you feel patriotic.}
	)
)

(instance computer of Feature
	(properties
		x 214
		y 126
		onMeCheck 8192
		lookStr {Those computers are everywhere, aren't they?}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 54 38) ; "The recruiter would no doubt flatten your face if you tried to walk out with his computer."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fileCab of Feature
	(properties
		x 226
		y 98
		onMeCheck 16384
		lookStr {The filing cabinets probably hold countless forms in triplicate.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 54 39) ; "The recruiting officer might be upset if you starting rifling through his files uninvited."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trash of Feature
	(properties
		x 226
		y 131
		onMeCheck 256
		lookStr {A trash can}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 54 40) ; "You're not a janitor."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance counterLt of Feature
	(properties
		x 77
		y 126
		description {counter}
		onMeCheck 1024
		lookStr {The counters are polished and bare.}
	)
)

(instance counterRt of Feature
	(properties
		x 178
		y 65
		description {counter}
		onMeCheck 512
		lookStr {The counters are polished and bare.}
	)
)

(instance doorOpenSound of Sound
	(properties
		number 304
	)
)

(instance doorClosedSound of Sound
	(properties
		number 304
	)
)

(instance printSound of Sound
	(properties
		number 542
	)
)

(instance rustleSound of Sound
	(properties
		flags 1
		number 211
	)
)

