;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use oAnnounceTimer)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	ro341 0
	voWallPhone 1
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
	local8
	local9
	local10
	local11
	local12
	local13 = 18
)

(instance ro341 of L7Room
	(properties
		picture 34100
	)

	(method (init)
		(proc80_1 0)
		(if ((ScriptID 64017 0) test: 173) ; oFlags
			(gEgo
				init:
				normalize: 4
				setScaler: Scaler 125 97 364 279
				posn: 436 364
			)
		else
			(gEgo
				init:
				normalize: 7
				setScaler: Scaler 125 97 364 279
				posn: 284 290
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 619 245 39 295 37 448 102 476 571 476 638 447 636 401 571 365 387 320 404 290 627 270
					yourself:
				)
		)
		(if (not (OneOf gPrevRoomNum 340 341 360)) ; ro340, ro341, ro360
			(gOMusic1 setMusic: 34000)
		)
		(if (!= gPrevRoomNum 340) ; ro340
			(gOSound1 setAmbient: 34002)
		)
		(voDeskPhone init:)
		(voWallPhone init:)
		(foWallPhone init:)
		(foAquarium init:)
		(foExitWest init:)
		(foExitEast init:)
		(poPurser init:)
		(poAnnouncer init:)
		(aoYellow2Blue init:)
		(aoAngel init:)
		(ao2Yellow init:)
		(aoSmallBlue init:)
		(aoGreen init:)
		(oSpecialAnnounceTimer setReal: oSpecialAnnounceTimer (Random 15 45))
		(gGame handsOn:)
		(cond
			(((ScriptID 64017 0) test: 173) ; oFlags
				((ScriptID 64017 0) clear: 173) ; oFlags
				(foWallPhone doVerb: 249)
			)
			(global218
				(poPurser doVerb: 4)
				(poPurser doVerb: global218)
				(= global218 0)
			)
			(else
				(poPurser doVerb: 4)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and script (!= script (ScriptID 64039 1)))) ; soExit
			(
				(or
					(== (poPurser script:) soPurserLeaves)
					(== (poPurser script:) soPurserReturns)
				)
				0
			)
			(
				(or
					(and
						(== (poPurser script:) soPurserMotions)
						(or
							(and (== (gEgo x:) 284) (== (gEgo y:) 290))
							(and (== (gEgo x:) 436) (== (gEgo y:) 364))
						)
					)
					(and
						local5
						(!= (poPurser script:) soPurserStopMotion)
						(or (!= (gEgo x:) 436) (!= (gEgo y:) 364))
					)
				)
				(poPurser setScript: soPurserStopMotion)
			)
			(
				(and
					(!= (poPurser script:) soPurserMotions)
					(!= (poPurser script:) soPurserStopMotion)
					(or (!= (gEgo x:) 284) (!= (gEgo y:) 290))
					(or (!= (gEgo x:) 436) (!= (gEgo y:) 364))
				)
				(poPurser setScript: soPurserMotions)
			)
			(
				(and
					((ScriptID 64040 2) oPlane:) ; L7TalkWindow
					(or (!= (gEgo x:) 284) (!= (gEgo y:) 290))
					(or (!= (gEgo x:) 436) (!= (gEgo y:) 364))
				)
				(poPurser addHotspotVerb: 4)
				(voWallPhone addHotspotVerb: 249)
				(foWallPhone addHotspotVerb: 249)
				((ScriptID 64040 2) dispose:) ; L7TalkWindow
				(= global340 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 330 340 341 360)) ; ro330, ro340, ro341, ro360
			(gOMusic1 fadeOut:)
		)
		(if (!= newRoomNumber 340) ; ro340
			(gOSound1 fadeOut:)
		)
		(if (and (== newRoomNumber 340) (== (poPurser view:) 34101)) ; ro340
			((ScriptID 64017 0) set: 203) ; oFlags
		)
		(super newRoom: newRoomNumber)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 30)) ; oInvHandler, ioPhotoID
	)

	(method (dispose)
		(if (gTimers contains: oSpecialAnnounceTimer)
			(oSpecialAnnounceTimer dispose: delete:)
		)
		(oAnnounceSFX stop:)
		((ScriptID 64017 0) clear: 183) ; oFlags
		(= global340 0)
		(= global330 0)
		(proc80_1 1)
		(super dispose: &rest)
	)
)

