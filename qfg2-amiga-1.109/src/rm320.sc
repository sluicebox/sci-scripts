;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Stage)
(use TargActor)
(use Interface)
(use Feature)
(use LoadMany)
(use Follow)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	[unused 4]
)

(instance rm320 of Stage
	(properties
		picture 300
		north 160
		east 704
		south 330
		west 704
		topFromX 158
		topFromY 95
		topExit 4
		topToX 158
		topToY 118
		bottomExit 2
		rightFromX 330
		rightFromY 170
		rightExit 1
		rightToX 260
		rightToY 170
		leftFromX -10
		leftFromY 170
		leftExit 3
		leftToX 35
		leftToY 170
	)

	(method (init)
		(LoadMany rsVIEW 11 300 294 168 301 320 297)
		(Load rsSCRIPT 971)
		(++ gEnter320)
		(if (!= gLastTimeIn gDay)
			(= gEnter320 1)
			(= gLastTimeIn gDay)
		)
		(if (IsFlag 28) ; fTeleporting
			(= inOut 3)
		)
		(if (<= 0 gTimeODay 4)
			(= gSpellChecker gNoChecker)
		else
			(= gSpellChecker gAllChecker)
		)
		(if (== gPrevRoomNum south)
			(= bottomToX (= bottomFromX (- 319 (gEgo x:))))
		)
		(if (and (== gPrevRoomNum 160) (IsFlag 157)) ; fUhuraMad
			(= inOut 3)
		)
		(if (not (IsFlag 28)) ; fTeleporting
			(gEgo init:)
		)
		(super init:)
		(self overlay: gCurRoomNum)
		(InitFeatures leftAlleyDoor rightAlleyDoor)
		(InitAddToPics guildSign mosaic windowL windowR)
		(if (not gNight)
			(if (== gDay 3)
				((ScriptID 322 1) init:) ; baby
			)
		else
			(doorL palette: 2)
			(doorR palette: 2)
		)
		(cond
			(
				(and
					(== gPrevRoomNum 160)
					(== gDay 10)
					(not gNight)
					(gEgo has: 50) ; Saurus
					(not (IsFlag 151)) ; fReturnedSaurus320
				)
				(self entranceScript: saurusAndGuard west: 290)
				(saurus init:)
				(InitAddToPics theGuard)
				(guardMouth init:)
			)
			(
				(and
					[gEgoStats 11] ; climb
					(< gTightWinCount 3)
					(not gNight)
					(OneOf gDay 2 4 8 11 16)
				)
				((ScriptID 321 0) init:) ; challenger
			)
			((and (not gNight) (OneOf gDay 1 3 13))
				((ScriptID 322 0) init:) ; rakeesh
				(InitAddToPics carpet)
			)
		)
		(cond
			((and (== gPrevRoomNum 160) (IsFlag 157)) ; fUhuraMad
				(doorL cel: 3 init:)
				(doorR cel: 3 init:)
				(gEgo setScript: thrownOut)
			)
			((== gPrevRoomNum 160)
				(doorL cel: 3 init: setScript: closeDoors)
				(doorR cel: 3 init:)
			)
			(else
				(doorL cel: 0 init: stopUpd:)
				(doorR cel: 0 init: stopUpd:)
			)
		)
		(if (IsFlag 28) ; fTeleporting
			(NormalEgo)
			(gEgo posn: 160 165 init:)
			(ClearFlag 28) ; fTeleporting
		)
	)

	(method (dispose)
		(if (not (IsFlag 160)) ; fFirstTime320
			(SetFlag 160) ; fFirstTime320
		)
		(ClearFlag 15) ; fTightrope
		(super dispose:)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((and (== inOut 3) (& (gEgo onControl: 1) $0010) (not gNight))
				(gEgo setScript: toGuildHall)
			)
		)
		(super doit:)
	)

	(method (cue)
		(super cue:)
		(if (gAddToPics contains: carpet)
			(gEgo illegalBits: (| (gEgo illegalBits:) $1000))
		)
		(if
			(and
				(not gNight)
				(== gDay 3)
				(not (& (gEgo illegalBits:) $0800))
			)
			(gEgo illegalBits: (| (gEgo illegalBits:) $0800))
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(or
				(Said 'search,look,look[<at,around][/room,area][/!*]')
				(Said 'look,look/courtyard')
			)
			(HighPrint 320 0) ; "At the west end of the Plaza of the Fighters is the entrance to the local Guild Hall."
		)
	)
)

(instance carpet of PicView
	(properties
		x 217
		y 115
		noun '/carpet,carpet'
		description {the carpet beneath Rakeesh}
		lookStr {The carpet beneath Rakeesh looks well-worn and comfortable.}
		view 168
		loop 9
		priority 0
		signal 16400
	)
)

