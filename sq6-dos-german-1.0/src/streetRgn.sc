;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use SQNarrator)
(use Scaler)
(use ROsc)
(use RegionPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	streetRgn 0
	Blaine 1
	Elmo 2
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
	[local11 3]
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23 = 8
	local24 = 40
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	[local45 100] = [32767 320 2 105 18 102 32769 91 103 32771 90 109 161 109 189 97 212 92 210 92 32773 247 90 32767 330 17 167 64 112 106 104 119 82 79 81 134 79 32786 161 47 161 50 161 47 161 53 144 60 141 80 32787 176 90 258 96 32771 260 112 329 136 32767 340 131 89 131 90 32786 132 90 140 92 183 94 32772 184 94 32787 218 104 303 104 280 106 72 104 32770 1 106 32767 320 329 102 287 103 32770 262 120 10 120 32768]
	[local145 102] = [32767 330 106 104 119 82 79 81 134 79 32786 161 47 161 50 161 47 161 53 144 60 141 80 32787 176 90 258 96 32771 260 112 329 136 32767 340 131 89 131 90 32786 132 90 140 92 183 94 32772 184 94 32787 218 104 303 104 280 106 72 104 32770 1 106 32767 320 329 102 287 103 32770 262 120 10 120 2 105 18 102 32769 91 103 32771 90 109 161 109 189 97 212 92 210 92 32773 247 90 32767 330 17 167 64 112 106 104 32768]
	[local247 98] = [32767 340 131 89 131 90 32786 132 90 140 92 183 94 32772 184 94 32787 218 104 303 104 280 106 72 104 32770 1 106 32767 320 329 102 287 103 32770 262 120 10 120 2 105 18 102 32769 91 103 32771 90 109 161 109 189 97 212 92 210 92 32773 247 90 32767 330 17 167 64 112 106 104 119 82 79 81 134 79 32786 161 47 161 50 161 47 161 53 144 60 141 80 32787 176 90 258 96 32771 260 112 329 136 32768]
	local345
	[local346 56] = [32767 320 1 116 136 122 256 124 32777 325 122 32767 340 0 117 285 116 32777 276 105 165 102 32784 164 102 32788 154 94 138 87 32789 138 86 32767 330 325 138 179 132 32776 158 102 32785 115 150 32767 320 249 91 229 97 252 119 1 115 32768]
	[local402 56] = [32767 330 325 138 179 132 32776 158 102 32785 115 150 32767 320 249 91 229 97 252 119 1 115 32767 320 1 116 136 122 256 124 32777 325 122 32767 340 0 117 285 116 32777 276 105 165 102 32784 164 102 32788 154 94 138 87 32789 138 86 32768]
	[local458 56] = [32767 340 0 117 285 116 32777 276 105 165 102 32784 164 102 32788 154 94 138 87 32789 138 86 32767 330 325 138 179 132 32776 158 102 32785 115 150 32767 320 249 91 229 97 252 119 1 115 32767 320 1 116 136 122 256 124 32777 325 122 32768]
	[local514 13] = [32767 320 -10 112 325 112 32767 340 -5 110 345 110 32768]
	[local527 13] = [32767 340 335 110 -5 110 32767 320 325 112 -10 112 32768]
	[local540 49] = [32767 330 162 54 147 53 141 82 181 85 186 121 325 143 32767 340 132 90 154 92 186 99 189 117 0 116 32767 320 325 116 246 112 230 92 246 88 32767 330 49 166 73 123 167 122 165 83 92 81 32768]
	[local589 45] = [32767 330 162 89 190 122 70 135 59 165 32767 320 247 92 197 102 137 111 71 111 71 115 325 115 32767 340 0 115 197 114 191 95 135 90 32767 330 325 140 181 113 169 85 97 85 32768]
)

(instance streetRgn of Rgn
	(properties)

	(method (init)
		(if (or (and (IsFlag 60) (!= gCurRoomNum 330)) (== gPrevRoomNum 330))
			(gGSound1 number: 330 setLoop: -1 play: setVol: 0 fade: 127 2 1 0)
			(ClearFlag 60)
		)
		(= keep 1)
		(if (== local18 0)
			(= local18 (+ 320 (* 10 (proc0_8 0 2))))
		)
		(if (and (== gCurRoomNum local18) (not (IsFlag 32)))
			(Load 140 321) ; WAVE
			(Load 140 325) ; WAVE
			(Load 140 323) ; WAVE
			(Load rsVIEW 3251)
			(Load rsVIEW 3250)
			(Load rsVIEW 3280)
			(Load rsVIEW 209)
			(Load rsVIEW 9441)
			(Load rsVIEW 9401)
			(Load rsHEAP 64938)
			(Load rsSCRIPT 64938)
			(victim init:)
			(photoBoothFront init: approachVerbs: 64 4) ; Buckazoids, Do
			(photoBoothBack init: approachVerbs: 64 4) ; Buckazoids, Do
			(photoCurtain init: approachVerbs: 64 4) ; Buckazoids, Do
			(photoEye init: hide:)
			(gCurRoom notify: 1)
			(Load 140 335) ; WAVE
			(Load rsVIEW local21)
			(switch gCurRoomNum
				(320
					(= local9 188)
					(= local10 107)
					(= local7 183)
					(= local8 120)
				)
				(330
					(= local9 96)
					(= local10 119)
					(= local7 122)
					(= local8 125)
				)
				(340
					(= local9 183)
					(= local10 116)
					(= local7 157)
					(= local8 130)
				)
			)
		)
		(if
			(or
				(and (not (IsFlag 35)) (IsFlag 32))
				(and
					(or (gEgo has: 111) (gEgo has: 61)) ; Whisk_Broom_Full, Full_Tray
					(== gCurRoomNum 330)
				)
			)
			(Load 140 335) ; WAVE
			(blaine init:)
		)
		(if (and (not (IsFlag 31)) (IsFlag 32) (IsFlag 5) (IsFlag 35))
			(if (gEgo has: 12) ; Brandy
				(if (== gCurRoomNum 340)
					(elmo init:)
				)
			else
				(elmo init:)
			)
		)
		(if (and (or (== local36 1) (>= 2 (proc0_8 1 16))) (not local39))
			(wanderer init:)
		)
		(if (and (or (== local39 1) (>= 2 (proc0_8 1 14))) (not local36))
			(wandererB init:)
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(if (and (!= newRoomNumber 320) (!= newRoomNumber 330) (!= newRoomNumber 340))
			(= keep 0)
		)
		(if
			(and
				(!= newRoomNumber 200)
				(!= newRoomNumber 300)
				(!= newRoomNumber 320)
				(!= newRoomNumber 340)
				(not (IsFlag 60))
			)
			(gGSound1 fade: 0 3 1 1)
			(= local19 0)
			(SetFlag 60)
		)
		(if
			(and
				(!= newRoomNumber 320)
				(!= newRoomNumber 330)
				(!= newRoomNumber 340)
				(not (IsFlag 60))
			)
			(photoBoothFront dispose:)
			(photoBoothBack dispose:)
			(photoCurtain dispose:)
			(photoEye dispose:)
		)
	)
)

(instance sIgnore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local42 1)
				(blaine ignoreActors: 1)
				(= ticks 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sIgnore2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local43 1)
				(elmo ignoreActors: 1)
				(= ticks 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sNotice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local42 0)
				(blaine ignoreActors: 0)
				(= ticks 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sNotice2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local43 0)
				(elmo ignoreActors: 0)
				(= ticks 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sWait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 2 15 0 self 222) ; "He's too far away or doesn't care."
			)
			(1
				(= ticks 40)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDroidRunAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(droid
					cycleSpeed: 12
					setLoop: 0
					setCel: 0
					show:
					setCycle: End self
				)
				(gGSound2 setLoop: 0 number: 335 play:)
			)
			(1
				(droid hide:)
				(self dispose:)
			)
		)
	)
)