(instance soPurserMotions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 34103 34105 34104) ; WAVE
				(= ticks (Random 360 540))
			)
			(1
				(oSFX playSound: 34102 self)
			)
			(2
				(poPurser
					view: 34100
					loop: 0
					cel: 0
					setCycle: End self 3 5 8 999
				)
			)
			(3
				(oSFX playSound: 34103)
			)
			(4
				(voDeskPhone cel: 1)
			)
			(5
				(poPurserPhoneMouth init: setCycle: RandCycle 999)
				(oSFX2 setAmbient: 34105)
			)
			(6
				(poPurser setCycle: RangeRandCycle (Random 120 240) 8 12 self)
			)
			(7
				(poPurser setCycle: Beg self 7 6 4 0)
			)
			(8
				(oSFX2 stop:)
				(poPurserPhoneMouth setCycle: 0 dispose:)
			)
			(9
				(oSFX playSound: 34104)
			)
			(10
				(voDeskPhone cel: 0)
			)
			(11
				(self changeState: 0)
			)
		)
	)
)

(instance soPurserStopMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPurser setCycle: 0)
				(cond
					((>= (poPurser cel:) 8)
						(self setScript: soMouthPhoneStop self)
					)
					((>= (poPurser cel:) 5)
						(self setScript: soPhoneStop self)
					)
					((== (poPurser cel:) 0)
						(self dispose:)
					)
					(else
						(poPurser setCycle: Beg self)
					)
				)
			)
			(1
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance soMouthPhoneStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPurser setCycle: Beg self 7 6 4)
			)
			(1
				(oSFX2 stop:)
				(poPurserPhoneMouth setCycle: 0 dispose:)
			)
			(2
				(oSFX playSound: 34104 self)
			)
			(3
				(voDeskPhone cel: 0)
				(if local9
					(oSFX2 setAmbient: 34202)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soPhoneStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPurser setCycle: Beg self 6 4)
			)
			(1
				(oSFX playSound: 34104 self)
			)
			(2
				(voDeskPhone cel: 0)
				(if local9
					(oSFX2 setAmbient: 34202)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soPurserLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 1 184 0 1 2 self) ; "I'm a little worried about the charges on my account. Could you check my balance for me?"
			)
			(1
				((ScriptID 64040 2) dispose:) ; L7TalkWindow
				(poPurser addHotspotVerb: 4)
				(poPurser
					setCycle: 0
					view: 34101
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(poPurser hide:)
				((ScriptID 64017 0) set: 183) ; oFlags
				(voDeskPhone addApproachVerb: 1)
				(= ticks 1200)
			)
			(3
				(if local3
					(self dispose:)
				else
					(self setScript: soPurserReturns self 1)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soPurserReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= cycles 1)
				else
					(= ticks 360)
				)
			)
			(1
				(= local10 0)
				((ScriptID 64017 0) clear: 183) ; oFlags
				(voDeskPhone deleteApproachVerb: 1)
				(poPurser show: loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(poPurser view: 34100 loop: 0 cel: 0)
				(if (or local6 (gGame script:) (not (gUser canControl:)))
					(= cycles 1)
				else
					(gEgo setMotion: 0)
					(Face gEgo poPurser self)
				)
			)
			(3
				(cond
					(((ScriptID 64017 0) test: 29) ; oFlags
						(gMessager sayRange: 1 184 0 7 8 self) ; "I wouldn't worry; it seems Captain Thygh has flagged your account."
					)
					((> (= register (proc64896_22)) 4)
						(gMessager say: 1 184 0 6 self) ; "Oh, it's nothing so far; slightly under $50,000."
					)
					((> register 2)
						(gMessager say: 1 184 0 5 self) ; "Your account is next to nothing; only $19,123 dollars."
					)
					((> register 0)
						(gMessager say: 1 184 0 4 self) ; "Your account is miniscule; only $5,002 dollars."
					)
					(else
						(gMessager say: 1 184 0 3 self) ; "Your account is almost nothing, unless you count the $381 from the bar."
					)
				)
			)
			(4
				(poPurser setScript: soPurserMotions)
				(self dispose:)
			)
		)
	)
)

