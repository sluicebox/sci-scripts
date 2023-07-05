;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Conversation)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	local0
)

(instance rm021 of PQRoom
	(properties
		noun 1
		picture 21
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and (== (gEgo view:) 185) (not (gCurRoom script:)))
					(gCurRoom setScript: standUp 0 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0) ; "The Narcotics office is well-equipped."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 131 189 150 189 152 163 175 163 249 135 249 111 200 106 158 106 141 116 120 115 87 119 68 135
					yourself:
				)
		)
		(BASKET init:)
		(COMCABLES init:)
		(COMP init:)
		(FILEPLANT init:)
		(FLOORPLANT init:)
		(KEYPD init:)
		(PENCIL init:)
		(TALLPLANT init:)
		(DESK init:)
		(FILECABINET init:)
		(WINDW init:)
		(SONNYDESK init:)
		(LAURADRAWER init:)
		(sonnyPhone init:)
		(sonnyComputer init:)
		(chair1 init:)
		(printer init:)
		(leftDrawer init:)
		(rightDrawer init:)
		(if (or (< global211 54) (and (== global211 80) (not (IsFlag 52))))
			(laura init:)
		else
			(chair2 init:)
		)
		(keys init:)
		(super init:)
		(fileDrawer init:)
		(cond
			((< global211 53)
				((ScriptID 896 1) next: notANarc) ; sWI
			)
			((== global211 53)
				((ScriptID 896 1) next: visit1) ; sWI
			)
			((and (== global211 80) (not (IsFlag 52)))
				((ScriptID 896 1) next: lauraRemindsEgo) ; sWI
			)
		)
		(if (== gPrevRoomNum 117)
			(self setScript: returnToComputer)
		else
			(gEgo init: setPri: 12 posn: 150 178)
			(self posn: 150 146 setScript: (ScriptID 896 1)) ; sWI
		)
		(gWalkHandler addToFront: self)
	)

	(method (notify param1 &tmp [temp0 20])
		(= local0 param1)
		(usePhone cue:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (= temp0 (gEgo onControl: 0)) $0002)
				(gEgo setPri: 12)
				(self posn: 150 178 setScript: (ScriptID 896 2) 0 19) ; sWO
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(DisposeScript 555)
		(super dispose:)
	)
)

(instance notANarc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(laura loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 18 2 1 1 self) ; "Hello, Sonny. Excuse me, I have a lot of work to do."
			)
			(2
				(laura setCycle: Beg self)
			)
			(3
				(laura loop: 1 setCycle: Fwd)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openFileCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LoadMany rsSOUND 945)
				(LoadMany rsVIEW 182)
				(gEgo setMotion: PolyPath 225 115 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gLongSong2 number: 945 loop: 1 play:)
				(gEgo
					view: 182
					loop: 0
					cel: 0
					posn: 224 115
					setCycle: CT 2 1 self
				)
			)
			(3
				(fileDrawer startUpd: setCycle: End self)
				(gEgo setCycle: End self)
			)
			(4)
			(5
				(self setScript: (ScriptID 212 0) self) ; lookAtFileCabinet
			)
			(6
				(HandsOff)
				(NormalEgo -1 0)
				(gEgo posn: 224 115 setMotion: MoveTo 198 113 self)
			)
			(7
				(gEgo setHeading: 0 self)
			)
			(8
				(gEgo
					view: 182
					loop: 2
					cel: 0
					posn: 200 112
					setCycle: CT 3 1 self
				)
			)
			(9
				(gLongSong2 number: 945 loop: 1 play:)
				(gEgo setCycle: End self)
				(fileDrawer setCycle: Beg self)
			)
			(10)
			(11
				(NormalEgo -1 1)
				(fileDrawer stopUpd:)
				(gEgo posn: 198 113)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 144 114 self)
				(ClearFlag 80)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					get: 16 ; Wanted_Poster
					view: 182
					loop: 3
					cel: 0
					posn: 142 114
					setCycle: CT 2 1 self
				)
				(SetScore 121 5)
			)
			(3
				(printer startUpd: setCel: 0)
				(gEgo setCycle: End self)
			)
			(4
				(gMessager say: 34 4 17 0 self) ; "You pick up the freshly-printed Wanted poster of Jason Taselli and take it with you."
			)
			(5
				(printer stopUpd:)
				(NormalEgo -1 1)
				(gEgo posn: 144 114)
				(HandsOn)
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
				(= next register)
				(gEgo setMotion: PolyPath 167 146 self)
			)
			(1
				(gEgo setMotion: MoveTo 190 160 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(gLongSong2 number: 944 loop: 1 play:)
				(gEgo
					view: 185
					loop: 0
					cel: 0
					posn: 198 159
					setCycle: End self
				)
				(chair1 startUpd: setCycle: End self)
			)
			(4)
			(5
				(if (not next)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= next register)
				(gLongSong2 number: 944 loop: 1 play:)
				(gEgo
					view: 185
					setLoop: 0
					cel: 9
					posn: 198 159
					setCycle: Beg self
				)
				(chair1 startUpd: setCycle: Beg self)
			)
			(1)
			(2
				(NormalEgo -1 6)
				(gEgo posn: 190 160 setMotion: MoveTo 167 146 self)
				(chair1 stopUpd:)
			)
			(3
				(if (not next)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance useComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 185
					loop: 1
					cel: 0
					posn: 198 159
					setCycle: End self
				)
			)
			(1
				(gLongSong2 number: 947 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 117)
			)
		)
	)
)