(instance guildSign of PicView
	(properties
		x 159
		y 37
		noun '/sign[<hall,club,adventurer]'
		description {the Sign of the Adventurer's Guild}
		lookStr {The sign would indicate that the door beneath it is the entrance to the Adventurer's Guild.}
		view 301
		loop 2
		priority 6
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance mosaic of PicView
	(properties
		x 159
		y 189
		noun '/mosaic,tile'
		description {the tile mosaic}
		lookStr {The mosaic tile work is exceptionally well-crafted.}
		view 301
		loop 8
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance windowL of PicView
	(properties
		x 69
		y 51
		noun '/window'
		description {the window}
		lookStr {The window has an outstanding view of the Plaza.}
		view 300
		loop 1
		priority 3
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance windowR of PicView
	(properties
		x 252
		y 51
		noun '/window'
		description {the window}
		lookStr {What a view of the Plaza this window has!}
		view 300
		loop 2
		cel 1
		priority 3
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance doorL of TargActor
	(properties
		x 145
		y 90
		noun '/door[<wooden,hall,club,adventurer]'
		description {the wooden door}
		lookStr {According to the sign above it, this is the entrance to the Adventurer's Guild.}
		view 320
		loop 5
		priority 6
		signal 16
	)

	(method (hurtMe)
		(HighPrint 320 1) ; "That was a waste."
		(return 1)
	)

	(method (openMe)
		(HighPrint 320 2) ; "The door is barred from the inside."
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((> (gEgo distanceTo: self) 35)
						(Print 320 3) ; "Move to the door first."
					)
					(gNight
						(Print 320 4) ; "The doors are locked; a sign on the door says "Back at 8 a.m.""
					)
					(else
						(gEgo setScript: toGuildHall)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorR of TargActor
	(properties
		x 173
		y 90
		description {the wooden door}
		lookStr {According to the sign above it, this is the entrance to the Adventurer's Guild.}
		view 320
		loop 4
		priority 6
		signal 16
	)

	(method (hurtMe)
		(HighPrint 320 1) ; "That was a waste."
		(return 1)
	)

	(method (openMe)
		(HighPrint 320 2) ; "The door is barred from the inside."
		(return 1)
	)
)

(instance saurus of Actor
	(properties
		x 250
		y 144
		noun '/saurii'
		description {your saurus}
		yStep 3
		view 11
		loop 1
		xStep 5
	)
)

(instance theGuard of PicView
	(properties
		x 122
		y 100
		view 294
		loop 2
		cel 5
		priority 7
		signal 16
	)
)

(instance guardMouth of Talker
	(properties
		x 123
		y 60
		view 294
		loop 4
		priority 8
		signal 16400
		cycleSpeed 1
		illegalBits 0
		tLoop 4
		said '[/guard,guard]>'
		title {Guard:}
		back 11
	)

	(method (init)
		(super init:)
		(= tWindow BotWindow)
	)
)

(instance leftAlleyDoor of Feature
	(properties
		x 5
		y 124
		noun '/door,sign[<alley,bearing,street]'
		nsTop 92
		nsBottom 156
		nsRight 13
		description {the alley door}
		lookStr {You see a dark passage leading South.  The street sign reads "Khanjar Tarik," which means "Dagger Street."}
	)
)

(instance rightAlleyDoor of Feature
	(properties
		x 312
		y 124
		noun '/door,sign[<alley,bearing,street]'
		nsTop 89
		nsLeft 305
		nsBottom 159
		nsRight 320
		description {the alley door}
		lookStr {You see a dark passage leading North.  The street sign reads "Saif Darb," which means "Sword Avenue."}
	)
)

(instance saurusAndGuard of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90)
				(saurus setCycle: Walk setMotion: MoveTo 200 118 self)
				(gSpareSound number: 291 loop: 1 play:)
				(Print 320 5 #at -1 120 #time 3 #dispose) ; "Gronk!!"
			)
			(1
				(gEgo hide:)
				(saurus
					view: 297
					loop: 1
					cel: 0
					posn: (+ (gEgo x:) 34) (- (gEgo y:) 1)
					cycleSpeed: 1
					setCycle: CT 5 1 self
				)
			)
			(2
				(gSpareSound number: 292 loop: 1 play: self)
				(saurus setCycle: End)
			)
			(3
				(Say guardMouth self 320 6) ; "The beast has been running through the city searching for you! There was no stopping him. You must take this thing back to the stables where it belongs."
			)
			(4
				(saurus view: 11 setLoop: 1 cel: 0 cycleSpeed: 0 posn: 200 118)
				(gEgo show: setMotion: MoveTo -5 170 self)
				(= cycles 10)
			)
			(5
				(saurus
					illegalBits: 0
					setCycle: Walk
					setMotion: Follow gEgo 20
				)
			)
			(6
				(SetFlag 149) ; fReturningSaurus
				(SetFlag 151) ; fReturnedSaurus320
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance closeDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(doorL setCycle: Beg self)
				(doorR setCycle: Beg)
			)
			(2
				(doorL stopUpd:)
				(doorR stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance thrownOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 49
					setLoop: 0
					setCel: 0
					posn: 158 95
					setCycle: End self
				)
			)
			(1
				(doorL setCycle: Beg)
				(doorR setCycle: Beg)
				(= cycles 8)
			)
			(2
				(doorL stopUpd:)
				(doorR stopUpd:)
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(gEgo posn: (+ (gEgo x:) 32) (+ (gEgo y:) 19))
				(NormalEgo)
				(= cycles 1)
			)
			(4
				(HighPrint 320 7) ; "You get the feeling Uhura was really serious when she asked you to return Rakeesh's flaming sword."
				(self dispose:)
			)
		)
	)
)

(instance toGuildHall of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorL setCycle: End self)
				(doorR setCycle: End)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 160 93 self)
			)
			(2
				(= gRoomExitDir (gCurRoom topExit:))
				(gCurRoom newRoom: 160)
				(self dispose:)
			)
		)
	)
)

