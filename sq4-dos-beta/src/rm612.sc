;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 612)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
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
		(ulence roomVer: 11591)
		(switch gPrevRoomNum
			(609
				(gEgo x: (- (gEgo x:) 30))
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
		(if (and (> (Random 0 100) 33) (== (ulence status:) 1))
			(ulence status: 2)
			(Load rsVIEW 632)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		)
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 2) distanceTo: gEgo) 15) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 0)
			(self setScript: (ScriptID 706 4)) ; theDeathScript
		)
		(cond
			(script 0)
			((and (== (ulence status:) 2) (gEgo inRect: 90 160 152 182))
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 2) ; theBiker
					init:
					hide:
					posn: 320 116
					setLoop: 5
					setScript: bikerScript
				)
				(gEgo setScript: (ScriptID 706 5)) ; theDodgeR
			)
			((and (== (ulence status:) 2) (gEgo inRect: 178 123 214 139))
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 2) ; theBiker
					init:
					hide:
					posn: 62 223
					setLoop: 6
					setScript: bikerScript1
				)
				(gEgo setScript: (ScriptID 706 6)) ; theDodgeL
			)
		)
		(super doit: &rest)
	)
)

(instance bikerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong vol: 5 number: 50 loop: -1 fade: 127 10 10 0)
				(= seconds 3)
			)
			(1
				((ScriptID 706 2) ; theBiker
					show:
					setMotion: MoveTo 218 (- (gEgo y:) 5) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 2) ; theBiker
					setLoop: 1
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 104 (- (gEgo y:) 5) self
				)
			)
			(3
				((ScriptID 706 2) setLoop: 5 setMotion: MoveTo 90 160 self) ; theBiker
			)
			(4
				((ScriptID 706 2) ; theBiker
					posn: 81 168
					setLoop: 2
					setMotion: MoveTo 81 197 self
				)
			)
			(5
				(gLongSong fade:)
				((ScriptID 706 2) hide:) ; theBiker
				(= seconds 3)
			)
			(6
				(if (== (ulence status:) 5)
					(ulence status: 1)
					(proc706_1)
					(HandsOn)
					(gEgo setScript: 0)
				else
					(EgoDead 612 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance bikerScript1 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong
					vol: 5
					number: 50
					loop: -1
					playBed:
					fade: 127 20 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 2) show: setMotion: MoveTo 186 122 self) ; theBiker
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 2) ; theBiker
					setLoop: 0
					posn: 201 122
					setPri: (+ (gEgo priority:) 1)
				)
				(= cycles 2)
			)
			(3
				((ScriptID 706 2) setMotion: MoveTo 363 122 self) ; theBiker
			)
			(4
				(gLongSong fade:)
				((ScriptID 706 2) hide:) ; theBiker
				(= seconds 3)
			)
			(5
				(if (== (ulence status:) 5)
					(ulence status: 1)
					(proc706_1)
					(HandsOn)
					(gEgo setScript: 0)
				else
					(EgoDead 612 0)
				)
				(self dispose:)
			)
		)
	)
)