(instance returnToComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 947 loop: 1 play:)
				(chair1 startUpd:)
				(gEgo
					init:
					view: 185
					loop: 1
					cel: 0
					posn: 198 159
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo view: 185 loop: 0 cel: 9 posn: 198 159)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance usePhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 185
					setLoop: 2
					cel: 0
					posn: 198 159
					setCycle: 0
					setMotion: MoveTo 182 160 self
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				((ScriptID 555 0) init: 1 self) ; TTDialer
			)
			(3
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: 185
					setLoop: 2
					cel: 0
					setCycle: 0
					setMotion: MoveTo 198 159 self
				)
			)
			(5
				(gEgo view: 185 loop: 0 cel: 9 posn: 198 159)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lauraGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 944 loop: 1 play:)
				(laura
					view: 189
					loop: 2
					cel: 0
					posn: (chair2 x:) (chair2 y:)
					setCycle: End self
				)
			)
			(1
				(chair2 init:)
				(laura
					view: 189
					loop: 1
					cel: 0
					posn: (+ (chair2 x:) 1) (+ (chair2 y:) 2)
					setCycle: End self
				)
			)
			(2
				(proc134_4 laura 12 2 141 112)
				(laura ignoreActors: 1 setMotion: MoveTo 112 125 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance shakeHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura
					view: 188
					loop: 0
					cel: 0
					posn: (chair2 x:) (chair2 y:)
					setCycle: CT 6 1 self
				)
			)
			(1
				(gMessager say: 18 2 3 1 self) ; "Oh, hi, Sonny. Or should I say,"Detective Bonds"? Congratulations on the transfer. I know it's only temporary, but if you do good work, we'll probably ask to keep you. Come on, I'll give you a tour of the office."
			)
			(2
				(gEgo setMotion: PolyPath 145 123 self)
			)
			(3
				(gEgo setHeading: 315 self)
			)
			(4
				(proc134_3 self)
			)
			(5
				(laura setCycle: End self)
			)
			(6
				(NormalEgo -1 7)
				(gEgo posn: 145 123)
				(self dispose:)
			)
		)
	)
)