(instance sWaitForBooth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gCurRoomNum
					(320
						(= local5 170)
						(= local6 112)
						(+= local9 3)
						(victim
							setPri: (- (photoCurtain priority:) 1)
							setStep: 8 2
							x: 0
							y: 113
						)
					)
					(330
						(= local5 124)
						(= local6 122)
						(+= local9 1)
						(victim
							setPri: (+ (photoCurtain priority:) 1)
							setStep: 8 2
							x: 325
							y: 122
						)
					)
					(340
						(= local5 150)
						(= local6 122)
						(victim
							setPri: (+ (photoBoothBack priority:) 1)
							setStep: 8 2
							x: 0
							y: 111
						)
					)
				)
				(victim setMotion: MoveTo local5 local6 self)
			)
			(1
				(victim setLoop: 2)
				(if (== gCurRoomNum 330)
					(victim setCel: 1)
				else
					(victim setCel: 0)
				)
				(= local4 1)
			)
			(2
				(victim setMotion: MoveTo local9 local10 self)
			)
			(3
				(victim setCel: 6 setPri: (- (photoCurtain priority:) 1))
				(photoCurtain setCycle: End self)
			)
			(4
				(sPhotoBooth cue:)
				(victim dispose:)
			)
		)
	)
)

(instance Blaine of SmallTalker
	(properties
		talkView 329
		talkLoop 2
	)

	(method (init)
		(= client blaine)
		(self talkLoop: (+ (blaine loop:) 2))
		(super init:)
	)
)

(instance sBlaineTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(!= gCurRoomNum 200)
						(!= gCurRoomNum 240)
						(<
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(blaine x:)
								(blaine y:)
								75
							)
							70
						)
						(not local42)
					)
					(if (!= 0 (blaine mover:))
						(= local28 (blaine mover:))
					)
					(blaine view: 329 mover: 0 setCel: 0)
					(if (< (gEgo x:) (blaine x:))
						(blaine setLoop: 1)
					else
						(blaine setLoop: 0)
					)
					(gMessager say: 0 2 14 1 self 222) ; "Hey!"
				else
					(blaine init:)
					(gEgo setScript: sWait)
					(self dispose:)
				)
			)
			(1
				(= local30 0)
				(= ticks 15)
			)
			(2
				(if (< (gEgo x:) (blaine x:))
					(gEgo
						setMotion: MoveTo (- (blaine x:) 9) (+ (blaine y:) 4)
					)
				else
					(gEgo
						setMotion: MoveTo (+ (blaine x:) 9) (+ (blaine y:) 4)
					)
				)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(= cycles 1)
			)
			(3
				(= cycles 10)
			)
			(4
				(if (and (== (gEgo x:) local1) (== (gEgo y:) local2))
					(+= local0 1)
				else
					(= local0 0)
					(= local1 (gEgo x:))
					(= local2 (gEgo y:))
				)
				(cond
					(
						(and
							(== (gEgo y:) (+ (blaine y:) 4))
							(or
								(== (gEgo x:) (+ (blaine x:) 9))
								(== (gEgo x:) (- (blaine x:) 9))
							)
						)
						(self changeState: (+ state 1))
					)
					((< local0 10)
						(self changeState: (- state 1))
					)
					(else
						(gEgo setMotion: MoveTo (gEgo x:) (gEgo y:))
						(self changeState: 10)
					)
				)
			)
			(5
				(proc0_4 gEgo blaine self)
			)
			(6
				(blaine setCycle: End self)
			)
			(7
				(if (IsFlag 27)
					(cond
						((IsFlag 43)
							(= local15 1)
							(switch (proc0_8 0 1)
								(0
									(gMessager say: 3 2 9 0 self 222) ; "He seems to be anxious to get somewhere else and ignores you."
								)
								(1
									(gMessager say: 3 2 0 0 self 222) ; "He gives you a long look, then exhibits a facial expression not unlike that of one who has just found some special treat stuck underneath the table."
								)
							)
						)
						((gEgo has: 27) ; Datacorder
							(not (IsFlag 43))
							(= local15 1)
							(SetFlag 43)
							(gMessager say: 3 2 8 0 self 222) ; "Just find the endodroid, little guy. I'll talk to you later."
						)
						(else
							(gGame points: 1)
							(SetFlag 35)
							(= local15 7)
							(gEgo get: 27) ; Datacorder
							(gMessager sayRange: 3 0 4 1 16 self 222) ; "Uh, Buddy, maybe you can help me out. I'm trying to track down this endodroid. I'm an Endodroid Runner. I know I don't look so hot but I'm in disguise, you know?"
						)
					)
				else
					(SetFlag 27)
					(= local15 1)
					(gMessager say: 3 0 17 0 self 222) ; "Hmm. I wonder if you ... nah. What was I thinkin'?"
				)
			)
			(8
				(if (and (IsFlag 35) (not (IsFlag 43)))
					(blaine view: 332 setCel: 0 setCycle: End self)
				else
					(self changeState: (+ state 2))
				)
			)
			(9
				(gGame points: 1)
				(gMessager say: 3 0 4 17 self 222) ; "Thanks. I've gotta go check in with the home office. I'll check back out here a little later to see how you're comin' along."
			)
			(10
				(client view: 327 setCycle: Walk setMotion: local28)
				(= local0 0)
				(gEgo setScript: sGetBackInPolygon)
				(self dispose:)
			)
		)
	)
)

