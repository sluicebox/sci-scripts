;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Interface)
(use Elevator)
(use Osc)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	arcadaRegion 0
	proc700_1 1
	detonationBox 2
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(if (arcadaRegion theTimeID:)
		(Display 700 3 dsRESTOREPIXELS (arcadaRegion theTimeID:))
		(arcadaRegion theTimeID: 0)
	)
	(detonationBox
		x: (if (or (> 320 (gEgo x:) 160) (< (gEgo x:) 0)) 30 else 264)
	)
	(detonationBox y: (if (== global166 1) 190 else 44) forceUpd: stopUpd:)
)

(procedure (proc700_1 param1 param2)
	(if (& (arcadaRegion param1:) param2)
		(return 1)
	else
		(return 0)
	)
)

(class Sarien of Actor
	(properties
		description {sarien}
		lookStr {These guys look scary. But then, don't most other beings packing weapons?}
		cycleSpeed 4
		moveSpeed 4
		firePosn 0
		SLastCel 0
		stepState 1
		stepVol 60
	)

	(method (init)
		(super init: &rest)
		(self setCycle: StopWalk 480 illegalBits: 0 setLoop: Grooper x: 337)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 700 0) ; "These guys carry weapons. How wise do you think that is?"
			)
			(12 ; Smell
				(Print 700 1) ; "You'd need to be closer for that."
			)
			(11 ; Taste
				(Print 700 1) ; "You'd need to be closer for that."
			)
			(2 ; Look
				(if (== global166 global173)
					(super doVerb: theVerb &rest)
				else
					(Print 700 2) ; "You are on the wrong level to do that."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(== view 410)
				(!= SLastCel cel)
				(or
					(and (== loop 0) (or (== cel 2) (== cel 6)))
					(and (== loop 1) (or (== cel 2) (== cel 6)))
					(and (== loop 2) (or (== cel 2) (== cel 5)))
					(and (== loop 4) (or (== cel 1) (== cel 5)))
					(and (== loop 5) (or (== cel 1) (== cel 5)))
					(and (== loop 6) (or (== cel 3) (== cel 6)))
					(and (== loop 7) (or (== cel 3) (== cel 6)))
				)
			)
			(if (<= x 0)
				(= temp0 0)
			else
				(if (> (= temp0 (/ x 2)) 127)
					(= temp0 127)
				)
				(if (< temp0 0)
					(= temp0 0)
				)
			)
			(sarienSteps number: 313 loop: 1)
			(if
				(and
					(or (> x 320) (< x 0))
					(or (== stepState 1) (== stepState 2))
				)
				(cond
					((== stepState 1)
						(if (> (+= stepVol 10) 127)
							(= stepVol 127)
						)
					)
					((< (-= stepVol 10) 0)
						(= stepVol 0)
					)
				)
			else
				(= stepVol 127)
			)
			(sarienSteps play: stepVol send: 2 10 temp0)
		)
		(if
			(or
				(and
					(== view 411)
					(or
						(and (<= loop 3) (== cel 5))
						(and (> loop 3) (== cel 6))
					)
				)
				(and
					(== view 412)
					(or
						(and (<= loop 1) (== cel 4))
						(and (> loop 1) (== cel 5))
					)
				)
				(and (== view 413) (== cel 5))
			)
			(gSoundEffects number: 312 loop: 1 play:)
		)
		(= SLastCel cel)
	)
)