(instance tour1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setMotion: PolyPath 89 122 self)
				(gEgo setMotion: PolyPath 102 132 self)
			)
			(1)
			(2
				(laura setHeading: 225 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance tour2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setMotion: PolyPath 132 113 self)
			)
			(1
				(laura setHeading: 225 self)
				(gEgo setHeading: 0 self)
			)
			(2)
			(3
				(laura
					view: 180
					loop: 0
					cel: 0
					posn: 127 114
					setCycle: End self
				)
			)
			(4
				(proc134_4 laura 12 5 132 113)
				(laura ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance tour3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setMotion: PolyPath 170 108 self)
				(gEgo setMotion: PolyPath 132 114 self)
			)
			(1)
			(2
				(laura setHeading: 225 self)
				(gEgo setHeading: 0 self)
			)
			(3)
			(4
				(laura
					view: 180
					loop: 0
					cel: 0
					posn: 165 109
					setCycle: End self
				)
			)
			(5
				(proc134_4 laura 12 5 170 108)
				(laura ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance tour4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setMotion: PolyPath 187 110 self)
				(gEgo setMotion: PolyPath 230 115 self)
			)
			(1)
			(2
				(laura setHeading: 135 self)
				(gEgo setHeading: 315 self)
			)
			(3)
			(4
				(laura
					view: 180
					loop: 1
					cel: 0
					posn: 190 110
					setCycle: End self
				)
			)
			(5
				(proc134_4 laura 12 4 187 110)
				(laura ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance tour5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setMotion: PolyPath 205 134)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: PolyPath 162 141 self)
			)
			(2
				(laura setHeading: 135 self)
				(gEgo setHeading: 90 self)
			)
			(3)
			(4
				(laura
					view: 180
					loop: 1
					cel: 0
					posn: 208 134
					setCycle: End self
				)
			)
			(5
				(proc134_4 laura 12 4 205 134)
				(laura ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance chitChat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setHeading: 225 self)
				(gEgo setHeading: 90 self)
			)
			(1)
			(2
				(laura
					view: 180
					loop: 0
					cel: 0
					posn: 201 135
					setCycle: End self
				)
			)
			(3
				(proc134_4 laura 12 5 205 134)
				(laura ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance lauraLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(laura setMotion: PolyPath 161 148 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(laura setPri: 12 setMotion: MoveTo 160 200 self)
			)
			(3
				(laura dispose:)
				(self dispose:)
			)
		)
	)
)

