;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm043 0
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	[local15 100] = [230 83 188 95 156 83 153 84 182 98 23 153 2 153 10 161 132 127 185 157 148 173 109 182 109 184 125 189 318 189 319 127 289 132 306 145 278 145 259 144 211 157 159 124 220 103 243 103 254 97 235 84 230 83 188 95 156 83 153 84 182 98 4 161 0 180 23 169 117 138 177 155 148 173 108 181 109 184 125 189 318 189 319 127 280 138 259 144 211 157 165 131 233 107 240 107 282 98 235 84]
)

(instance rm043 of PQRoom
	(properties
		noun 29
		picture 43
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(gLongSong number: 252 loop: -1 flags: -1 play:)
			(gEgo get: 2 0 5 1 9) ; Extender
			(= global224 {Wednesday, July 29, 1992})
		)
		(= global206 0)
		(= global207 914)
		(LoadMany
			rsVIEW
			0
			7
			139
			255
			284
			297
			355
			361
			362
			363
			365
			369
			371
			372
			374
			914
			920
			980
		)
		(LoadMany
			rsSOUND
			900
			909
			938
			939
			940
			252
			253
			915
			430
			431
			432
			433
			434
			435
			436
		)
		(sfx number: 915 flags: -1 play:)
		(pOpenDoorPoly points: @local15 size: 26)
		(gCurRoom addObstacle: pOpenDoorPoly)
		(HandsOff)
		(stolenCar init: ignoreActors: 1 addToPic:)
		(stolenDoor x: (stolenCar x:) y: (stolenCar y:) init: stopUpd:)
		(patrolCar1 init: setPri: 7 addToPic:)
		(patDoorF init: setPri: 10 stopUpd:)
		(patDoorR setPri: 9 init: stopUpd:)
		(lights1 init: setCycle: Fwd)
		(suspect init: stopUpd:)
		(super init:)
		(street init:)
		(sidewalk init:)
		(redCurb init:)
		(redBuilding init:)
		(alley init:)
		(dumpster init:)
		(garage init:)
		(ticketWindow init:)
		(barredWindow init:)
		(stain init:)
		(poster1 init:)
		(poster2 init:)
		(poster3 init:)
		(poster4 init:)
		(sinBldg init:)
		(sinCitySignTop init:)
		(sinCitySign init:)
		(self setScript: startScript)
		(gEgo
			init:
			view: 7
			setLoop: 2
			setPri: 9
			x: 276
			y: 142
			setCycle: 0
			actions: egoActions
		)
		(gLongSong fade:)
		(gLongSong2 fade:)
	)

	(method (doit)
		(if (>= local5 17)
			(cond
				((gEgo inRect: 0 127 168 160)
					(gEgo setPri: 9)
				)
				((gEgo inRect: 152 81 319 109)
					(gEgo setPri: 5)
				)
				(else
					(gEgo setPri: -1)
				)
			)
		)
		(if
			(and
				(== (suspect view:) 363)
				(not (suspect loop:))
				(<= (gEgo x:) 225)
				(not local0)
			)
			(= local0 1)
			(gCurRoom setScript: perpFireScript)
		)
		(super doit: &rest)
	)

	(method (cue)
		(if (== (gEgo view:) 11)
			(sfx number: 586 play:)
		else
			(gLongSong pause: 0)
		)
	)
)

(instance startScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong fade:)
				(= seconds 4)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance killPerpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 2)
			)
			(1
				(suspect setMotion: 0 setCycle: StopWalk -1)
				(= cycles 10)
			)
			(2
				(gEgo view: 361 loop: 1 setCel: 0 setCycle: End self)
				(sfx number: 939 loop: 1 flags: 1 play:)
			)
			(3
				(gEgo view: 361 loop: 1 setCel: 0 setCycle: End self)
				(sfx number: 939 loop: 1 flags: 1 play:)
			)
			(4
				(suspect view: 365 setLoop: 5 cel: 0 setCycle: End self)
			)
			(5
				(EgoDead 38)
			)
		)
	)
)