(class arcadaRegion of Rgn
	(properties
		rFlag1 0
		rFlag2 0
		timeTilSariens -1
		sarienState 0
		safeCode 0
		checkFootCode 0
		checkEntryCode 0
		sarienEntryDir 0
		s1startX 337
		s1startY 0
		s2startX 337
		s2startY 0
		s1gotoX 0
		s1gotoY 0
		s2gotoX 0
		s2gotoY 0
		inGame 0
		explosionTimer 400
		cartNumber 0
		theTime 0
		lastTime 0
		theTimeID 0
		saveBits 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 3 4 5 6 7 8 9 10 11 12 13 103))
		(= safeCode (= sarienState (= global173 (= initialized 0))))
		(= timeTilSariens -1)
		(if script
			(script dispose:)
		)
		(self
			sarienEntryDir: 0
			s1startX: 337
			s2startX: 337
			s1startY: 0
			s2startY: 0
			s1gotoX: 0
			s1gotoY: 0
			s2gotoX: 0
			s2gotoY: 0
			checkFootCode: 0
			checkEntryCode: 0
		)
		(if
			(and
				(!= (gLongSong number:) 355)
				(or (OneOf newRoomNumber 7 11 13) (== newRoomNumber 7))
			)
			(gLongSong loop: 0 fade: number: 0)
		)
		(if theTimeID
			(Display 700 3 dsRESTOREPIXELS theTimeID)
			(Animate (gCast elements:) 0)
			(= theTimeID 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init &tmp temp0)
		(Load rsSOUND 308 364 365)
		(super init: &rest)
		(if (and inGame (!= gCurRoomNum 103))
			(detonationBox init:)
			(cond
				((> global172 600)
					(Load rsSOUND 997)
				)
				((> global172 300)
					(Load rsSOUND 996)
				)
				((> global172 240)
					(Load rsSOUND 995)
				)
				((> global172 180)
					(Load rsSOUND 994)
				)
				((> global172 120)
					(Load rsSOUND 993)
				)
				((> global172 60)
					(Load rsSOUND 992)
				)
				((> global172 30)
					(LoadMany rsSOUND 991 990 989)
				)
				((> global172 10)
					(LoadMany rsSOUND 984 985 986 987 988)
				)
			)
		)
		(if
			(and
				inGame
				(!= (gLongSong number:) 355)
				(or
					(and
						(OneOf gCurRoomNum 8 9 10 12)
						(!= (gLongSong number:) 360)
						(= temp0 360)
					)
					(and
						(OneOf gCurRoomNum 3 4 5 6 103)
						(!= (gLongSong number:) 300)
						(= temp0 300)
					)
				)
			)
			(gLongSong
				number: temp0
				loop: -1
				hold: 0
				play: 30
				fade: 127 25 10 0
			)
			(if (== temp0 360)
				(gLongSong hold: 1)
			)
		)
		(if (OneOf gCurRoomNum 4 5 6 8 10 11)
			(Load rsSOUND 315)
			(UpperElevFeat init:)
			(LowElevFeat init:)
		)
		(if
			(and
				(> global172 60)
				(not (IsFlag 16))
				(& rFlag1 $0004)
				(OneOf gCurRoomNum 4 6 9)
				(not (IsFlag 16))
				(!= gPrevRoomNum 10)
			)
			(LoadMany rsVIEW 410 480)
			(Load rsSOUND 313)
			(if (== sarienEntryDir 1)
				(-= s1startX 356)
				(-= s2startX 356)
			)
			(if (>= gHowFast 1)
				(sarien1 init: x: (self s1startX:) hide: firePosn: 0)
			)
			(sarien2 init: x: (self s2startX:) hide: firePosn: 4)
			(= global173 global166)
			(if (!= gPrevRoomNum 7)
				(= sarienState 2)
				(self setCountDown: (Random 3 5))
			)
		else
			(= sarienState 1)
			(= global173 0)
			(= timeTilSariens -1)
		)
		(= local3
			(switch gHowFast
				(0 10)
				(1 4)
				(2 1)
			)
		)
	)

	(method (doit &tmp [temp0 10])
		(super doit:)
		(cond
			((and (not local2) inGame (>= global172 0))
				(if (not (-- local3))
					(= local3
						(switch gHowFast
							(0 10)
							(1 4)
							(2 2)
						)
					)
					(if (!= lastTime (= theTime (GetTime 1))) ; SysTime12
						(= lastTime theTime)
						(if (gCast contains: detonationBox)
							(if theTimeID
								(Display 700 3 dsRESTOREPIXELS theTimeID)
							)
							(= theTimeID
								(Display
									(Format ; "%2d:%02d"
										@temp0
										700
										4
										(/ global172 60)
										(mod global172 60)
									)
									dsCOORD
									(detonationBox x:)
									(- (detonationBox y:) (detonationBox z:))
									dsCOLOR
									global136
									dsFONT
									2
									dsSAVEPIXELS
								)
							)
						)
						(if
							(OneOf
								global172
								1
								2
								3
								4
								5
								10
								15
								30
								60
								120
								180
								240
								300
								600
								900
								1800
							)
							(gEgo setScript: DoCountDown 0 global172)
						)
						(if (< (-- global172) 0)
							(= inGame 0)
							(gLongSong fade:)
							(gCurRoom setScript: timesUp)
						)
						(if (!= timeTilSariens -1)
							(-- timeTilSariens)
						)
						(if (and (!= gCurRoomNum 103) (not local4))
							(detonationBox init:)
						)
					)
				)
			)
			((gCast contains: detonationBox)
				(detonationBox dispose:)
			)
		)
		(if (and explosionTimer inGame (not (-- explosionTimer)))
			(switch (Random 0 2)
				(0
					(explosionSound number: 308)
				)
				(1
					(explosionSound number: 364)
				)
				(2
					(explosionSound number: 365)
				)
			)
			(explosionSound loop: 1 play:)
			(ShakeScreen 6 (Random 1 3))
			(= explosionTimer (Random 50 1000))
		)
		(if (and (not script) (!= sarienState 1))
			(switch sarienState
				(2
					(if
						(or
							(and checkFootCode (self perform: checkFootCode))
							(== timeTilSariens -1)
						)
						(Print 700 5) ; "You hear footsteps."
						(sarien2 cycleSpeed: 5 stepState: 1 setCycle: Fwd)
						(self setCountDown: (Random 3 6))
						(= sarienState 3)
					)
				)
				(3
					(if
						(or
							(and checkEntryCode (self perform: checkEntryCode))
							(== timeTilSariens -1)
						)
						(self setScript: callGuards)
					)
				)
				(4
					(if (self perform: safeCode)
						(if (== timeTilSariens -1)
							(if
								(and
									(== gCurRoomNum 6)
									(!= global166 global173)
									(or
										(and
											(== global173 2)
											(< (gEgo x:) (+ s2gotoX 5))
										)
										(and
											(== global173 1)
											(> (gEgo x:) (- s2gotoX 5))
										)
									)
								)
								0
							else
								(= sarienState 5)
							)
						)
					else
						(self setScript: shootEgoDead)
					)
				)
				(5
					(= sarienState 1)
					(self setScript: removeGuards)
				)
			)
		)
	)

	(method (setCountDown param1)
		(if (not (HaveMouse))
			(+= param1 1)
		)
		(= timeTilSariens param1)
	)
)