(instance visit1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global211 54)
				(self setScript: shakeHands self)
			)
			(1
				(self setScript: lauraGetUp self)
			)
			(2
				(gMessager say: 18 2 3 2 self) ; "Thanks, Detective Watts."
			)
			(3
				(self setScript: tour1 self)
			)
			(4
				(gMessager say: 18 2 3 3 self) ; "Call me Laura. This is the key board. Or, in a room full of computers, I guess I should just call it the keyholder to avoid confusion. Anyway, we hang our vehicle keys here."
			)
			(5
				(self setScript: tour2 self)
			)
			(6
				(gMessager say: 18 2 3 4 self) ; "This is our laser printer, it's hooked up to both the department computers. Not the fastest machine in the world, but it beats writing everything out longhand."
			)
			(7
				(self setScript: tour3 self)
			)
			(8
				(gMessager say: 18 2 3 5 self) ; "This is my computer terminal. It's kind of a mess right now."
			)
			(9
				(self setScript: tour4 self)
			)
			(10
				(gMessager say: 18 2 3 6 self) ; "This cabinet holds our files on all cases currently being investigated, as well as ones that were only recently closed, and "dormant" cases, where we don't have enough evidence to act, but we refuse to close the case in the event we should manage to obtain more evidence."
			)
			(11
				(self setScript: tour5 self)
			)
			(12
				(gMessager say: 18 2 3 7 self) ; "This is your workstation, Sonny. You can access firearm registrations, license numbers, VIN numbers, and other evidence codes here. Since you have a desk now, your pigeonhole downstairs will be assigned to someone else."
			)
			(13
				(self setScript: chitChat self)
			)
			(14
				(gMessager say: 18 2 3 8 self) ; "Our call number here is 83-NORA-10. That's about it for the Grand Tour of the Narcotics Office. Okay, let's get down to business!"
			)
			(15
				(gMessager say: 18 2 3 9 self) ; "This creep Hoffman is on the verge of being released on bail. We suspect he's tied in with much bigger things than just the narcotics found in the trunk of the stolen car. He claims they were there when he "borrowed" it, of course."
			)
			(16
				(gMessager say: 18 2 3 10 self) ; "We know damn well if he's released, he'll bolt like a rabbit. We need some hard evidence to keep him in. See if you can dig anything up that might convince Judge Palmer to keep the jerk locked up, okay? I've gotta go. Do your best, Sonny. Bye."
			)
			(17
				(self setScript: lauraLeaves self)
			)
			(18
				(gMessager say: 18 2 3 11 self) ; "Wow. Your first Narcotics investigation. You wonder where you should start."
			)
			(19
				(SetFlag 84)
				(ClearFlag 81)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 86 126 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(SetScore 125 3)
				(gEgo get: 11) ; Undercover_Car_Keys
				(proc134_3 self)
			)
			(3
				(NormalEgo -1 7)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lauraRemindsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(laura
					setMotion:
						MoveTo
						(- (gEgo x:) 20)
						(- (gEgo y:) 15)
						self
				)
			)
			(1
				(Face gEgo laura self)
				(Face laura gEgo self)
			)
			(2)
			(3
				(gMessager say: 18 2 14 0 self) ; "There you are Sonny. I came by to tell you that when you're done checking out the case evidence, Lt. Morgan wants to see you."
			)
			(4
				(laura setMotion: MoveTo (- (gEgo x:) 20) 165 self)
			)
			(5
				(laura
					setPri: 12
					setMotion: MoveTo (- (gEgo x:) 20) 189 self
				)
				(SetFlag 52)
			)
			(6
				(laura dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fileDrawer of Prop
	(properties
		x 224
		y 101
		noun 30
		view 181
		loop 1
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(switch theVerb
				(4 ; Do
					(if (!= (gEgo view:) 185)
						(gCurRoom setScript: openFileCabinet)
					else
						(gCurRoom setScript: standUp 0 openFileCabinet)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance leftDrawer of Feature
	(properties
		x 206
		y 142
		noun 20
		sightAngle 40
		onMeCheck 4
	)
)

(instance rightDrawer of Feature
	(properties
		x 206
		y 142
		noun 21
		sightAngle 40
		onMeCheck 32
	)
)

(instance printer of Prop
	(properties
		x 93
		y 192
		z 100
		noun 34
		view 181
		loop 2
		signal 16400
	)

	(method (cue)
		(super cue: &rest)
		(self stopUpd:)
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 81)
				(ClearFlag 81)
				(SetFlag 80)
				(self setCycle: End self)
			)
			((and (IsFlag 80) (not (gEgo has: 16))) ; Wanted_Poster
				(self setCel: (self lastCel:))
				(self stopUpd:)
			)
			(else
				(self stopUpd:)
			)
		)
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(switch theVerb
				(4 ; Do
					(if (and (not (gEgo has: 16)) (IsFlag 80)) ; Wanted_Poster
						(if (!= (gEgo view:) 185)
							(gCurRoom setScript: getPaper)
						else
							(gCurRoom setScript: standUp 0 getPaper)
						)
					else
						(gMessager say: noun 4 16 0) ; "The printer hasn't printed anything; therefore, there's nothing to take."
					)
				)
				(1 ; Look
					(if (IsFlag 80)
						(gMessager say: noun 1 17 0) ; "It's the Narcotics office's old, slow laser printer. There's a wanted poster printout in the tray."
					else
						(gMessager say: noun 1 16 0) ; "It can't be...but it is! It's the one, the only, the original LaserDot I. With its tremendous 2 ppm and 60 dpi graphics, this workhorse of a printer must keep this office ever-supplied with quickly printed, high quality material."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance chair1 of Prop
	(properties
		x 199
		y 155
		view 181
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 117)
			(self setCel: (self lastCel:))
		)
		(self stopUpd:)
	)

	(method (doit)
		(if (== (gEgo view:) 185)
			(= x (+ (gEgo x:) 1))
			(= y (- (gEgo y:) 4))
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(switch theVerb
				(4 ; Do
					(if (!= (gEgo view:) 185)
						(gCurRoom setScript: sitDown)
					else
						(gCurRoom setScript: standUp 0 0)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance chair2 of Prop
	(properties
		x 140
		y 110
		view 181
		cel 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sonnyComputer of Feature
	(properties
		x 219
		y 228
		z 100
		noun 8
		nsTop 118
		nsLeft 199
		nsBottom 139
		nsRight 240
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(switch theVerb
				(4 ; Do
					(if (== (gEgo view:) 185)
						(gCurRoom setScript: useComputer)
					else
						(gCurRoom setScript: sitDown 0 useComputer)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sonnyPhone of Feature
	(properties
		x 196
		y 241
		z 100
		noun 10
		nsTop 137
		nsLeft 188
		nsBottom 146
		nsRight 205
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(switch theVerb
				(4 ; Do
					(if (== (gEgo view:) 185)
						(gCurRoom setScript: usePhone)
					else
						(gCurRoom setScript: sitDown 0 usePhone)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance keys of Feature
	(properties
		x 77
		y 78
		noun 6
		nsTop 67
		nsLeft 69
		nsBottom 89
		nsRight 85
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (checker doVerb: theVerb self)
			(switch theVerb
				(4 ; Do
					(if (not (gEgo has: 11)) ; Undercover_Car_Keys
						(if (!= (gEgo view:) 185)
							(gCurRoom setScript: getKey)
						else
							(gCurRoom setScript: standUp 0 getKey)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance checker of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					((< global211 53)
						(gMessager say: 23 4 1 0) ; "Only narcotics officers are allowed to use the equipment in this office."
						(return 0)
					)
					((and (!= global206 1) (!= invItem keys))
						(gMessager say: 23 4 15 0) ; "You've got more important things to do, Bonds! Let's get moving!"
						(return 0)
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(return 1)
			)
		)
	)
)

(instance BASKET of Feature
	(properties
		x 97
		y 110
		noun 11
		nsTop 106
		nsLeft 92
		nsBottom 115
		nsRight 102
		sightAngle 40
		onMeCheck 16384
	)
)

(instance COMCABLES of Feature
	(properties
		x 236
		y 138
		noun 17
		nsTop 127
		nsLeft 224
		nsBottom 149
		nsRight 249
		sightAngle 40
		onMeCheck 16384
	)
)

(instance COMP of Feature
	(properties
		x 146
		y 80
		noun 2
		nsTop 73
		nsLeft 133
		nsBottom 87
		nsRight 160
		sightAngle 40
		onMeCheck 16384
	)
)

(instance FILEPLANT of Feature
	(properties
		x 228
		y 64
		noun 12
		nsTop 49
		nsLeft 216
		nsBottom 80
		nsRight 240
		sightAngle 40
		onMeCheck 16384
	)
)

(instance FLOORPLANT of Feature
	(properties
		x 179
		y 71
		noun 13
		nsTop 39
		nsLeft 159
		nsBottom 104
		nsRight 200
		sightAngle 40
		onMeCheck 16384
	)
)

(instance KEYPD of Feature
	(properties
		x 220
		y 228
		z 100
		noun 9
		nsTop 117
		nsLeft 200
		nsBottom 139
		nsRight 240
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(sonnyComputer doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance PENCIL of Feature
	(properties
		x 206
		y 142
		noun 15
		nsTop 139
		nsLeft 201
		nsBottom 146
		nsRight 212
		sightAngle 40
		onMeCheck 4096
	)
)

(instance TALLPLANT of Feature
	(properties
		x 176
		y 71
		noun 14
		nsTop 39
		nsLeft 159
		nsBottom 104
		nsRight 194
		sightAngle 40
		onMeCheck 8192
	)
)

(instance DESK of Feature
	(properties
		x 128
		y 112
		z 16
		noun 16
		nsTop 80
		nsLeft 89
		nsBottom 112
		nsRight 168
		sightAngle 40
		onMeCheck 2048
	)
)

(instance FILECABINET of Feature
	(properties
		x 223
		y 90
		noun 25
		nsTop 73
		nsLeft 200
		nsBottom 108
		nsRight 246
		sightAngle 40
		onMeCheck 2048
	)
)

(instance WINDW of Feature
	(properties
		x 186
		y 59
		noun 26
		nsTop 42
		nsLeft 122
		nsBottom 76
		nsRight 251
		sightAngle 40
		onMeCheck 1024
	)
)

(instance SONNYDESK of Feature
	(properties
		x 217
		y 138
		noun 28
		nsTop 127
		nsLeft 184
		nsBottom 150
		nsRight 251
		sightAngle 40
		onMeCheck 1024
	)
)

(instance LAURADRAWER of Feature
	(properties
		x 139
		y 99
		noun 27
		nsTop 86
		nsLeft 113
		nsBottom 112
		nsRight 166
		sightAngle 40
		onMeCheck 1024
	)
)

(instance laura of Actor
	(properties
		x 140
		y 110
		noun 18
		view 188
		signal 4096
	)

	(method (init)
		(super init: &rest)
		(self setAvoider: PAvoider)
		(cond
			((< global211 53)
				(self loop: 1 setCycle: Fwd)
			)
			((== global211 80)
				(proc134_4 self 12 2 120 120)
				(chair2 init:)
				(self ignoreActors: 1)
			)
			(else
				(self loop: 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 18 2 2) ; "Detective Watts is busy right now, Bonds. Don't try to engage her in idle chatter."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lauraConv of Conversation ; UNUSED
	(properties)
)