(instance sElmoSitTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local33 1)
				(gEgo ignoreActors: 1)
				(gEgo setMotion: MoveTo 131 132 self)
			)
			(1
				(proc0_4 gEgo elmo self)
			)
			(2
				(SetFlag 30)
				(gMessager say: 2 2 5 0 self 222) ; "Say, you look familiar. Didn't I kick your butt in a huge robot once?"
			)
			(3
				(SetFlag 29)
				(gEgo ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sElmoTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(<
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(elmo x:)
								(elmo y:)
								75
							)
							70
						)
						(not local43)
					)
					(gGame handsOff:)
					(if (!= 0 (elmo mover:))
						(= local32 (elmo mover:))
					)
					(elmo view: 325 mover: 0 setLoop: 4 setCel: 0)
					(if (< (gEgo x:) (elmo x:))
						(elmo setCel: 1)
					else
						(elmo setCel: 0)
					)
					(gMessager say: 0 2 14 1 self 222) ; "Hey!"
				else
					(gMessager say: 0 2 15 0 0 222) ; "He's too far away or doesn't care."
					(elmo init:)
					(self dispose:)
				)
			)
			(1
				(= local34 0)
				(= ticks 15)
			)
			(2
				(if (< (gEgo x:) (elmo x:))
					(gEgo setMotion: MoveTo (- (elmo x:) 19) (+ (elmo y:) 2))
				else
					(gEgo setMotion: MoveTo (+ (elmo x:) 19) (+ (elmo y:) 2))
				)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(= cycles 1)
			)
			(3
				(= cycles 10)
			)
			(4
				(if (and (== (gEgo x:) local1) (== (gEgo y:) local2))
					(+= local0 2)
				else
					(= local0 0)
					(= local1 (gEgo x:))
					(= local2 (gEgo y:))
				)
				(cond
					(
						(and
							(== (gEgo y:) (+ (elmo y:) 2))
							(or
								(== (gEgo x:) (+ (elmo x:) 19))
								(== (gEgo x:) (- (elmo x:) 19))
							)
						)
						(self changeState: (+ state 1))
					)
					((< local0 10)
						(self changeState: (- state 1))
					)
					(else
						(gEgo setMotion: MoveTo (gEgo x:) (gEgo y:))
						(self changeState: 7)
					)
				)
			)
			(5
				(proc0_4 gEgo elmo self)
			)
			(6
				(cond
					((IsFlag 33)
						(gMessager say: 2 2 7 0 self 222) ; "Get out of my face or I'll puke on your boots!"
					)
					((IsFlag 29)
						(SetFlag 33)
						(gMessager say: 2 2 6 0 self 222) ; "I hope you're here to remit your portion of the business arrangement. We need to put this thing to bed. Otherwise, you should leave. I do have other contacts interested."
					)
					(else
						(SetFlag 30)
						(SetFlag 29)
						(gGame points: 1)
						(gMessager say: 2 2 5 0 self 222) ; "Say, you look familiar. Didn't I kick your butt in a huge robot once?"
					)
				)
			)
			(7
				(elmo view: 325 setCycle: Walk setMotion: local32)
				(= local0 0)
				(gEgo setScript: sGetBackInPolygon)
				(self dispose:)
			)
		)
	)
)

(instance sGetBackInPolygon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 20)
			)
			(1
				(blaine ignoreActors: 1)
				(elmo ignoreActors: 1)
				(gEgo ignoreActors: 1)
				(= local14 (gEgo y:))
				(= ticks 1)
			)
			(2
				(cond
					(
						(((gCurRoom obstacles:) at: 0)
							onMe: (gEgo x:) (gEgo y:)
						)
						(gGame handsOn:)
						(blaine ignoreActors: 0)
						(elmo ignoreActors: 0)
						(gEgo ignoreActors: 0)
						(self dispose:)
					)
					((< local14 113)
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(+ (gEgo y:) 4)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 4)
								self
						)
					)
				)
			)
			(3
				(self changeState: (- state 1))
			)
		)
	)
)