(instance soPickUpPhone of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 34201 34001) ; WAVE
				(gEgo
					view: 34103
					loop: 0
					cel: 0
					setScale: 0
					posn: 422 363
					setCycle: End self 4
				)
			)
			(1
				(oSFX playSound: 34201 self)
			)
			(2
				(voWallPhone hide:)
				(oSFX playSound: 34001 self)
			)
			(3
				(gGame handsOn:)
				(= global330 toLarry)
				(= local6 1)
				(self dispose:)
			)
		)
	)
)

(instance soPurserOnPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPurser setCycle: RangeRandCycle (Random 120 240) 8 12 self)
			)
			(1
				(poPurser cel: 8)
				(= ticks (Random 60 240))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance soYouMakeTheCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 34201 34001 34102 34103 34302) ; WAVE
				(if (== register 211)
					(Load 140 34202) ; WAVE
				)
				(= global340 toPurserPhone)
				(= local12 (gEgo cycleSpeed:))
				(gEgo
					view: 34103
					loop: 0
					cel: 0
					setScale: 0
					posn: 422 363
					setSpeed: 6
					setCycle: End self 4
				)
			)
			(1
				(oSFX playSound: 34201 self)
				(voWallPhone hide:)
			)
			(2
				(oSFX playSound: 34001)
				(= ticks 30)
			)
			(3
				(oSFX2 playSound: 34102 self)
			)
			(4
				(= global330 toLarry)
				(= local6 1)
				(poPurser view: 34100 loop: 0 cel: 0 setCycle: End self 5 8)
			)
			(5
				(oSFX playSound: 34103)
				(voDeskPhone cel: 1)
			)
			(6
				(poPurserPhoneMouth init:)
				(= local5 1)
				(poPurser setScript: soPurserOnPhone)
				(switch register
					(182
						((ScriptID 64017 0) set: 79) ; oFlags
						((ScriptID 64040 2) addTopic: 182) ; L7TalkWindow
						(if local0
							(gMessager sayRange: 5 182 8 1 3 self) ; "Purser's Desk. Now what?"
						else
							(gMessager sayRange: 5 182 0 1 3 self) ; "Purser's Desk. What do you want?"
						)
					)
					(122
						(= local9 1)
						((ScriptID 64040 2) addTopic: 122) ; L7TalkWindow
						(gMessager sayRange: 5 122 0 1 9 self) ; "Purser's Desk. Is this really important?"
					)
					(211
						(cond
							((== global216 0)
								(= local13 18)
							)
							((== global216 3)
								(= local13 15)
							)
							(else
								(= local13 (+ global216 15))
							)
						)
						(if (OneOf local13 16 19)
							(= local8 3)
						else
							(= local8 5)
						)
						(= local9 1)
						(gMessager sayRange: 5 211 local13 1 local8 self)
					)
					(else
						(foWallPhone doVerb: register)
					)
				)
			)
			(7
				(switch register
					(182
						(poPurser setScript: soPurserStopMotion)
						(= local4 1)
						(if local0
							(gMessager sayRange: 5 182 8 4 999 self) ; "(CLICK) Hello."
						else
							(= local0 1)
							(gMessager sayRange: 5 182 0 4 999 self) ; "(CLICK) Hello."
							(UnmarkTopic global256 182)
						)
					)
					(122
						(poPurser setScript: soPurserStopMotion)
						(gMessager say: 5 122 0 10 self) ; "(REGULAR VOICE) 2, 1. (BEAT) Zero."
					)
					(211
						(poPurser setScript: soPurserStopMotion)
						(gMessager say: 5 211 local13 (+ local8 1) self)
						(++ global216)
						(if (not ((ScriptID 64017 0) test: 287)) ; oFlags
							(switch global216
								(1
									((ScriptID 64017 0) set: 73) ; oFlags
								)
								(2
									((ScriptID 64017 0) set: 74) ; oFlags
								)
								(3
									((ScriptID 64017 0) set: 75) ; oFlags
								)
								(4
									((ScriptID 64017 0) set: 76) ; oFlags
								)
								(5
									((ScriptID 64017 0) set: 77) ; oFlags
								)
								(6
									((ScriptID 64017 0) set: 78) ; oFlags
								)
							)
						)
						(cond
							((> global216 5)
								((ScriptID 64017 0) set: 287) ; oFlags
								(= global216 0)
							)
							((not ((ScriptID 64017 0) test: 287)) ; oFlags
								(UnmarkTopic global256 211)
							)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				(poPurser setScript: soPurserStopMotion)
				(gEgo setCycle: Beg self 4 0)
			)
			(9
				(voWallPhone show:)
				(oSFX playSound: 34302)
				(= local9 0)
				(oSFX2 stop:)
			)
			(10
				(gEgo
					normalize: 6 1
					setScaler: Scaler 125 97 364 279
					posn: 436 364
					setSpeed: local12
				)
				(= local6 0)
				(= global330 0)
				(= global340 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPickUpPutDownPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 34201 34001 34302) ; WAVE
				(= local12 (gEgo cycleSpeed:))
				(gEgo
					view: 34103
					loop: 0
					cel: 0
					setScale: 0
					posn: 422 363
					setSpeed: 6
					setCycle: End self 4
				)
			)
			(1
				(oSFX playSound: 34201 self)
				(voWallPhone hide:)
			)
			(2
				(oSFX playSound: 34001 self)
			)
			(3
				(gEgo setCycle: Beg self 4 0)
			)
			(4
				(voWallPhone show:)
				(oSFX playSound: 34302)
			)
			(5
				(gGame handsOn:)
				(gEgo
					normalize: 6 1
					setScaler: Scaler 125 97 364 279
					posn: 436 364
					setSpeed: local12
				)
				(self dispose:)
			)
		)
	)
)