(instance callGuards of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== gCurRoomNum 4) (== global173 2))
			(if (gCast contains: sarien1)
				(sarien1 setPri: 3)
			)
			(sarien2 setPri: 3)
		else
			(if (gCast contains: sarien1)
				(sarien1 setPri: -1)
			)
			(sarien2 setPri: -1)
		)
		(cond
			((== state 0)
				(switch (arcadaRegion sarienEntryDir:)
					(1
						(if
							(or
								(!= global173 global166)
								(> (gEgo x:) 160)
								(and (== gCurRoomNum 9) (<= (gEgo y:) 109))
							)
							(self cue:)
						)
					)
					(2
						(if (or (!= global173 global166) (< (gEgo x:) 160))
							(self cue:)
						)
					)
				)
			)
			((== global173 global166)
				(switch (arcadaRegion sarienEntryDir:)
					(1
						(if (and (< (gEgo x:) 160) (> (sarien2 x:) 10))
							(if (and (== gCurRoomNum 9) (< (gEgo y:) 109))
								0
							else
								(if (gCast contains: sarien1)
									(sarien1 setMotion: 0)
								)
								(sarien2 setMotion: 0)
								(arcadaRegion setCountDown: 0 sarienState: 4)
								(self dispose:)
							)
						)
					)
					(2
						(if (and (> (gEgo x:) 160) (< (sarien1 x:) 310))
							(if (gCast contains: sarien1)
								(sarien1 setMotion: 0)
							)
							(sarien2 setMotion: 0)
							(arcadaRegion setCountDown: 0 sarienState: 4)
							(self dispose:)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(arcadaRegion sarienEntryDir: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(if (gCast contains: sarien1)
					(sarien1 show: y: (arcadaRegion s1startY:))
				)
				(sarien2 show: cycleSpeed: 4 y: (arcadaRegion s2startY:))
				(= cycles 3)
			)
			(2
				(if (gCast contains: sarien1)
					(sarien1
						stepState: 3
						setMotion:
							MoveTo
							(arcadaRegion s1gotoX:)
							(arcadaRegion s1gotoY:)
							self
					)
				else
					(= cycles 1)
				)
				(sarien2
					stepState: 3
					setCycle: StopWalk 480
					setMotion:
						MoveTo
						(arcadaRegion s2gotoX:)
						(arcadaRegion s2gotoY:)
						self
				)
			)
			(3 0)
			(4
				(arcadaRegion setCountDown: 2 sarienState: 4)
				(self dispose:)
			)
		)
	)
)

(instance removeGuards of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> (sarien2 heading:) 180)
					(if (gCast contains: sarien1)
						(sarien1 setHeading: 90)
					)
					(sarien2 setHeading: 90 self)
				else
					(if (gCast contains: sarien1)
						(sarien1 setHeading: 270)
					)
					(sarien2 setHeading: 270 self)
				)
			)
			(1
				(if (gCast contains: sarien1)
					(Print 700 6) ; "Failing to notice anyone or anything in the room, the Sarien guards decide to check elsewhere. Way to go, Roger!"
				else
					(Print 700 7) ; "Failing to notice anyone or anything in the room, the guard decides to check elsewhere. Way to go, Roger!"
				)
				(if (gCast contains: sarien1)
					(sarien1
						setMotion:
							MoveTo
							(arcadaRegion s1startX:)
							(arcadaRegion s1startY:)
					)
				)
				(= cycles 2)
			)
			(2
				(sarien2
					stepState: 2
					setMotion:
						MoveTo
						(arcadaRegion s2startX:)
						(arcadaRegion s2startY:)
						self
				)
			)
			(3
				(if (gCast contains: sarien1)
					(sarien1 dispose:)
				)
				(sarien2 cycleSpeed: 5 setCycle: Fwd)
				(= seconds 2)
			)
			(4
				(sarien2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance shootEgoDead of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (gCurRoom script:)))
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 0)
			(1
				(if (not (self perform: (arcadaRegion safeCode:)))
					(= local2 1)
					(HandsOff)
					(gEgo setMotion: 0)
					(if (= temp0 (gCast firstTrue: #isKindOf Elevator))
						(temp0 state: 0)
					)
					(Face gEgo sarien2)
					(Face sarien2 gEgo self)
					(if (gCast contains: sarien1)
						(Face gEgo sarien1 self)
						(Face sarien1 gEgo)
					else
						(= cycles 2)
					)
				else
					(arcadaRegion setCountDown: 2)
					(self dispose:)
				)
			)
			(2 0)
			(3
				(if (gCast contains: sarien1)
					(sarien1
						view:
							(cond
								(
									(or
										(>= 105 (sarien1 heading:) 75)
										(>= 285 (sarien1 heading:) 255)
									)
									411
								)
								((> 255 (sarien1 heading:) 75) 412)
								(else 413)
							)
						setLoop:
							(+ (sarien1 firePosn:) (>= (sarien1 heading:) 180))
						cel: 0
						setCycle: Osc 1
					)
				)
				(sarien2
					view:
						(cond
							(
								(or
									(>= 105 (sarien2 heading:) 75)
									(>= 285 (sarien2 heading:) 255)
								)
								411
							)
							((>= 255 (sarien2 heading:) 75) 412)
							(else 413)
						)
					setLoop: (+ (sarien2 firePosn:) (>= (sarien2 heading:) 180))
					cel: 0
					setCycle: End self
				)
			)
			(4
				(if (== (sarien2 view:) 411)
					(sarien2 setCycle: CT 5 -1)
				else
					(sarien2 setCycle: CT 4 -1)
				)
				(gEgo
					view: 6
					cel: 0
					setLoop:
						(cond
							((& (gEgo onControl:) $0100) 2)
							((>= (gEgo heading:) 180) 1)
							(else 0)
						)
					illegalBits: 0
					ignoreActors: 1
					setCycle: CT 3 1 self
				)
			)
			(5
				(cond
					((& (gEgo onControl:) $0080)
						(gEgo setLoop: 0)
					)
					((& (gEgo onControl:) $4000)
						(gEgo setLoop: 3)
					)
				)
				(gEgo cel: 3 setCycle: End self)
			)
			(6
				(if (gCast contains: sarien1)
					(Print 700 8) ; "The aliens observe their handiwork briefly before looking for others to process in similiar fashion."
				else
					(Print 700 9) ; "The alien observes his handiwork briefly before looking for others to process in similiar fashion."
				)
				(sarien2 setCycle: Beg self)
			)
			(7
				(if (IsFlag 16)
					(EgoDead 940 1 0 700 10) ; "As you lie on the floor in a smoldering, carbogelatinous heap, you just can't help but wonder why you bothered getting up this morning."
				else
					(EgoDead 940 0 0 700 10) ; "As you lie on the floor in a smoldering, carbogelatinous heap, you just can't help but wonder why you bothered getting up this morning."
				)
			)
		)
	)
)