(instance sPhotoBooth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo ignoreActors: 1)
				(cond
					((== gCurRoomNum 340)
						(gEgo setHeading: 45 self)
					)
					((== gCurRoomNum 320)
						(gEgo setHeading: 0 self)
					)
					((== gCurRoomNum 330)
						(gEgo setHeading: 315 self)
					)
				)
			)
			(1
				(gGame handsOff:)
				(victim setScript: sWaitForBooth)
				(if (== gCurRoomNum 340)
					(gEgo view: 349 setCel: 0 setLoop: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (== gCurRoomNum 340)
					(gEgo normalize: 6)
					(self cue:)
				else
					(self cue:)
				)
			)
			(3
				(if (== gCurRoomNum 330)
					(gEgo setPri: (+ (photoCurtain priority:) 1))
				else
					(gEgo setPri: (- (photoCurtain priority:) 1))
				)
				(gEgo setMotion: MoveTo local9 local10 self)
			)
			(4
				(if (!= gCurRoomNum 340)
					(gEgo setPri: (- (photoCurtain priority:) 1))
				)
				(photoCurtain setCycle: End self)
			)
			(5
				(if (== (-= global150 1) 0)
					(gEgo put: 13) ; Buckazoids
				)
				(gTheIconBar show:)
				(gMessager say: 1 64 0 0 self 222) ; "You pop a coin in the slot and climb on in."
			)
			(6
				(= seconds 4)
			)
			(7
				(gGSound2 loop: 0 number: 328 play:)
				(photoCurtain setLoop: 2)
				(= ticks 7)
			)
			(8
				(photoCurtain setLoop: 1 setCel: 3)
				(++ local17)
				(= seconds 2)
			)
			(9
				(if (< local17 4)
					(self changeState: (- (self state:) 2))
				else
					(self changeState: (+ (self state:) 1))
				)
			)
			(10
				(= ticks 10)
			)
			(11
				(if local4
					(self cue:)
				else
					(self changeState: (- (self state:) 1))
				)
			)
			(12
				(gEgo get: 93) ; Roger_Photos
				(gGame points: 3)
				(SetFlag 32)
				(photoCurtain loop: 1 cel: 6 setCycle: Beg self)
			)
			(13
				(if (!= gCurRoomNum 340)
					(gEgo setPri: (+ (photoCurtain priority:) 1))
				)
				(gEgo setMotion: MoveTo local7 local8 self)
			)
			(14
				(gEgo setPri: -1)
				(victim cue:)
				(gMessager say: 1 0 1 0 self 222) ; "There's got to be an optics problem with that machine. I look, uh, partially digested."
			)
			(15)
			(16
				(photoEye show:)
				(Load 140 329) ; WAVE
				(= ticks 50)
			)
			(17
				(photoEye hide:)
				(= ticks 15)
			)
			(18
				(photoEye show:)
				(= ticks 30)
			)
			(19
				(photoEye hide:)
				(= ticks 5)
			)
			(20
				(photoEye show:)
				(= ticks 55)
			)
			(21
				(switch gCurRoomNum
					(320
						(gEgo setHeading: 45)
					)
					(330
						(gEgo setHeading: 315)
					)
					(340
						(gEgo setHeading: 45)
					)
				)
				(victim dispose:)
				(photoEye hide:)
				(photoCurtain hide:)
				(photoBoothBack hide:)
				(gGSound2 number: 321 setLoop: -1 play:)
				(client view: local21 setLoop: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(22
				(client setCycle: End self)
			)
			(23
				(gGSound2 number: 323 setLoop: 0 play:)
				(client setLoop: 1 setCel: 0 setCycle: End self)
			)
			(24
				(gGSound2 number: 325 setLoop: 0 play:)
				(client setLoop: 2 setCel: 0 setCycle: End self)
			)
			(25
				(photoEye hide: dispose:)
				(photoBoothBack hide: dispose:)
				(photoCurtain hide: dispose:)
				(if (== gCurRoomNum 340)
					(photoBoothFront
						view: 348
						setCel: 0
						setLoop: 0
						setCycle: End self
					)
				else
					(self changeState: (+ (self state:) 1))
				)
			)
			(26
				(if (== gCurRoomNum 340)
					(photoBoothFront x: 142 y: 93)
				)
				(if (== gCurRoomNum 320)
					(photoBoothFront cycleSpeed: 8)
				)
				(photoBoothFront
					view: local22
					setLoop: 0
					setCel: 0
					setCycle: CT 14 1 self
				)
				(gGSound2 number: 329 loop: 0 play:)
			)
			(27
				(if (== gCurRoomNum 330)
					(photoBoothFront setPri: 140)
				)
				(photoBoothFront setCycle: End self)
			)
			(28
				(= ticks 60)
			)
			(29
				(gEgo signal: 33)
				(photoBoothFront hide:)
				(gMessager say: 1 0 2 0 self 222) ; "Good thing you didn't opt for that second set of prints after all. Guess that guy won't be filing any complaints with the Portable Business Association."
			)
			(30
				(gEgo ignoreActors: 0)
				(photoBoothFront dispose:)
				(gCurRoom notify: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDroidRefuse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (- (blaine x:) 15) (blaine y:) self)
			)
			(1
				(proc0_4 gEgo blaine self)
			)
			(2
				(blaine setCycle: End self)
			)
			(3
				(gMessager say: 3 156 0 0 self 222) ; "I can't take him like that. Find something cool to put him in. The last thing I need is for him to thaw before I take him in."
			)
			(4
				(blaine setCycle: End)
				(SetFlag 59)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTradeDroid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(blaine ignoreActors: 1)
				((ScriptID 0 9) client: 0 delete: dispose:) ; reformTimer
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (- (blaine x:) 11) (blaine y:) self)
			)
			(1
				(proc0_4 gEgo blaine self)
			)
			(2
				(blaine setCycle: End self)
			)
			(3
				(gMessager sayRange: 3 65 0 1 6 self 222) ; "Here's your cubed compadre. Where's my fifty buckazoids?"
			)
			(4
				(blaine
					view: 332
					setCel: 0
					setLoop: 1
					setCycle: End self
					ignoreActors: 1
				)
			)
			(5
				(gMessager say: 3 65 0 7 self 222) ; "Here, you happy? I'll just be taking that tray. It's been a special treat doin' business with you."
			)
			(6
				(gEgo setHeading: 0)
				(blaine
					view: 327
					setCel: 0
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 220 94 self
				)
			)
			(7
				(gGame points: 20)
				(SetFlag 28)
				(gEgo put: 61 get: 13) ; Full_Tray, Buckazoids
				(+= global150 50)
				(gTheIconBar show:)
				(blaine setMotion: MoveTo 240 70 self)
			)
			(8
				(= seconds 3)
			)
			(9
				(gGSound2 setLoop: 0 number: 339 play:)
				(= ticks 1)
			)
			(10
				(= seconds 4)
			)
			(11
				(droid setScript: sDroidRunAway)
				(gCurRoom notify: 3)
				(self dispose:)
			)
		)
	)
)

(instance elmoSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elmo view: 3252 x: 103 y: 130 setLoop: 2 setCel: 0)
				(= seconds (proc0_8 3 7))
			)
			(1
				(elmo setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance Elmo of SmallTalker
	(properties
		talkView 3252
		talkLoop 1
	)

	(method (init)
		(if (or (gEgo has: 12) (gEgo has: 18)) ; Brandy, Cheat_Sheet
			(self talkView: 3252 talkLoop: 1)
		else
			(self talkView: 3253 talkLoop: (elmo cel:))
		)
		(= client elmo)
		(super init:)
	)
)

(instance sTradeBrandy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elmo view: 3252 x: 103 y: 130 setLoop: 2 setCel: 0)
				(= local33 1)
				(gGame handsOff:)
				(gEgo ignoreActors: 1)
				(gEgo setMotion: MoveTo 120 132 self)
			)
			(1
				(Load 140 326) ; WAVE
				(proc0_4 gEgo elmo self)
			)
			(2
				(elmo setCycle: End self)
			)
			(3
				(gMessager sayRange: 2 16 0 1 2 self 222) ; "YES!!! ... Uh, I mean, Mr. Wilco, I'm most pleased you've chosen to do business with us. You're just in time, too. I have another party on his way interested in the same item. Oh well, his loss."
			)
			(4
				(gGame points: 7)
				(gEgo put: 12) ; Brandy
				(gEgo hide:)
				(elmo setCel: 0 setLoop: 3 setCycle: CT 10 1 self)
			)
			(5
				(gGSound2 setLoop: 0 number: 341 play:)
				(elmo cycleSpeed: 4 setCycle: ROsc 2 10 12 self)
			)
			(6
				(elmo setCycle: End self)
			)
			(7
				(gEgo get: 18) ; Cheat_Sheet
				(gMessager say: 2 16 0 3 self 222) ; "Uh, now, per our agreement, here's your cheat sheet. I'm certain you'll find the game much more interesting now."
				(elmo view: 3252 setCel: 0 setLoop: 1)
				(gEgo show:)
			)
			(8
				(gGame points: 3)
				(gEgo hide:)
				(elmo setLoop: 4 setCel: 0 cycleSpeed: 9 1 setCycle: End self)
			)
			(9
				(gMessager say: 2 16 0 4 self 222) ; "Also, you look like you could use this fish."
				(elmo view: 3252 setCel: 0 setLoop: 1)
				(gEgo show:)
			)
			(10
				(gEgo hide:)
				(elmo view: 326 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(11
				(gMessager sayRange: 2 16 0 5 6 self 222) ; "Enjoy, Mr. Wilco. I have, uh, real important business in another part of town. Be seeing you."
				(elmo setLoop: 1 setCel: 0)
				(gEgo show:)
			)
			(12
				(gGame handsOn:)
				(gEgo get: 28) ; Dead_Fish
				(gGame points: 1)
				(gGSound2 setLoop: 0 number: 34002 play:)
				(elmo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(13
				(SetFlag 31)
				(gEgo ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBlainePeekNGE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client
					view: 328
					mover: 0
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(client setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(client
					view: 327
					x: (+ (blaine x:) 10)
					setCycle: Walk
					setMotion: local28
				)
				(self dispose:)
			)
		)
	)
)

(instance sBlainePeekNGW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client
					view: 328
					mover: 0
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(client setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(client
					view: 327
					x: (- (blaine x:) 10)
					setCycle: Walk
					setLoop: 0
					setMotion: local28
				)
				(self dispose:)
			)
		)
	)
)

(instance sBlaineLookWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client
					view: 209
					mover: 0
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(client setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(client
					x: (+ (blaine x:) 2)
					view: 327
					setLoop: 0
					setCel: 0
					setSpeed: 6
					setCycle: Walk
					setMotion: local28
				)
				(self dispose:)
			)
		)
	)
)