(instance soEyebrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 50 100))
			)
			(1
				(switch (client cel:)
					(0
						(client cel: (Random 1 2))
					)
					(1
						(if (Random 1 2)
							(client cel: 0)
						else
							(client cel: 2)
						)
					)
					(else
						(client cel: (Random 0 1))
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance soAnnounce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: CT 6 1 self)
			)
			(1
				(= local1 1)
				(oAnnounceSFX
					playSubtitledSound:
						(+ 5010 (- (= register (Random 1 5)) 1))
						2
						0
						0
						register
						self
				)
				(client loop: 1 setCycle: RandCycle -1)
			)
			(2
				(client setCycle: 0 loop: 0 cel: 8 setCycle: End self)
			)
			(3
				(client cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance soYellow2Blue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 30 300))
			)
			(2
				(client posn: 4 251 setMotion: MoveTo 460 225 self)
			)
			(3
				(= ticks (Random 300 600))
			)
			(4
				(self changeState: 1)
			)
		)
	)
)

(instance soAngel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 30 300))
			)
			(2
				(client posn: 4 251 setMotion: MoveTo 427 233 self)
			)
			(3
				(= ticks (Random 300 600))
			)
			(4
				(self changeState: 1)
			)
		)
	)
)

(instance so2Yellow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 30 300))
			)
			(2
				(client posn: 427 233 setMotion: MoveTo -8 256 self)
			)
			(3
				(= ticks (Random 300 600))
			)
			(4
				(self changeState: 1)
			)
		)
	)
)

(instance soSmallBlue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 30 300))
			)
			(2
				(client posn: 431 231 setMotion: MoveTo 8 255 self)
			)
			(3
				(= ticks (Random 300 600))
			)
			(4
				(self changeState: 1)
			)
		)
	)
)

(instance soGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 30 300))
			)
			(2
				(client posn: -4 256 setMotion: MoveTo 418 236 self)
			)
			(3
				(= ticks (Random 300 600))
			)
			(4
				(self changeState: 1)
			)
		)
	)
)

