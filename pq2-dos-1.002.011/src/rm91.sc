;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm91 0
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
)

(instance band of Sound
	(properties
		number 7
		priority 15
	)
)

(instance Extro of Sound
	(properties
		number 15
		priority 15
		loop -1
	)
)

(instance WedBells of Sound
	(properties
		number 48
		priority 15
	)
)

(instance rm91 of Rm
	(properties
		picture 94
		style 7
	)

	(method (init)
		(HandsOff)
		(gGame setSpeed: 4)
		(Load rsPIC 91)
		(Load rsVIEW 207)
		(Load rsVIEW 282)
		(Load rsVIEW 276)
		(Load rsPIC 95)
		(Load rsVIEW 280)
		(Load rsVIEW 259)
		(Load rsVIEW 304)
		(Load rsVIEW 285)
		(Load rsPIC 89)
		(Load rsSOUND 7)
		(Load rsSOUND 15)
		(Load rsSOUND 48)
		(super init:)
		(gCurRoom setScript: recommendationsScript)
	)
)

(instance recommendationsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 91 0 #time 8) ; "Back home in Lytton..."
				(Print 91 1 #time 16) ; "You have been placed on a mandatory three-day administrative leave of absence, resulting from the shooting death of Jessie Bains."
				(Print 91 2 #time 16) ; "You spend needed leisure time with Marie and await results from the Lytton PD Internal Affairs shooting review board."
				(= seconds 5)
			)
			(1
				(Print 91 3 #time 10) ; "The three days finally pass, and now the findings, conclusions, and recommendations from the shooting review board are as follows...."
				(Print 91 4 #time 6) ; "THE REVIEW BOARD FINDINGS:"
				(Print 91 5 #time 22) ; "This board finds that Homicide Detective Sonny Bonds, while on duty, was involved in the discharge of his weapon at another human being during the process of rescuing kidnap victim Marie Wilkans."
				(Print 91 6 #time 14) ; "Further...the shooting resulted in the fatal wounding of "Jessie Bains", escaped fugitive."
				(Print 91 7 #time 20) ; "The board notes: Jessie Bains, while using a stolen .32 caliber Browning automatic, first attacked and fired at Detective Bonds with the intent to commit murder."
				(Print 91 8 #time 6) ; "THE REVIEW BOARD CONCLUSIONS:"
				(Print 91 9 #time 20) ; "The Board finds that Detective Bonds acted in self-defense while in fear for his own life and while protecting the life of kidnap victim Marie Wilkans."
				(Print 91 10 #time 20) ; "The Board concludes that the shooting death of "Jessie Bains" by Homicide Detective Sonny Bonds was totally and unquestionably legal and justifiable."
				(Print 91 11 #time 6) ; "THE REVIEW BOARDS RECOMMENDATIONS:"
				(Print 91 12 #time 30) ; "#1. This board recommends immediate cancellation of administrative leave, therefore returning Detective Bonds to permanent active status."
				(Print 91 13 #time 30) ; "#2. Detective Sonny Bonds will receive Lytton Police Department's "Silver Commendation Award" for superior effort and performance while engaged in a life-threatening situation."
				(Print 91 14 #time 20) ; "#3. This board recommends that Detective Sonny Bonds participate in a two week "Rest and Relaxation" period prior to returning to duty."
				(= cycles 10)
			)
			(2
				(Print 91 15 #time 10) ; "The next day..."
				(gCurRoom setScript: airportScript)
			)
		)
	)
)

(instance eatIceCream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 hide:)
				(local0 setLoop: 1 setCel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(= state -1)
				(local1 setLoop: 2 setCel: 0 show: cycleSpeed: 1 setCycle: End)
				(= seconds (Random 4 8))
			)
		)
	)
)

(instance airportScript of Script
	(properties)

	(method (init)
		(gCurRoom drawPic: 91)
		((View new:)
			view: 276
			posn: 207 149
			loop: 0
			cel: 0
			setPri: 11
			init:
			addToPic:
		)
		((View new:)
			view: 276
			posn: 306 151
			loop: 0
			cel: 1
			setPri: 11
			init:
			addToPic:
		)
		((View new:)
			view: 276
			posn: 250 152
			loop: 1
			cel: 0
			setPri: 11
			init:
			addToPic:
		)
		((View new:)
			view: 282
			posn: 47 191
			loop: 0
			cel: 0
			setPri: 15
			init:
			addToPic:
		)
		((View new:)
			view: 282
			posn: 71 190
			loop: 0
			cel: 1
			setPri: 14
			init:
			addToPic:
		)
		((View new:)
			view: 282
			posn: 136 190
			loop: 0
			cel: 2
			setPri: 14
			init:
			addToPic:
		)
		((= local1 (Prop new:))
			view: 282
			posn: 185 142
			loop: 2
			cel: 0
			setPri: 15
			init:
			hide:
		)
		((= local0 (Prop new:))
			view: 282
			posn: 179 191
			loop: 1
			cel: 0
			setPri: 14
			init:
			setScript: eatIceCream
		)
		((= local2 (Prop new:))
			view: 207
			posn: 241 160
			loop: 1
			setPri: 12
			init:
			cycleSpeed: 1
			setCycle: Fwd
		)
		((= local3 (Prop new:))
			view: 207
			posn: 274 157
			loop: 0
			setPri: 12
			init:
			cycleSpeed: 1
			setCycle: Fwd
		)
		((= local4 (Prop new:))
			view: 207
			posn: 293 159
			loop: 2
			setPri: 12
			init:
			cycleSpeed: 2
			setCycle: Fwd
		)
		(RedrawCast)
		(band play:)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (Print 91 16 #at 25 20 #dispose)) ; "The three piece band strikes it up, as Captain Fletcher Hall presents you with the "Silver Commendation Award"."
				(= seconds 11)
			)
			(1
				(clr)
				(= local5 (Print 91 17 #at 25 20 #dispose)) ; "Marie stands proudly by your side as the band plays on."
				(= seconds 8)
			)
			(2
				(clr)
				(= local5 (Print 91 18 #at 25 20 #dispose)) ; "Although you know it's a lie, Keith vows to quit smoking by the time you return from the Island paradise."
				(= seconds 10)
			)
			(3
				(clr)
				(= local5 (Print 91 19 #at 25 20 #dispose)) ; "Since this is a special occasion, you wonder why the Captain can't quit slurping, licking and smacking ice cream long enough to get you out of here."
				(= seconds 11)
			)
			(4
				(clr)
				(= local5 (Print 91 20 #at 25 20 #dispose)) ; "Oh well" you think..."I guess it's better than the old habit he used to have...dipping and spitting snuff."
				(= seconds 10)
			)
			(5
				(eatIceCream dispose:)
				(clr)
				(= local5 (Print 91 21 #at 25 20 #dispose)) ; "With congratulations over, and the awards ceremony out of the way, you board the plane. Then..."
				(= seconds 11)
			)
			(6
				(if (!= (band prevSignal:) -1)
					(-- state)
					(= cycles 2)
				else
					(clr)
					(gCast eachElementDo: #dispose)
					(gCurRoom setScript: flyingIntoSunsetScript)
				)
			)
		)
	)
)

(instance flyingIntoSunsetScript of Script
	(properties)

	(method (init)
		((= local6 (Act new:))
			view: 280
			loop: 0
			cel: 0
			posn: 183 189
			setPri: -1
			init:
		)
		(band stop:)
		(gCurRoom drawPic: 95)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local6 cel: 0 setMotion: MoveTo 190 177 self)
			)
			(1
				(Extro play:)
				(local6 cel: 1 setMotion: MoveTo 192 163 self)
			)
			(2
				(local6 cel: 2 setMotion: MoveTo 196 149 self)
			)
			(3
				(local6 cel: 3 setMotion: MoveTo 203 137 self)
			)
			(4
				(local6 cel: 6 setMotion: MoveTo 209 125 self)
			)
			(5
				(clr)
				(= local5 (Print 91 22 #at -1 20 #dispose)) ; "You and your high school sweetheart, Marie Wilkans, fly away into the sunset..."
				(local6 cel: 6 setMotion: MoveTo 214 114 self)
			)
			(6
				(local6 cel: 6 setMotion: MoveTo 219 104 self)
			)
			(7
				(local6 cel: 7 setMotion: MoveTo 226 94 self)
			)
			(8
				(local6 cel: 8 setMotion: MoveTo 235 86 self)
			)
			(9
				(local6 cel: 9 setMotion: MoveTo 247 79 self)
			)
			(10
				(local6 cel: 10 setMotion: MoveTo 261 73 self)
			)
			(11
				(local6 cel: 11 setMotion: MoveTo 274 68 self)
			)
			(12
				(clr)
				(local6 cel: 12 setMotion: MoveTo 288 63 self)
			)
			(13
				(local6 cel: 13 setMotion: MoveTo 304 58 self)
			)
			(14
				(local6 cel: 14 setMotion: MoveTo 311 52 self)
			)
			(15
				(local6 cel: 15 setMotion: MoveTo 312 45 self)
			)
			(16
				(local6 setLoop: 1 cel: 0 setMotion: MoveTo 312 40 self)
			)
			(17
				(local6 cel: 1 setMotion: MoveTo 312 29 self)
			)
			(18
				(local6 cel: 1 setMotion: MoveTo 316 25 self)
			)
			(19
				(local6 cel: 2 setMotion: MoveTo 323 23 self)
			)
			(20
				(local6 cel: 2 setMotion: MoveTo 350 20 self)
			)
			(21
				(local6 dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom setScript: finaleScript)
			)
		)
	)
)

(instance finaleScript of Script
	(properties)

	(method (init)
		((= local7 (Act new:))
			view: 259
			setLoop: 7
			setCel: 0
			posn: 313 118
			setPri: 5
			setStep: 1 1
			moveSpeed: 0
			init:
			setMotion: MoveTo -60 118
		)
		((View new:)
			view: 259
			setLoop: 4
			setCel: 0
			posn: 146 162
			setPri: 12
			init:
			addToPic:
		)
		((View new:)
			view: 259
			setLoop: 5
			setCel: 0
			posn: 239 177
			setPri: 13
			init:
			addToPic:
		)
		((View new:)
			view: 259
			setLoop: 6
			setCel: 0
			posn: 220 140
			setPri: 10
			init:
			addToPic:
		)
		((View new:)
			view: 259
			setLoop: 4
			setCel: 0
			posn: 63 54
			setPri: 2
			init:
			addToPic:
		)
		((View new:)
			view: 259
			setLoop: 4
			setCel: 0
			posn: 37 150
			setPri: 7
			init:
			addToPic:
		)
		((View new:)
			view: 259
			setLoop: 6
			setCel: 0
			posn: 6 57
			setPri: 2
			init:
			addToPic:
		)
		(gCurRoom drawPic: 89)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= local5 (Print 91 23 #draw #at 10 20 #dispose)) ; "While high in the sky, bound for the warm, emerald clear waters of the Bahamas..."
				(= seconds 2)
			)
			(2
				((View new:)
					view: 304
					setLoop: 0
					setCel: 0
					posn: 245 87
					setPri: 10
					init:
					stopUpd:
				)
				((= local8 (Prop new:))
					view: 304
					setLoop: 1
					setCel: 1
					posn: 245 82
					setPri: 11
					init:
					stopUpd:
				)
				(= seconds 2)
			)
			(3
				(clr)
				(= local5 (Print 91 24 #draw #at 40 20 #dispose)) ; "You ask Marie..."
				(= seconds 3)
			)
			(4
				(clr)
				(= local5 (Print 91 25 #at 10 20 #dispose)) ; "Marie," you say... "Will you marry me?"
				(= seconds 5)
			)
			(5
				(local8 setCel: 2)
				(clr)
				(Extro stop:)
				(WedBells play:)
				(= local5 (Print 91 26 #draw #at 10 20 #dispose)) ; "With tears of joy flowing, Marie answers..."
				(= seconds 4)
			)
			(6
				(clr)
				(= local5 (Print 91 27 #at 100 40 #dispose)) ; "YES"
				(local8 setCycle: End)
				(= seconds 2)
			)
			(7
				(clr)
				(local8 setCycle: Beg self)
			)
			(8
				((= local10 (Act new:))
					view: 285
					setLoop: 0
					setCel: 0
					posn: (- (local7 x:) 20) 100
					setPri: 6
					init:
					setStep: 1 1
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo -60 100
				)
				((= local11 (Act new:))
					view: 285
					setLoop: 1
					setCel: 1
					posn: (- (local7 x:) 10) 93
					setPri: 6
					init:
					setStep: 1 1
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo -50 93
				)
				((= local12 (Act new:))
					view: 285
					setLoop: 2
					setCel: 2
					posn: (- (local7 x:) 5) 104
					setPri: 9
					init:
					setStep: 1 1
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo -40 100 self
				)
			)
			(9
				(local8
					setLoop: 2
					setCel: 0
					posn: 234 60
					setPri: 12
					setCycle: End self
				)
			)
			(10
				(local8 stopUpd:)
				(= local5 (Print 91 28 #at -1 100 #dispose)) ; "Thank you for playing "Police Quest 2.""
				(= seconds 10)
			)
			(11
				(clr)
				(= local5 (Print 91 29 #at -1 100 #dispose)) ; "THE END"
			)
		)
	)
)

