;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm016 0
)

(local
	local0
	local1
)

(instance rm016 of PQRoom
	(properties
		noun 4
		picture 16
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 102 149 206 147 280 162 246 113 206 98 173 78 150 85 154 95 172 87 200 100
					yourself:
				)
		)
		(board init:)
		(cabinetPapers init:)
		(cabinet init:)
		(chair init:)
		(deskPapers init:)
		(desk init:)
		(donuts init:)
		(file init:)
		(floorPapers init:)
		(inBasket init:)
		(lamp init:)
		(outBasket init:)
		(phone init:)
		(wallPicture init:)
		(crockPot init:)
		(trash init:)
		(wallNotes init:)
		(roomWindow init:)
		(super init: &rest)
		(self posn: 217 135)
		(dooley init:)
		(gEgo init: posn: 261 158)
		(switch global211
			(28
				(gLongSong number: 160 loop: -1 play:)
				(self setScript: chickenShit)
			)
			(51
				((ScriptID 896 1) next: memoScript) ; sWI
				(self setScript: (ScriptID 896 1)) ; sWI
			)
			(else
				(self setScript: (ScriptID 896 1)) ; sWI
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(if (== global211 51)
					(if local1
						(++ global211)
						(self posn: 261 158 setScript: (ScriptID 896 2) 0 13) ; sWO
					else
						(self setScript: bounce)
					)
				else
					(self posn: 261 158 setScript: (ScriptID 896 2) 0 13) ; sWO
				)
			)
		)
		(super doit: &rest)
	)
)

(instance bounce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Prints {ig-you should read the memo})
				(gEgo setMotion: MoveTo 217 135 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chickenDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chicken
					setLoop: 0
					posn: 122 99
					setCycle: Fwd
					setMotion: MoveTo 159 89 self
				)
			)
			(1
				(chicken setLoop: 1 setMotion: MoveTo 122 99 self)
			)
			(2
				(if (dooley heading:)
					(= state -1)
				)
				(= cycles 1)
			)
			(3
				(chicken setLoop: 0 setMotion: MoveTo 135 94 self)
			)
			(4
				(chicken setLoop: 2 cel: 0 posn: 144 94 setCycle: End self)
			)
			(5
				(chicken
					setLoop: 3
					cel: 0
					posn: 144 94
					setCycle: ForwardCounter 3 self
				)
			)
			(6
				(= state -1)
				(chicken
					setLoop: 1
					posn: 135 94
					setCycle: Fwd
					setMotion: MoveTo 122 99 self
				)
				(chickenShit cue:)
			)
		)
	)
)

(instance dooleyTooBusy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dooley setCycle: End self)
			)
			(1
				(dooley
					view: 142
					loop: 3
					cel: 0
					posn: 148 107
					setCycle: End self
				)
			)
			(2
				(gMessager say: 23 0 9 0 self) ; "You must have something to do, Bonds. So go do it! Don't bother me!"
			)
			(3
				(HandsOn)
				(= cycles 1)
			)
			(4
				(= seconds 10)
			)
			(5
				(dooley setCycle: End self)
			)
			(6
				(gMessager say: 23 0 4 0 self) ; "OUT! OUT!! OUT!!!"
				(-= state 3)
			)
		)
	)
)