(instance soGetID of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 81) ; oFlags
				(gMessager sayRange: 1 21 0 1 4 self) ; "I'd like my passport, please."
			)
			(1
				(poPurser
					setCycle: 0
					view: 34101
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(poPurser hide:)
				(= ticks 90)
			)
			(3
				(poPurser show: loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(poPurser view: 34100 loop: 0 cel: 0)
				(gMessager sayRange: 1 21 0 5 99 self) ; "Here you are. Do not lose it! There are many nafarious types roaming this ship, all of them mooching ill-gotten booty such as this from our unsuspecting guileless guests."
			)
			(5
				(global255 delete: 122 121)
				(global256 delete: 122 121)
				(gEgo get: ((ScriptID 64037 0) get: 29)) ; oInvHandler, ioPassport
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poPurser of Prop
	(properties
		noun 1
		approachX 284
		approachY 290
		x 203
		y 126
		view 34100
	)

	(method (init)
		(if
			(and
				((ScriptID 64017 0) test: 160) ; oFlags
				(not ((ScriptID 64017 0) test: 81)) ; oFlags
			)
			(global255 add: 122)
		)
		(if ((ScriptID 64017 0) test: 278) ; oFlags
			(global255 add: 171)
		)
		(if ((ScriptID 64017 0) test: 177) ; oFlags
			(global255 add: 132)
		)
		(if ((ScriptID 64017 0) test: 157) ; oFlags
			(global255 add: 136)
		)
		(if ((ScriptID 64017 0) test: 50) ; oFlags
			(global255 add: 167)
		)
		(if ((ScriptID 64017 0) test: 81) ; oFlags
			(global255 delete: 122 121)
			(global256 delete: 122 121)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (cue)
		(switch local11
			(86
				((ScriptID 64017 0) clear: 180) ; oFlags
				((ScriptID 64017 0) clear: 181) ; oFlags
				(gCurRoom newRoom: 340) ; ro340
			)
			(122
				((ScriptID 64040 2) addTopic: 121) ; L7TalkWindow
				(global256 add: 122 121)
			)
			(else
				(self doVerb: local7)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(= local11 0)
		(= local7 theVerb)
		(= temp0 (GetAngle (gEgo x:) (gEgo y:) (self x:) (self y:)))
		(if (> (Abs (- temp0 (gEgo heading:))) 45)
			(gEgo setHeading: temp0 self)
			(return)
		)
		(if
			(OneOf
				theVerb
				182 ; Annette Boning
				171 ; Cabin boy
				147 ; Kumquats
				84 ; LoveMaster 2000
				151 ; Where's my cabin?
				210 ; Old man
				132 ; Peggy
				121 ; Photo ID
				153 ; Bolts of polyester
				136 ; Complain about room
				185 ; Telephone
				15 ; Captain Thygh
				167 ; Xqwzts
			)
			(gMessager say: noun theVerb)
			((ScriptID 64040 2) addTopic: theVerb) ; L7TalkWindow
			(return)
		)
		(switch theVerb
			(86 ; Goodbye
				(= local11 86)
				(gMessager say: noun theVerb 0 0 self) ; "Okay. See you around."
			)
			(17 ; Your Cabin Keycard
				(if
					(or
						((ScriptID 64017 0) test: 160) ; oFlags
						((ScriptID 64017 0) test: 72) ; oFlags
					)
					(gMessager say: noun theVerb 21) ; "Could I use this as an ID?"
					((ScriptID 64040 2) addTopic: theVerb) ; L7TalkWindow
				else
					(super doVerb: theVerb)
				)
			)
			(184 ; My account
				(poPurser setScript: soPurserLeaves)
			)
			(122 ; Passport
				(= local11 122)
				((ScriptID 64017 0) set: 72) ; oFlags
				((ScriptID 64040 2) addTopic: 122) ; L7TalkWindow
				(gMessager say: noun theVerb 0 0 self) ; "I'd like my passport, please. I'm Larry; Larry Laffer."
			)
			(21 ; Photo ID
				(if ((ScriptID 64017 0) test: 81) ; oFlags
					(gMessager say: 1 161) ; "Are you trying to trick me? Did you think I'd fall for THAT?! Hah! I'm on to you!"
				else
					(gCurRoom setScript: soGetID)
				)
			)
			(16 ; TMT Scorecard
				(gMessager say: 1 16) ; "May I hurt you?"
				((ScriptID 64040 2) addTopic: theVerb) ; L7TalkWindow
			)
			(4 ; Talk
				(if (and (== local2 2) (L7TalkWindow oPlane:))
					((ScriptID 64040 2) dispose:) ; L7TalkWindow
				)
				(if (not (L7TalkWindow oPlane:))
					(= local2 1)
					(voWallPhone addHotspotVerb: 249)
					(foWallPhone addHotspotVerb: 249)
					(self deleteHotspotVerb: 4)
					(L7TalkWindow init: poPurser global255)
					(= global340 toPurser)
				)
			)
			(else
				(if (proc64040_1 theVerb)
					(Random (GetTime))
					(gMessager say: noun 70 (Random 22 26))
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance voDeskPhone of View
	(properties
		noun 3
		approachX 284
		approachY 290
		x 245
		y 189
		view 34105
	)

	(method (init)
		(super init: &rest)
		(self setPri: 270)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 64017 0) test: 183) ; oFlags
					(gCurRoom addRoomPlane: oPhoneCUPlane)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voWallPhone of View
	(properties
		noun 5
		approachX 436
		approachY 364
		x 468
		y 310
		z 50
		view 34150
	)

	(method (init)
		(super init: &rest)
		(self setPri: 330)
		(AddDefaultVerbs self)
		(self addApproachVerb: 249)
	)

	(method (doVerb theVerb)
		(foWallPhone doVerb: theVerb)
	)
)

(instance poAnnouncer of Prop
	(properties
		x 373
		y 197
		view 34104
	)
)

(instance aoYellow2Blue of Actor
	(properties
		x 2
		y 252
		priority 260
		fixPriority 1
		view 34105
		loop 1
		cycleSpeed 5
		moveSpeed 5
	)

	(method (init)
		(self setCycle: Walk setLoop: 1 1)
		(super init:)
		(self setScript: soYellow2Blue)
	)
)

(instance aoAngel of Actor
	(properties
		x 4
		y 251
		priority 260
		fixPriority 1
		view 34106
	)

	(method (init)
		(self setCycle: Walk setLoop: 0 1)
		(super init:)
		(self setScript: soAngel)
	)
)

(instance ao2Yellow of Actor
	(properties
		x 427
		y 233
		priority 260
		fixPriority 1
		view 34107
		cycleSpeed 8
		moveSpeed 8
	)

	(method (init)
		(self setCycle: Walk setLoop: 0 1)
		(super init:)
		(self setScript: so2Yellow)
	)
)

(instance aoSmallBlue of Actor
	(properties
		x 431
		y 231
		priority 260
		fixPriority 1
		view 34108
		cycleSpeed 3
		moveSpeed 3
	)

	(method (init)
		(self setCycle: Walk setLoop: 0 1)
		(super init:)
		(self setScript: soSmallBlue)
	)
)

(instance aoGreen of Actor
	(properties
		x -4
		y 256
		priority 260
		fixPriority 1
		view 34109
		cycleSpeed 8
	)

	(method (init)
		(self setCycle: Walk setLoop: 0 1)
		(super init:)
		(self setScript: soGreen)
	)
)

(instance foExitWest of ExitFeature
	(properties
		nsRight 39
		nsBottom 479
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		((ScriptID 64017 0) set: 180) ; oFlags
		((ScriptID 64017 0) clear: 181) ; oFlags
		(gCurRoom exitRoom: 340 5 312)
	)
)

(instance foExitEast of ExitFeature
	(properties
		nsLeft 599
		nsRight 639
		nsBottom 293
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		((ScriptID 64017 0) set: 181) ; oFlags
		((ScriptID 64017 0) clear: 180) ; oFlags
		(gCurRoom exitRoom: 340 670 259)
	)
)

(instance foWallPhone of Feature
	(properties
		noun 5
		approachX 436
		approachY 364
		x 472
		y 310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 449 209 488 205 496 263 481 317 466 318 449 262
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addApproachVerb: 249)
	)

	(method (doVerb theVerb)
		(if (and (not local6) (OneOf theVerb 182 122 121 211)) ; Annette Boning, Passport, Photo ID, Prank
			(gGame handsOff:)
			(gCurRoom setScript: soYouMakeTheCall 0 theVerb)
			(return)
		)
		(switch theVerb
			(182 ; Annette Boning
				(= local4 1)
				((ScriptID 64040 2) addTopic: 182) ; L7TalkWindow
				(if local0
					(gMessager say: 5 182 8 0 soYouMakeTheCall) ; "Purser's Desk. Now what?"
				else
					(= local0 1)
					(gMessager say: 5 182 0 0 soYouMakeTheCall) ; "Purser's Desk. What do you want?"
					(UnmarkTopic global256 182)
				)
			)
			(249 ; Call
				(if (and (== local2 1) ((ScriptID 64040 2) oPlane:)) ; L7TalkWindow
					((ScriptID 64040 2) dispose:) ; L7TalkWindow
				)
				(if (not ((ScriptID 64040 2) oPlane:)) ; L7TalkWindow
					(if
						(or
							((ScriptID 64017 0) test: 183) ; oFlags
							(== (poPurser script:) soPurserReturns)
						)
						(gEgo setScript: soPickUpPutDownPhone)
					else
						(= local2 2)
						(poPurser addHotspotVerb: 4)
						(voWallPhone deleteHotspotVerb: 249)
						(foWallPhone deleteHotspotVerb: 249)
						((ScriptID 64040 2) init: foWallPhone global256) ; L7TalkWindow
					)
				)
			)
			(122 ; Passport
				((ScriptID 64040 2) addTopic: 122) ; L7TalkWindow
				(gMessager say: 5 122 0 0 soYouMakeTheCall) ; "Purser's Desk. Is this really important?"
			)
			(121 ; Photo ID
				(gMessager say: 5 121 0 0 soYouMakeTheCall) ; "Purser's Desk. Now what?"
			)
			(211 ; Prank
				(gMessager say: 5 211 (+ global216 15) 0 soYouMakeTheCall)
				(if (> (++ global216) 5)
					(= global216 0)
				)
				(UnmarkTopic global256 211)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foAquarium of Feature
	(properties
		noun 7
		approachDist 1000
		x 234
		y 241
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 212 422 199 433 248 35 283
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 theVerb 0 0 0 340) ; "The Purser's Desk has a beautiful aquarium built into it; but what's that scuba diver doing in there?!"
			)
			(71 ; Smell
				(gMessager say: 5 theVerb 0 0 0 340) ; "How you love the aroma of old fish tanks."
				(proc64896_15 7 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toPurser of Talker
	(properties)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(super init: poPurserMouth voPurserBust)
		(poPurser hide:)
	)

	(method (dispose)
		(poPurser show:)
		(super dispose:)
	)
)

(instance poPurserMouth of Prop
	(properties
		view 34102
		loop 1
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self setPri: (+ (poPurser priority:) 1))
		(super init: &rest)
	)
)

(instance voPurserBust of View
	(properties
		view 34102
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self setPri: (poPurser priority:))
		(super init: &rest)
		(poPurserEyebrows init:)
	)

	(method (dispose)
		(poPurserEyebrows dispose:)
		(super dispose: &rest)
	)
)

(instance poPurserEyebrows of Prop
	(properties
		view 34102
		loop 2
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self cel: (Random 0 2) setPri: (+ (poPurser priority:) 2))
		(super init: &rest)
		(self setScript: soEyebrows)
	)

	(method (dispose)
		(self setScript: 0)
		(super dispose: &rest)
	)
)

(instance toPurserPhone of Talker
	(properties)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(poPurserPhoneMouth dispose:)
		(super init: poPurserPhoneMouth)
	)

	(method (dispose)
		(super dispose:)
		(poPurserPhoneMouth init:)
	)
)

(instance poPurserPhoneMouth of Prop
	(properties
		view 34100
		loop 1
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self setPri: (+ (poPurser priority:) 1))
		(super init: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(super init: poLarryMouth poLarryBody)
		(gEgo hide:)
	)

	(method (dispose)
		(gEgo show:)
		(super dispose:)
	)
)

(instance poLarryMouth of Prop
	(properties
		view 34103
		loop 2
	)

	(method (init)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(self setPri: (+ (gEgo priority:) 2))
		(super init: &rest)
	)
)

(instance poLarryBody of Prop
	(properties
		view 34103
		loop 1
	)

	(method (init)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(self setPri: (+ (gEgo priority:) 1))
		(super init: &rest)
	)
)

(instance toAnnouncer of Talker ; UNUSED
	(properties)

	(method (init)
		(super init: poAnnouncerMouth)
		(poAnnouncer hide:)
	)

	(method (dispose)
		(poAnnouncer show:)
		(super dispose:)
	)
)

(instance poAnnouncerMouth of Prop
	(properties
		view 34104
		loop 1
	)

	(method (init)
		(= x (poAnnouncer x:))
		(= y (poAnnouncer y:))
		(self setPri: (poAnnouncer priority:))
		(super init: &rest)
	)
)

(instance oPhoneCUPlane of Plane
	(properties
		picture 34200
	)

	(method (init)
		(= local3 1)
		(if (poPurser script:)
			((poPurser script:) dispose:)
		)
		(gThePlane drawPic: -1)
		(if (L7TalkWindow oPlane:)
			(L7TalkWindow dispose:)
		)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(if local10
			(voRedialNumber init:)
		)
		(foPhoneCU init:)
		(foRedial init:)
		(foExit init:)
	)

	(method (dispose)
		(= local3 0)
		(gThePlane drawPic: 34100)
		(poPurser setScript: soPurserReturns 0 0)
		(super dispose: &rest)
	)
)

(instance foExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oPhoneCUPlane)
	)
)

(instance foPhoneCU of Feature
	(properties
		noun 4
		x 311
		y 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 34 149 217 97 221 84 267 69 318 62 360 68 419 88 480 121 548 168 560 179 565 192 555 215 585 230 595 253 585 283 279 448 267 439 245 451 210 417 133 296 44 204 28 156
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 186)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(187 ; Redial
				(cond
					(((ScriptID 64017 0) test: 80) ; oFlags
						(gMessager say: 4 187 5) ; "You already did that. They're in room 1009!"
					)
					(local4
						((ScriptID 64017 0) set: 80) ; oFlags
						(gCurRoom setScript: soDialPhone 0 1)
					)
					(else
						(gCurRoom setScript: soDialPhone 0 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRedial of Feature
	(properties
		noun 6
		x 104
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 292 213 296 202 323 191 340 203 338 216 310 230
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 160)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(160 ; Push
				(foPhoneCU doVerb: 187)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soDialPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 34203 34204) ; WAVE
				(oSFX playSound: 34203 self)
			)
			(1
				(oSFX playSound: 34204 self)
			)
			(2
				(if register
					(if (not local10)
						(voRedialNumber init:)
					)
					(voRedialNumber loop: 1 doit:)
					(gMessager say: 4 187 4 0 self) ; "Good idea."
				else
					(if (not local10)
						(voRedialNumber init:)
					)
					(voRedialNumber loop: 0 doit:)
					(gMessager say: 4 187 6 0 self) ; "Good idea. That will tell you the last number the Purser dialed."
				)
				(= local10 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voRedialNumber of View
	(properties
		priority 500
		fixPriority 1
		view 34200
	)
)

(instance oSpecialAnnounceTimer of Timer
	(properties)

	(method (cue)
		(cond
			(
				(or
					((ScriptID 64017 0) test: 158) ; oFlags
					(gCurRoom script:)
					(and gTalkers (not (gTalkers isEmpty:)))
					(not (gUser canControl:))
					(gCurRoom script:)
					(gEgo script:)
				)
				(self setReal: self 3)
			)
			(local1
				(= local1 0)
				(self setReal: self (Random 30 60))
			)
			(else
				(poAnnouncer setScript: soAnnounce self)
			)
		)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFX2 of TPSound
	(properties)
)

(instance oAnnounceSFX of TPSound
	(properties)
)