(instance contactScript2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 153 2)
				(gMessager say: 38 2 32 0 self) ; "HALT!"
			)
			(1
				(= ticks 90)
			)
			(2
				(suspect setCycle: 0 setMotion: 0)
				(= seconds 2)
			)
			(3
				(gMessager say: 38 2 33 0 self) ; "RAISE YOUR HANDS OVER YOUR HEAD!"
				(SetScore 154 2)
			)
			(4
				(suspect
					view: 365
					loop: 1
					cel: 0
					x: (+ (suspect x:) 3)
					setCycle: End self
				)
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 0)
				(= seconds 15)
			)
			(6
				(gCurRoom setScript: perpFireScript)
			)
		)
	)
)

(instance rightsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 157 1)
				(gMessager say: 38 2 29 0 self) ; "You read the suspect his Miranda rights as he sulks in the back of the car. You're suddenly shaking with relief and excitement. What a righteous bust!"
			)
			(1
				(gMessager say: 35 0 16 0 self) ; "Alright, Sonny! Excellent bust! No, AWESOME bust! Good thing you didn't forget his Miranda rights."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theDash of Feature
	(properties
		x 80
		y 161
		nsTop 147
		nsLeft 58
		nsBottom 169
		nsRight 103
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: (ScriptID 430 0)) ; lookDashScript
			)
			(4 ; Do
				(gCurRoom setScript: (ScriptID 430 0)) ; lookDashScript
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theTrunk of Feature
	(properties
		x 140
		y 166
		z 30
		noun 41
		nsTop 130
		nsLeft 122
		nsBottom 143
		nsRight 158
		sightAngle 40
		approachX 147
		approachY 152
	)

	(method (init)
		(self approachVerbs: 4 1) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if global244
					(gCurRoom setInset: trunkInset)
				else
					(gMessager say: 41 1 34) ; "You wonder what might be in the trunk. No telling, with a perp like this one."
				)
			)
			(4 ; Do
				(if global244
					(gCurRoom setInset: trunkInset)
				else
					(gMessager say: 41 4 34) ; "The trunk is locked. It won't budge. You didn't realize Mercedes were still made so solidly."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trunkInset of Inset
	(properties
		view 371
		x 27
		y 69
		priority 15
		disposeNotOnMe 1
	)

	(method (init)
		(if (!= (gLongSong2 number:) 435)
			(gLongSong pause: 1)
			(gLongSong2 number: 435 loop: 1 play: gCurRoom)
		)
		(SetFlag 82)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 5 4) ; "You don't need to take the drugs out of the trunk. They will be impounded with the car."
			)
			(1 ; Look
				(gMessager say: 41 1 35) ; "You look into the open trunk and see some whitish plastic packages containing what appears to be cocaine and a few green bags containing a leafy substance which you assume to be marijuana."
				(SetScore 161 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theJam of Feature
	(properties
		x 118
		y 161
		heading 180
		nsTop 145
		nsLeft 95
		nsBottom 180
		nsRight 132
		sightAngle 40
		approachX 123
		approachY 185
	)

	(method (init)
		(self approachVerbs: 4 1) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: doorJamInset)
			)
			(4 ; Do
				(gCurRoom setInset: doorJamInset)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorJamInset of Inset
	(properties
		view 369
		x 9
		y 70
		priority 15
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local1
					(gMessager say: 17 4 40) ; "You already did that."
				else
					(= local1 1)
					(SetScore 159 5)
					(SetFlag 83)
					(gMessager say: 17 4 4) ; "You scratch the paint away. The number is 603456218. It's the right car!"
				)
			)
			(1 ; Look
				(if local1
					(gMessager say: 17 1 4) ; "The number is 603456218. It's the right car!"
				else
					(gMessager say: 17 1) ; "You take a close look at the Mercedes' door. Hmm, there seems to be black paint over the VIN number."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stolenDoor of Prop
	(properties
		noun 17
		view 920
		loop 1
		priority 10
		signal 16400
	)

	(method (facingMe)
		(super facingMe:)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local5 0)
					(gLongSong fade:)
					(gMessager say: 19 1) ; "You look the suspect vehicle over from your vantage point, noting the license plate number, its make and color."
					(= local5 1)
				else
					(gMessager say: 19 1 7) ; "It certainly looks like the silver Mercedes everyone has been talking about."
				)
			)
			(4 ; Do
				(if (and (not (gCurRoom script:)) (> local5 16))
					(gCurRoom setScript: (ScriptID 430 0)) ; lookDashScript
				else
					(stolenCar doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance patDoorF of Prop
	(properties
		x 255
		y 121
		noun 20
		approachX 302
		approachY 139
		view 914
		loop 3
		priority 10
		signal 16400
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== local7 0)
						(gCurRoom setScript: egoExitScript)
					)
					((>= local5 17)
						(gCurRoom setScript: egoExitScript)
					)
					((< local5 16)
						(gMessager say: 20 4) ; "That wouldn't be your most efficient time expenditure. You've got more important things to do now."
					)
					(else
						(gCurRoom setScript: egoExitScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance patDoorR of Prop
	(properties
		x 286
		y 79
		z -30
		noun 20
		view 914
		loop 4
		priority 10
		signal 16400
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 20 4) ; "That wouldn't be your most efficient time expenditure. You've got more important things to do now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance patrolCar1 of View
	(properties
		x 275
		y 78
		z -50
		noun 21
		view 914
		cel 1
		priority 8
		signal 20496
	)
)

(instance lights1 of Prop
	(properties
		x 278
		y 90
		noun 14
		view 914
		loop 1
		priority 8
		signal 16
	)
)

(instance jack of Actor
	(properties
		x 333
		y 99
		noun 10
		view 139
		priority 6
		signal 4112
	)
)

(instance patrolCar2 of Actor
	(properties
		x 415
		y 52
		noun 9
		view 914
		signal 22528
		xStep 20
	)

	(method (init)
		(super init: &rest)
		(self setScript: jackEntersScript)
	)
)

(instance lights2 of Prop
	(properties
		x 360
		y 38
		noun 14
		view 914
		loop 1
		cel 1
		priority 14
		signal 16400
	)
)

(instance street of Feature
	(properties
		x 159
		y 76
		z -60
		noun 37
		nsTop 83
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 8
	)
)

(instance sidewalk of Feature
	(properties
		x 159
		y 58
		z -60
		noun 30
		nsTop 51
		nsBottom 186
		nsRight 319
		sightAngle 40
		onMeCheck 64
	)
)

(instance redCurb of Feature
	(properties
		x 45
		y 173
		noun 28
		nsTop 157
		nsBottom 189
		nsRight 90
		sightAngle 40
		onMeCheck 16
	)
)

(instance redBuilding of Feature
	(properties
		x 262
		y 42
		noun 3
		nsTop 1
		nsLeft 205
		nsBottom 83
		nsRight 319
		sightAngle 40
		onMeCheck 4096
	)
)

(instance alley of Feature
	(properties
		x 186
		y 47
		noun 1
		nsTop 1
		nsLeft 167
		nsBottom 94
		nsRight 205
		sightAngle 40
		onMeCheck 2048
	)
)

(instance dumpster of Feature
	(properties
		x 183
		y 63
		noun 44
		nsTop 42
		nsLeft 166
		nsBottom 85
		nsRight 200
		sightAngle 40
		onMeCheck 2
	)
)

(instance garage of Feature
	(properties
		x 249
		y 37
		noun 7
		nsLeft 215
		nsBottom 74
		nsRight 283
		sightAngle 40
		onMeCheck 8192
	)
)

(instance ticketWindow of Feature
	(properties
		x 44
		y 98
		noun 39
		nsTop 80
		nsLeft 34
		nsBottom 116
		nsRight 54
		sightAngle 40
		onMeCheck 4
	)
)

(instance barredWindow of Feature
	(properties
		x 305
		y 18
		noun 42
		nsTop 7
		nsLeft 297
		nsBottom 30
		nsRight 314
		sightAngle 40
		onMeCheck 4
	)
)

(instance stain of Feature
	(properties
		x 267
		y 77
		noun 36
		nsTop 69
		nsLeft 248
		nsBottom 86
		nsRight 287
		sightAngle 40
		onMeCheck 32
	)
)

(instance poster1 of Feature
	(properties
		x 87
		y 86
		noun 24
		nsTop 72
		nsLeft 78
		nsBottom 100
		nsRight 96
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not local11)
				(gMessager say: noun 1 10 0) ; "The poster is an advertisement for "Naugahyde Goddesses of Oakhurst, Part VII, The Absolutely Final Chapter, No, Seriously, We Mean it This Time.""
				(= local11 1)
			else
				(gMessager say: noun 1 0 0) ; "It's the story of three young, nubile computer programmers with a thing for leather on their own in the big city. Will corruption, sleaze and cheap hardware destroy them? Will they find true love? Will they get good jobs at a computer game company and live happily ever after...or will they sink into the pit of arcade depravity?"
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance poster2 of Feature
	(properties
		x 107
		y 80
		noun 26
		nsTop 67
		nsLeft 99
		nsBottom 94
		nsRight 116
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not local12)
				(gMessager say: noun 1 10 0) ; "It's an ad for "Vixens With Vestigal Tails Meet the Studley Possum Men from Outer Space"."
				(= local12 1)
			else
				(gMessager say: noun 1 0 0) ; "Six identical sisters from the bayou can never get dates because they have tails and whiskers. It looks like they'll live their lives alone with just their pet gators for company...until a spaceship full of Studley Possum Men show up! Yow, it's wild possum passion in the savage swamp! Lash that tail, baby!"
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance poster3 of Feature
	(properties
		x 126
		y 74
		noun 25
		nsTop 62
		nsLeft 118
		nsBottom 87
		nsRight 135
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not local13)
				(gMessager say: noun 1 10 0) ; "It's an ad for "Monaco Princess"."
				(= local13 1)
			else
				(gMessager say: noun 1 0 0) ; "Kitty Nicolman stars as a young princess who decides to take up race-car driving and accidentally kills her mother in the process. She then falls under the sway of a handsome driver (Crom Truze) who gets her job after job in the race-car industry, jobs she would never have gotten without his connections."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance poster4 of Feature
	(properties
		x 145
		y 69
		noun 43
		nsTop 56
		nsLeft 137
		nsBottom 82
		nsRight 154
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not local14)
				(gMessager say: noun 1 10 0) ; "It's an ad for "Loree: Rat Goddess of the Hell's Angels"."
				(= local14 1)
			else
				(gMessager say: noun 1 0 0) ; "Phil at the station told everyone about the plot of this "flick." Her mother was bitten by a radioactive rat and tragically gave birth to Loree, half-rat, half-girl. She put up with the town's taunts and tormenting...until the night they killed her brother with a giant mousetrap. Now she's joined the Hell's Angels (men who appreciate a girl with furry legs), and Loree's gonna get even."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sinBldg of Feature
	(properties
		x 86
		y 75
		noun 32
		nsTop -1
		nsBottom 152
		nsRight 172
		sightAngle 40
		onMeCheck 16384
	)
)

(instance sinCitySign of Feature
	(properties
		x 36
		y 61
		noun 33
		nsTop 30
		nsBottom 92
		nsRight 73
		sightAngle 40
		onMeCheck 256
	)
)

(instance sinCitySignTop of Feature
	(properties
		x 36
		y 61
		noun 40
		nsTop 30
		nsBottom 92
		nsRight 73
		sightAngle 40
		onMeCheck 128
	)
)

(instance pOpenDoorPoly of Polygon
	(properties
		size 29
		type PContainedAccess
	)
)

(instance pClosedDoorPoly of Polygon ; UNUSED
	(properties
		size 27
		type PContainedAccess
	)
)

(instance streetSfx of Sound ; UNUSED
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance stolenCar of View
	(properties
		x 95
		y 160
		noun 19
		view 920
		cel 1
		priority 10
		signal 16400
	)

	(method (facingMe)
		(super facingMe:)
		(return 1)
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(switch theVerb
			(1 ; Look
				(if (== local5 0)
					(gLongSong fade:)
					(gMessager say: 19 1) ; "You look the suspect vehicle over from your vantage point, noting the license plate number, its make and color."
					(= local5 1)
				else
					(gMessager say: 19 1 7) ; "It certainly looks like the silver Mercedes everyone has been talking about."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local7 0)
					(gCurRoom setScript: egoExitScript)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(11 ; Extender
				(gMessager
					say:
						27
						4
						(cond
							((== local5 1) 9)
							((== local5 2) 11)
							((>= local5 15) 14)
							(else 13)
						)
				)
				(if (== local5 2)
					(SetScore 151 5)
				)
				(if (== local5 1)
					(sfx stop:)
					(gLongSong number: 253 loop: -1 flags: -1 play:)
				)
				(if (and (or (== local5 1) (== local5 2)) (== (++ local5) 3))
					(= local5 4)
					(patrolCar2 init: stopUpd:)
				)
				(return 1)
			)
			(9 ; Service_Revolver
				(cond
					((== local5 14)
						(gMessager say: 29 4 38) ; "You don't have enough room in your pockets for THAT!"
					)
					((> local7 0)
						(gCurRoom setScript: weaponScript)
					)
					(else
						(gMessager say: 38 9 25) ; "You'll need to be standing for that."
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sShootSuspect of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sfx number: 940 loop: 2 flags: -1 play:)
				(= ticks 10)
			)
			(1
				(gMessager say: 38 9 0 0 self) ; "You blow the suspect away. That may be admirable behavior in the movies, but not in the real world. Internal Affairs investigates, and six weeks later, you are bounced off the force."
			)
			(2
				(EgoDead)
			)
		)
	)
)

(instance weaponScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local7 2)
					(= local7 1)
					(NormalEgo)
					(self dispose:)
				else
					(gEgo
						view: 361
						setLoop: 0
						cel: 0
						posn: (- (gEgo x:) 5) (+ (gEgo y:) 5)
						setCycle: End self
					)
					(if (gEgo inRect: 247 118 319 152)
						(gEgo setPri: 9)
					)
				)
			)
			(1
				(gMessager say: 34 9 15 0 self) ; "You draw your service revolver. It never felt so heavy in your hands before."
			)
			(2
				(HandsOn)
				(if (gEgo cel:)
					(gTheIconBar disable: 0)
					(= local7 2)
				else
					(NormalEgo)
					(= local7 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(patDoorF setCycle: End self)
				(sfx number: 900 loop: 1 flags: 1 play:)
			)
			(1
				(if (< local5 17)
					(gLongSong
						number: (if (== local5 5) 431 else 432)
						loop: (if (== local5 5) -1 else 1)
						flags: -1
						play:
					)
				)
				(patDoorF stopUpd:)
				(if (< local5 17)
					(gEgo
						view: 7
						setLoop: (if (== local7 0) 2 else 3)
						cel: 0
						x: 275
						y: 142
						z: 0
						setCycle: End self
					)
				else
					(gEgo setPri: 9 setMotion: MoveTo 287 131 self)
					(patDoorF setPri: 10)
				)
			)
			(2
				(if (< local5 17)
					(NormalEgo)
					(gEgo posn: 289 132 setHeading: 250 self)
				else
					(= cycles 2)
				)
			)
			(3
				(cond
					((< local5 5)
						(= local5 18)
						(gEgo setHeading: 250)
						(gCurRoom setScript: perpExitScript)
					)
					((== local7 0)
						(HandsOn)
						(NormalEgo)
						(gEgo loop: 8 cel: 5)
						(= local7 1)
						(patDoorF approachVerbs: 4) ; Do
						(+= state 2)
						(= seconds 15)
					)
					(else
						(gEgo
							view: 7
							x: 274
							y: 139
							setPri: 9
							setLoop: 2
							setCel: 255
							setCycle: Beg self
						)
					)
				)
			)
			(4
				(patDoorF setCycle: Beg self)
				(gLongSong fade:)
			)
			(5
				(= global211 47)
				(gCurRoom newRoom: 500)
			)
			(6
				(gCurRoom setScript: perpFireScript)
			)
		)
	)
)

(instance arrestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (HaveMouse))
					(hoffManFeature dispose:)
				)
				(gMessager say: 38 2 30 0 self) ; "HIT THE ASPHALT! FACE TO THE PAVEMENT! NOW!"
				(SetScore 155 2)
			)
			(1
				(= ticks 30)
			)
			(2
				(suspect
					view: 365
					loop: 2
					cel: 0
					x: (- (suspect x:) 5)
					y: (+ (suspect y:) 8)
					setCycle: End self
				)
			)
			(3
				(= local5 14)
				(gMessager say: 10 2 2 0 self) ; "Go ahead and move in, Sonny! I've got him covered!"
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 0)
			)
			(5
				(HandsOff)
				(= local8 (suspect x:))
				(= local9 (suspect y:))
				(gEgo
					view: 362
					setLoop: 5
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 311 146 self
				)
			)
			(6
				(gEgo setPri: -1 setMotion: MoveTo 311 150 self)
			)
			(7
				(gEgo
					view: 362
					setLoop: 5
					cel: 0
					setPri: -1
					setCycle: Walk
					setMotion:
						MoveTo
						(+ (suspect x:) 15)
						(- (suspect y:) 25)
						self
				)
			)
			(8
				(gEgo view: 372 setLoop: 0 setCel: 2 setCycle: Beg self)
			)
			(9
				(gEgo
					view: 0
					loop: 5
					setCel: -1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo (- local8 10) (- local9 12) self
				)
			)
			(10
				(gLongSong fade:)
				(gEgo view: 285 setLoop: 3 cel: 0 x: local8 y: local9)
				(suspect dispose:)
				(= seconds 3)
			)
			(11
				(gMessager say: 38 3 27 0 self) ; "You stand directly over the suspect. You can see he's shaking. He might do anything right now."
			)
			(12
				(jack setLoop: 0 cel: 255 setCycle: Beg)
				(gEgo setCycle: End self)
			)
			(13
				(jack
					view: 139
					setLoop: -1
					setHeading: 180
					setCycle: StopWalk -1
				)
				(gEgo loop: 4 cel: 0 setCycle: End self)
				(= cycles 3)
			)
			(14
				(sfx number: 919 play:)
			)
			(15
				(= ticks 10)
			)
			(16
				(gLongSong number: 433 play:)
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(17
				(= cycles 10)
			)
			(18
				(gEgo loop: 6 cel: 0 setCycle: End self)
			)
			(19
				(SetScore 156 2)
				(gMessager say: 38 38 24 0 self) ; "You search the suspect, finding only some pocket change, a dried-up stick of gum..."
			)
			(20
				(gEgo
					view: 0
					setLoop: -1
					loop: 4
					cel: 7
					posn: (- local8 10) (- local9 10)
				)
				(suspect
					view: 285
					loop: 1
					cel: 0
					x: local8
					y: local9
					init:
					setPri: -1
				)
				(gMessager say: 38 2 24 0 self) ; "Nice pea shooter. On your feet, bud."
			)
			(21
				(suspect setCycle: End self)
			)
			(22
				(suspect loop: 2 cel: 0 setCycle: End self)
			)
			(23
				(suspect view: 297 setLoop: -1 loop: 6 cel: 1 setCycle: Walk)
				(= ticks 2)
			)
			(24
				(gMessager say: 38 2 28 0 self) ; "Let's go, buddy. Into the patrol car."
			)
			(25
				(suspect setMotion: MoveTo (+ (suspect x:) 20) 184 self)
			)
			(26
				(suspect setMotion: PolyPath 320 150 self)
				(= ticks 60)
			)
			(27
				(gEgo setCycle: Walk setMotion: PolyPath 275 152 self)
			)
			(28
				(if (not (suspect mover:))
					(suspect loop: 3)
				)
			)
			(29
				(if (not (suspect mover:))
					(suspect loop: 3)
				)
				(patDoorF setCycle: Beg self)
			)
			(30
				(sfx number: 901 play:)
				(if (not (suspect mover:))
					(suspect loop: 3)
				)
				(= ticks 60)
			)
			(31
				(gEgo setMotion: PolyPath 298 139 self)
			)
			(32
				(gEgo
					view: 355
					loop: 0
					cel: 0
					x: (- (gEgo x:) 5)
					y: (+ (gEgo y:) 8)
					setCycle: CT 7 1
				)
				(patDoorR setCycle: End self)
			)
			(33
				(sfx number: 900 play:)
				(patDoorR setPri: 9)
				(suspect setPri: 8)
				(suspect setMotion: PolyPath 319 139 self)
			)
			(34
				(suspect setMotion: MoveTo 295 136 self)
			)
			(35
				(suspect view: 363 loop: 1 cel: 0 setPri: 8 setCycle: End self)
				(patDoorR setPri: 9)
			)
			(36
				(gEgo setCycle: End)
				(patDoorR setCycle: Beg self)
			)
			(37
				(sfx number: 901 play:)
				(gEgo view: 0 loop: 8 cel: 3 setCycle: StopWalk -1)
				(= local5 17)
				(HandsOn)
				(theTrunk init:)
				(theJam init:)
				(theDash init:)
				(= ticks 2)
			)
			(38
				(gMessager say: 10 2 36 0 self) ; "Well handled, Sonny. Give me that piece and I'll take care of booking it into evidence while you search the vehicle."
			)
			(39
				(self dispose:)
			)
		)
	)
)