(instance sBlainePeekEast0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client
					view: 3280
					mover: 0
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(client
					view: 327
					setLoop: 0
					setCel: 0
					setSpeed: 6
					setCycle: Walk
					setMotion: local28
				)
				(self dispose:)
			)
		)
	)
)

(instance sBlainePeekEast1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client
					view: 3280
					mover: 0
					setLoop: 1
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(client
					view: 327
					setLoop: 0
					setCel: 0
					setSpeed: 6
					setCycle: Walk
					setMotion: local28
				)
				(self dispose:)
			)
		)
	)
)

(instance sBlaineStandW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client mover: 0 setLoop: 4 1 setCel: 1)
				(= seconds 6)
			)
			(1
				(client setLoop: -1 setCycle: Walk setMotion: local28)
				(self dispose:)
			)
		)
	)
)

(instance sBlaineStandE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local28 (blaine mover:))
				(client mover: 0 setLoop: 4 1 setCel: 0)
				(= seconds 5)
			)
			(1
				(client setLoop: -1 setCycle: Walk setMotion: local28)
				(self dispose:)
			)
		)
	)
)

(instance sElmoStandW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local32 (elmo mover:))
				(client mover: 0 setLoop: 4 1 setCel: 1)
				(= seconds (proc0_8 3 12))
			)
			(1
				(client setLoop: -1 setCycle: Walk setMotion: local32)
				(self dispose:)
			)
		)
	)
)

(instance sEastStumble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local32 (elmo mover:))
				(client
					mover: 0
					view: 3250
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(client view: 325 setCycle: Walk setMotion: local32)
				(self dispose:)
			)
		)
	)
)

(instance sWestStumble1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local32 (elmo mover:))
				(client
					mover: 0
					view: 3250
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(client view: 325 setCycle: Walk setMotion: local32)
				(self dispose:)
			)
		)
	)
)

(instance sWestStumble2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local32 (elmo mover:))
				(client
					mover: 0
					view: 3251
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(client view: 325 setCycle: Walk setMotion: local32)
				(self dispose:)
			)
		)
	)
)

(instance elmoRegPath1 of RegionPath
	(properties
		theRegion 222
	)

	(method (at param1)
		(return [local346 param1])
	)

	(method (moveDone)
		(switch (self at: (+ 2 value))
			(32788
				(++ value)
				(elmo ignoreActors: 1)
				(elmo setScript: sIgnore2)
			)
			(32789
				(++ value)
				(elmo ignoreActors: 0)
				(elmo setScript: sNotice2)
			)
			(32776
				(++ value)
				(elmo setScript: sElmoStandW)
			)
			(32777
				(++ value)
				(elmo setScript: sEastStumble)
			)
			(32784
				(++ value)
				(elmo setScript: sWestStumble1)
			)
			(32785
				(++ value)
				(elmo setScript: sWestStumble2)
			)
		)
		(super moveDone: &rest)
	)
)

(instance elmoRegPath2 of RegionPath
	(properties
		theRegion 222
	)

	(method (at param1)
		(return [local402 param1])
	)

	(method (moveDone)
		(switch (self at: (+ 2 value))
			(32788
				(++ value)
				(elmo ignoreActors: 1)
				(elmo setScript: sIgnore2)
			)
			(32789
				(++ value)
				(elmo ignoreActors: 0)
				(elmo setScript: sNotice2)
			)
			(32776
				(++ value)
				(elmo setScript: sElmoStandW)
			)
			(32777
				(++ value)
				(elmo setScript: sEastStumble)
			)
			(32784
				(++ value)
				(elmo setScript: sWestStumble1)
			)
			(32785
				(++ value)
				(elmo setScript: sWestStumble2)
			)
		)
		(super moveDone: &rest)
	)
)

(instance elmoRegPath3 of RegionPath
	(properties
		theRegion 222
	)

	(method (at param1)
		(return [local458 param1])
	)

	(method (moveDone)
		(switch (self at: (+ 2 value))
			(32788
				(++ value)
				(elmo ignoreActors: 1)
				(elmo setScript: sIgnore2)
			)
			(32789
				(++ value)
				(elmo ignoreActors: 0)
				(elmo setScript: sNotice2)
			)
			(32776
				(++ value)
				(elmo setScript: sElmoStandW)
			)
			(32777
				(++ value)
				(elmo setScript: sEastStumble)
			)
			(32784
				(++ value)
				(elmo setScript: sWestStumble1)
			)
			(32785
				(++ value)
				(elmo setScript: sWestStumble2)
			)
		)
		(super moveDone: &rest)
	)
)

(instance blaineRegPath1 of RegionPath
	(properties
		theRegion 222
	)

	(method (at param1)
		(return [local45 param1])
	)

	(method (moveDone)
		(switch (self at: (+ 2 value))
			(32769
				(++ value)
				(blaine setScript: sBlainePeekNGE)
			)
			(32770
				(++ value)
				(blaine setScript: sBlainePeekNGW)
			)
			(32773
				(++ value)
				(blaine setScript: sBlaineLookWest)
			)
			(32771
				(++ value)
				(blaine setScript: sBlainePeekEast0)
			)
			(32772
				(++ value)
				(blaine setScript: sBlainePeekEast1)
			)
			(32774
				(++ value)
				(blaine setScript: sBlaineStandW)
			)
			(32775
				(++ value)
				(blaine setScript: sBlaineStandE)
			)
			(32786
				(++ value)
				(blaine ignoreActors: 1)
				(blaine setScript: sIgnore)
			)
			(32787
				(++ value)
				(blaine ignoreActors: 0)
				(blaine setScript: sNotice)
			)
		)
		(super moveDone: &rest)
	)
)