(instance memoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 23 0 3 1 self) ; "Ah Bonds, so good of you to take a little time out of your "busy" schedule to drop by. Well, it looks like you got what you wanted. A memo just came down from Morgan's office. It says here--"
			)
			(1
				(dooley setCycle: CT 5 1 self)
			)
			(2
				(gMessager say: 23 0 3 2 self) ; "Aw, crap! Somebody maced this memo! Who thinks this kinda crud is funny? When I find out, the Gremlin will be singing soprano!"
			)
			(3
				(chicken init: setMotion: MoveTo 143 185 self)
				(dooley setCycle: End self)
			)
			(4)
			(5
				(dooley
					view: 142
					loop: 3
					cel: 0
					posn: 150 103
					setCycle: End self
				)
			)
			(6
				(gMessager say: 23 0 3 3 self) ; "Here, you take it. Read it yourself, I hope you choke on it! As soon as you're done, put on your plainclothes and get to Morgan's office. I don't want to look at you any more! Oh, man, my whole head is leaking!"
			)
			(7
				(dooley
					view: 141
					loop: 6
					cel: 0
					posn: 158 104
					setCycle: End self
				)
			)
			(8
				(dooley
					view: 141
					loop: 6
					cel: 0
					posn: 176 101
					setCycle: End self
				)
			)
			(9
				(proc134_4 dooley 132 6 182 99)
				(dooley setMotion: MoveTo 266 130 self)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtMemo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 154 95 self)
			)
			(1
				(gEgo setHeading: 180 self)
				(SetScore 115 2)
			)
			(2
				(if (not local1)
					(gLongSong number: 162 loop: 1 play:)
				)
				(memoInset init:)
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 3 4 2 5)
			)
			(3
				(HandsOff)
				(memoInset startUpd: hide:)
				(if (not local1)
					(gLongSong fade: 0 10 3 1)
					(= local1 1)
				)
				(= cycles 3)
			)
			(4
				(memoInset dispose: delete:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dooley of Officer
	(properties
		x 257
		y 144
		noun 24
		view 132
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (!= global211 51)
					(gMessager say: noun 1 1 0) ; "Sgt. Dooley has his hands full. While this chicken business seems to cross the line, you do get a secret satisfaction out of seeing Dooley this flustered."
				else
					(gMessager say: noun 1 0 0) ; MISSING MESSAGE
				)
			)
			(2 ; Talk
				(cond
					((== global211 0)
						(gMessager say: noun 2 11 0) ; "BONDS! In case you hadn't heard, you've got a BRIEFING to attend in a few minutes. So do us all a favor and get out of your pajamas before the briefing starts."
					)
					((and (not local0) (< global211 2))
						(gMessager say: noun 2 10 0) ; "Whatever it is, Bonds, I don't wanna hear it. In case you forgot, we've got a BRIEFING to attend this morning. So if it isn't too much trouble..."
						(= local0 1)
					)
					((< global211 2)
						(gMessager say: noun 2 10 0) ; "Whatever it is, Bonds, I don't wanna hear it. In case you forgot, we've got a BRIEFING to attend this morning. So if it isn't too much trouble..."
					)
					(else
						(gMessager say: noun 2 0 0) ; "You don't think Seargent Dooley is in the mood for chit-chat right now."
					)
				)
			)
			(4 ; Do
				(if (!= global211 51)
					(gMessager say: noun 4 2 0) ; "I'd leave the Sergeant alone, if I were you."
				else
					(gCurRoom setScript: lookAtMemo)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(switch global211
			(28
				(super init: &rest)
				(= gabScript 0)
				(proc134_4 self)
				(self turnOffNormal:)
			)
			(51
				(self view: 142 loop: 2 cel: 0 posn: 139 104)
				(super init: &rest)
			)
			(else
				(self
					view: 142
					loop: 0
					cel: 0
					posn: 138 109
					ignoreActors: 1
					turnOffNormal:
					setScript: dooleyTooBusy
				)
				(super init: &rest)
			)
		)
	)
)

(instance chicken of Actor
	(properties
		x 122
		y 99
		noun 1
		view 140
		priority 9
		signal 16400
	)

	(method (init)
		(if (== global211 51)
			(self view: 142 setLoop: 4 setPri: 8 z: 100 posn: 143 180 cel: 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (!= global211 51)
					(gMessager say: noun 1 1 0) ; "Someone has played a juvenile prank on Sgt. Dooley. This chicken is blissfully adding to the crap that litters Dooley's office."
				else
					(gCurRoom setScript: lookAtMemo)
				)
			)
			(2 ; Talk
				(if (!= global211 51)
					(gMessager say: noun 2 1 0) ; "BUCK BUCK BUCK BAGAWK! BUCKBUCKBUCK BAGAWK! BUCKBUCKBUCKBUCK BAGAWK! BAGAWK! (Translation: "What a pigsty this office is! And I thought *I* was raised in a barn!")"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (!= global211 51)
					(gMessager say: noun 4 1 0) ; "Never touch a crazed chicken, Bonds. It could turn that beak on you in a heartbeat."
				else
					(gCurRoom setScript: lookAtMemo)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance board of Feature
	(properties
		x 219
		y 54
		noun 5
		nsTop 37
		nsLeft 203
		nsBottom 71
		nsRight 235
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinetPapers of Feature
	(properties
		x 208
		y 69
		noun 12
		nsTop 62
		nsLeft 199
		nsBottom 77
		nsRight 217
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 220
		y 81
		noun 11
		nsTop 61
		nsLeft 195
		nsBottom 102
		nsRight 246
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 133
		y 84
		noun 22
		nsTop 77
		nsLeft 122
		nsBottom 91
		nsRight 144
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deskPapers of Feature
	(properties
		x 140
		y 148
		z 50
		noun 21
		nsTop 89
		nsLeft 127
		nsBottom 107
		nsRight 154
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 148
		y 100
		noun 16
		nsTop 77
		nsLeft 108
		nsBottom 123
		nsRight 189
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance donuts of Feature
	(properties
		x 221
		y 73
		noun 6
		nsTop 66
		nsLeft 212
		nsBottom 80
		nsRight 230
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance file of Feature
	(properties
		x 82
		y 92
		noun 9
		nsTop 69
		nsLeft 66
		nsBottom 116
		nsRight 98
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance floorPapers of Feature
	(properties
		x 154
		y 126
		noun 15
		nsTop 109
		nsLeft 101
		nsBottom 143
		nsRight 207
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance inBasket of Feature
	(properties
		x 170
		y 81
		noun 17
		nsTop 71
		nsLeft 159
		nsBottom 92
		nsRight 182
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 156
		y 89
		noun 19
		nsTop 83
		nsLeft 150
		nsBottom 96
		nsRight 163
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance outBasket of Feature
	(properties
		x 170
		y 81
		noun 18
		nsTop 71
		nsLeft 159
		nsBottom 92
		nsRight 182
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance phone of Feature
	(properties
		x 120
		y 96
		noun 20
		nsTop 92
		nsLeft 115
		nsBottom 101
		nsRight 126
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wallPicture of Feature
	(properties
		x 197
		y 47
		noun 13
		nsTop 40
		nsLeft 191
		nsBottom 55
		nsRight 203
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance crockPot of Feature
	(properties
		x 228
		y 77
		noun 7
		nsTop 73
		nsLeft 220
		nsBottom 81
		nsRight 236
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance trash of Feature
	(properties
		x 110
		y 124
		noun 8
		nsTop 113
		nsLeft 102
		nsBottom 136
		nsRight 119
		sightAngle 40
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wallNotes of Feature
	(properties
		x 89
		y 67
		noun 14
		nsTop 62
		nsLeft 85
		nsBottom 72
		nsRight 94
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance roomWindow of Feature
	(properties
		x 122
		y 58
		noun 10
		nsTop 44
		nsLeft 99
		nsBottom 83
		nsRight 146
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance memoInset of Prop
	(properties
		x 182
		y 75
		noun 2
		view 887
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(gMessager say: noun 1 6 0) ; "From: Lt. Morgan To: Sgt. Dooley Re: Officer Sonny Bonds"
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not (event modifiers:))
			)
			(event claimed: 1)
			((gCurRoom script:) cue:)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance chickenShit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chicken init: setScript: chickenDance)
				(dooley init: posn: 257 144 setMotion: MoveTo 224 130 self)
			)
			(1
				(gEgo setMotion: MoveTo 233 146 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 4 5)
				(dooley
					view: 141
					loop: 0
					cel: 0
					posn: 212 129
					setCycle: End self
				)
			)
			(4
				(gMessager say: 23 0 1 1 self) ; "A chicken! A chicken! Somebody left a damn chicken on my desk! This is not funny! What kind of person thinks this is funny? Damn that Gremlin! Bonds, do you think this is funny? Do you? You better not have done this, Bonds. I'll have your head on a platter if you did. Do you understand me?"
			)
			(5
				(proc134_4 dooley 132 7 207 125)
				(dooley setHeading: 180 self)
				(gEgo setHeading: 0 self)
			)
			(6)
			(7
				(dooley setHeading: 270 self)
			)
			(8
				(dooley
					view: 141
					loop: 1
					cel: 0
					posn: 191 126
					setCycle: End self
				)
			)
			(9
				(proc134_4 dooley 132 5 187 125)
				(dooley setHeading: 135 self)
			)
			(10
				(gMessager say: 23 0 1 2 self) ; "It better not be you, Bonds! So help me, I'll make the Gremlin wish he were never born! I'll have his BADGE, and I won't --Oh, no! No!"
			)
			(11
				(dooley setMotion: MoveTo 131 141 self)
			)
			(12
				(dooley setHeading: 0 self)
				(gEgo setHeading: 270 self)
			)
			(13)
			(14)
			(15
				(dooley setHeading: 180 self)
			)
			(16
				(dooley
					view: 141
					loop: 2
					cel: 0
					posn: 136 141
					setCycle: ForwardCounter 4 self
				)
			)
			(17
				(gMessager say: 23 0 1 3 self) ; "Don't do that--Oh, NO! My paperwork! You stupid chicken! I'm gonna wring someone's neck for this."
			)
			(18
				(dooley
					view: 141
					loop: 3
					cel: 0
					posn: 145 143
					setCycle: ForwardCounter 3 self
				)
			)
			(19
				(gMessager say: 23 0 1 4 self) ; "Bonds! What are you looking at? Your shift is over, isn't it? So get your sorry butt out of here. Right now, Bonds! NOW!"
			)
			(20
				(proc134_4 dooley 132 3 131 141)
				(dooley setMotion: MoveTo 206 145 self)
			)
			(21
				(dooley
					view: 141
					loop: 3
					cel: 0
					posn: 212 146
					setCycle: ForwardCounter 2 self
				)
			)
			(22
				(gLongSong fade:)
				(gMessager say: 23 0 1 5 self) ; "NOW! NOW!! NOW!!!"
			)
			(23
				(gCurRoom posn: 261 158 setScript: (ScriptID 896 2) 0 13) ; sWO
				(= global211 29)
			)
		)
	)
)