(instance timesUp of Script
	(properties)

	(method (init)
		(LoadMany rsSOUND 804 805)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and local1 (< (deltaur y:) -25))
			(= local1 0)
			(= cycles 1)
		)
		(if
			(and
				local0
				(== (gLongSong number:) 355)
				(== (gLongSong prevSignal:) -1)
			)
			(= local0 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: detonationBox)
					(detonationBox dispose:)
				)
				(sampledVoice stop:)
				(gCurRoom drawPic: 16 10)
				(gCast eachElementDo: #dispose)
				(deltaurArm init:)
				(arcada init:)
				(deltaur init:)
				(star1 init: setCycle: Fwd)
				(star2 init: setCycle: Fwd)
				(star3 init: setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(gSoundEffects number: 804 loop: 1 play:)
				(deltaur
					illegalBits: 0
					setMotion: MoveTo (- (deltaur x:) 50) (- (deltaur y:) 120)
				)
				(deltaurArm
					setMotion:
						MoveTo
						(- (deltaurArm x:) 50)
						(- (deltaurArm y:) 120)
					setCycle: End
				)
				(= local1 1)
			)
			(2
				(= local0 1)
			)
			(3
				(gLongSong2 number: 805 loop: 1 flags: 1 play:)
				(arcada setCycle: End self)
			)
			(4
				(arcada dispose:)
				(= cycles 12)
			)
			(5
				(Print 700 11) ; "Bad news travels fast - especially when it's in the form of a shock wave."
				(Print 700 12) ; "The explosion was pretty messy. It's a judgment call as to which one critically damaged you first. Was it the concussion? Or, maybe, the fragments of ship that were located more closely to the epicenter than yourself and attempted to escape THROUGH you?"
				(Print 700 13) ; "Regardless of what got you first, enough molecular relocation (in bulk and in individual units) occurred to forever alter your form and place in the universe."
				(EgoDead 945 0 0 700 14) ; "Recompose yourself and let's see if we can't get off this scow more efficiently."
			)
		)
	)
)