(instance jackEntersScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(gLongSong fade:)
				(gLongSong2 number: 911 loop: -1 play:)
				(= seconds 3)
			)
			(2
				(patrolCar2 setMotion: MoveTo 340 77 self)
				(sfx number: 910 loop: 1 flags: -1 play:)
			)
			(3
				(lights2 posn: 343 38 init: setCycle: Fwd)
				(sfx stop:)
				(= seconds 2)
			)
			(4
				(gLongSong2 stop:)
				(gLongSong number: 430 loop: -1 flags: -1 play:)
				(gMessager say: 35 0 17 0 self) ; "At last, Officer Jack Cobb arrives. You've never been so glad to see him in your life!"
			)
			(5
				(= ticks 2)
			)
			(6
				(sfx number: 900 loop: 1 flags: -1 play:)
				(= seconds 2)
			)
			(7
				(jack
					init:
					setCycle: StopWalk -1
					setMotion: MoveTo 222 126 self
				)
			)
			(8
				(jack view: 361 setLoop: 0 cel: 0 setCycle: End self)
			)
			(9
				(jack setLoop: 1 setCel: 0 stopUpd:)
				(= local5 5)
				(= local2 1)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance suspect of Actor
	(properties
		x 110
		y 183
		noun 38
		view 363
		priority 10
		signal 16400
	)

	(method (cue)
		(super cue:)
		(EgoDead)
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(switch theVerb
			(2 ; Talk
				(cond
					((== local5 14)
						(gMessager say: 38 2 39) ; "Don't move. Don't even BREATHE. You're in enough trouble right now as it is, sir, and I'd hate for you to say something that might be used against you in a court of law."
					)
					((== local5 17)
						(gCurRoom setScript: rightsScript)
					)
					((== local5 12)
						(= local5 13)
						(gCurRoom setScript: arrestScript)
					)
					((or (== local5 9) (== local5 8))
						(= local5 12)
						(gCurRoom setScript: contactScript2)
					)
					((< local5 6)
						(if local7
							(HandsOff)
							(= local5 6)
							(gCurRoom setScript: contactScript1)
						else
							(gMessager say: 38 2 25) ; "You yell to the man in the car, but receive only a serious ringing in the ears as a response."
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(4 ; Do
				(if (== local5 14)
					(gMessager say: 38 4 37) ; "Searching a dangerous suspect without first handcuffing them is an invitation to a broken skull...or worse."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(21 ; Handcuffs
				(cond
					((== local5 14)
						(arrestScript cue:)
					)
					((< local5 14)
						(gMessager say: 38 38 23) ; "You'll have to get him under control first."
					)
					((> local7 0)
						(gMessager say: 38 38 23) ; "You'll have to get him under control first."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(9 ; Service_Revolver
				(cond
					((>= local5 14)
						(sfx number: 940 loop: 2 flags: -1 play:)
						(gMessager say: 38 9 2 0 self) ; "Shoot an unarmed man when he's down? Get real, Bonds. You're a law enforcement officer. Shooting an unarmed man isn't going to win you any brownie points with Dooley."
					)
					((or (== local5 8) (== local5 10))
						(HandsOff)
						(gCurRoom setScript: killPerpScript)
					)
					(else
						(gCurRoom setScript: sShootSuspect)
					)
				)
			)
			(1 ; Look
				(if (>= local5 7)
					(gMessager say: 38 1 27) ; "You're still not sure exactly who this dirtbag is, but you know he's bad news."
				else
					(gMessager say: 38 1) ; "You have no idea who it could be from here, but he sure looks seedy."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance perpFireScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= (gLongSong number:) 432)
					(gLongSong number: 432 loop: 1 play:)
				)
				(if (== (stolenDoor cel:) 0)
					(-- state)
					(stolenDoor setPri: 14 setCycle: End self)
				else
					(if (and (!= (suspect cel:) 3) (!= (suspect loop:) 1))
						(suspect posn: (+ (suspect x:) 10) (+ (suspect y:) 10))
					)
					(suspect view: 365 setLoop: 0 setCycle: CT 3 1 self)
					(if (== local7 1)
						(gEgo setHeading: 250)
					)
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(suspect setCycle: End self)
				(sfx number: 938 loop: 1 flags: -1 play:)
			)
			(3
				(= ticks 10)
			)
			(4
				(suspect setCel: 3 setCycle: End self)
				(sfx number: 938 loop: 1 flags: -1 play:)
				(gEgo view: 11 setLoop: 4 cel: 0 setCycle: End gCurRoom)
			)
			(5
				(cond
					((== local2 1)
						(sfx number: 940 loop: 2 flags: -1 play:)
						(jack setCycle: End self)
					)
					((< local5 5)
						(suspect
							view: 365
							setLoop: 0
							setCel: 255
							setCycle: Beg self
						)
						(patrolCar2 setScript: 0)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(6
				(if local2
					(suspect view: 365 setLoop: 5 cel: 0 setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(7
				(if (not local2)
					(suspect
						view: 365
						setLoop: 0
						setCel: 255
						setCycle: Beg self
					)
				else
					(= cycles 2)
				)
			)
			(8
				(= ticks 120)
			)
			(9
				(gMessager
					say:
						(if (== local5 18) 15 else 38)
						4
						(if (== local5 18) 5 else 23)
						1
						self
				)
			)
			(10
				(EgoDead (if (== local5 18) 32 else 34))
				(self dispose:)
			)
		)
	)
)

(instance contactScript1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 38 2 10 0 self) ; "PLEASE EXIT THE VEHICLE WITH YOUR HANDS RAISED! REPEAT, PLEASE EXIT THE VEHICLE WITH YOUR HANDS RAISED!"
			)
			(1
				(if (== local7 2)
					(self setScript: perpExitScript self)
				else
					(gCurRoom setScript: perpFireScript)
				)
			)
			(2
				(HandsOff)
				(= local5 8)
				(suspect
					view: 374
					setHeading: 90
					setCycle: Walk
					setMotion: MoveTo 140 185 self
				)
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 0)
				(if (not (HaveMouse))
					(= seconds 2)
				else
					(suspect setMotion: MoveTo 190 185 self)
				)
			)
			(4
				(if (not (HaveMouse))
					(suspect setMotion: MoveTo 190 185 self)
				else
					(gCurRoom setScript: perpFireScript)
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(gCurRoom setScript: perpFireScript)
			)
		)
	)
)

(instance perpExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (HaveMouse))
					(hoffManFeature init:)
				)
				(stolenDoor setPri: 14 setCycle: End self)
				(sfx number: 900 loop: 1 flags: 1 play:)
			)
			(1
				(suspect setCycle: End self)
			)
			(2
				(if (== local5 6)
					(= local5 7)
				)
				(suspect view: 365 posn: 132 180 setLoop: 0 cel: 0)
				(= ticks 2)
			)
			(3
				(cond
					((or (== local5 18) (and (== local5 6) (== local7 1)))
						(gCurRoom setScript: perpFireScript)
					)
					((and (== local5 7) (== local7 2))
						(if (and (> (gEgo y:) 140) (<= (gEgo x:) 288))
							(gCurRoom setScript: perpFireScript)
						else
							(self dispose:)
						)
					)
					(
						(and
							(== local7 1)
							(or (== local5 6) (== local5 8) (== local5 7))
						)
						(if (and (> (gEgo y:) 140) (<= (gEgo x:) 288))
							(gCurRoom setScript: perpFireScript)
						else
							(self dispose:)
						)
					)
					((and (== local5 9) (== local7 2))
						(if (and (> (gEgo y:) 140) (<= (gEgo x:) 288))
							(gCurRoom setScript: perpFireScript)
						else
							(self dispose:)
						)
					)
					(else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance hoffManFeature of Feature
	(properties
		x 166
		y 151
		nsTop 116
		nsLeft 89
		nsBottom 187
		nsRight 243
	)

	(method (doVerb theVerb)
		(suspect doVerb: theVerb)
	)
)