(instance blaineRegPath2 of RegionPath
	(properties
		theRegion 222
	)

	(method (at param1)
		(return [local145 param1])
	)

	(method (moveDone)
		(switch (self at: (+ 2 value))
			(32769
				(++ value)
				(blaine setScript: sBlainePeekNGE)
			)
			(32770
				(++ value)
				(blaine setScript: sBlainePeekNGW)
			)
			(32773
				(++ value)
				(blaine setScript: sBlaineLookWest)
			)
			(32771
				(++ value)
				(blaine setScript: sBlainePeekEast0)
			)
			(32772
				(++ value)
				(blaine setScript: sBlainePeekEast1)
			)
			(32774
				(++ value)
				(blaine setScript: sBlaineStandW)
			)
			(32775
				(++ value)
				(blaine setScript: sBlaineStandE)
			)
			(32786
				(++ value)
				(blaine ignoreActors: 1)
				(blaine setScript: sIgnore)
			)
			(32787
				(++ value)
				(blaine ignoreActors: 0)
				(blaine setScript: sNotice)
			)
		)
		(super moveDone: &rest)
	)
)

(instance blaineRegPath3 of RegionPath
	(properties
		theRegion 222
	)

	(method (at param1)
		(return [local247 param1])
	)

	(method (moveDone)
		(switch (self at: (+ 2 value))
			(32769
				(++ value)
				(blaine setScript: sBlainePeekNGE)
			)
			(32770
				(++ value)
				(blaine setScript: sBlainePeekNGW)
			)
			(32773
				(++ value)
				(blaine setScript: sBlaineLookWest)
			)
			(32771
				(++ value)
				(blaine setScript: sBlainePeekEast0)
			)
			(32772
				(++ value)
				(blaine setScript: sBlainePeekEast1)
			)
			(32774
				(++ value)
				(blaine setScript: sBlaineStandW)
			)
			(32775
				(++ value)
				(blaine setScript: sBlaineStandE)
			)
			(32786
				(++ value)
				(blaine ignoreActors: 1)
				(blaine setScript: sIgnore)
			)
			(32787
				(++ value)
				(blaine ignoreActors: 0)
				(blaine setScript: sNotice)
			)
		)
		(super moveDone: &rest)
	)
)

(instance wanderPathOne of RegionPath
	(properties
		endType 0
		theRegion 222
	)

	(method (init)
		(super init: &rest)
	)

	(method (at param1)
		(return [local514 param1])
	)
)

(instance wanderPathTwo of RegionPath
	(properties
		endType 0
		theRegion 222
	)

	(method (init)
		(super init: &rest)
	)

	(method (at param1)
		(return [local527 param1])
	)
)

(instance wanderPathThree of RegionPath
	(properties
		endType 0
		theRegion 222
	)

	(method (init)
		(super init: &rest)
	)

	(method (at param1)
		(return [local540 param1])
	)
)

(instance wanderPathFour of RegionPath
	(properties
		endType 0
		theRegion 222
	)

	(method (init)
		(super init: &rest)
	)

	(method (at param1)
		(return [local589 param1])
	)
)

(instance victim of Actor
	(properties
		noun 5
		view 354
		signal 16417
	)

	(method (init)
		(self setStep: 7 2 setCycle: Walk)
		(switch gCurRoomNum
			(320
				(self setScaler: Scaler 99 30 137 90)
			)
			(330
				(self setScaler: Scaler 55 20 138 40)
			)
			(340
				(self setScaler: Scaler 100 23 134 91)
			)
		)
		(super init:)
	)
)