(instance DoCountDown of Script
	(properties)

	(method (dispose)
		(= register 0)
		(cond
			((> global172 600)
				(Load rsSOUND 997)
			)
			((> global172 300)
				(UnLoad 132 997)
				(Load rsSOUND 996)
			)
			((> global172 240)
				(UnLoad 132 996)
				(Load rsSOUND 995)
			)
			((> global172 180)
				(UnLoad 132 995)
				(Load rsSOUND 994)
			)
			((> global172 120)
				(UnLoad 132 994)
				(Load rsSOUND 993)
			)
			((> global172 60)
				(UnLoad 132 993)
				(Load rsSOUND 992)
			)
			((> global172 30)
				(UnLoad 132 992)
				(LoadMany rsSOUND 991 990 989)
			)
			((> global172 10)
				(LoadMany rsSOUND 984 985 986 987 988)
			)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 30)
					(gLongSong number: 355 loop: 1 flags: 0 play:)
				)
				(sampledVoice
					number:
						(switch register
							(1 984)
							(2 985)
							(3 986)
							(4 987)
							(5 988)
							(10 989)
							(15 990)
							(30 991)
							(60 992)
							(120 993)
							(180 994)
							(240 995)
							(300 996)
							(600 997)
							(900 998)
							(1800 982)
						)
					loop: 1
					play: self
				)
			)
			(1
				(if (> register 5)
					(sampledVoice number: 983 loop: 1 play: self)
				else
					(self dispose:)
				)
			)
			(2
				(if
					(or
						(and gHowFast (== register 900))
						(and (not gHowFast) (== register 1800))
					)
					((ScriptID 4 1) cue:) ; beginGame
				)
				(if (and (!= gCurRoomNum 13) (< global172 15))
					(arcadaRegion inGame: 0)
					(gCurRoom setScript: timesUp)
				)
				(self dispose:)
			)
		)
	)
)

