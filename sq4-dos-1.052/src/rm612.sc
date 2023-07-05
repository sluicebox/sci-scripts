;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 612)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use eRS)
(use Polygon)
(use Motion)
(use System)

(public
	rm612 0
)

(instance rm612 of SQRoom
	(properties
		picture 612
		east 613
		south 609
	)

	(method (init)
		(ulence roomVer: 22891)
		(switch gPrevRoomNum
			(609
				(gEgo x: (- (gEgo x:) 30))
				(if (< (gEgo x:) 95)
					(gEgo x: 95)
				)
			)
			(613
				(if (< (gEgo y:) 144)
					(gEgo y: 132)
				)
			)
			(else
				(gEgo x: 280 y: 164)
			)
		)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(super init:)
		(Load rsVIEW 636)
		(self
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 59 189 59 182 186 120 194 118 319 118 319 0 0 0
					yourself:
				)
		)
		(if (== (ulence status:) 1)
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 632)
			(Load rsVIEW 635)
			(Load rsVIEW 634)
			(Load rsSOUND 50)
		else
			(ulence bikerComing: 0)
		)
		((ScriptID 706 7) init: nsLeft: 0 nsTop: 87 nsBottom: 189 nsRight: 319) ; theSand
		((ScriptID 706 8) init: nsLeft: 0 nsTop: 0 nsBottom: 87 nsRight: 319) ; theDunes
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 1) distanceTo: gEgo) 15) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(ulence deathLoop: 0)
			(gEgo setScript: 0)
			(gCurRoom setScript: (ScriptID 706 3)) ; theDeathScript
		)
		(cond
			(script 0)
			(
				(and
					(> (Random 0 100) 95)
					(== (ulence status:) 2)
					(gEgo inRect: 90 160 152 182)
				)
				(HandsOff)
				(ulence status: 3 fieldOff: 1)
				((ScriptID 706 1) ; theBiker
					init:
					hide:
					posn: 320 116
					setLoop: 5
					setScript: runOver
				)
				(gEgo setScript: (ScriptID 706 4)) ; theDodgeR
			)
			(
				(and
					(> (Random 0 100) 95)
					(== (ulence status:) 2)
					(gEgo inRect: 261 172 284 182)
				)
				(HandsOff)
				(ulence status: 3 fieldOff: 1)
				((ScriptID 706 1) ; theBiker
					view: 634
					init:
					hide:
					setLoop: 6
					posn: 39 226
					setScript: runOver2
				)
				(gEgo setScript: (ScriptID 706 5)) ; theDodgeL
			)
		)
		(super doit: &rest)
	)
)

(instance runOver of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) ; theBiker
					show:
					setMotion: MoveTo 218 (- (gEgo y:) 5) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 1) ; theBiker
					setLoop: 1
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 104 (- (gEgo y:) 5) self
				)
			)
			(3
				((ScriptID 706 1) setLoop: 5 setMotion: MoveTo 90 160 self) ; theBiker
			)
			(4
				((ScriptID 706 1) ; theBiker
					posn: 81 168
					setLoop: 2
					setMotion: MoveTo 81 197 self
				)
			)
			(5
				(gLongSong fade:)
				((ScriptID 706 6) fade:) ; theBikeSound
				((ScriptID 706 1) hide:) ; theBiker
				(= seconds 3)
			)
			(6
				(if (!= (ulence status:) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(HandsOn)
					(Print 612 0) ; "Boy, that was close!"
				)
				(self dispose:)
			)
		)
	)
)

(instance runOver2 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 20 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) show: setMotion: MoveTo 122 171 self) ; theBiker
			)
			(2
				((ScriptID 706 1) setLoop: 0 setMotion: MoveTo 176 171 self) ; theBiker
			)
			(3
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 1) ; theBiker
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 341 (- (gEgo y:) 5) self
				)
			)
			(4
				(gLongSong fade:)
				((ScriptID 706 6) fade:) ; theBikeSound
				((ScriptID 706 1) hide:) ; theBiker
				(= seconds 3)
			)
			(5
				(if (!= (ulence status:) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(HandsOn)
					(Print 612 0) ; "Boy, that was close!"
				)
				(self dispose:)
			)
		)
	)
)