(instance wanderer of Actor
	(properties
		noun 5
		view 352
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
		(if (== local38 0)
			(= local38 (proc0_8 1 6))
		)
		(switch gCurRoomNum
			(320
				(self setScaler: Scaler 99 30 137 90)
			)
			(340
				(self setScaler: Scaler 100 23 134 91)
			)
		)
		(switch local38
			(1
				(self view: 352 setStep: 4 2)
			)
			(2
				(self view: 353 setStep: 5 2)
				(if (== gCurRoomNum 320)
					(self setScaler: Scaler 84 25 137 90)
				else
					(self setScaler: Scaler 86 20 134 91)
				)
			)
			(3
				(self view: 354 setStep: 7 2)
			)
			(4
				(if (== gCurRoomNum 340)
					(self view: 351 setStep: 1 2)
				else
					(self view: 3510 setStep: 1 2)
				)
			)
			(5
				(if (== gCurRoomNum 340)
					(self view: 350 setStep: 2 4)
				else
					(self view: 3500 setStep: 2 4)
				)
			)
			(6
				(if (== gCurRoomNum 340)
					(self
						view: 341
						setScaler: Scaler 100 57 134 91
						setStep: 3 2
					)
				else
					(self
						view: 3410
						setScaler: Scaler 100 57 134 91
						setStep: 3 2
					)
				)
			)
		)
		(if (not (< 0 local37 3))
			(= local37 (proc0_8 1 2))
		)
		(switch local37
			(1
				(self setMotion: wanderPathOne self)
			)
			(2
				(self setMotion: wanderPathTwo self)
			)
		)
		(= local36 1)
	)

	(method (doit)
		(cond
			(
				(and
					(not (self script:))
					(<
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					(not local26)
				)
				(= local25 (self mover:))
				(= local26 1)
				(= local27 0)
				(self mover: 0 ignoreActors: 0)
			)
			(
				(and
					(not (self script:))
					(>=
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					local26
				)
				(= local26 0)
				(self setMotion: local25 ignoreActors: 1)
			)
			(local26
				(++ local27)
			)
		)
		(super doit:)
	)

	(method (cue)
		(= local36 0)
		(= local37 0)
		(= local38 0)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch view
					(352
						(gMessager say: noun 1 11 0 0 222) ; "Wow, a great woolly vulture. It resembles a hairy embryo."
					)
					(353
						(gMessager say: noun 1 12 0 0 222) ; "That guy looks like a walking green fleshbulb and his eyes look like filaments, and ... WHOA!!! Must be a janitorial flashback!"
					)
					(354
						(gMessager say: noun 1 13 0 0 222) ; "Check out the knuckles on that thing. This planet is starting to remind you of some sort of genetic playground."
					)
					(341
						(gMessager say: 3 1 0 0 0 340) ; "Hey, that one has some legs. They're kind of spindly, but you sure have no room to criticize."
					)
					(350
						(gMessager say: 2 1 0 0 0 340) ; "This guy looks like a vertically challenged Darth Vadar. What does a thing like that do for fun?"
					)
					(351
						(gMessager say: 4 1 0 0 0 340) ; "Hey, that one looks familiar. It lacks a bit in the stature department, though."
					)
					(3410
						(gMessager say: 3 1 0 0 0 340) ; "Hey, that one has some legs. They're kind of spindly, but you sure have no room to criticize."
					)
					(3500
						(gMessager say: 2 1 0 0 0 340) ; "This guy looks like a vertically challenged Darth Vadar. What does a thing like that do for fun?"
					)
					(3510
						(gMessager say: 4 1 0 0 0 340) ; "Hey, that one looks familiar. It lacks a bit in the stature department, though."
					)
				)
			)
			(2 ; Talk
				(gMessager say: noun theVerb 0 0 0 222) ; "Not unlike your fellow humans, they pay you no mind."
			)
			(4 ; Do
				(switch view
					(352
						(gMessager say: noun theVerb 11 0 0 222) ; "You consider it, but decide it's something best not done."
					)
					(353
						(gMessager say: noun theVerb 12 0 0 222) ; "Bad idea."
					)
					(354
						(gMessager say: noun theVerb 13 0 0 222) ; "Bad idea. Let's pretend you didn't seriously consider that."
					)
					(3410
						(gMessager say: 2 4 0 0 0 340) ; "It doesn't want you to do that."
					)
					(3500
						(gMessager say: 2 4 0 0 0 340) ; "It doesn't want you to do that."
					)
					(3510
						(gMessager say: 2 4 0 0 0 340) ; "It doesn't want you to do that."
					)
					(341
						(gMessager say: 2 4 0 0 0 340) ; "It doesn't want you to do that."
					)
					(350
						(gMessager say: 2 4 0 0 0 340) ; "It doesn't want you to do that."
					)
					(351
						(gMessager say: 2 4 0 0 0 340) ; "It doesn't want you to do that."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wandererB of Actor
	(properties
		noun 9
		view 352
		signal 16417
	)

	(method (init)
		(self setCycle: Walk)
		(if (== local41 0)
			(= local41 (proc0_8 1 4))
		)
		(switch local41
			(1
				(self view: 356)
			)
			(2
				(self view: 357)
			)
			(3
				(self view: 358)
			)
			(4
				(self view: 346)
			)
		)
		(if (== local40 0)
			(= local40 (proc0_8 1 2))
		)
		(switch local40
			(1
				(self setMotion: wanderPathThree self)
			)
			(2
				(self setMotion: wanderPathFour self)
			)
		)
		(switch gCurRoomNum
			(320
				(self setScaler: Scaler 99 30 137 90)
			)
			(330
				(self setScaler: Scaler 55 20 138 40)
			)
			(340
				(self setScaler: Scaler 100 23 134 91)
			)
		)
		(= local39 1)
		(super init:)
	)

	(method (doit)
		(cond
			(
				(and
					(not (self script:))
					(<
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					(not local26)
				)
				(= local25 (self mover:))
				(= local26 1)
				(= local27 0)
				(self mover: 0 ignoreActors: 0)
				(self setCel: loop)
				(self setLoop: 4)
			)
			(
				(and
					(not (self script:))
					(>=
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					local26
				)
				(= local26 0)
				(self setMotion: local25 ignoreActors: 1)
			)
			(local26
				(++ local27)
			)
		)
		(super doit:)
	)

	(method (cue)
		(= local39 0)
		(= local40 0)
		(= local41 0)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== view 346)
					(gMessager say: 5 1 10 0 0 222) ; "What is that? It looks like a punk grasshopper. What would Darwin think of this place?"
				else
					(gMessager say: noun 1 0 0 0 222) ; "It's one of those Bjorn guys. It's so cute when they talk about assimilating everyone."
				)
			)
			(2 ; Talk
				(gMessager say: 0 2 14 0 0 222) ; "Hey!"
			)
			(4 ; Do
				(if (== view 346)
					(gMessager say: 5 4 10 0 0 222) ; "No, that wouldn't be wise."
				else
					(gMessager say: noun 4 0 0 0 222) ; "Let's not and say we did."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blaine of Actor
	(properties
		noun 3
		sightAngle 40
		view 327
		signal 16417
	)

	(method (init)
		(super init:)
		(droid init:)
		(self setSpeed: 5 1)
		(switch gCurRoomNum
			(200
				(self setScaler: Scaler 100 80 138 93)
			)
			(240
				(self setScaler: Scaler 100 70 95 70)
			)
			(320
				(self setScaler: Scaler 99 30 137 90)
			)
			(330
				(self setScaler: Scaler 55 20 138 40)
			)
			(340
				(self setScaler: Scaler 100 23 134 91)
			)
		)
		(cond
			((and (gEgo has: 61) (== gCurRoomNum 330)) ; Full_Tray
				(= local29 1)
				(blaine view: 329 x: 237 y: 105 setLoop: 1 setCel: 0)
			)
			((and (gEgo has: 111) (== gCurRoomNum 330)) ; Whisk_Broom_Full
				(= local29 1)
				(blaine view: 329 x: 237 y: 105 setLoop: 1 setCel: 0)
			)
			(else
				(self view: 327 setSpeed: 5 setScript: 0 setCycle: Walk)
				(if (== local44 0)
					(= local44 (proc0_8 1 3))
				)
				(switch local44
					(1
						(self setMotion: blaineRegPath1)
					)
					(2
						(self setMotion: blaineRegPath2)
					)
					(3
						(self setMotion: blaineRegPath3)
					)
				)
			)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(not (self script:))
					(<
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					(not local30)
					(not local29)
				)
				(= local28 (self mover:))
				(= local30 1)
				(= local31 0)
				(self mover: 0 ignoreActors: 0)
				(self setCel: loop)
				(self setLoop: 4)
			)
			(
				(and
					(not (self script:))
					(>=
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					local30
				)
				(= local30 0)
				(self setMotion: local28 ignoreActors: 1)
			)
			(local30
				(++ local31)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(gMessager say: noun theVerb 0 0 0 222) ; "Are you crazy? Let him get his own."
			)
			(65 ; Full_Tray
				(blaine setScript: sTradeDroid)
			)
			(13 ; Empty_Tray
				(gMessager say: noun theVerb 0 0 0 222) ; "That's a real nice tray. How proud you must be!"
			)
			(156 ; Whisk_Broom_Full
				(blaine setScript: sDroidRefuse)
			)
			(1 ; Look
				(if (IsFlag 35)
					(gMessager say: noun theVerb 0 0 0 222) ; "It's that runner guy."
				else
					(gMessager say: noun theVerb 4 0 0 222) ; "This guy looks like he should be standing watch around one of those barrels. He has a bit of a nervous look about him."
				)
			)
			(2 ; Talk
				(cond
					((gEgo has: 111) ; Whisk_Broom_Full
						(gEgo setScript: sDroidRefuse)
					)
					((gEgo has: 61) ; Full_Tray
						(gEgo setScript: sTradeDroid)
					)
					(else
						(self ignoreActors: 1)
						(proc0_4 gEgo self)
						(self setScript: sBlaineTalk)
					)
				)
			)
			(4 ; Do
				(gMessager say: noun theVerb 0 0 0 222) ; "Here's a hint: avoid direct contact with beings with personal hygiene worse than your own."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elmo of Actor
	(properties
		noun 2
		sightAngle 40
		view 325
		signal 16417
	)

	(method (init)
		(switch gCurRoomNum
			(320
				(self setScaler: Scaler 99 30 137 90)
			)
			(330
				(self setScaler: Scaler 55 20 138 40)
			)
			(340
				(self setScaler: Scaler 100 23 134 91)
			)
		)
		(if (gEgo has: 12) ; Brandy
			(= local33 1)
			(Load 140 341) ; WAVE
			(Load 140 34002) ; WAVE
			(self setScript: elmoSit)
		else
			(self view: 325 setSpeed: 5 setScript: 0 setLoop: -1 setCycle: Walk)
			(if (== local345 0)
				(= local345 (proc0_8 1 3))
			)
			(switch local345
				(1
					(self setMotion: elmoRegPath1)
				)
				(2
					(self setMotion: elmoRegPath2)
				)
				(3
					(self setMotion: elmoRegPath3)
				)
			)
		)
		(super init:)
	)

	(method (doit)
		(cond
			(
				(and
					(not (self script:))
					(<
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					(not local34)
					(not local33)
				)
				(= local32 (self mover:))
				(= local34 1)
				(= local35 0)
				(self mover: 0 ignoreActors: 0)
				(self setCel: loop)
				(self setLoop: 4)
			)
			(
				(and
					(not (self script:))
					(>=
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(self x:)
							(self y:)
							80
						)
						local23
					)
					local34
				)
				(= local34 0)
				(self setMotion: local32 ignoreActors: 1)
			)
			(local34
				(++ local35)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; Brandy
				(if (not (IsFlag 29))
					(elmo setScript: sElmoSitTalk)
				else
					(self setScript: sTradeBrandy)
				)
			)
			(1 ; Look
				(if (IsFlag 30)
					(gMessager say: noun theVerb 0 0 0 222) ; "Elmo has definitely taken a turn for the worse. You'd like to think it was your exit from the admittedly captive rank of that off-world sweat-orb, Scumsoft Inc. It was probably something dumb like a compulsion for pet projects or personally beneficial programs over those things important to the company as a whole. Nah, that couldn't be it."
				else
					(gMessager say: noun theVerb 4 0 0 222) ; "No! Can it be? It is! It's Elmo Pug, the former CEO of Scumsoft. Hard times have hit him like a ball peen hammer between the, uh, eyes. Maybe there is a karma fairy."
					(SetFlag 30)
				)
			)
			(2 ; Talk
				(cond
					((and (not (IsFlag 29)) (gEgo has: 12)) ; Brandy
						(elmo setScript: sElmoSitTalk)
					)
					((gEgo has: 12) ; Brandy
						(elmo setScript: sTradeBrandy)
						(SetFlag 30)
					)
					((gEgo has: 28) ; Dead_Fish
						(gMessager say: noun theVerb 18 0 0 222) ; "He blows you off since your business has been completed. How corporate of him."
					)
					(else
						(self ignoreActors: 1)
						(proc0_4 gEgo self)
						(elmo setScript: sElmoTalk)
					)
				)
			)
			(4 ; Do
				(gMessager say: noun theVerb 0 0 0 222) ; "Look at him. Do you really think that's a wise idea?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance droid of Prop
	(properties
		x 139
		y 49
		view 333
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 setPri: 85 hide:)
	)
)

(instance photoBoothFront of Actor
	(properties
		noun 1
		cel 1
		signal 16417
	)

	(method (init)
		(switch gCurRoomNum
			(320
				(= local20 3201)
				(= local21 322)
				(= local22 3220)
				(self
					x: 199
					y: 109
					approachX: 190
					approachY: 112
					view: 3201
					setCel: 0
				)
			)
			(330
				(= local20 3371)
				(= local21 337)
				(= local22 3370)
				(self
					x: 86
					y: 121
					approachX: 111
					approachY: 123
					view: 3371
					setCel: 0
				)
			)
			(340
				(= local20 3401)
				(= local21 3481)
				(= local22 3480)
				(self
					x: 185
					y: 123
					approachX: 172
					approachY: 123
					view: 3401
					setCel: 1
				)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(photoBoothFront ignoreActors: 1)
				(photoBoothBack ignoreActors: 1)
				(photoCurtain ignoreActors: 1)
				(photoBoothFront setScript: sPhotoBooth)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 222) ; "It's one of those new Qodrac mobile photo booths. I heard they were beta-testing those."
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 222) ; "It's unmoved by your touch."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance photoBoothBack of Prop
	(properties
		noun 1
		signal 16417
	)

	(method (init)
		(switch gCurRoomNum
			(320
				(self
					x: 199
					y: 109
					setPri: 106
					approachX: 190
					approachY: 112
					view: 3201
				)
			)
			(330
				(self
					x: 86
					y: 121
					setPri: 118
					approachX: 111
					approachY: 123
					view: 3371
					setCel: 1
				)
			)
			(340
				(self
					x: 186
					y: 123
					setPri: 120
					approachX: 172
					approachY: 123
					view: 3401
					setCel: 0
				)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(photoBoothFront ignoreActors: 1)
				(photoBoothBack ignoreActors: 1)
				(photoCurtain ignoreActors: 1)
				(photoBoothFront setScript: sPhotoBooth)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 222) ; "It's one of those new Qodrac mobile photo booths. I heard they were beta-testing those."
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 222) ; "It's unmoved by your touch."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance photoCurtain of Prop
	(properties
		noun 1
		loop 1
		signal 16417
	)

	(method (init)
		(switch gCurRoomNum
			(320
				(self
					x: 199
					y: 109
					approachX: 190
					approachY: 112
					setPri: 111
					view: 3201
				)
			)
			(330
				(self
					x: 86
					y: 121
					approachX: 111
					approachY: 123
					setPri: 120
					view: 3371
				)
			)
			(340
				(self
					x: 168
					y: 66
					approachX: 172
					approachY: 123
					setPri: 122
					view: 3401
				)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(photoBoothFront ignoreActors: 1)
				(photoBoothBack ignoreActors: 1)
				(photoCurtain ignoreActors: 1)
				(photoBoothFront setScript: sPhotoBooth)
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 0 0 222) ; "It's one of those new Qodrac mobile photo booths. I heard they were beta-testing those."
			)
			(4 ; Do
				(gMessager say: noun theVerb 0 0 0 222) ; "It's unmoved by your touch."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance photoEye of Prop
	(properties
		noun 1
		loop 3
		signal 16417
	)

	(method (init)
		(switch gCurRoomNum
			(320
				(self x: 186 y: 73 setPri: 118 view: 3201)
			)
			(330
				(self x: 86 y: 121 setPri: 300 view: 3371)
			)
			(340
				(self x: 216 y: 91 setPri: 300 view: 3401)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Buckazoids
				(gEgo signal: 16417)
				(photoBoothFront signal: 16417)
				(photoBoothBack signal: 16417)
				(photoCurtain signal: 16417)
				(photoBoothFront setScript: sPhotoBooth)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 222) ; "It's one of those new Qodrac mobile photo booths. I heard they were beta-testing those."
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 222) ; "It's unmoved by your touch."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