(instance star1 of Prop
	(properties
		x 155
		y 51
		view 216
		loop 4
		cel 3
		priority 1
		signal 22544
		cycleSpeed 20
	)
)

(instance star2 of Prop
	(properties
		x 271
		y 114
		view 216
		loop 4
		cel 1
		priority 1
		signal 22544
		cycleSpeed 24
	)
)

(instance star3 of Prop
	(properties
		x 105
		y 154
		view 216
		loop 4
		cel 2
		priority 1
		signal 22544
		cycleSpeed 16
	)
)

(instance arcada of Prop
	(properties
		x 247
		y 100
		view 216
		signal 26624
		cycleSpeed 5
	)
)

(instance detonationBox of View
	(properties
		z 29
		description {countdown window}
		view 3
		priority 15
		signal 24593
	)

	(method (init)
		(super init: &rest)
		(= local4 1)
		(localproc_0)
	)

	(method (doit)
		(super doit:)
		(if
			(or
				(and (< x 160) (< (gEgo x:) 160))
				(and (> x 160) (> (gEgo x:) 160))
			)
			(localproc_0)
		)
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(switch theVerb
			(2 ; Look
				(Print
					(Format ; "You have %2d:%02d till the Arcada self-destructs."
						@temp0
						700
						15
						(/ (+ global172 1) 60)
						(mod (+ global172 1) 60)
					)
					#mode
					1
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(if (arcadaRegion theTimeID:)
			(Display 700 3 dsRESTOREPIXELS (arcadaRegion theTimeID:))
		)
		(= local4 0)
		(super dispose:)
	)
)

(instance sarien1 of Sarien
	(properties
		x 337
		description {sarien}
		lookStr {These guys look scary. But then, don't most other beings packing weapons?}
		view 410
	)
)

(instance sarien2 of Sarien
	(properties
		x 337
		description {sarien}
		lookStr {These guys look scary. But then, don't most other beings packing weapons?}
		view 410
	)
)

(instance deltaur of Actor
	(properties
		x 253
		y 49
		view 216
		loop 1
		signal 26624
		cycleSpeed 4
		xStep 1
		moveSpeed 4
	)
)

(instance deltaurArm of Actor
	(properties
		x 253
		y 49
		view 216
		loop 2
		priority 12
		signal 30736
		cycleSpeed 4
		moveSpeed 4
	)
)

(instance UpperElevFeat of Feature
	(properties
		description {elevator shaft}
		sightAngle 45
		onMeCheck 32
		lookStr {This is an elevator shaft. Elevators are known to have traveled these parts, mostly up and down.}
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(Print 700 16) ; "You can't do that from this level."
		)
	)
)

(instance LowElevFeat of Feature
	(properties
		description {elevator shaft}
		sightAngle 45
		onMeCheck 8192
		lookStr {This is an elevator shaft.}
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 700 16) ; "You can't do that from this level."
		)
	)
)

(instance sarienSteps of Sound
	(properties)
)

(instance explosionSound of Sound
	(properties
		number 308
	)
)

(instance sampledVoice of Sound
	(properties)
)

